package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro 配列の要素の並びをランダムにシャッフルするプログラムを作成せよ。
 *
 */

public class E06_12 {

	public static void main(String[] args) {

		// 配列を宣言
		int[] inputList;
		// 要素数を宣言
		int yousoNum = 0;
		// 切り替え作業用の変数
		int tradeNum = 0;
		// 切り替え先インデックス
		int switchElement = 0;

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			do {

				System.out.print("要素数を設定してください。(1~10とする）＞");
				// 要素数を設定
				yousoNum = scanner.nextInt();
				if (yousoNum < 1 || 10 < yousoNum) {
					System.out.println("１〜１０の整数を入力してください。");
				}
			} while (yousoNum < 1 || 10 < yousoNum);

			// 設定した要素数の配列を生成
			inputList = new int[yousoNum];

			// 配列に順番に値を格納
			for (int i = 0; i < inputList.length; i++) {
				System.out.print((i + 1) + "番目の要素は？");
				// 要素に値を格納（入力）
				inputList[i] = scanner.nextInt();
			}

			System.out.println("シャッフル前の要素はこのような順番で格納されています。");
			// シャッフル前の配列の全ての要素を出力する
			for (int j : inputList) {
				// 配列の要素を順番に出力
				System.out.println(j);
			}
			
			//要素を全てシャッフルする
			for (int k = 0; k < inputList.length; k++) {
				// 入れ替え先のインデックスをランダムに決定する
				switchElement = (int) (Math.random() * 10) % (inputList.length);
				
				//　入れ替え先の要素を作業用変数へ退避
				tradeNum = inputList[switchElement];
				
				//入れ替え元の値を入れ替え先の要素へ代入する
				inputList[switchElement] = inputList[k];
				
				//退避していた入れ替え先の要素を、入れ替え元の要素へ格納する。（シャッフル完了）
				inputList[k] = tradeNum;
			}
			
			System.out.println("シャッフル後の要素はこのような順番で格納されています。");
			// シャッフル後の配列の全ての要素を出力する
			for (int l : inputList) {
				// 配列の要素を順番に出力
				System.out.println(l);
			}

		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
