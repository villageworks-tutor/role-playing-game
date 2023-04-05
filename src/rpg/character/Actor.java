package rpg.character;

import java.util.Random;

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
	private int maxHp;   // 最大生命力
	
	/**
	 * コンストラクタ
	 * @param name   キャラクター名
	 * @param hp     生命力（最大生命力も兼ねる）
	 * @param attack 攻撃力
	 */
	public Actor(String name, int hp, int attack) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.maxHp = hp;
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
		return this.name + "（HP：" + this.hp + "/" + this.maxHp + "）";
	}
	
	/**
	 * 攻撃する
	 * @param target 攻撃する相手のActorクラスのインスタンス
	 */
	public void attack(Actor target) {
		// 攻撃する相手の生命力を減らす
		if (target.hp >= this.attack) {
			// 相手の生命力が自身の攻撃力より大きい場合：攻撃力の分だけ減らす
			target.hp -= this.attack;
		} else {
			// 相手の生命力が自身の攻撃力より小さい場合：0に設定 ⇐ 相手の生命力が0以下になった場合は0に設定
			target.hp = 0;
		}
		System.out.println("\t" + target.name + "に" + this.attack + "のダメージを与えた！");
	}
	
	/**
	 * ランダムに敵キャラクタを生成する
	 * @return 「ゾンビ　生命力:10　攻撃力：5」、「ゾンビ　生命力:20　攻撃力：10」、「ゴースト　生命力：30　攻撃力：15」のいずれかのオブジェクト
	 */
	public static Actor randomEnemy() {
		//　1から3までの整数の乱数を発生
		Random random = new Random();
		int weight = random.nextInt(3) + 1;
		// 乱数をもとに敵キャラクタを生成
		Actor enemy = randomEnemyBy(weight);
		// 生成した敵キャラクタを返却
		return enemy;
	}

	/**
	 * 重みに対応した敵キャラクタを生成する
	 * @param weight 敵キャラクタを生成するための重み：1から3までの範囲の整数
	 * @return 重みが1の場合は「ゾンビ　生命力:10　攻撃力：5」、重みが2の場合は「ゾンビ　生命力:20　攻撃力：10」、重みが3の場合は「ゴースト　生命力：30　攻撃力：15」のオブジェクト
	 */
	public static Actor randomEnemyBy(int weight) {
		// 重みから生命力、攻撃力を計算
		int hp = 10 * weight;
		int attack = 5 * weight;
		// 重みで敵キャラクタの生成を分岐
		Actor enemy = null;
		if (weight < 3) {
			// 重みが１または2の場合：ゾンビを生成
			enemy = new Zombie(hp, attack);
		} else {
			// 重みが3の場合：ゴーストを生成
			enemy = new Ghost(hp, attack);
		}
		// 生成した敵キャラクタを返却
		return enemy;
	}
	
	/**
	 * 生命力を回復する
	 */
	public void heal() {
		if (((double) this.hp) / this.maxHp < 1.0) {
			this.hp += this.maxHp;
		} else {
			this.hp = this.maxHp;
		}
		System.out.println(this.name + "は回復した！");
	}
	
}
