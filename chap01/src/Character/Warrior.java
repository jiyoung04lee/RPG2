package Character;

public class Warrior extends Hero {
	public Warrior(String name) {
		super(name);
		hp += 50;
		power += 10;
		defense += 10;
	}

	public int attackType1() {
		System.out.println(name + "의 쓰러스트!");
		return power * 2;
	}

	public int attackType2() {
		if (level >= 3) {
			System.out.println(name + "의 삼단베기!");
			return power * 3;
		} else {
			System.out.println("레벨 부족 (3레벨 이상)");
			return 0;
		}
	}
}