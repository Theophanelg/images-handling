package image;

import image.util.*;
import image.color.*;

/**
 * Image example main class
 */
public class ImageExampleMain {
      /**
     * The file path of the lamp image.
     */
    private static final String LAMP_IMAGE = "/images/lamp.pgm";
      /**
     * The file path of the cat image.
     */
    private static final String CAT_IMAGE = "/images/chat.pgm";

      /**
     * The main method of the program.
     * It loads the lamp and cat images, displays them on the screen, and creates a new image with rectangles in it.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

            // Load the lamp and cat images using ImageLoader
            Image lampImg = ImageLoader.loadPGM(LAMP_IMAGE);
            Image catImg = ImageLoader.loadPGM(CAT_IMAGE);

            // Create an ImageDisplayer object to display the images
            ImageDisplayer displayer = new ImageDisplayer();

            // Display the lamp image at coordinates (200,100)
            displayer.display(lampImg, "Lampe", 200, 100);

            // Display the cat image at coordinates (600,100)
            displayer.display(catImg, "Chat", 600, 100);

            // Create a white image with size 200x150
            Image white = new Image(200, 150);

            // Fill rectangles in the white image
            white.fillRectangle(10, 10, 30, 30, GrayColor.BLACK);
            white.fillRectangle(50, 60, 40, 50, GrayColor.BLACK);

            // Display the white image at coordinates (1000,100)
            displayer.display(white, "White image", 1000, 100);

            // Display the negative of the white image at coordinates (1400,100)
            displayer.display(white.negative(), "White image (negative)", 1200, 100);
      }

}
