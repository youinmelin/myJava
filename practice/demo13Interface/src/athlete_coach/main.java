package athlete_coach;

public class main {
    public static void main(String[] args) {
        Coach coachTennis = new CoachTennis("coach",22);
        coachTennis.eat();
        coachTennis.teach();

        AthleteTennis athleteTennis = new AthleteTennis();
        athleteTennis.setAge(29);
        athleteTennis.setName("haha");
        System.out.println(athleteTennis);
        athleteTennis.eat();
        athleteTennis.learn();
        athleteTennis.learnEnglish();

    }
}
