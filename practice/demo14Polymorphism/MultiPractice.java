package demo14Polymorphism;
public class MultiPractice {
	public static void main(String[] args) {
		Laptop asus = new Laptop();
		asus.turnOn();
		Usb usb = new Mouse();
		asus.usbDevice(usb);
		asus.usbDevice(new Keyboard());
		asus.turnOff();
	}
}
