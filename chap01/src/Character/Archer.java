package Character;

public class Archer extends Hero {
	public Archer(String name) {
		super(name);
		power += 3;
		defense += 2;
	}

	public int attackType1() {
		System.out.println(name + "의 화살 발사!");
		return power * 2;
	}

	public int attackType2() {
		if (level >= 3) {
			System.out.println(name + "의 멀티샷!");
			return power * 3;
		} else {
			System.out.println("레벨 부족 (3레벨 이상)");
			return 0;
		}
	}
}