
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Caden Finley
 */
public class ImageToASCIITEST {

	private ImageToASCII img;

	private String imagePathToVaevLogo = "vaevlogo.jpg";

	@Before
	public void setUp() {
		img = null;
	}

	@Test
	public void Test_Load_Image_Vaevlogo() {
		img = new ImageToASCII(imagePathToVaevLogo);
		assertTrue(img != null);
	}
	
	@Test
	public void Test_Output_File_Exists() {
		img = new ImageToASCII(imagePathToVaevLogo);
		img.convertToASCIIInFile("vaevlogo.txt");
		assertTrue(img.getOutputPath().exists());
	}
}
