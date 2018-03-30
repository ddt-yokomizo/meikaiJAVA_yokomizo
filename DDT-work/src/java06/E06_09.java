package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 要素型がint型である配列を作成し、全要素を１〜１０の乱数で埋め尽くすプログラムを作成せよ。
 *
 */
public class E06_09 {

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
			}
			//配列の全ての要素を出力する
			for(int j : inputList){
				//配列の要素を順番に出力
				System.out.println(j);
			}
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
