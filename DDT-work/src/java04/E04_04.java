package java04;

import java.util.Scanner;

/**
 *
 * List4-4のwhile文終了時にxの値が-1になることを確認するプログラムを作成せよ。
 *
 */

public class E04_04 {

	public static void main(String[] args) {

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		int inputNum1 = 0; // 入力値１の変数を宣言

		// メッセージを出力
		System.out.println("カウントダウンします");

		do {
			System.out.print("入力値1＞");
			// 入力値１
			inputNum1 = scanner.nextInt();

		//入力値１が0未満ならループ
		} while (inputNum1 <= 0);

		//入力値１が0未満になるまでループする
		while( 0 <= inputNum1){

			//入力値１を出力
			System.out.println(inputNum1);

			//入力値１をデクリメント
			inputNum1--;

		}

		//while文を抜けた後の入力値１を出力
		System.out.print("while文を抜けた後、値は" + inputNum1 + "となる。");

	}

}
