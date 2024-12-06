package com.cadenfinley.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Caden Finley
 */
public class ImageToASCII {

    private BufferedImage image;
    private int width;
    private int height;
    private String imagePath;

    public ImageToASCII(String pathToImage, int width, int height) {
        image = null;
        this.width = width;
        this.height = height;
        this.imagePath = pathToImage;
        try {
            loadImage(imagePath);
        } catch (IOException e) {
            System.out.println("Error loading image");
        }
    }

    private void loadImage(String path) throws IOException {
        File inputImage = new File(path);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        image = ImageIO.read(inputImage);
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }
}
