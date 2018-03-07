package java03;

import java.util.Scanner;

/**
 * 2つの実数値を読み込んで、大きいほうの値を表示するプログラムを作成せよ。
 * 
 *
 */

public class E03_09 {

	public static void main(String[] args) {
		
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("整数１＞");
		//int型の変数num1を入力
		int num1 = scanner.nextInt();
		
		System.out.print("整数２＞");
		//int型の変数num1を入力
		int num2 = scanner.nextInt();
		
		//num1とnum2を比較し、大きい値を出力
		System.out.println("大きい方の値は" + ( num1 < num2 ? num2 : num1) + "です。");
		

	}

}
