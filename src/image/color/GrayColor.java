package image.color;

/**
 * 
 * The GrayColor class represents a grayscale color.
 * 
 * It provides methods to get and set the gray level and alpha transparency of
 * the color.
 */
public class GrayColor {
    /**
     * Constant representing the black color with a gray level of 0.
     */
    public static final GrayColor BLACK = new GrayColor(0);
    /**
     * Constant representing the white color with a gray level of 255.
     */
    public static final GrayColor WHITE = new GrayColor(255);
    /**
     * The gray level of the color.
     */
    private int grayLevel = 1;
    /**
     * The alpha transparency value of the color.
     */
    private double alpha = 1;

    /**
     * Constructs a GrayColor object with the specified gray level.
     * 
     * @param level the gray level of the color
     */
    public GrayColor(int level) {
        this.grayLevel = level;
    }

    /**
     * Returns the gray level of the color.
     * 
     * @return the gray level of the color
     */
    public int getGrayLevel() {
        return this.grayLevel;
    }

    /**
     * Returns the alpha transparency value of the color.
     * 
     * @return the alpha transparency value of the color
     */
    public double getAlpha() {
        return alpha;
    }

    /**
     * Sets the alpha transparency value of the color.
     * 
     * @param alpha the alpha transparency value to set
     */
    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    /**
     * Compares this GrayColor object to the specified object. The result is true if
     * and only if
     * the argument is not null and is a GrayColor object with the same gray level
     * and alpha transparency
     * as this GrayColor object.
     * 
     * @param o the object to compare this GrayColor against
     * @return true if the given object represents a GrayColor equivalent to this
     *         GrayColor, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof GrayColor)) {
            return false;
        } else {
            GrayColor color = (GrayColor) o;
            return this.getGrayLevel() == color.getGrayLevel() && this.getAlpha() == color.getAlpha();
        }
    }
}