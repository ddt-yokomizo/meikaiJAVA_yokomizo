package java03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2つの正の整数値を読み込み、後者が前者の約数であれば 「BはAの約数です」と表示し、そうでなければ 「BはAの約数ではありません。」
 * と表示するプログラムを作成せよ。
 *
 */

public class E03_02 {

	public static void main(String[] args) throws IOException {
		// 標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("整数A：");
		// 変数 str をキーボードから入力
		String str1 = br.readLine();

		// 入力値をinteger型へ変換
		int num1 = Integer.parseInt(str1);

		System.out.print("整数B：");
		// 変数 str をキーボードから入力
		String str2 = br.readLine();

		// 入力値をinteger型へ変換
		int num2 = Integer.parseInt(str2);

		/**
		 * num2がnum1の約数であれば 「BはAの約数です」と表示し、
		 * そうでなければ 「BはAの約数ではありません。」 と表示する。
		 *
		 */
		if (num1 % num2 != 0) {
			System.out.println("BはAの約数ではありません。");

		} else {

			System.out.println("BはAの約数です");
		}

	}

}
