package by.touchsoft.exception;

public class MappingException extends Exception {

    private static final long serialVersionUID = -8512384017577023423L;

    private static final String defaultMsg = "Incorrect data for mapping";

    public MappingException(String message, int number) {
        super("Line " + number + ". " + defaultMsg + ". " + message);
    }

    public MappingException(int number, Throwable cause) {
        super("Line " + number + ". " + defaultMsg, cause);
    }
}
