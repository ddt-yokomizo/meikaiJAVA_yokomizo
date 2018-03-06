package java03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 整数値を読み込んで、その絶対値を表示するプログラムを作成せよ。
 *
 */

public class E03_01 {

	public static void main(String[] args) throws IOException{
		//標準入力クラスをインポート
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("整数値：");
		// 変数 str をキーボードから入力
		String str = br.readLine();

		//入力値をinteger型へ変換
		int num = Integer.parseInt(str);

		//num がマイナスなら符号を反転
		if (0 > num) {

			num = -num;

		}


		//入力値の絶対値を表示
		System.out.println("その絶対値は" + num +  "です。");



	}

}
