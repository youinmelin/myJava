package demo26Exception;

import java.util.Objects;

public class Exception01Null {
	public static void main(String[] args) {
		method(null);	
	}

	public static void method(Object obj) {
		Objects.requireNonNull(obj);

	}
}