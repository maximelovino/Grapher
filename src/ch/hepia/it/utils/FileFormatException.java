package ch.hepia.it.utils;

/**
 * Exception to throw in case of problem with the file we pass as an argument
 */
public class FileFormatException extends RuntimeException {
	public FileFormatException (int lineNumber) {
		super("There is a problem with your file at line " + lineNumber);
	}
}
