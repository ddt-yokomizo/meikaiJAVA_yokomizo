package stringBuild;
import static number.Number.*;

import java.util.ArrayList;

import player.ComPlayer;
import player.Player;
import player.You;

import static number.Constants.*;
	/**
	 * 
	 * @author masahiro
	 *　３人でお行うジャンケンプログラムを作成せよ。
	 *ぷれーや３人のうち、コンピュータ２人として人間を１人とすること。
	 *また、演習１３−３で作成したプレーヤクラスを利用すること。
	 *
	 */

public class E15_05 {
	/* ====================================================================== */
	/**
	 * @brief メインメソッド
	 *
	 * @param なし
	 *
	 * @return なし
	 *
	 * @note 
	 */
	/* ====================================================================== */

	public static void main(String[] args) {
		try {
			final String PLAYER_NAME = "プレーヤー名を入力＞"; // プレーヤー名を入力する際に表示するメッセージ
			final String PLAYERS_STRING = "プレイヤー数＞"; // プレーヤー数を入力する際に表示するメッセージ
			int numOfPlayers; //プレイヤー数

			//プレイヤーコレクションを宣言
			ArrayList<Player> players = new ArrayList<Player>();
			
			//プレイヤー数を３に決定
			numOfPlayers = sPLAYER3;
			
			System.out.println("\nあなたの操作するプレイヤーを作成します。");
			//プレイヤーオブジェクトを生成して格納
			players.add(new You(scannerInputString(PLAYER_NAME)));
			
			
			//コンピュータのプレイヤを生成してコレクションに格納（操作できるプレイヤーを１人とし、それ以外はCOMとする）
			for(int i = 0 ; i < (numOfPlayers - 1) ; i++){
				
				System.out.printf("\nコンピュータプレイヤー%dを作成します。",i);
				//コンピュータのプレイヤを生成してコレクションに格納
				players.add(new ComPlayer(scannerInputString(PLAYER_NAME)));
			}
			//生成したオブジェクトでジャンケンを行う
			Player.playOn(players);
			
		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}
}