package athlete_coach;

public class CoachBasketball extends Coach{
    public CoachBasketball() {
    }

    public CoachBasketball(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("teach basketball");
    }
}
