package Main;

import java.util.Scanner;

import Character.Archer;
import Character.Hero;
import Character.Mage;
import Character.Monster;
import Character.Raccoon;
import Character.Warrior;
import Character.WildBoar;
import Character.WildDog;
import Character.Wildcat;
import Map.Mission;
import Map.PotionStore;
import Map.WeaponStore;

public class MainGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("==== RPG GAME ====");
		System.out.print("닉네임 입력: ");
		String name = sc.nextLine();

		System.out.println("직업 선택: 1. 전사 2. 궁수 3. 마법사");
		int job = sc.nextInt();
		Hero hero;

		if (job == 1)
			hero = new Warrior(name);
		else if (job == 2)
			hero = new Archer(name);
		else
			hero = new Mage(name);

		PotionStore ps = new PotionStore();
		WeaponStore ws = new WeaponStore();
		Mission mission = new Mission("살쾡이", 5, 200);

		while (true) {
			System.out.println("\n==== 메뉴 ====");
			System.out.println("1. 상태보기 2. 전투 3. 포션샵 4. 무기샵 5. 종료");
			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("레벨: " + hero.getLevel() + " HP: " + hero.getHp() + " MP: " + hero.getMp() + " 파워: "
						+ hero.getPower() + " 돈: " + hero.getMoney());
			} else if (menu == 2) {
				System.out.println("전투 상대 선택: 1. 너구리 2. 살쾡이 3. 들개 4. 멧돼지");
				int monSel = sc.nextInt();
				Monster monster;
				switch (monSel) {
				case 1:
					monster = new Raccoon();
					break;
				case 2:
					monster = new Wildcat();
					break;
				case 3:
					monster = new WildDog();
					break;
				case 4:
					monster = new WildBoar();
					break;
				default:
					monster = new Raccoon();
				}

				while (monster.isAlive() && hero.isAlive()) {
					System.out.println("공격 선택: 1. 일반 2. 특수공격");
					int atk = sc.nextInt();
					int damage = 0;

					if (hero instanceof Warrior warrior) {
						damage = (atk == 1) ? warrior.attackType1() : warrior.attackType2();
					} else if (hero instanceof Archer archer) {
						damage = (atk == 1) ? archer.attackType1() : archer.attackType2();
					} else if (hero instanceof Mage mage) {
						damage = (atk == 1) ? mage.attackType1() : mage.attackType2();
					}

					monster.takeDamage(damage);
					System.out.println(monster.getName() + " 남은 HP: " + monster.getHp());

					if (monster.isAlive()) {
						int monsterDamage = monster.getPower();
						hero.takeDamage(monsterDamage);
						System.out.println(hero.getName() + " 남은 HP: " + hero.getHp());
					}
				}

				if (!monster.isAlive()) {
					System.out.println("몬스터 처치!");
					hero.gainExp(50);
					hero.addMoney(100);
					mission.checkProgress(monster, hero);
				}
			} else if (menu == 3) {
				ps.buyPotion(hero);
			} else if (menu == 4) {
				ws.buyWeapon(hero);
			} else {
				System.out.println("게임 종료");
				break;
			}
		}
		sc.close();
	}
}
