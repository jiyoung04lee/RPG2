package game;

import java.util.Scanner;

public class Rpg_before_class {
	static int hero_level, hero_power, hero_hp, hero_defense, hero_mp, hero_experience, hero_money;
	static int monster_hp, monster_defense, monster_power, monster_mp, monster_level, monster_experience, monster_money;
	static String hero_name, monster_name;

	// 퀘스트: 너구리 처치 수 및 완료 여부
	static int raccoonKillCount = 0;
	static boolean isQuestCompleted = false;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("영웅의 이름을 입력하세요. : ");
		hero_name = in.next();
		System.out.println("이름이 입력되었습니다.\n게임에 입장하였습니다.\n");

		hero_level = 1;
		hero_power = 15;
		hero_defense = 25;
		hero_hp = 80;
		hero_mp = 0;
		hero_experience = 0;
		hero_money = 0;

		while (true) {
			printHeroStatus();
			System.out.println("1. 사냥터");
			System.out.println("2. 포션 상점");
			System.out.print("입장할 장소를 입력하세요. : ");
			int place = in.nextInt();

			if (place == 1) {
				System.out.println("사냥터에 입장하였습니다.");
				System.out.println("1. 너구리");
				System.out.println("2. 살쾡이");
				System.out.print("전투할 상대를 입력하세요. : ");
				int choice = in.nextInt();

				if (choice == 1) {
					monster_name = "너구리";
					monster_level = 1;
					monster_hp = 100;
					monster_mp = 0;
					monster_power = 20;
					monster_defense = 5;
					monster_money = 10;
					monster_experience = 10;
				} else if (choice == 2) {
					monster_name = "살쾡이";
					monster_level = 5;
					monster_hp = 2000;
					monster_mp = 0;
					monster_power = 100;
					monster_defense = 20;
					monster_money = 30;
					monster_experience = 50;
				} else {
					System.out.println("잘못된 선택입니다.");
					continue;
				}

				// (조건 4)
				System.out.println(monster_name + "과 전투를 시작합니다.");
				if (monster_name.equals("살쾡이")) {
					if (hero_power < 16 || hero_hp < 81) {
						System.out.println(hero_name + "은(는) 아직 " + monster_name + "을(를) 상대할 수 없습니다.");
						System.out.println("힘이 16 이상이고 HP가 81 이상이어야 전투가 가능합니다.");
						System.out.println("포션 상점에서 강화하고 다시 도전하세요!\n");
						continue;
					}
				}

				// 전투 루프
				while (true) {
					System.out.println("\n" + hero_name + "의 공격입니다.");
					System.out.println("1. 쓰러스트");
					System.out.print("공격 번호를 입력하세요 : ");
					int attackChoice = in.nextInt();
					int damage = 0;
					if (attackChoice == 1) {
						damage = hero_attack();
						System.out.println("데미지는 " + damage + "입니다.");
					}
					monster_attacked(damage);

					if (monster_hp <= 0) {
						System.out.println(monster_name + "가 죽었습니다.");
						hero_experience += monster_experience;
						hero_money += monster_money;

						// 퀘스트: 너구리 3마리 처치 보상
						if (monster_name.equals("너구리")) {
							raccoonKillCount++;
							if (raccoonKillCount == 3 && !isQuestCompleted) {
								System.out.println("[퀘스트 완료] 너구리 3마리를 처치했습니다! 보상으로 100골드를 받았습니다.");
								hero_money += 100;
								isQuestCompleted = true;
							} else if (!isQuestCompleted) {
								System.out.println("[퀘스트 진행중] 너구리 처치: " + raccoonKillCount + "/3");
							}
						}

						checkLevelUp();
						break;
					}

					int monsterDamage = monster_attack();
					System.out.println("\n" + monster_name + "의 공격입니다.");
					hero_attacked(monsterDamage);

					if (hero_hp <= 0) {
						hero_hp = 1;
						System.out.println(hero_name + "이(가) 사망 위기에서 부활했습니다!");
						break;
					}
				}

			} else if (place == 2) {
				potionStore_show(in);
			} else {
				System.out.println("잘못된 장소입니다.");
			}
		}
	}

	static int hero_attack() {
		return hero_level * 10 + hero_power * 30;
	}

	static void printHeroStatus() {
		System.out.println("현재 Hero 의 이름 : " + hero_name);
		System.out.println("현재 " + hero_name + "의 레벨 : " + hero_level);
		System.out.println("현재 " + hero_name + "의 힘 : " + hero_power);
		System.out.println("현재 " + hero_name + "의 방어력 : " + hero_defense);
		System.out.println("현재 " + hero_name + "의 HP : " + hero_hp);
		System.out.println("현재 " + hero_name + "의 MP : " + hero_mp);
		System.out.println("현재 " + hero_name + "의 경험치 : " + hero_experience);
		System.out.println("현재 " + hero_name + "의 돈 : " + hero_money + "원\n");
	}

	static void checkLevelUp() {
		if (hero_experience >= hero_level * 80) {
			hero_experience = 0;
			hero_level++;
			System.out.println(hero_name + "의 레벨이 " + hero_level + "이 되었습니다.");
			int bonusMoney = hero_level * 50;
			hero_money += bonusMoney;
			System.out.println("레벨업 기념으로 돈이 " + bonusMoney + "원 증가하여");
			System.out.println(hero_money + "원이 되었습니다.");
		}
	}

	static int monster_attack() {
		return monster_power;
	}

	static void monster_attacked(int sum) {
		int damage = sum - monster_defense;
		if (damage < 0)
			damage = 0;
		monster_hp -= damage;
		System.out.println(monster_name + "이(가) " + damage + "의 피해를 입었습니다.");
	}

	static void hero_attacked(int sum) {
		int damage = sum - hero_defense;
		if (damage < 0)
			damage = 0;
		hero_hp -= damage;
		System.out.println(hero_name + "이(가) " + damage + "의 피해를 입었습니다.");
	}

	static void potionStore_show(Scanner in) {
		System.out.println("포션 상점에 입장하였습니다.");
		System.out.println("1. 힘 증가 포션 (30원)");
		System.out.println("2. 방어력 증가 포션 (30원)");
		System.out.println("3. 경험치 증가 포션 (100원)");
		System.out.println("4. HP 증가 포션 (10원)");
		System.out.println("5. MP 증가 포션 (10원)");
		System.out.print("원하시는 물건을 입력하세요. : ");

		int choice = in.nextInt();
		boolean success = false;

		switch (choice) {
		case 1:
			if (hero_money >= 30) {
				hero_power += 3;
				hero_money -= 30;
				success = true;
			}
			break;
		case 2:
			if (hero_money >= 30) {
				hero_defense += 3;
				hero_money -= 30;
				success = true;
			}
			break;
		case 3:
			if (hero_money >= 100) {
				hero_experience += 50;
				hero_money -= 100;
				success = true;
			}
			break;
		case 4:
			if (hero_money >= 10) {
				hero_hp += 50;
				hero_money -= 10;
				success = true;
			}
			break;
		case 5:
			if (hero_money >= 10) {
				hero_mp += 50;
				hero_money -= 10;
				success = true;
			}
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}

		if (success) {
			System.out.println("포션 상점에서 물건을 구매하는 중입니다.");
			System.out.println("구입이 완료되었습니다.");
			System.out.println(hero_money + "원 남았습니다.");
		} else {
			System.out.println("돈이 부족하거나 잘못된 선택입니다.");
		}
	}
}
