package java04;

import java.util.Scanner;

/**
 *
 * 「inputNum1--」(デクリメント)が「--inputNum1」となっている場合にどのような出力結果が得られるか考察せよ。
 * プログラムを作成し実行結果を確認すること。
 *
 */

public class E04_05 {

	public static void main(String[] args) {

		/**
		 * 【考察結果】
		 * 後置減分演算子の場合は減少前（デクリメント）の値が生成され、
		 * 前置減分演算子の場合は減少後（デクリメント）の値が生成される。
		 *
		 * inputNum1--　の場合
		 * 入力値が5だとしたら
		 * System.out.print(inputNum1--);
		 * の出力結果は5となる。
		 *
		 * --inputNum1　の場合
		 * 入力値が5だとしたら
		 * System.out.print(--inputNum1);
		 * の出力結果は4となる。
		 *
		 *
		 */

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		int inputNum1 = 0; // 入力値１の変数を宣言

		// メッセージを出力
		System.out.println("カウントダウンします");

		do {
			System.out.print("入力値1＞");
			// 入力値１
			inputNum1 = scanner.nextInt();

			// 入力値１が0未満ならループ
		} while (inputNum1 <= 0);

		// 入力値１が0未満になるまでループする
		while (0 <= inputNum1) {

			// 入力値１をデクリメントしてから出力
			System.out.println(--inputNum1);

		}


	}

}
