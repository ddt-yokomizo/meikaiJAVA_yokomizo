package java06;
/**
 * 行数・各行の要素を値からキーボードから読み込むプログラムを作成せよ。
 */

import java.util.Scanner;

public class E06_18 {

	public static void main(String[] args) {

		// 配列を宣言
		int[][] inputArray;
		// 列を宣言
		int rowNum = 0;
		// 行を宣言
		int lineNum = 0;

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("配列の行数を設定してください＞");
			// 行を入力
			lineNum = scanner.nextInt();
			// 入力値の行を持った配列を作成
			inputArray = new int[lineNum][];

			// 行ごとに、列数を設定する
			for (int i = 0; i < lineNum; i++) {
				System.out.print((i + 1) + "段目の列数を設定してください＞");
				// 上から順番に列数を入力していく
				rowNum = scanner.nextInt();
				// 読み込んだ行の列数を設定する。
				inputArray[i] = new int[rowNum];
			}

			// 作成した配列に、順番に要素を格納する
			// 行を順番にカウント
			for (int i = 0; i < inputArray.length; i++) {
				// 列を順番にカウント
				for (int j = 0; j < inputArray[i].length; j++) {
					System.out.print((i + 1) + "段目" + (j + 1) + "列の要素を入力してください＞");
					// 要素に入力値を格納
					inputArray[i][j] = scanner.nextInt();
				}

			}
			System.out.println("配列の要素を一覧表示します。");
			// 作成した配列の要素を順番に出力
			// 行を順番にカウント
			for (int i = 0; i < inputArray.length; i++) {
				// 列を順番にカウント
				for (int j = 0; j < inputArray[i].length; j++) {
					// 要素に入力値を格納
					System.out.print(inputArray[i][j]);
				}
				// 1行出力したら改行
				System.out.println("");
			}

		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
