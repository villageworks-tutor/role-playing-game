package rpg.character;

/**
 * ゴーストクラス：ゲームキャラクタクラスの継承クラス
 * @author villa
 */
public class Ghost extends Actor {

	public Ghost(int hp, int attack) {
		super("ゴースト", hp, attack);
	}

	@Override
	public void attack(Actor target) {
		System.out.println(this.getName() + "の叫び声！");
		super.attack(target);
	}

}
