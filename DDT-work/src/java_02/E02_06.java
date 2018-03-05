package java_02;
/*
 * 三角形の底辺と高さを読み込んで、その面積を表示するプログラムを作成せよ。
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02_06 {

	public static void main(String[] args) throws IOException {
		// 標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//メッセージを出力
		System.out.println("三角形の面積を求めます。");

		System.out.print("底辺：");
		// str1（底辺） をキーボードから入力
		String str1 = br.readLine();

		// str1をDouble型へ変換
		Double num1 = Double.parseDouble(str1);

		System.out.print("高さ:");
		// str2（高さ） をキーボードから入力
		String str2 = br.readLine();

		// str2をDouble型へ変換
		Double num2 = Double.parseDouble(str2);

		//面積を出力
		System.out.println("面積は" + ( num1 * num2 ) / 2 + "です。");

	}

}
