package java03;

import java.util.Scanner;

/**
 * キーボードから読み込んだ3つの整数値の最小値を求めて表示するプログラムを作成せよ。
 *
 *
 */

public class E03_12 {

	public static void main(String[] args) {

		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		System.out.print("整数１＞");
		//int型の変数inputNum1を入力
		int inputNum1 = scanner.nextInt();

		System.out.print("整数２＞");
		//int型の変数inputNum2を入力
		int inputNum2 = scanner.nextInt();

		System.out.print("整数３＞");
		//int型の変数inputNum3を入力
		int inputNum3 = scanner.nextInt();

		int minNum = inputNum1; //整数１を一旦最小値とする

		if (inputNum2 < minNum ){
			//整数２が最小値より小さければ最小値を変数２へ更新
			minNum = inputNum2;
		}

		if (inputNum3 < minNum ){
			//整数３が最小値より小さければ最小値を変数３へ更新
			minNum = inputNum3;
		}

		System.out.println("最小値は" + minNum + "です。");


		/**
		 * 訂正前コード
		 *
		 * //入力値の最小値を出力
		 * System.out.println("最小値は" + ( inputNum1 < inputNum2 ? (inputNum1 < inputNum3 ? inputNum1 : inputNum3)  : (inputNum2 < inputNum3 ? inputNum2 : inputNum3)) + "です。");
		 *
		 *
		 *
		 */






	}

}
