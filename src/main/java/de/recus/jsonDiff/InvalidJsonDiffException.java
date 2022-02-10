package de.recus.jsonDiff;
public class InvalidJsonDiffException extends JsonDiffApplicationException {
    public InvalidJsonDiffException(String message) {
        super(message);
    }

    public InvalidJsonDiffException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidJsonDiffException(Throwable cause) {
        super(cause);
    }
}