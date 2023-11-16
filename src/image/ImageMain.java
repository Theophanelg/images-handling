package image;

import image.util.*;
import image.color.*;

/**
 * Image main class 
 */
public class ImageMain {
  /**
     * The main method of the program.
     * It loads an image from a file, displays it on the screen, and applies various image processing operations to it.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    // Load the image from the command line argument using ImageLoader
      Image img = ImageLoader.loadPGM(args[0]);

    // Create an ImageDisplayer object to display the image
    ImageDisplayer displayer = new ImageDisplayer();

    // Display the original image at coordinates (200,100)
    displayer.display(img, "Original Image", 20, 100);

    // Display the negative of the image at coordinates (600,100)
    displayer.display(img.negative(), "Negative Image", 420, 100);

    // Display the result of edge extraction on the image at coordinates (1000,100)
      int nb1 = Integer.parseInt(args[1]);
    displayer.display(img.edgeExtraction(nb1), "Edge Extraction", 820, 100);

    // Display the image with a decreased number of gray levels at coordinates (1400,100)
      int nb2 = Integer.parseInt(args[2]);
    displayer.display(img.decreaseNbGrayLevels(nb2), "Decreased Gray Levels", 1220, 100);


  }

}
