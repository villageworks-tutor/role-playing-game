package rpg;

import rpg.character.Actor;
import rpg.character.Hero;

/**
 * ゲームを実行するクラス
 * @author villa
 */
public class Game {

	public static void main(String[] args) {
		
		int hp = Integer.parseInt(args[0]);
		int attack = Integer.parseInt(args[1]);
		
		System.out.println("★★★ ゲーム開始 ★★★");
		
		// オブジェクトの生成（名前：勇者、生命力：50、攻撃力：10）と情報の表示
		Actor brave = new Hero(hp, attack);
		System.out.println(brave.toString());
		
		partition();
		
		// 3体の敵キャラクタと戦う
		for (int count = 0; count < 3; count++) {
			
			// 敵キャラクタの生成
			Actor enemy = Actor.randomEnemy();
			System.out.println(enemy + "があらわれた！");
			partition();
			
			while (true) {
				
				// 勇者から敵への攻撃
				brave.attack(enemy);
				// 敵の情報を表示
				System.out.println("\t" + enemy);
				partition();
				// 敵の生命力を評価
				if (enemy.getHp() == 0) {
					System.out.println(enemy.getName() + "を倒した！");
					partition();
					partition();
					break; // 次の敵キャラクタを生成
				}
				
				// 敵から勇者への攻撃
				enemy.attack(brave);
				// 勇者の情報を表示
				System.out.println("\t" + brave);
				partition();
				// 勇者の生命力を評価
				if (brave.getHp() == 0) {
					System.out.println(brave.getName() + "はやられてしまった...");
					partition();
					partition();
					System.out.println("★★★ ゲームオーバー ★★★");
					return; // 強制的に終了
				}
			}
		}
		
		System.out.println("すべての敵を倒した！");
		partition();
		System.out.println("★★★ ゲーム終了 ★★★");
		
	}

	
	/**
	 * 処理の仕切りを表示する
	 */
	private static void partition() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("待機処理でエラーが発生しました");
			e.printStackTrace();
		}
		System.out.println("---------");
	}

}
