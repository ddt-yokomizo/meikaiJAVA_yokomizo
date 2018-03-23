package java04;

import java.util.Scanner;

/**
 * 
 * @author masahiro 直角か左上、右下、右上となるよう表示するプログラムを作成せよ。
 *
 */

public class E04_21 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		// 作業用変数
		int tmpNum = 0;

		try {
			System.out.print("整数値＞");
			// 入力値１
			int inputNum1 = scanner.nextInt();

			/*******************************
			 * 左上が直角のパターン
			 ******************************/
			System.out.println("左上が直角の三角形を表示します。");
			// 作業変数を０とする
			tmpNum = 0;
			// 入力回数分ループ（段の作成）
			for (int i = 0; i < inputNum1; i++) {
				// 行の作成（処理を行うたびに＊を横に並べる回数が減る）
				for (int j = 0; j < (inputNum1 - tmpNum); j++) {
					// 入力値分、＊を横に並べる
					System.out.print("＊");
				}
				// 次の集会で列を減らすために作業用変数をインクリメント
				tmpNum++;
				// １行分全て終了したタイミングで改行
				System.out.println("");
			}

			/*******************************
			 * 右下が直角のパターン
			 ******************************/
			System.out.println("右下が直角の三角形を表示します。");
			// 作業変数を入力値−１に更新する（最初の１段目が1幅あるため）
			tmpNum = inputNum1 - 1;
			// 入力回数分ループ（段の作成）
			for (int i = 0; i < inputNum1; i++) {
				// 行の作成(空白スペースの確保）
				for (int j = 0; j < tmpNum; j++) {
					//作業変数分、空白を作成
					System.out.print("　");
				}
				for (int k = 0 ; k < (inputNum1 - tmpNum) ; k++){
					// 列のスペースで余った部分に、＊を横に並べる
					System.out.print("＊");
				}
				// 次の周回で空白減らすために作業用変数をデクリメント
				tmpNum--;
				// １行分全て終了したタイミングで改行
				System.out.println("");
			}
			
			/*******************************
			 * 右上が直角のパターン
			 ******************************/
			System.out.println("右上が直角の三角形を表示します。");
			// 作業変数を0にリセットする（最初の１段目が1幅あるため）
			tmpNum = 0;
			// 入力回数分ループ（段の作成）
			for (int i = 0; i < inputNum1; i++) {
				// 行の作成(空白スペースの確保）
				for (int j = 0; j < tmpNum; j++) {
					//作業変数分、空白を作成
					System.out.print("　");
				}
				for (int k = 0 ; k < (inputNum1 - tmpNum) ; k++){
					// 列のスペースで余った部分に、＊を横に並べる
					System.out.print("＊");
				}
				// 次の周回で空白を増やすために作業用変数をインクリメント
				tmpNum++;
				// １行分全て終了したタイミングで改行
				System.out.println("");
			}

		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}

}
