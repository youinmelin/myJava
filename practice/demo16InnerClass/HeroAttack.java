package demo16InnerClass;

public class HeroAttack {

    public static void main(String[] args) {
        String heroName = "Harry Potter";
        int heroAge = 11;
        Weapon wand = new Weapon("black wand", 10);
        Hero hero = new Hero();
        hero.setName(heroName);
        hero.setAge(heroAge);
        hero.setWeapon(wand);
        hero.attack();
    }
}