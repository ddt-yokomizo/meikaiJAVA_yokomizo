package java07;

import java.util.Scanner;

/**
 * 
 * @author masahiro 引数で指定された月の季節を表示するメソッドを表示せよ。 １〜１２以外の引数が入力された時は何も表示しないこと。
 *
 */

public class E07_07 {
	// 引数に対応する季節を出力するメソッド
	static void printSeason(int getMonth) {

		// 季節を格納する変数
		// String strSeason = null;

		// 引数に対応した季節を出力する
		switch (getMonth) {
		// 12月、１月〜2月は冬
		case 12:
		case 1:
		case 2:
			System.out.println(getMonth + "月は冬です。");
			break;
		// 3月〜5月は春
		case 3:
		case 4:
		case 5:
			System.out.println(getMonth + "月は春です。");
			break;
		// 6月〜8月は夏
		case 6:
		case 7:
		case 8:
			System.out.println(getMonth + "月は夏です。");
			break;
		// 9月〜11月は秋
		case 9:
		case 10:
		case 11:
			System.out.println(getMonth + "月は秋です。");
			break;
		//１〜１２以外の引数の場合は何もせず処理を終了する
		default:
			break;
		}
	}

	public static void main(String[] args) {

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			// 入力月を宣言
			int iInputMonth = 0;

			System.out.print("月を入力してください。＞");
			// 月を入力
			iInputMonth = scanner.nextInt();
			
			//引数に対応する季節を出力するメソッドprintSeasonを呼び出す
			printSeason(iInputMonth);

		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
