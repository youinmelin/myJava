package athlete_coach;

public abstract class Athlete extends Person{

    public abstract void learn();

    public Athlete() {
    }

    public Athlete(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("eat as a athlete");
    }
}
