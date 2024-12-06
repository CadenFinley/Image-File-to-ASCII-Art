
/**
 * @author Caden Finley
 */
public class Main {

    //Demo of the ImageToASCII class
    private static ImageToASCII imageToAscii;

    public static void main(String[] args) {
        System.out.println("Input the File path to image: ");
        String path = System.console().readLine();
        System.out.println("Out to window or file or both? (w/f/b): ");
        String out = System.console().readLine();
        switch (out) {
            case "w" -> {
                imageToAscii = new ImageToASCII(path);
                imageToAscii.convertToASCIIInWindow();
                displayInfo();
            }
            case "f" -> {
                System.out.println("Input the File name to create output (.txt): ");
                String outputPath = System.console().readLine();
                imageToAscii = new ImageToASCII(path);
                imageToAscii.convertToASCIIInFile(outputPath);
                displayInfo();
            }
            case "b" -> {
                System.out.println("Input the File name to create output (.txt): ");
                String outputPath = System.console().readLine();
                imageToAscii = new ImageToASCII(path);
                imageToAscii.convertToASCIIInWindow();
                imageToAscii.convertToASCIIInFile(outputPath);
                displayInfo();
            }
            default ->
                System.out.println("Invalid input");
        }
    }

    private static void displayInfo() {
        System.out.println("Image dimensions: " + imageToAscii.getHeight() + "x" + imageToAscii.getWidth());
        System.out.println("Output path: " + imageToAscii.getOutputPath());
        System.out.println("Output path exists: " + imageToAscii.getOutputPath().exists());
    }

}
