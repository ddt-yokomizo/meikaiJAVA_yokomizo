package java03;

import java.util.Scanner;

/**
 * 2つの整数値を読み込んで、その値の差を表示するプログラムを作成せよ。
 *
 */

public class E03_10 {

	public static void main(String[] args) {

		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		System.out.print("整数１＞");
		//int型の変数num1を入力
		int num1 = scanner.nextInt();

		System.out.print("整数２＞");
		//int型の変数num1を入力
		int num2 = scanner.nextInt();

		//num1とnum2を比較し、その差分値を出力
		System.out.println("2つの値の差は" + ( num1 < num2 ? num2 - num1 : num1 - num2) + "です。");

	}

}
