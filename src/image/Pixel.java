package image;

import image.color.GrayColor;

/**
 * The Pixel class represents a pixel in an image.
 * It contains a GrayColor object representing the color of the pixel.
 */
public class Pixel {
    /**
     * Color of the pixel
     */
    public GrayColor color;

    /**
     * Constructs a Pixel object with default values.
     * @param color the color of the pixel
     */
    public Pixel(GrayColor color) {
        this.color = color;
    }

    /**
     * Returns the color of the pixel.
     *
     * @return the color of the pixel
     */
    public GrayColor getColor() {
        return this.color;
    }

    /**
     * Sets the color of the pixel.
     *
     * @param color the color to set
     */
    public void setColor(GrayColor color) {
        this.color = color;
    }

    /**
     * Compares this Pixel object to the specified object. The result is true if and
     * only if
     * the argument is not null and is a Pixel object with the same color as this
     * Pixel object.
     *
     * @param o the object to compare this Pixel against
     * @return true if the given object represents a Pixel with the same color as
     *         this Pixel, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof Pixel)) {
            return false;
        } else {
            Pixel p = (Pixel) o;
            return p.getColor().equals(this.getColor());
        }
    }

    /**
     * Calculates the difference in gray level between the color of this pixel and
     * another pixel.
     *
     * @return the difference in gray level
     */
    public int colorLevelDifference() {
        int grayLevel = this.getColor().getGrayLevel();
        int grayLevel2 = this.getColor().getGrayLevel();
        return Math.abs(grayLevel - grayLevel2);
    }
}