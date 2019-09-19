package waterplant_webapp_core.exception;

public class DBException extends Exception {

	public DBException(String message) {
		super(message);
	}
	
	public DBException(String message, Throwable t) {
		super(message,t);
	}

}
