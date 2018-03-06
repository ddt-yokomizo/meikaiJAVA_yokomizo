package java_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 名前の姓と名を個別にキーボードに読み込んで挨拶を行うプログラムを作成せよ。
 * 例）
 * 姓：横溝
 * 名：正洋
 * こんにちは横溝正洋さん。
 *
 */

public class E02_10 {

	public static void main(String[] args) throws IOException{

		// 標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("姓：");

		// 変数 strLastName をキーボードから入力
		String strLastName = br.readLine();

		System.out.print("名：");

		// 変数 strFirstName をキーボードから入力
		String strFirstName = br.readLine();

		//名前を出力
		System.out.println("こんにちは" + strLastName + strFirstName + "さん。");

	}

}
