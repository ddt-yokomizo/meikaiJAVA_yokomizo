package java_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * キーボードから読み込んだ整数値プラスマイナス5の範囲の整数値を ランダムに生成して表示するプログラムを作成せよ。
 *
 */
public class E02_08 {

	public static void main(String[] args) throws IOException {

		// 標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// random クラスをインポート
		Random rand = new Random();

		System.out.print("整数値：");

		// 変数 str をキーボードから入力
		String str = br.readLine();

		// 入力値をinteger型へ変換
		int num = Integer.parseInt(str);

		// boolean型の乱数を生成
		boolean dispflg = rand.nextBoolean();

		//1～５の乱数を生成
		int num2 = (int)(Math.random() * 5 % 10) +1;

		//dispflgがtrueならnum2の符号を反転
		if (dispflg) {

			num2 = -num2;

		}

		//キーボードから読み込んだ整数値プラスマイナス5の範囲の整数値を ランダムに生成して表示
		System.out.println("その値の±5の値を生成しました。それは" + (num + num2) + "です。");

	}

}
