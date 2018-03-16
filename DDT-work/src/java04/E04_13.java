package java04;

import java.util.Scanner;

/**
 * 
 * @author yokomizomasahiro
 * １から入力値までの和を求めるプログラムを作成せよ
 *
 */
public class E04_13 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		//計算用の変数（初期値0）
		int tmpNum = 0;
		
		System.out.print("整数値＞");
		//入力値１
		int inputNum1 = scanner.nextInt();
		
		// 入力値分ループ
		for (int i = 0; i < inputNum1; i++) {
			// 1から入力値までの和を計算
			tmpNum += (i + 1);
		}
		
		//１から入力値までの和を出力
		System.out.println("1から" + inputNum1 + "までの和は" + tmpNum + "です。");

	}

}
