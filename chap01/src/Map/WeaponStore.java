package Map;

import Character.Archer;
import Character.Hero;
import Character.Mage;
import Character.Warrior;

public class WeaponStore {
	public void buyWeapon(Hero hero) {
		if (hero instanceof Warrior && hero.getLevel() >= 3) {
			hero.setPower(hero.getPower() + 15);
			hero.deductMoney(100);
			System.out.println("전사 무기 구매! 파워 +15");
		} else if (hero instanceof Archer && hero.getLevel() >= 3) {
			hero.setPower(hero.getPower() + 10);
			hero.deductMoney(100);
			System.out.println("궁수 무기 구매! 파워 +10");
		} else if (hero instanceof Mage && hero.getLevel() >= 3) {
			hero.setPower(hero.getPower() + 20);
			hero.deductMoney(100);
			System.out.println("마법사 무기 구매! 파워 +20");
		} else {
			System.out.println("구매 조건 부족");
		}
	}
}