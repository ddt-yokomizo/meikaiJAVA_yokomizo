package java03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 2つの整数値を読み込んで降順にソートするプログラムを作成せよ。
 *
 */

public class E03_15 {

	public static void main(String[] args) throws IOException {

		int inputTime = 2; // 入力回数を設定
		int[] inputNums = new int[inputTime]; // 入力値

		// 標準入力ストリーム
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 入力回数分だけループ
		for (int i = 0; i < inputNums.length; i++) {

			System.out.print("整数" + (i + 1) + ">");
			// 文字列キーボードから入力
			String inputStr = br.readLine();

			// 入力値を配列に格納
			inputNums[i] = Integer.parseInt(inputStr);

		}

		// 配列の要素を順番にすべて調べるため、入力回数-1分ループ
		for (int s = 0; s < inputNums.length - 1; s++) {

			// ループ中の配列要素のとなりの要素と比較
			for (int t = s + 1; t < inputNums.length; t++) {

				if (inputNums[s] < inputNums[t]) {
					// 隣の要素が確認中の要素より大きければ、作業用変数へ格納
					int tmpNum = inputNums[t];

					// 大きかった要素に確認中要素を格納
					inputNums[t] = inputNums[s];

					// 作業用変数に格納していた大きい要素を確認中要素の位置へ格納
					inputNums[s] = tmpNum;
				}

			}
		}

		for (int u = 0; u < inputNums.length; u++) {
			// 降順ソートされた入力値を表示
			System.out.println("降順ソートされた入力値を表示>" + inputNums[u]);

		}

	}

}
