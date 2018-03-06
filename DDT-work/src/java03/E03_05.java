package java03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 正の整数値を読み込んで、それが5で割り切れれば「その値は5で割り切れます。」と
 * 表示し、そうでなければ「その値は5で割り切れません。」と表示するプログラムを作成せよ。
 * ※正でない値を読み込んだ場合は、「正でない値が入力されました。」と表示すること。
 *
 *
 */

public class E03_05 {

	public static void main(String[] args) throws IOException {

		// 標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("正の整数値を入力＞");
		// 変数 str をキーボードから入力
		String str = br.readLine();

		// 入力値をinteger型へ変換
		int num = Integer.parseInt(str);

		/**
		 * 入力値が5で割り切れるか判定し、結果により以下のメッセージを出力
		 *
		 * 【割り切れる場合】 ・その値は5で割り切れます。
		 *
		 * 【割り切れない場合】 ・その値は5で割り切れません。
		 *
		 * 【正の整数値以外の値を読み込んだ場合】 ・正でない値が入力されました。
		 *
		 *
		 */
		if (0 > num) {
			System.out.println("正でない値が入力されました。");
		} else {

			if (num % 5 == 0) {
				System.out.println("その値は5で割り切れます。");
			} else if (num % 5 != 0) {
				System.out.println("その値は5で割り切れません。");
			}

		}

	}

}
