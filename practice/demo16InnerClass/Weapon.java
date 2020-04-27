package demo16InnerClass;

public class Weapon {
    private String weaponName;
    private int hurtPoint;
    
	public Weapon() {
	}

	public Weapon(String weaponName, int hurtPoint) {
		this.weaponName = weaponName;
		this.hurtPoint = hurtPoint;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public int getHurtPoint() {
		return hurtPoint;
	}

	public void setHurtPoint(int hurtPoint) {
		this.hurtPoint = hurtPoint;
	}

    
}