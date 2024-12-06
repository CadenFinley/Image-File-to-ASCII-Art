
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Caden Finley
 */
public class ImageToASCIITEST {

	private ImageToASCII img;

	private String imagePathToVaevLogo = "/Users/cadenfinley/Documents/GitHub/imageasciitool/vaevlogo.jpg";
	private String imagePathToCadenFinley = "/Users/cadenfinley/Documents/GitHub/imageasciitool/cadenfinley.jpg";

	private String outputFilePathVaevLogo = "vaevlogo.txt";
	private String outputFilePathCadenFinley = "cadenfinley.txt";

	@Before
	public void setUp() {
		img = null;
	}

	@Test
	public void Test_Load_Image_Vaevlogo() {
		img = new ImageToASCII(imagePathToVaevLogo, outputFilePathVaevLogo);
		assertTrue(img != null);
		img.convertToASCIIInWindow();
	}

	@Test
	public void Test_Load_Image_CadenFinley() {
		img = new ImageToASCII(imagePathToCadenFinley, outputFilePathCadenFinley);
		assertTrue(img != null);
		img.convertToASCIIInWindow();
	}3

}
