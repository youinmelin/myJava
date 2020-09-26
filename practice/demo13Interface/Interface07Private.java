public interface Interface07Private {
	default void methodDefault(){
		System.out.println("This is a default method.");
		commonMethod();
	}
	private void commonMethod(){
		System.out.println("This is a common method.");
	}
}
