package demo14Polymorphism;
public class Keyboard implements Usb {
	@Override
	public void connect() {
		System.out.println("Connect the keyboard.");
	}
	@Override
	public void disconnect() {
		System.out.println("Disconnect the keyboard.");
	}
	public void type() {
		System.out.println("Type the keyboard.");
	}
}
