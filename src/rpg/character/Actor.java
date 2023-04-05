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
	
}
