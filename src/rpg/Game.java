package rpg;

import java.util.Scanner;

import rpg.character.Actor;
import rpg.character.Hero;

/**
 * ゲームを実行するクラス
 * @author villa
 */
public class Game {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int hp = Integer.parseInt(args[0]);
		int attack = Integer.parseInt(args[1]);
		
		System.out.println("★★★ ゲーム開始 ★★★");
		
		// オブジェクトの生成（名前：勇者、生命力：50、攻撃力：10）と情報の表示
		Actor brave = new Hero(hp, attack);
		System.out.println(brave.toString());
		
		partition();
		
		for (int count = 0; count < 3; count++) {
			
			// 敵キャラクタの生成
			Actor enemy = Actor.randomEnemy();
			System.out.println(enemy + "があらわれた！");
			partition();
			
			while (true) {
				System.out.println("どうしますか？");
				System.out.print("\t[1]攻撃　[2]回復　[3]逃げる：");
				int behavior = scanner.nextInt();
				
				partition();
				
				if (behavior == 1) {
					// 勇者から敵への攻撃
					fight(brave, enemy);
					partition();
					if (isDefeated(enemy)) break; // 次の敵キャラクタを生成
					
					// 敵から勇者への攻撃
					fight(enemy, brave);
					partition();
					if (isDefeated(brave)) return; // 強制的に終了
				} else if (behavior == 2) {
					brave.heal();
					System.out.println("\t" + brave);
					partition();
				} else {
					System.out.println(brave.getName() + "は逃げ出した！");
					partition();
					count--;
					break;
				}
				
			}
		}
		
		System.out.println("すべての敵を倒した！");
		partition();
		System.out.println("★★★ ゲーム終了 ★★★");
		
	}

	/**
	 * 指定されたキャラクタの生命力を判定する
	 * @param target 指定されたキャラクタ
	 * @return キャラクタの生命力が0の場合はtrue、それ以外はfalse
	 */
	private static boolean isDefeated(Actor target) {
		// ターゲットの生命力が0でない場合
		if (target.getHp() > 0) return false;
		if (target instanceof Hero) {
			System.out.println(target.getName() + "はやられてしまった...");
			partition();
			partition();
			System.out.println("★★★ ゲームオーバー ★★★");
		} else {
			System.out.println(target.getName() + "を倒した！");
			partition();
			partition();
		}
		return true;
	}

	/**
	 * キャラクタを戦わせる
	 * @param attacker 攻撃するキャラクタ
	 * @param reciever 攻撃されるキャラクタ
	 */
	private static void fight(Actor attacker, Actor reciever) {
		// 勇者から敵への攻撃
		attacker.attack(reciever);
		// 敵の情報を表示
		System.out.println("\t" + reciever);
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
