package Character;

public class Mage extends Hero {
	public Mage(String name) {
		super(name);
		mp += 30;
		power += 5;
	}

	public int attackType1() {
		System.out.println(name + "의 파이어볼!");
		return power * 2;
	}

	public int attackType2() {
		if (level >= 3) {
			System.out.println(name + "의 라이트닝 스트라이크!");
			return power * 4;
		} else {
			System.out.println("레벨 부족 (3레벨 이상)");
			return 0;
		}
	}
}