package demo14Polymorphism;
public class Mouse implements Usb {
	@Override
	public void connect() {
		System.out.println("Connect the mouse.");
	}
	@Override
	public void disconnect() {
		System.out.println("Disconnect the mouse.");
	}
	public void click() {
		System.out.println("Click the mouse.");
	}
}
