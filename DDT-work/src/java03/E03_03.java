package java03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * List3-5の最後のelseをelse if (num == 0)
 * に変更したらどうなるか検討せよ。
 *
 */

public class E03_03 {

	public static void main(String[] args) throws IOException {

		// 標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 変数 str をキーボードから入力
		String str = br.readLine();

		//入力値をinteger型へ変換
		int num = Integer.parseInt(str);

		if (num > 0) {
			System.out.println("その値は正の値です。");
		} else if (0 > num) {
			System.out.println("その値は負の値です。");
		} else {
			System.out.println("その値は0です。");
		}

		/**
		 * 最後のelseをelse if (num == 0)としたとき、
		 * 入力値が0であったときは「その値は0です。」と表示される。
		 * また、入力値が1以上でもなく、0未満でもなく、0でもないときは
		 * 条件分岐をスルーする。
		 *
		 *
		 */


	}

}
