package demo16InnerClass;
public class BodyClass {

	public class Heart {
		public void methodHeart() {
			System.out.println("Heart beat.");
		}
	}
	
	private String name;

	public void methodBody() {
		System.out.println("Outer class method.");
		Heart heart = new Heart();
		heart.methodHeart();
		System.out.println("I am " + getName());
	}
	public BodyClass() {
	}
	public BodyClass(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
