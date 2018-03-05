package java_02;
/*
 * 2つの実数値を読み込み、その和と平均を求めて表示するプログラムを作成せよ
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02_05 {

	public static void main(String[] args) throws IOException {

		// 標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("xの値:");
		// str1 をキーボードから入力
		String str1 = br.readLine();

		// str1をDouble型へ変換
		Double num1 = Double.parseDouble(str1);

		System.out.print("yの値:");
		// str2 をキーボードから入力
		String str2 = br.readLine();

		// str2をDouble型へ変換
		Double num2 = Double.parseDouble(str2);

		//合計を出力
		System.out.println("合計は" + ( num1 + num2 ) + "です。");

		//平均を出力
		System.out.println("平均は" + ( num1 + num2 ) / 2 + "です。");

	}

}
