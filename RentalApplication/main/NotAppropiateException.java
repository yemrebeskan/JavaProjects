package main;

public class NotAppropiateException extends Exception {
	public NotAppropiateException() {
		super("Not appropiate");
	}
	
	public NotAppropiateException(String message) {
		super(message);
	}
}
