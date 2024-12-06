
import java.io.File;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Caden Finley
 */
public class TestSuite {

    private ImageToASCII img;

    private final String imagePathToVaevLogo = "vaevlogo.jpg";

    /**
     * Sets up the test environment before each test.
     */
    @Before
    public void setUp() {
        img = null;
    }

    /**
     * Cleans up the test environment after each test.
     */
    @After
    public void tearDown() {
        File outputFile = img.getOutputPath();
        if (outputFile != null) {
            outputFile.delete();
        }
    }

    /**
     * Tests if the image is loaded correctly.
     */
    @Test
    public void Test_Load_Image_Vaevlogo() {
        img = new ImageToASCII(imagePathToVaevLogo);
        assertTrue(img != null);
    }

    /**
     * Tests if the output file is created after conversion.
     */
    @Test
    public void Test_Output_File_Exists() {
        img = new ImageToASCII(imagePathToVaevLogo);
        img.convertToASCIIInFile("vaevlogo.txt");
        assertTrue(img.getOutputPath().exists());
    }
}
