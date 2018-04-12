package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * double型の配列の全要素の合計値と平均値を求めるプログラムを作成せよ。
 * 要素数と全要素の値はキーボードから読み込むこと。
 *
 */
public class E06_08 {

	public static void main(String[] args) {

		// 配列を宣言
		double[] inputList;
		// 要素数を宣言
		int yousoNum = 0;
		// 合計値
		double sumNum = 0.0;
		// 平均値
		double avrNum = 0.0;

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("要素数を設定してください。＞");
			// 要素数を設定
			yousoNum = scanner.nextInt();
			// 設定した要素数の配列を生成
			inputList = new double[yousoNum];

			// 配列に順番に値を格納する
			for (int i = 0; i < inputList.length; i++) {
				System.out.println((i + 1) + "番目の要素の値は？　＞");
				// 要素に値を格納
				inputList[i] = scanner.nextDouble();
			}
			// 配列の要素を全てチェックし、要素の平均値と合計値を計算する。
			for (double inputNum : inputList) {
				//【拡張for文】要素の合計値を計算する。
				sumNum += inputNum;
			}
			//要素の平均値を計算する。
			avrNum = sumNum / inputList.length;
			
			// 合計値を出力する。
			System.out.println("合計値："+ sumNum);
			// 平均値を出力する。
			System.out.println("平均値："+ avrNum);
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
