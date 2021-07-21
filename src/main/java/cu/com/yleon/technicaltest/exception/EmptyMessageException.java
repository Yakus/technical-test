package cu.com.yleon.technicaltest.exception;

public class EmptyMessageException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmptyMessageException(String message) {
        super(message);
    }
}
