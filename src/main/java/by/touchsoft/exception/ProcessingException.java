package by.touchsoft.exception;

public class ProcessingException extends RuntimeException {

    private static final long serialVersionUID = -8512373240579573017L;

    private static final String defaultMsg = "Can't process file";

    public ProcessingException(String path, Throwable cause) {
        super(defaultMsg + ": " + path, cause);
    }
}
