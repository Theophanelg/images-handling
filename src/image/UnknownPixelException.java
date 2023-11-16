package image;

/**
 * The `UnknownPixelException` class is a custom exception class that is thrown when an unknown pixel value is encountered.
 * It extends the `RuntimeException` class.
 */
public class UnknownPixelException extends RuntimeException {

	/**
     * Constructs a new `UnknownPixelException` with no detail message.
     */
    public UnknownPixelException() {}

	/**
     * Constructs a new `UnknownPixelException` with the specified detail message.
     *
     * @param msg the detail message
     */
    public UnknownPixelException(String msg) {
		super(msg);
	}
}
