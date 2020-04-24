package demo14Polymorphism;

public class Zi extends Fu {
	String str = "I'm a Zi str";
	@Override
	public void method() {
		System.out.println("child class method.");
	}
	@Override
	public String getStr() {
		return str;
	}
	public void methodZi() {
		System.out.println("method zi only");
	}

}
