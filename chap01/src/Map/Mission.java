package Map;

import Character.Hero;
import Character.Monster;

public class Mission {
	private String target;
	private int targetCount;
	private int progress;
	private int reward;

	public Mission(String target, int targetCount, int reward) {
		this.target = target;
		this.targetCount = targetCount;
		this.reward = reward;
		this.progress = 0;
	}

	public void checkProgress(Monster monster, Hero hero) {
		if (monster.getName().equals(target)) {
			progress++;
			System.out.println("미션 진행: " + progress + "/" + targetCount);
			if (progress >= targetCount) {
				System.out.println("미션 완료! 보상: +" + reward);
				hero.addMoney(reward);
				progress = 0;
			}
		}
	}
}