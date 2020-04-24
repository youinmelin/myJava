package demo14Polymorphism;

public class Laptop {
	public void turnOn(){
		System.out.println("Turn on the Laptop.");
	}

	public void usbDevice(Usb usb){
		usb.connect();
		if (usb instanceof Mouse){
			Mouse mouse = (Mouse) usb;
			mouse.click();
		}else if(usb instanceof Keyboard) {
			Keyboard keyboard = (Keyboard) usb;
			keyboard.type();
		}
		usb.disconnect();

	}
	
	public void turnOff(){
		System.out.println("Turn off the Laptop.");
	}

}
