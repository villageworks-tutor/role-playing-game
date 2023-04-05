package rpg.character;

/**
 * ゾンビクラス：ゲームキャラクタクラスの継承クラス
 * @author villa
 */
public class Zombie extends Actor {

	/**
	 * コンストラクタ
	 * @param hp     生命力
	 * @param attack 攻撃力
	 */
	public Zombie(int hp, int attack) {
		super("ゾンビ", hp, attack);
	}

	@Override
	public void attack(Actor target) {
		System.out.println(this.getName() + "の体当たり！");
		super.attack(target);
	}

}
