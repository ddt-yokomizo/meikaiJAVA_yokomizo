package java04;

import java.util.Scanner;

/**
 * 
 * @author yokomizomasahiro 演習4−13のプログラムを書き換えて、 「式」まで表示するよう変更せよ。
 *
 */
public class E04_14 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		// 文字列を扱う
		StringBuffer outputBuff = new StringBuffer();

		// 計算用の変数（初期値0）
		int tmpNum = 0;

		System.out.print("整数値＞");
		// 入力値１
		int inputNum1 = scanner.nextInt();

		// 入力値分ループ
		//ループ処理とStringBufferクラスを使って式を作成する
		for (int i = 0; i < inputNum1; i++) {
			// 1から入力値までの和を計算
			tmpNum += (i + 1);
			if (i != 0) {
				// ループ一周目ではないなら文字列に＋を結合
				outputBuff.append(" + ");

			}
			
			//文字列にループ回数と同じ値を結合
			outputBuff.append(String.valueOf(i + 1));

			if (i == (inputNum1 - 1)) {
				// 最終ループなら文字列に＝を結合
				outputBuff.append(" = ");
				// 和を結合
				outputBuff.append(String.valueOf(tmpNum));

			}

		}

		// 結合した文字列を出力
		System.out.println(outputBuff);

	}

}
