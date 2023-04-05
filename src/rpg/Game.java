package rpg;

import rpg.character.Actor;
import rpg.character.Hero;
import rpg.character.Zombie;

/**
 * ゲームを実行するクラス
 * @author villa
 */
public class Game {

	public static void main(String[] args) {
		
		System.out.println("★★★ ゲーム開始 ★★★");
		
		// オブジェクトの生成（名前：勇者、生命力：50、攻撃力：10）と情報の表示
		Actor brave = new Hero(50, 10);
		//Actor brave = new Hero(10, 5);
		System.out.println(brave.toString());
		
		partition();
		
		// オブジェクトの生成（名前：ゾンビ、生命力：15、攻撃力：5）と情報の表示
		Actor zombie = new Zombie(15, 5);
		System.out.println(zombie + "があらわれた！");
		
		partition();
		
		while (true) {
			// 勇者から敵への攻撃
			brave.attack(zombie);
			// 敵の情報を表示
			System.out.println("\t" + zombie);
			
			partition();
			
			if (zombie.getHp() == 0) {
				System.out.println(zombie.getName() + "を倒した！");
				partition();
				partition();
				System.out.println("★★★ ゲーム終了 ★★★");
				break;
			}
	
			// 敵から勇者への攻撃
			zombie.attack(brave);
			// 勇者の情報を表示
			System.out.println("\t" + brave);
			
			partition();
			
			if (brave.getHp() == 0) {
				System.out.println(brave.getName() + "はやられてしまった...");
				partition();
				partition();
				System.out.println("★★★ ゲームオーバー ★★★");
				break;
			}
			
		}
		
//		System.out.println("★★★ ゲーム終了 ★★★");
		
	}

	/**
	 * 処理の仕切りを表示する
	 */
	private static void partition() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("待機処理でエラーが発生しました");
		}
		System.out.println("---------");
	}

}
