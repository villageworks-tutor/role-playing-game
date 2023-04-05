package rpg;

import rpg.character.Actor;

/**
 * ゲームを実行するクラス
 * @author villa
 */
public class Game {

	public static void main(String[] args) {
		
		// オブジェクトの生成（名前：勇者、生命力：50、攻撃力：10）と情報の表示
		Actor brave = new Actor("勇者", 50, 10);
		System.out.println(brave.toString());
		
		// オブジェクトの生成（名前：ゾンビ、生命力：15、攻撃力：5）と情報の表示
		Actor zombie = new Actor("ゾンビ", 15, 5);
		System.out.println(zombie);

	}

}
