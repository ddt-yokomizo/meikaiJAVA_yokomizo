package java03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから読み込んだ点数に応じて、 優/良/可/不可を判定して表示するプログラムを作成せよ。 判定は以下のように行うこと。
 *
 * 0～59 ⇒不可 60～69 ⇒可 70～79 ⇒良 80～100 ⇒優
 *
 *
 */

public class E03_08 {

	public static void main(String[] args) throws IOException {

		// 標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("点数＞");
		// 変数 str をキーボードから入力
		String str = br.readLine();

		// 入力値をinteger型へ変換
		int num = Integer.parseInt(str);

		/**
		 * 読み込んだ値によってメッセージを出力
		 *
		 * 0～59 ⇒不可
		 * 60～69 ⇒可
		 * 70～79 ⇒良
		 * 80～100 ⇒優
		 *
		 */

		if (0 <= num && num <= 59) {
			System.out.println("不可");
		} else if (60 <= num && num <= 69) {
			System.out.println("可");
		} else if (70 <= num && num <= 79) {
			System.out.println("良");
		} else if (80 <= num && num <= 100) {
			System.out.println("優");
		}

	}

}
