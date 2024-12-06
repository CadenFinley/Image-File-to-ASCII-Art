
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Caden Finley
 */
public class ImageToASCIITEST {

	private ImageToASCII img;

	@Before
	public void setUp() {
		img = null;
	}

	@Test
	public void Test_Load_Image() {
		img = new ImageToASCII("path", 100, 100);
		assertEquals(100, img.getWidth());
		assertEquals(100, img.getHeight());
	}

	@Test
	public void Test_Get_Width() {
		img = new ImageToASCII("path", 100, 100);
		assertEquals(100, img.getWidth());
	}

	@Test
	public void Test_Get_Height() {
		img = new ImageToASCII("path", 100, 100);
	}
}
