package image;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import image.color.GrayColor;

/**
 * Test class for the Image class.
*/
public class TestImage {
    /**
     * Test for the getPixel() method.
     * Checks if the method returns a non-null pixel.
     * @throws UnknownPixelException if the requested pixel does not exist in the image.
     */
    @Test
    public void testGetPixel() throws UnknownPixelException{
        Image image = new Image(10, 10);
        Pixel pixel = image.getPixel(5, 5);
        assertNotNull(pixel);
    }

    /**
     * Test for the changeColorPixel() method.
     * Checks if the method correctly changes the color of a pixel.
     */
    @Test
    public void testChangeColorPixel(){
        Image image = new Image(10, 10);
        image.changeColorPixel(5, 5, GrayColor.BLACK);
        assertEquals(image.getPixel(5, 5).getColor(), GrayColor.BLACK);
    }

    /**
     * Test for the fillRectangle() method.
     * Checks if the method correctly fills a rectangle with a given color.
     */
    @Test
    public void testFillRectangle(){
        Image image = new Image(20, 20);
        image.fillRectangle(5, 5, 10, 10, GrayColor.BLACK);
        for(int i = 5; i < 15; i++){
            for(int j = 5; j < 15; j++){
                assertEquals(image.getPixel(i, j).getColor(), GrayColor.BLACK);
            }
        }
    }

    /**
     * Test for the negative() method.
     * Checks if the method returns a correct negative image.
     */
    @Test
    public void testNegative(){
        Image image = new Image(20, 20);
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                assertEquals(image.negative().getPixel(i, j).getColor(), GrayColor.BLACK);
            }
        }
    }

    /**
     * Test for the edgeExtraction() method.
     * Checks if the method returns an image with correct edge extraction.
     */
    @Test
    public void testEdgeExtraction() {
        Image image = new Image(20, 20);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                image.changeColorPixel(i, j, GrayColor.WHITE);
            }
        }
        Image result = image.edgeExtraction(8);
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                assertEquals(result.getPixel(i, j).getColor(), GrayColor.WHITE);
            }
        }
    }
    
    /**
    * Verifies that the gray levels of the pixels in the resulting image are correct after decreasing the number of gray levels.
    */
    @Test
    public void testDecreaseNbGrayLevels() {
        int nbGrayLevels = 10;
        Image image = new Image(20, 20);
        Image img = image.decreaseNbGrayLevels(nbGrayLevels);
        int t = 256 / nbGrayLevels;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                Pixel pixel = img.getPixel(i, j);
                int l = pixel.getColor().getGrayLevel();
                int k = l / t;
                assertEquals(new GrayColor(k * t), img.getPixel(i, j).getColor());
            }
        }
    }
}