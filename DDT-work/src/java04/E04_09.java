package java04;

/**
 * 正の整数値を読み込んで、1から入力値までの積を求めるプログラムを作成せよ。
 */
import java.util.Scanner;

public class E04_09 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		// 入力値１用の変数
		int inputNum1 = 0;
		// 作業用変数(初期値1）
		int tmpNum = 1;

		do {
			System.out.print("正の整数を入力＞");
			// 入力値1
			inputNum1 = scanner.nextInt();
			// 0未満の値が入力されたらループ
		} while (inputNum1 < 0);

		// 入力値分ループ
		for (int i = 0; i < inputNum1; i++) {
			// 1から入力値までの積を計算
			tmpNum *= (i + 1);

		}

		System.out.println("1から" + inputNum1 + "までの積は" + tmpNum + "です。");

	}

}
