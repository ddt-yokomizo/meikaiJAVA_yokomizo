package java07;
/**
 * @author masahiro 3つのint型引数の中央値を求めるメソッドを作成せよ
 */

import java.util.Scanner;

public class E07_03 {
	// ３つの引数から中央値を返すメソッド
	static int minReturn(int getNumA, int getNumB, int getNumC) {
		// 中央値を宣言
		int iMidNum = 0;
		// 引数を配列へ格納
		int[] iGetNumsList = { getNumA, getNumB, getNumC };
		// 作業用変数
		int iTmpNum = 0;

		// 昇順ソート
		for (int i = 0; i < iGetNumsList.length - 1; i++) {
			for (int j = i + 1; j < iGetNumsList.length; j++) {
				if (iGetNumsList[j] < iGetNumsList[i]) {
					iTmpNum = iGetNumsList[i];
					iGetNumsList[i] = iGetNumsList[j];
					iGetNumsList[j] = iTmpNum;
				}
			}
		}

		//中央値を算出（要素数が奇数なら昇順ソートした配列の中央の要素、偶数なら中央＋１の要素が中央値
		switch (iGetNumsList.length % 2) {
		case 0:
			// 要素数が偶数なら配列の長さ÷２＋１の要素を中央値とする
			iMidNum = iGetNumsList[(iGetNumsList.length % 2) + 1];
			break;
		case 1:
			// 要素数が偶数なら配列の長さ÷２の要素を中央値とする
			iMidNum = iGetNumsList[(iGetNumsList.length % 2)];
			break;
		default:
			break;
		}
		// 中央値を返却する
		return iMidNum;
	}

	public static void main(String[] args) {

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			// 入力回数を宣言（定数３）
			final int iINPUT_TIMES = 3;
			// 入力値を宣言（要素数３）
			int[] iInputNumsList = new int[3];

			// 整数を３回入力する
			for (int i = 0; i < iINPUT_TIMES; i++) {
				System.out.print("整数" + (i + 1) + "を入力してください。＞");
				// 整数を入力
				iInputNumsList[i] = scanner.nextInt();
			}
			// メソッドminReturnから最小値を呼び出す
			System.out.println("中央値は" + minReturn(iInputNumsList[0], iInputNumsList[1], iInputNumsList[2]) + "です。");

		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
