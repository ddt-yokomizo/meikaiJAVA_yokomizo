package java04;

/**
 * 入力値分の段の数字ピラミッドを表示するプログラムを作成せよ。
 * 表示する値は
 * 段　%　10 とすること
 * 
 */

import java.util.Scanner;

public class E04_23 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		// 空白を出力する作業用変数
		int emptyPoint = 0;
		// 出力するマークの個数（作業用変数）
		int outputMark = 0;

		try {
			System.out.print("整数値＞");
			// 入力値１
			int inputNum1 = scanner.nextInt();

			/*******************************
			 * ピラミッド型の表示
			 ******************************/
			System.out.println("数字で作成したピラミッド型を表示します。");

			// 入力回数分ループ（段の作成）
			for (int i = 0; i < inputNum1; i++) {
				//今回のループで出力する記号を決定
				outputMark = i * 2 + 1;
				//今回のループで出力する空白の数を決定（右側と左側）
				emptyPoint = ((inputNum1 * 2 + 1) - outputMark) / 2;
				
				// 行の作成(左側の空白スペースの確保）
				for (int j = 0; j < emptyPoint; j++) {
					//作業変数分、空白を作成
					System.out.print(" ");
				}
				// 行の作成(記号の配置）
				for (int k = 0 ; k < outputMark ; k++){
					// 数字を横に並べる
					System.out.print((i + 1) % 10);
				}
				// 行の作成(右側の空白スペースの確保）
				for (int l = 0; l < emptyPoint; l++) {
					//作業変数分、空白を作成
					System.out.print(" ");
				}
				// １行分全て終了したタイミングで改行
				System.out.println("");
			}
		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}

}