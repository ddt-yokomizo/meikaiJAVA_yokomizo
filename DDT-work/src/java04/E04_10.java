package java04;

import java.util.Scanner;

/**
 * 
 * @author yokomizomasahiro 読み込んだ値が１未満であれば改行文字を出力しないように
 *         List4−11を書き換えたプログラムを作成せよ。
 *
 */

public class E04_10 {

	public static void main(String[] args) {

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		int inputNum1 = 0; // 入力値用変数

			System.out.print("整数値＞");
			// 入力値１
			inputNum1 = scanner.nextInt();
			
		//1以上の値を読み込んだ時にループ処理をする
		if (1 <= inputNum1) {

			for (int i = 1, j = inputNum1 - 1; i <= inputNum1; i++, j--) {
				// 読み込んだ整数値との１、２、・・・との差を出力
				System.out.println(i + " " + j);
			}
		}

	}

}
