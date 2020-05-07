package demo37ObjectStream;

import java.io.Serializable;

public class Phone implements Serializable {
	private String type;
	private int price;

	public Phone( String type, int price) {
		this.type = type;
		this.price = price;
	}

	public String getType() {
		return type;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public String toString() {
		String ret = "Phone[Type:" + type + ",Price: " + price + "]";
		return ret;
	}
}


