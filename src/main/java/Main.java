
public class Main {

	private static ImageToASCII img;

	private static String imagePathToVaevLogo = "/Users/cadenfinley/Documents/GitHub/imageasciitool/vaevlogo.jpg";
	private static String imagePathToCadenFinley = "/Users/cadenfinley/Documents/GitHub/imageasciitool/cadenfinley.jpg";

	private static String outputFilePathVaevLogo = "vaevlogo.txt";
	private static String outputFilePathCadenFinley = "cadenfinley.txt";

	public static void main(String[] args) {
		img = new ImageToASCII(imagePathToVaevLogo);
		img.convertToASCIIInFile(outputFilePathVaevLogo);

		img = new ImageToASCII(imagePathToCadenFinley);
		img.convertToASCIIInFile(outputFilePathCadenFinley);

		img = new ImageToASCII(imagePathToVaevLogo);
		img.convertToASCIIInWindow();

		img = new ImageToASCII(imagePathToCadenFinley);
		img.convertToASCIIInWindow();

	}

}
