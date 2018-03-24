package java04;
/**
 * 読み込んだ整数の合計、平均を求めるプログラム（０が入力されたら終了）と、
 * 読み込んだ整数の合計、平均を求めるプログラム（1000を超えない範囲で加算）
 * を作成せよ
 * 
 */

import java.util.Scanner;

public class E04_25 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		// 合計値1
		double sumNum = 0.0;
		// 平均値1
		double avrNum = 0.0;
		// 合計値2
		double sumNum2 = 0.0;
		// 平均値2
		double avrNum2 = 0.0;
		// 作業用変数
		int tmpNum = 0;

		try {
			/*******************************
			 * 読み込んだ整数の合計、平均を求める（０が入力されたら終了）
			 ******************************/
			System.out.print("整数を加算します。");
			System.out.print("何個加算しますか？＞");
			// 入力値１
			int inputNum1 = scanner.nextInt();

			// 入力回数分ループして、合計と平均を求める
			for (int i = 0; i < inputNum1; i++) {
				System.out.print("加算値を入力してください（０が入力されたら終了）＞");

				// 加算値を入力
				tmpNum = scanner.nextInt();

				if (tmpNum == 0) {
					// 0が入力されたら終了
					break;
				}
				// 合計値を計算
				sumNum += tmpNum;
				// 平均値を計算
				avrNum = sumNum / (i + 1);

			}

			// 計算結果を出力
			System.out.println("合計値は" + (int) sumNum + "、平均値は" + avrNum + "です。");

			/*******************************
			 * 読み込んだ整数の合計、平均を求める（合計が１０００を超えない範囲で加算）
			 ******************************/
			tmpNum = 0; // 作業用の変数を初期化

			System.out.print("整数を加算します。");
			System.out.print("何個加算しますか？＞");
			// 入力値１
			int inputNum2 = scanner.nextInt();

			// 入力回数分ループして、合計と平均を求める
			for (int ｊ = 0; ｊ < inputNum2; ｊ++) {
				System.out.print("加算値を入力してください＞");

				// 加算値を入力
				tmpNum = scanner.nextInt();

				if (1000 < (sumNum2 + tmpNum)) {
					// 合計値が１０００を超えたら最後の入力は無視して終了する。
					System.out.println("合計が１０００を超えました。最後の数値は無視します。");
					break;
				}
				// 合計値を計算
				sumNum2 += tmpNum;
				// 平均値を計算
				avrNum2 = sumNum2 / (ｊ + 1);

			}

			// 計算結果を出力
			System.out.println("合計値は" + (int) sumNum2 + "、平均値は" + avrNum2 + "です。");
		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}

}
