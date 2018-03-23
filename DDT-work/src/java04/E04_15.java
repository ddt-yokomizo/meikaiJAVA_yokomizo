package java04;

import java.util.Scanner;

/**
 * 
 * 
 * @author masahiro 身長と標準体重の対応表を表示するプログラムを作成せよ。
 *         表示する新著の範囲（開始値/終了値/増分）は整数値として読み込むこと。 ※標準体重は（身長−１００）×0.9とする。
 * 
 *
 */

public class E04_15 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		//係数を宣言
		Double coefficientNum = 0.9;
		//標準体重を宣言
		Double standardWeight = 0.0;

		System.out.print("何㎝から：");
		// 開始値を入力
		int startHeight = scanner.nextInt();
		//作業用の変数(初期値を開始値とする）
		int tmpNum = startHeight;
		
		System.out.print("何㎝まで：");
		// 終了値を入力
		int endHeight = scanner.nextInt();
		
		System.out.print("何㎝ごと：");
		// 増分を入力
		int increaseValue = scanner.nextInt();
		
		System.out.println("身長　・　標準体重");
		
		//【処理概要】入力値に応じて必要回数分ループし、身長　・　標準体重を出力する。
		for(int i = 0; i < ((endHeight - startHeight) / increaseValue) + 1 ; i++){
			//標準体重を計算
			standardWeight = (tmpNum - 100) * coefficientNum; 
			//身長と、対応する標準体重を出力
			System.out.println("身長" + tmpNum + "㎝の標準体重は" + standardWeight + "Kgです。");
			
			//増分を加算
			tmpNum += increaseValue;
			
		}

	}

}
