
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

    private void loadImage(String path) {
        try {
            image = null;
            File inputImage = new File(path);
            image = ImageIO.read(inputImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setWidth() {

    }

    private void setHeight() {

    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }
}
