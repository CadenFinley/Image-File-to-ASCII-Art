
import java.awt.image.BufferedImage;

/**
 * @author Caden Finley
 */
public class ImageToASCII {

    private BufferedImage image;
    private int width;
    private int height;

    public ImageToASCII() {

    }

    public void loadImage(String path) {
        System.out.println("Loading image from path: " + path);
    }
}
