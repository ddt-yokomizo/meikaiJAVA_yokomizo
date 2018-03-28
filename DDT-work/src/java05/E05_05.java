package java05;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 3つの整数値を読み込んで、その合計と平均を表示するプログラムを作成せよ。
 * また、平均はキャスト演算子を用いて実数値として表示すること。
 *
 */

public class E05_05 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		//入力回数（３回）
		int inputTimes = 3;
		//入力値
		int inputNum = 0;
		//平均値
		double avrNum = 0.0;
		//合計値
		int sumNum = 0;

		try {
			//入力回数分ループして整数値を入力
			for ( int i = 0 ; i < inputTimes ; i++){
				System.out.print("整数値" + (i + 1) + "＞");
				//入力値
				inputNum = scanner.nextInt();
				
				//合計値を計算
				sumNum += inputNum;
				//平均値を計算
				avrNum = sumNum / (double)(i + 1);
			}
			System.out.println("合計値：" + sumNum);
			System.out.println("平均値：" + avrNum);
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}

}

