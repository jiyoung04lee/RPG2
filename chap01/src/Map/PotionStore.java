package Map;

import Character.Hero;

public class PotionStore {
	public void buyPotion(Hero hero) {
		if (hero.getMoney() >= 50) {
			hero.setHp(hero.getHp() + 30);
			hero.deductMoney(50);
			System.out.println("포션 구매! HP +30");
		} else {
			System.out.println("소지금 부족");
		}
	}
}
