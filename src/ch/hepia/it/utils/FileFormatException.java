package ch.hepia.it.utils;

public class FileFormatException extends RuntimeException {
	public FileFormatException (int lineNumber) {
		super("There is a problem with your file at line "+lineNumber);
	}
}
