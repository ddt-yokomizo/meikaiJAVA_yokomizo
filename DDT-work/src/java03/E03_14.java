package java03;

import java.util.Scanner;

/**
 *
 * 2つの整数値を読み込んで、小さい方の値と大きい方の値の両方を表示する プログラムを作成せよ。ただし、2つの整数値が等しい場合は
 * 「2つの値は同じです」と表示すること。
 *
 */

public class E03_14 {

	public static void main(String[] args) {

		int maxNum = 0; // 最大値用の変数を初期化
		int minNum = 0; // 最小値用の変数を初期化

		Scanner scanner = new Scanner(System.in);

		System.out.print("整数１＞");
		// 整数１を入力
		int inputNum1 = scanner.nextInt();

		System.out.print("整数２＞");
		// 整数２を入力
		int inputNum2 = scanner.nextInt();

		if (inputNum1 == inputNum2) {
			//読み込んだ値が同値ならメッセージを出力
			System.out.println("2つの値は同じです");

		} else {

			if (inputNum1 < inputNum2) {
				// 整数1が整数2未満なら整数１を最小値とする
				minNum = inputNum1;
				// 整数1が整数2未満なら整数2を最大値とする
				maxNum = inputNum2;
			} else {
				// 整数2が整数1未満なら整数2を最小値とする
				minNum = inputNum1;
				// 整数2が整数1未満なら整数1を最大値とする
				maxNum = inputNum2;
			}
			//最小値と最大値を出力
			System.out.println("最小値は" + minNum + "、最大値は" + maxNum + "です。" );
		}

	}

}
