package by.touchsoft.exception;

public class ProcessingException extends RuntimeException {

    private static final long serialVersionUID = -8512384017577023423L;

    public ProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
