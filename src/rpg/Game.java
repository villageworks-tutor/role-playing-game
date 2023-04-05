package rpg;

import rpg.character.Actor;

/**
 * ゲームを実行するクラス
 * @author villa
 */
public class Game {

	public static void main(String[] args) {
		
		System.out.println("★★★ ゲーム開始 ★★★");
		
		// オブジェクトの生成（名前：勇者、生命力：50、攻撃力：10）と情報の表示
		Actor brave = new Actor("勇者", 50, 10);
		System.out.println(brave.toString());
		
		partition();
		
		// オブジェクトの生成（名前：ゾンビ、生命力：15、攻撃力：5）と情報の表示
		Actor zombie = new Actor("ゾンビ", 15, 5);
		System.out.println(zombie + "があらわれた！");
		
		partition();
		
		// 勇者から敵への攻撃
		brave.attack(zombie);
		// 敵の情報を表示
		System.out.println("\t" + zombie);
		
		partition();

		// 敵から勇者への攻撃
		zombie.attack(brave);
		// 勇者の情報を表示
		System.out.println("\t" + brave);
		
		partition();
		
		// 勇者から敵への攻撃
		brave.attack(zombie);
		// 敵の情報を表示
		System.out.println("\t" + zombie);
		
		partition();
		System.out.println("★★★ ゲーム終了 ★★★");
		
	}

	private static void partition() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("待機処理でエラーが発生しました");
		}
		System.out.println("---------");
	}

}
