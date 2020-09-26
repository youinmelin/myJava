package athlete_coach;

public class AthleteTennis extends Athlete implements LearnEnglish{
    @Override
    public void learn() {
        System.out.println("learn tennis");
    }

    public AthleteTennis() {
    }

    public AthleteTennis(String name, int age) {
        super(name, age);
    }

    @Override
    public void learnEnglish() {
        System.out.println("learn english");

    }

}
