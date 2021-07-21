package cu.com.yleon.technicaltest.exception;

public class HandlerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public HandlerNotFoundException(String message) {
        super(message);
    }
	
	public HandlerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
