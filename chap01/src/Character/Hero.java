package Character;

public abstract class Hero extends Character {
	protected int money;
	protected int exp;

	public Hero(String name) {
		super(name, 1, 100, 50, 10, 5);
		this.money = 0;
		this.exp = 0;
	}

	public void gainExp(int amount) {
		this.exp += amount;
		if (exp >= 100) {
			levelUp();
			exp -= 100;
		}
	}

	protected void levelUp() {
		level++;
		hp += 20;
		mp += 10;
		power += 5;
		defense += 5;
		money += 100;
		System.out.println(name + "이 레벨업 하였습니다! 현재 레벨: " + level);
	}

	public int getMoney() {
		return money;
	}

	public void addMoney(int m) {
		money += m;
	}

	public void deductMoney(int m) {
		money -= m;
	}
}