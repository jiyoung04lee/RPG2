package Map;

public class Weapon {
	private String name;
	private int damage;
	private int requiredLevel;
	private int requiredPower;

	public Weapon(String name, int damage, int requiredLevel, int requiredPower) {
		this.name = name;
		this.damage = damage;
		this.requiredLevel = requiredLevel;
		this.requiredPower = requiredPower;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

	public int getRequiredLevel() {
		return requiredLevel;
	}

	public int getRequiredPower() {
		return requiredPower;
	}

	@Override
	public String toString() {
		return name + " (DMG: " + damage + ", Lv: " + requiredLevel + ", POW: " + requiredPower + ")";
	}
}
