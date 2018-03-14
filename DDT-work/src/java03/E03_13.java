package java03;

/**
 * キーボードから読み込んだ3つの整数値の中央値を求めて表示するプログラムを作成せよ。
 *
 *
 */

import java.util.Scanner;

public class E03_13 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		System.out.print("整数１＞");
		// int型の変数inputNum1を入力
		int inputNum1 = scanner.nextInt();

		System.out.print("整数２＞");
		// int型の変数inputNum2を入力
		int inputNum2 = scanner.nextInt();

		System.out.print("整数３＞");
		// int型の変数inputNum3を入力
		int inputNum3 = scanner.nextInt();

		// 中央値用の変数を宣言
		int middleNum = 0;

		// 入力値を配列に格納
		int[] inputNums = { inputNum1, inputNum2, inputNum3 };

		/**
		 * 降順ソート
		 */

		// 配列の要素を順番にすべて調べるため、入力回数-1分ループ
		for (int i = 0; i < inputNums.length - 1; i++) {

			// ループ中の配列要素のとなりの要素と比較
			for (int j = i + 1; j < inputNums.length; j++) {

				if (inputNums[i] < inputNums[j]) {
					// 隣の要素が確認中の要素より大きければ、作業用変数へ格納
					int tmpNum = inputNums[j];

					// 大きかった要素に確認中要素を格納
					inputNums[j] = inputNums[i];

					// 作業用変数に格納していた大きい要素を確認中要素の位置へ格納
					inputNums[i] = tmpNum;
				}

			}
		}

		// 配列の要素数を判定
		switch (inputNums.length % 2) {

		case 0:
			//要素数が偶数の場合、要素の中間の値を中央値とする
			middleNum = inputNums[(inputNums.length / 2 ) -1];

			break;

		case 1:
			//要素数が奇数の場合、要素の中間の値を中央値とする
			middleNum = inputNums[(inputNums.length / 2 ) ];

			break;

		default:
			break;
		}

		// 中央値を出力
		System.out.println("中央値は" + middleNum + "です。");

		/**
		 * 【修正前コード２】

		if (inputNum1 < inputNum2) {

			if (inputNum2 < inputNum3) {
				// 変数２が変数１より大きく、変数３未満の場合変数２を中央値とする
				middleNum = inputNum2;
			} else if (inputNum3 < inputNum2) {
				// 変数２が変数１より大きく、変数３が変数２未満の場合変数３を中央値とする
				middleNum = inputNum3;
			} else {
				// 変数１を中央値とする
				middleNum = inputNum1;
			}

		} else {

			if (inputNum2 < inputNum3) {
				// 変数２が変数１より小さく、変数３未満の場合変数３を中央値とする
				middleNum = inputNum3;
			} else if (inputNum3 < inputNum2) {
				// 変数２が変数１より小さく、変数３より大きい場合変数２を中央値とする
				middleNum = inputNum2;
			} else {
				// 変数１を中央値とする
				middleNum = inputNum1;
			}

		}
		*/



		/**
		 * 修正前コード
		 *
		 *
		 * // 3つの入力値の中央値を出力 System.out.println("中央値は" + (num1 < num2 ? (num1 <
		 * num3 ? num3 : num2) : (num2 < num3 ? num3 : num2)) + "です。");
		 *
		 */

	}

}
