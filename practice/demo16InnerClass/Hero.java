package demo16InnerClass;

public class Hero {
    private String name;
    private int age;
    private Weapon weapon;
    private Skill skill;

    public Hero() {
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    void attack() {
        String attackStr = "The Hero " + name + " use " + weapon.getWeaponName() + " to give the enemy " + weapon.getHurtPoint() + " points hurt.";
        System.out.println(attackStr);
    }

    void showSkill() {
        System.out.println(name);
        skill.type();
        skill.level ();
    }

    public Hero(String name, int age, Weapon weapon, Skill skill) {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
        this.skill = skill;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    
}