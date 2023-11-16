package image;

import image.color.GrayColor;

/**
 * Represents an image with pixels and provides various operations on the image.
 */
public class Image implements ImageInterface {
    private int width;
    private int height;
    private Pixel[][] pixel;

    /**
     * Constructs an image with the specified width and height.
     *
     * @param width  the width of the image
     * @param height the height of the image
     */
    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixel = new Pixel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixel[i][j] = new Pixel(GrayColor.WHITE);
            }
        }
    }

    /**
     * Returns the width of the image.
     *
     * @return the width of the image
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the image.
     *
     * @return the height of the image
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the pixel at the specified coordinates.
     *
     * @param x the x-coordinate of the pixel
     * @param y the y-coordinate of the pixel
     * @return the pixel at the specified coordinates
     * @throws UnknownPixelException if the specified coordinates are out of bounds
     */
    public Pixel getPixel(int x, int y) throws UnknownPixelException {
        if (x >= this.width || y >= this.height) {
            throw new UnknownPixelException();
        }
        return pixel[x][y];
    }

    /**
     * Changes the color of the pixel at the specified coordinates.
     *
     * @param x     the x-coordinate of the pixel
     * @param y     the y-coordinate of the pixel
     * @param color the new color of the pixel
     * @throws UnknownPixelException if the specified coordinates are out of bounds
     */
    public void changeColorPixel(int x, int y, GrayColor color) throws UnknownPixelException {
        if (x >= this.width || y >= this.height) {
            throw new UnknownPixelException();
        }
        this.pixel[x][y].setColor(color);
    }

    /**
     * Fills a rectangle in the image with the specified color.
     *
     * @param x      the x-coordinate of the top-left corner of the rectangle
     * @param y      the y-coordinate of the top-left corner of the rectangle
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     * @param color  the color to fill the rectangle with
     */
    public void fillRectangle(int x, int y, int width, int height, GrayColor color) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.pixel[x + i][y + j].setColor(color);
            }
        }
    }

    /**
     * Creates and returns a negative version of the image.
     *
     * @return a negative version of the image
     */
    public Image negative() {
        Image image = new Image(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Pixel pixel = this.getPixel(i, j);
                GrayColor color = pixel.getColor();
                int lvl = 255 - color.getGrayLevel();
                GrayColor color2 = new GrayColor(lvl);
                image.changeColorPixel(i, j, color2);
            }
        }
        return image;
    }

    /**
     * Performs edge extraction on the image with the specified threshold.
     *
     * @param threshold the threshold value for edge extraction
     * @return the result of edge extraction
     */
    public Image edgeExtraction(int threshold) {
        Image image = new Image(width, height);
        for (int i = 0; i < width - 1; i++) {
            for (int j = 0; j < height - 1; j++) {
                Pixel pixel = this.getPixel(i + 1, j);
                Pixel pixel2 = this.getPixel(i, j + 1);
                GrayColor color = pixel.getColor();
                GrayColor color2 = pixel2.getColor();
                if (Math.abs(color.getGrayLevel() - color2.getGrayLevel()) > threshold) {
                    image.changeColorPixel(i, j, GrayColor.BLACK);
                } else {
                    image.changeColorPixel(i, j, GrayColor.WHITE);
                }
            }
        }
        return image;
    }

    /**
     * Creates and returns a version of the image with a decreased number of gray levels.
     *
     * @param nbGrayLevels the number of gray levels to reduce the image to
     * @return a version of the image with a decreased number of gray levels
     */
    public Image decreaseNbGrayLevels(int nbGrayLevels) {
        Image image = new Image(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Pixel pixel = this.getPixel(i, j);
                int t = 256 / nbGrayLevels;
                int l = pixel.getColor().getGrayLevel();
                int k = l / t;
                GrayColor color2 = new GrayColor(k * t);
                image.changeColorPixel(i, j, color2);
            }
        }
        return image;
    }
}