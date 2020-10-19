public class Person {
	String name;
	private int age;
	private boolean male;

	public void sayHello(){
		System.out.println("Hello");
	}
	public void setAge(int num) {
		if (num > 200 || num <0 ) {
			System.out.println("error age");
		}else{
			age = num;
		}
	}
	public int getAge() {
		return age;
	}
	public void setMale(boolean gender){
		male = gender;
	}
	public boolean isMale() {
		return male;
	}
}
