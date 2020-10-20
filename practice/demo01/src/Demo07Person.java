public class Demo07Person {
	public static void main(String[] args) {
		Person one = new Person();
		one.sayHello();
		one.setAge(20);
		int age = one.getAge();
		System.out.println(age);
	}
}

