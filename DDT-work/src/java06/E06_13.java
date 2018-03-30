package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro 配列Aの全要素を、配列Bに対して逆順にコピーするプログラムを作成せよ。
 *         また、配列の要素数は同一であるものと仮定して良い。
 *
 */

public class E06_13 {

	public static void main(String[] args) {

		// 配列Aを宣言
		int[] inputListA;
		// 配列Bを宣言
		int[] inputListB;
		// 要素数を宣言（配列Aと配列Bの共通の要素数）
		int yousoNum = 0;

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			do {

				System.out.print("要素数を設定してください。(1~10とする）＞");
				// 要素数を設定
				yousoNum = scanner.nextInt();
				if (yousoNum < 1 || 10 < yousoNum) {
					System.out.println("１〜１０の整数を入力してください。");
				}
			} while (yousoNum < 1 || 10 < yousoNum);

			// 設定した要素数の配列Aを生成
			inputListA = new int[yousoNum];
			// 設定した要素数の配列Bを生成
			inputListB = new int[yousoNum];
			// 配列Aに順番に値を格納
			for (int i = 0; i < inputListA.length; i++) {
				System.out.print("配列Aの" + (i + 1) + "番目の要素は？");
				// 要素に値を格納（入力）
				inputListA[i] = scanner.nextInt();
			}

			// 配列Bに順番に値を格納
			for (int i = 0; i < inputListB.length; i++) {
				System.out.print("配列Bの" + (i + 1) + "番目の要素は？");
				// 要素に値を格納（入力）
				inputListB[i] = scanner.nextInt();
			}

			System.out.println("配列Aの要素：");
			// 配列Aの全ての要素を出力する
			for (int j : inputListA) {
				// 配列の要素を順番に出力
				System.out.println(j);
			}

			System.out.println("コピー前の配列Bの要素：");
			// コピー前の配列Bの全ての要素を出力する
			for (int j : inputListB) {
				// 配列の要素を順番に出力
				System.out.println(j);
			}

			// 配列Aの要素を配列Bへ逆順にコピーする
			for (int k = 0; k < inputListA.length; k++) {
					inputListB[inputListB.length - (k + 1) ] = inputListA[k];
			}

			System.out.println("コピー後の配列Bの要素：");
			// コピー後の配列Bの全ての要素を出力する
			for (int m : inputListB) {
				// 配列の要素を順番に出力
				System.out.println(m);
			}

		} finally

		{
			// scannerをクローズ
			scanner.close();
		}
	}
}
