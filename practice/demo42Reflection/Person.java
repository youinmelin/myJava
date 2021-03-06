package demo42Reflection;
public class Person {
	private String name;
	private int age;

	public String publicName;
	protected String protectedName;
	String justName;

	public Person () {
	}
	public Person (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public void eat() {
		System.out.println("eating...");
	}

	public void eat(String str) {
		System.out.println(str + " is eating...");
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", justName=" + justName + ", name=" + name + ", protectedName=" + protectedName
				+ ", publicName=" + publicName + "]";
	}
}
