package athlete_coach;

public abstract class Coach extends Person{

    public abstract void teach();

    @Override
    public void eat() {
        System.out.println("eat as a coach");
    }

    public Coach() {
    }

    public Coach(String name, int age) {
        super(name, age);
    }
}
