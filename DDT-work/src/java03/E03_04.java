package java03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2つの変数num1,num2を読み込んで、その大小関係を以下のいずれかで表示する
 * プログラムを作成せよ。
 * ・num1のほうが大きいです。
 * ・num2のほうが大きいです。
 * ・num1とnum2は同じ値です。
 *
 *
 */


public class E03_04 {

	public static void main(String[] args) throws IOException {

		// 標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("変数num1：");
		// 変数 str1 をキーボードから入力
		String str1 = br.readLine();

		//入力値をinteger型へ変換
		int num1 = Integer.parseInt(str1);

		System.out.print("変数num2：");
		// 変数 str2 をキーボードから入力
		String str2 = br.readLine();

		//入力値をinteger型へ変換
		int num2 = Integer.parseInt(str2);

		/**
		 * num1とnum2の大小関係を比較し、結果により以下のメッセージを出力
		 *
		 * 【num1がnum2より大きい場合】
		 * ・num1のほうが大きいです。
		 *
		 * 【num2がnum1より大きい場合】
		 * ・num2のほうが大きいです。
		 *
		 * 【num1とnum2が同じ値の場合】
		 * ・num1とnum2は同じ値です。
		 *
		 *
		 */
		if (num1 > num2) {
			System.out.println("num1のほうが大きいです。");
		} else if (num2 > num1) {
			System.out.println("num2のほうが大きいです。");
		} else if (num1 == num2) {
			System.out.println("num1とnum2は同じ値です。");
		}


	}

}
