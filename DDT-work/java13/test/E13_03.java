package test;

import static number.Constants.*;
import static number.Number.*;

import java.util.ArrayList;

import player.Player;

public class E13_03 {


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
			final String SELECT_PLAYER_TYPE = "ジャンケンするプレイヤーを決定します（　１・・・人間 / ２・・・COM　）＞"; // プレーヤータイプ選択時のメッセージ
			final int SELECT_TYPE_MAX = 2; //選択できるプレイヤータイプの最大値
			final int SELECT_TYPE_MIN = 1; //選択できるプレイヤータイプの最大値
			final int HUMAN_PLAYER = 1; //プレイヤータイプ（人間）
			final int COM_PLAYER = 2; //プレイヤータイプ（コンピュータ）
			int playerType; //プレイヤータイプ
			int numOfPlayers; //プレイヤー人数
			
			//プレイヤーコレクションを宣言
			ArrayList<Player> playerArray = new ArrayList<Player>();
			
			//２人対戦に決定
			numOfPlayers = sPLAYER1ON1;
			
			//対戦人数分ループしてコレクションにPlayer変数を格納
			for(int playerIndex = 0 ; playerIndex < numOfPlayers ; playerIndex++){		
				//プレーヤータイプを決定
				playerType = inputRangeCheck(SELECT_TYPE_MIN, SELECT_TYPE_MAX, SELECT_PLAYER_TYPE);
				
				//選択されたプレイヤーが人間の場合
				if(playerType == HUMAN_PLAYER){
					//人間プレイヤー変数をコレクションへ格納
					playerArray.add(createHumPlayer());
				}
				
				//選択されたプレイヤーがコンピュータの場合
				if(playerType == COM_PLAYER){
					//コンピュータプレイヤー変数をコレクションへ格納
					playerArray.add(createComPlayer());
				}
				
			}
			
			
			//自分以外のインスタンスと総当たりで対戦
			for (int i = 0 ; i < playerArray.size() ; i++){
				for (int j = 0 ; j < playerArray.size() ; j++){
					//自分以外のインスタンスと対戦
					if(i != j){
						System.out.println((i + 1) + "番目のプレイヤーが" + (j + 1) + "番目のプレイヤーと対戦");
						//対戦
						playerArray.get(i).play(playerArray.get(j));
					}
				}
			}
			
		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}
	
	/* ====================================================================== */
	/**
	 * @brief 人間プレイヤークラスのインスタンスを生成して返却するメソッド
	 * 
	 * @author masahiro
	 *
	 * @param 
	 *
	 * @return 生成した人間プレイヤークラスのインスタンス変数
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Player createHumPlayer() {
		// 作成した人間プレイヤーインスタンスを返却
		return new player.You();
	}
	
	/* ====================================================================== */
	/**
	 * @brief コンピュータプレイヤークラスのインスタンスを生成して返却するメソッド
	 *
	 * @author masahiro
	 *
	 * @param
	 *
	 * @return  生成したコンピュータプレイヤークラスのインスタンス変数
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Player createComPlayer() {
		// 作成したコンピュータプレイヤーインスタンスを返却
		return new player.ComPlayer();
	}
}
