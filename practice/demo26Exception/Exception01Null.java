package demo26Exception;

public class Exception01Null{
	public static void main(String[] args) {
		method(null);	
	}

	public static int method(Object obj) {
		Objects.requireNonNull(obj);

	}
