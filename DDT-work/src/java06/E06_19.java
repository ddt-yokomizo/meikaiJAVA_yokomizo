package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro クラスの数・各クラスの人数、全員の点数を読み込んで 点数の合計点と平均点を求めるプログラムを作成せよ。
 *         平均点はクラスごとのものと、全体のものを表示すること
 *
 */
public class E06_19 {

	public static void main(String[] args) {

		// 配列を宣言
		int[][] testArray;
		// クラス数を宣言
		int classNum = 0;
		// クラスの生徒数を宣言
		int studentNum = 0;
		// クラスの総得点
		int[] classSum;
		// クラス平均点
		double[] classAvr;
		// 全体の生徒数
		int totalTrainee = 0;
		// 全体の総得点
		int totalPoint = 0;
		// 全体の平均点
		double totalAvr = 0.0;

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("クラス数を設定してください＞");
			// クラス数を入力
			classNum = scanner.nextInt();
			// 入力値のクラス分のクラスを作成
			testArray = new int[classNum][];
			//クラス数だけクラス総合計がある
			classSum = new int[classNum];
			//クラス数だけクラス平均点がある
			classAvr = new double[classNum];

			// クラスごとに、生徒数を設定する
			for (int i = 0; i < testArray.length; i++) {
				System.out.print((i + 1) + "クラス目の人数は？＞");
				// 上から順番に生徒数を入力していく
				studentNum = scanner.nextInt();
				// 読み込んだ生徒数を作成したクラスへ格納する。
				testArray[i] = new int[studentNum];
				//クラスの生徒数から、全体の生徒数をカウントする
				totalTrainee += studentNum;

				// 生徒の点数を順番に入力する
				// 列を順番にカウント
				for (int j = 0; j < testArray[i].length; j++) {
					System.out.print((i + 1) + "組" + (j + 1) + "番のテストの点数は？＞");
					// テスト結果を格納
					testArray[i][j] = scanner.nextInt();
					//クラス総合計を計算
					classSum[i] += testArray[i][j];
					//全体の合計点を計算
					totalPoint =+ classSum[i];
				}
				//クラス平均点を計算
				classAvr[i] += (double)classSum[i] / testArray[i].length;
			}

			System.out.println("結果発表");
			System.out.println("　組　｜　　　合計　　　　平均");
			System.out.println("-----+--------------------");
			// クラスの成績を出力
			for (int i = 0; i < testArray.length; i++) {
				System.out.print((i + 1) + "組　｜    " + (classSum[i]) + "      " + classAvr[i]);
				// 1行出力したら改行
				System.out.println("");
			}
			//全体の平均点を計算
			totalAvr = (double)totalPoint / totalTrainee;
			System.out.println("-----+--------------------");
			System.out.print("　計　｜   " + totalPoint + "      " + totalAvr);
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
