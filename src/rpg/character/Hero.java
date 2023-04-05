package rpg.character;

/**
 * 勇者クラス：ゲームキャラクタクラスの継承クラス
 * @author villa
 */
public class Hero extends Actor {

	/**
	 * コンストラクタ
	 * @param hp     生命力
	 * @param attack 攻撃力
	 */
	public Hero(int hp, int attack) {
		super("勇者", hp, attack);
	}

	@Override
	public void attack(Actor target) {
		System.out.println(this.getName() + "は剣で切りつけた");
		super.attack(target);
	}

}
