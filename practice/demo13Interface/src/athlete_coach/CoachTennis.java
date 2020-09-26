package athlete_coach;

public class CoachTennis extends Coach{
    public CoachTennis() {
    }

    public CoachTennis(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("teach tennis");
    }
}
