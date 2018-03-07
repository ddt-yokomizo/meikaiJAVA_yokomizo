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
		//int型の変数num1を入力
		int num1 = scanner.nextInt();

		System.out.print("整数２＞");
		//int型の変数num2を入力
		int num2 = scanner.nextInt();

		System.out.print("整数３＞");
		//int型の変数num3を入力
		int num3 = scanner.nextInt();


		//入力値の最小値を出力
		System.out.println("最小値は" + ( num1 < num2 ? (num1 < num3 ? num1 : num3)  : (num2 < num3 ? num2 : num3)) + "です。");



	}

}
