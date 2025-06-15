package Character;

public abstract class Character {
	protected String name;
	protected int level;
	protected int hp;
	protected int mp;
	protected int power;
	protected int defense;

	public Character(String name, int level, int hp, int mp, int power, int defense) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.mp = mp;
		this.power = power;
		this.defense = defense;
	}

	public boolean isAlive() {
		return hp > 0;
	}

	public void takeDamage(int damage) {
		hp -= damage;
		if (hp < 0)
			hp = 0;
	}

	// Getter Setter 추가
	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
}