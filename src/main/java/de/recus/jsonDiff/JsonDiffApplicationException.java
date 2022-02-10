package de.recus.jsonDiff;

public class JsonDiffApplicationException extends RuntimeException {
	public JsonDiffApplicationException(String message) {
		super(message);
	}

	public JsonDiffApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public JsonDiffApplicationException(Throwable cause) {
		super(cause);
	}
}