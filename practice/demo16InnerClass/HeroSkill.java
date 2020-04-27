package demo16InnerClass;

public class HeroSkill {
    public static void main(String[] args) {
        Hero Snape = new Hero();
        Skill SnapeSkill = new Skill(){
        
            @Override
            public void type() {
                System.out.println("Skill is read mind.");
            }
        
            @Override
            public void level() {
                System.out.println("Skill level is 10.");
            }
        };
        Snape.setName("Snape");
        Snape.setAge(50);
        Snape.setSkill(SnapeSkill);
        Snape.showSkill();
    }
}