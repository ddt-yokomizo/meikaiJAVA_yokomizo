package java04;
/**
 * 
 * 読み込んだ整数の合計、平均を求めるプログラム（負の値は加算しない）
 * を作成せよ。
 * また、読み込んだ負の数の個数は平均値を求める分母からは除外すること。
 */

import java.util.Scanner;

public class E04_26 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		// 合計値
		double sumNum = 0.0;
		// 平均値
		double avrNum = 0.0;
		// 作業用変数
		int tmpNum = 0;

		try {

			/*******************************
			 * 読み込んだ整数の合計、平均を求める（負の値は加算しない）
			 ******************************/

			System.out.print("整数を加算します。");
			System.out.print("何個加算しますか？＞");
			// 入力値１
			int inputNum = scanner.nextInt();

			// 入力回数分ループして、合計と平均を求める
			for (int i = 0; i < inputNum; i++) {
				System.out.print("加算値を入力してください＞");
				// 加算値を入力
				tmpNum = scanner.nextInt();

				if (tmpNum < 0) {
					System.out.println("負の値は加算できません。");
					// 入力値が負の値なら、合計値、平均値の算出をせず次のループへ移行する。
					i--;
					continue;
				}
				// 合計値を計算
				sumNum += tmpNum;
				// 平均値を計算
				avrNum = sumNum / (i + 1);

			}

			// 計算結果を出力
			System.out.println("合計値は" + (int) sumNum + "、平均値は" + avrNum + "です。");
		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}

}