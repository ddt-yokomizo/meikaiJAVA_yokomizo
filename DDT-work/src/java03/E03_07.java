package java03;
/**
 * 正の整数値を読み込んで、それを3で割った値に応じて「その値は3で割り切れます。」、
 * 「その値を3で割った余りは1です。」、「その値を3で割った余りは2です。」と表示するプログラムを作成せよ。
 * ※正でない値を読み込んだ場合は、「正でない値が入力されました。」と表示すること。
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E03_07 {

	public static void main(String[] args) throws IOException {

		// 標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("正の整数値を入力＞");
		// 変数 str をキーボードから入力
		String str = br.readLine();

		// 入力値をinteger型へ変換
		int num = Integer.parseInt(str);

		/**
		 * 入力値を3で除算し、結果により以下のメッセージを出力
		 *
		 * 【割り切れる場合】 ・その値は3で割り切れます。
		 *
		 * 【余りが1となる場合】 ・その値を3で割った余りは1です。
		 *
		 * 【余りが2となる場合】 ・その値を3で割った余りは2です。
		 *
		 * 【正の整数値以外の値を読み込んだ場合】 ・正でない値が入力されました。
		 *
		 * ※【0以上3未満の値を読み込んだ場合】 ・0以上3未満の値は対象外
		 *
		 *
		 */
		if (0 > num) {
			System.out.println("正でない値が入力されました。");
		} else {

			if (num < 3 && 0 <= num) {
				System.out.println("0以上3未満の値は対象外");

			} else {

				if (num % 3 == 0) {
					System.out.println("その値は3で割り切れます。");
				} else if (num % 3 == 1) {
					System.out.println("その値を3で割った余りは1です。");
				} else if (num % 3 == 2) {
					System.out.println("その値を3で割った余りは2です。");
				}

			}

		}

	}

}
