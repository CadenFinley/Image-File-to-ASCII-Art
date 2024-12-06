
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Caden Finley
 */
public class ImageToASCII {

    private BufferedImage image = null;
    private int width = 0;
    private int height = 0;
    private String imagePath = "";
    private File outputPath = null;

    public ImageToASCII(String pathToImage) {
        image = null;
        this.imagePath = pathToImage;
        try {
            loadImage();
        } catch (IOException e) {
            System.out.println("Error loading image!");
            System.out.println("Error: " + e);
        }
    }

    private void loadImage() throws IOException {
        File inputImage = new File(imagePath);
        this.image = ImageIO.read(inputImage);
        this.height = image.getHeight();
        this.width = image.getWidth();
    }

    private boolean validateResolutions() {
        if (image.getHeight() == 0 || image.getWidth() == 0) {
            System.out.println("Image dimensions are 0");
            return false;
        }
        if (image.getHeight() > 1080 || image.getWidth() > 1920) {
            System.out.println("Image dimensions are too large");
            return false;
        }
        return true;
    }

    private boolean validateImage() {
        if (image == null) {
            System.out.println("Image not loaded");
            return false;
        }
        return true;
    }

    private boolean validateOutputPath() {
        if (outputPath == null) {
            System.out.println("Output path not set");
            return false;
        }
        return true;
    }

    private char pixelToASCII(int pixel) {
        final char[] asciiChars = {'@', '#', 'S', '%', '?', '*', '+', ';', ':', ',', '.'};
        Color color = new Color(pixel, true);
        int gray = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        int index = (gray * (asciiChars.length - 1)) / 255;
        return asciiChars[index];
    }

    //unused method
    private String pixelToColoredASCII(int pixel) {
        final char[] asciiChars = {'@', '#', 'S', '%', '?', '*', '+', ';', ':', ',', '.'};
        Color color = new Color(pixel, true);
        int gray = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        int index = (gray * (asciiChars.length - 1)) / 255;
        char asciiChar = asciiChars[index];

        // ANSI color code
        String ansiColor = String.format("\u001B[38;2;%d;%d;%dm", color.getRed(), color.getGreen(), color.getBlue());
        return ansiColor + asciiChar + "\u001B[0m"; // Reset color after character
    }

    public void convertToASCIIInFile(String nameOfOutputFile) {
        outputPath = new File(nameOfOutputFile);
        if (!validateImage() || !validateOutputPath() || !validateResolutions()) {
            return;
        }
        try (FileWriter writer = new FileWriter(this.outputPath)) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int pixel = image.getRGB(x, y);
                    char ascii = pixelToASCII(pixel);
                    writer.write(ascii);
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file");
            System.out.println("Error: " + e);
        }
    }

    public void convertToASCIIInWindow() {
        if (!validateImage() || !validateResolutions()) {
            return;
        }
        StringBuilder asciiArt = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                char ascii = pixelToASCII(pixel);
                asciiArt.append(ascii);
            }
            asciiArt.append("\n");
        }

        // Display ASCII art in a JTextArea with a specific font
        JTextArea textArea = new JTextArea(asciiArt.toString());
        textArea.setFont(new Font("COURIER", Font.PLAIN, 2));
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(textArea);
        JFrame frame = new JFrame("ASCII Art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public File getOutputPath() {
        return outputPath;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getImagePath() {
        return imagePath;
    }
}
