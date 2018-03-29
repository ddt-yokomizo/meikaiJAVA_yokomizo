package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro 配列の全要素に乱数を代入して、縦向きの棒グラフで表示するプログラムを作成せよ。
 *         最下段には、インデックスを１０で割った剰余を表示すること。
 *
 */
public class E06_04 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		// 配列を宣言
		int[] inputList;
		// 要素数を宣言
		int yousoNum = 0;
		// 生成する乱数の個数
		int randomRange = 10;

		System.out.print("要素数を設定してください。＞");
		// 要素数を設定
		yousoNum = scanner.nextInt();
		// 設定した要素数の配列を生成
		inputList = new int[yousoNum];

		try {
			// 要素に０〜９の乱数を格納するため、設定回数分ループ
			for (int i = 0; i < inputList.length; i++) {
				// 0~9の乱数を要素へ格納
				inputList[i] = (int) (Math.random() * randomRange);
			}

			// グラフの段の作成（乱数の上限値分ループ）
			for (int j = 0; j < randomRange; j++) {
				// 値の作成（配列の要素数分ループ）
				for (int k = 0; k < inputList.length; k++) {
					// 読み込み中の段数と要素を比較
					if ((randomRange - j) <= inputList[k]) {
						// 要素の値が読み込み中の値に達していれば『＊」を出力
						System.out.print("*");
					} else {
						// 要素の値が読み込み中の値に達していなければ『 」を出力
						System.out.print(" ");
					}
				}
				// 値を１行分出力し終わったら改行
				System.out.println("");

				// 最終段が終了した時、ラインとインデックスを表示する
				if (j == (randomRange - 1)) {
					// 要素数分「ー」を出力
					for (int l = 0; l < inputList.length; l++) {
						System.out.print('-');
					}
					// 値を１行分出力し終わったら改行
					System.out.println("");
					// インデックスを出力（値は１０で割った剰余とする）
					for (int m = 0; m < inputList.length; m++) {
						System.out.print((m % 10));
					}
				}
			}
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
