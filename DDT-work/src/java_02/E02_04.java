package java_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * キーボードから読み込んだ整数値に10を加えた値と10を減じた値を出力するプログラムを作成せよ。
 * 例）整数値：7
 * 10を加えた値は17です。
 * 10を減じた値は-3です。
 *
 */
public class E02_04 {

	public static void main(String[] args) throws IOException {

		//標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("整数値：");
		//キーボードから文字列を入力
		String str =br.readLine();

		//入力値をint型へ変換
		int num = Integer.parseInt(str);

		//入力値から10を加えた値を出力
		System.out.println("10を加えた値は" + ( num + 10 ) + "です。");
		//入力値から10を減じた値を出力
		System.out.println("10を減じた値は" + ( num - 10 ) + "です。");


	}

}
