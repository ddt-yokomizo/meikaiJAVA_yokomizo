package test;
/**
 * 演習１４−３
 * クラスDVDPlayerを利用するプログラム例を作成せよ。
 * 
 */

import static number.Constants.*;
import static number.Number.*;

import java.io.IOException;

import dvdPlayer.DVDPlayer;

public class E14_03 {

	/* ====================================================================== */
	/**
	 * @brief メインメソッド
	 *
	 * @param なし
	 *
	 * @return なし
	 *
	 * @note DVDプレイヤーのインスタンスを１つ生成し、キーボードから入力した任意の操作を行う
	 */
	/* ====================================================================== */

	public static void main(String[] args) throws IOException {
		try {
			final String HOW_TO_MANIPULATE = "DVDプレイヤーをどのように操作しますか（1・・・再生　/ 2・・・停止 / 3・・・スロー再生 / 4・・・終了）"; // 操作を選択する際のメッセージ
			final int SELECT_OPERATION_MAX = 4; // 選択できる操作番号の最大値
			final int SELECT_OPERATION_MIN = 1; // 選択できる操作番号の最小値
			int selectedOperation; // 選択された操作番号

			// DVDプレイヤークラスのインスタンスを生成
			DVDPlayer player = new DVDPlayer();
			System.out.println("DVDプレイヤークラスのインスタンスを生成しました");

			// 終了番号が選択されるまでループ
			do {
				// 操作番号を入力
				selectedOperation = inputRangeCheck(SELECT_OPERATION_MIN, SELECT_OPERATION_MAX, HOW_TO_MANIPULATE);

				// 操作型列挙定数と入力した操作番号が一致していたらそれにあった処理を実行する
				// 再生する
				if (manipulateType.PLAY.getManipulate() == selectedOperation) {
					// playメソッドでDVDプレイヤーを再生する
					player.play();
					// スロー再生する
				} else if (manipulateType.SLOW_PLAY.getManipulate() == selectedOperation) {
					// slowPlayメソッドでDVDプレイヤーを再生する
					player.slowPlay();
					// 再生を止める
				} else if (manipulateType.STOP.getManipulate() == selectedOperation) {
					// stopメソッドでDVDプレイヤーの再生をストップする
					player.stop();
					// 終了する
				} else if (manipulateType.EXIT.getManipulate() == selectedOperation) {
					// 終了する
					System.out.println("終了します");
				}
			} while (manipulateType.EXIT.getManipulate() != selectedOperation);

		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}
}