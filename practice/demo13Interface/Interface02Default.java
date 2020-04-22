public interface Interface02Default {
	public abstract void methodAbs();
	public default void methodDefault(){
		System.out.println("This is a default method.");
	}
}
