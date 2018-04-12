package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro テストの合計点、平均点。最高点、最低点を表示するプログラムを作成せよ。 人数と点数はキーボードから読み込むこと。
 *
 */

public class E06_06 {

	public static void main(String[] args) {

		// 配列を宣言
		int[] scoreList;
		// 受験者数を宣言
		int examineeNum = 0;
		// 合計点を宣言
		int sumScore = 0;
		// 平均点を宣言
		double avrScore = 0.0;
		// 最高点を宣言
		int highScore = 0;
		// 最低点を宣言
		int lowScore = 0;
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		System.out.print("要素数を設定してください。＞");
		// 要素数を設定
		examineeNum = scanner.nextInt();
		// 設定した要素数の配列を生成
		scoreList = new int[examineeNum];

		try {
			// 受験者に点数を順番に入力する
			for (int i = 0; i < scoreList.length; i++) {
				System.out.print((i + 1) + "番目の受験者の点数は？＞");
				// 要素に値を格納
				scoreList[i] = scanner.nextInt();
			}


			// 一旦scoreList[0]を暫定の最高点として扱う
			highScore = scoreList[0];
			// 一旦scoreList[0]を暫定の最低点として扱う
			lowScore = scoreList[0];

			// スコアの合計点,最高点、最低点を計算する
			for (int i = 0; i < scoreList.length; i++) {
				// 入力した点数から合計を計算する。
				sumScore += scoreList[i];
				// 入力した点数からの最高点を算出しhighScoreへ代入する。
				if (highScore < scoreList[i]) {
					// 読み込んだ点数が暫定のhighScoreより高得点だった場合はhighScoreの値を更新する
					highScore = scoreList[i];
				}
				if (scoreList[i] < lowScore)
					// 読み込んだ点数が暫定のlowScoreより低い点数だった場合はlowScoreの値を更新する
					lowScore = scoreList[i];
			}

			// スコアの平均点を計算する
				avrScore = ((double) sumScore / scoreList.length);

			// 合計点を出力
			System.out.println("合計点：" + sumScore);
			// 平均点を出力
			System.out.println("平均点：" + avrScore);
			// 最高点を出力
			System.out.println("最高点：" + highScore);
			// 最低点を出力
			System.out.println("最低点：" + lowScore);
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}