package java04;

import java.util.Scanner;

/**
 *
 * 正の整数値を読み込んで、その桁数を表示するプログラムを作成せよ。
 *
 */
public class E04_08 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		// 入力値１用の変数
		int inputNum1 = 0;
		// 桁を格納する変数
		int ketaNum = 0;

		do {
			System.out.print("正の整数を入力＞");
			// 入力値1
			inputNum1 = scanner.nextInt();
			// 0未満の値が入力されたらループ
		} while (inputNum1 < 0);

		// 桁が数えられなくなるまでループ
		while (0 < inputNum1) {
			//桁をインクリメント
			ketaNum++;

			//入力値１を10で割る
			inputNum1 /= 10;
		}

		System.out.println("入力値は" + ketaNum + "桁です。");

	}

}
