package java_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * キーボードから読み込んだ整数値をそのまま反復して表示するプログラムを作成せよ。
 * 例）整数値：7
 * 7と入力しましたね。
 *
 */
public class E02_03 {

	public static void main(String[] args) throws IOException {

		//標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("整数値：");
		//キーボードから文字列を入力
		String str = br.readLine();

		//入力した文字列をInteger型へ変換
		int num = Integer.parseInt(str);

		//結果を出力
		System.out.println( num + "と入力しましたね。");





	}

}
