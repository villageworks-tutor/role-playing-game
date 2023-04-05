package rpg.character;

/**
 * ゲームキャラクタクラス
 * @author villa
 */
public class Actor {
	
	/**
	 * フィールド
	 */
	private String name; // キャラクター名
	private int hp;      // 生命力
	private int attack;  // 攻撃力
	
	/**
	 * コンストラクタ
	 * @param name   キャラクター名
	 * @param hp     生命力
	 * @param attack 攻撃力
	 */
	public Actor(String name, int hp, int attack) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
	}

	/**
	 * キャラクター名を取得する
	 * @return name キャラクター名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 生命力を取得する
	 * @return hp 生命力
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * 攻撃力を取得する
	 * @return attack 攻撃力
	 */
	public int getAttack() {
		return attack;
	}

	@Override
	public String toString() {
		return this.name + "（HP：" + this.hp + "）";
	}
	
	/**
	 * 攻撃する
	 * @param target 攻撃する相手のActorクラスのインスタンス
	 */
	public void attack(Actor target) {
		if (target.hp >= this.attack) {
			target.hp -= this.attack;
		} else {
			target.hp = 0;
		}
		System.out.println(this.name + "の攻撃");
		System.out.println("\t" + target.name + "に" + this.attack + "のダメージを与えた！");
	}
	
}
