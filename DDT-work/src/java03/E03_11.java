package java03;

/**
 * 2つの整数値を読み込んで、それらの値の差が10以下であれば
 * 「それらの差は10以下です」と表示し、そうでなければ
 * 「それらの差は11以上です」と表示するプログラムを作成せよ。
 */

import java.util.Scanner;

public class E03_11 {

	public static void main(String[] args) {

		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		System.out.print("整数１＞");
		//int型の変数num1を入力
		int num1 = scanner.nextInt();

		System.out.print("整数２＞");
		//int型の変数num1を入力
		int num2 = scanner.nextInt();

		/**
		 * num1とnum2を比較し、それらの値の差が10以下であれば
		 * 「それらの差は10以下です」と表示し、そうでなければ
		 * 「それらの差は11以上です」と表示する。
		 */
		System.out.println("それらの差は" + (( num1 < num2 ? num2 - num1 : num1 - num2) <= 10 ? "10以下" : "11以上" )  + "です。");

	}

}
