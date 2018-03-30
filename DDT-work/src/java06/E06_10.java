package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro 要素型がint型である配列を作成し、全要素を１〜１０の乱数で埋め尽くすプログラムを作成せよ。
 *         また、連続した要素が同じ値をもつことが無いように作成すること。
 *
 */

public class E06_10 {

	public static void main(String[] args) {

		// 配列を宣言
		int[] inputList;
		// 要素数を宣言
		int yousoNum = 0;
		// 乱数の範囲を宣言(10とする）
		final int RANDOM_RANGE = 10;

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("要素数を設定してください。＞");
			// 要素数を設定
			yousoNum = scanner.nextInt();
			// 設定した要素数の配列を生成
			inputList = new int[yousoNum];

			// 配列に順番に１〜１０の乱数を格納する
			for (int i = 0; i < inputList.length; i++) {
				// 要素に１〜１０の乱数を格納（定数を利用）
				inputList[i] = (int) (Math.random() * RANDOM_RANGE) + 1;
				
				// 格納した値が１つ前の要素と同じ値なら、制御用変数iを１つカウントダウンして、乱数の格納をやり直す(初回のループを除く）
				if (i != 0 && inputList[i] == inputList[i - 1]) {
					// 制御用変数iを１つカウントダウン
					i--;
				}
			}
			// 配列の全ての要素を出力する
			for (int j : inputList) {
				// 配列の要素を順番に出力
				System.out.println(j);
			}
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
