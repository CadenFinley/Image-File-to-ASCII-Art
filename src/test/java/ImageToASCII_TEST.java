
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Caden Finley
 */
public class ImageToASCII_TEST {

    @Test
    public void Test_Load_Image() {
        ImageToASCII img = new ImageToASCII();
        img.loadImage("src/test/resources/test.png");
        assertEquals(100, img.getWidth());
        assertEquals(100, img.getHeight());
    }
}
