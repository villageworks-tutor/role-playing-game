package rpg.character;

public class ActorUtils {

	public static Actor randomEnemy(int weight) {
		int hp = 10 * weight;
		int attack = 5 * weight;
		Actor enemy = null;
		if (weight < 3) {
			enemy = new Zombie(hp, attack);
		} else {
			enemy = new Ghost(hp, attack);
		}
		return enemy;
	}

}
