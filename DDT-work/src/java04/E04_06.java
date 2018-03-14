package java04;

import java.util.Scanner;

/**
 *
 * 読み込んだ値が1未満であれば改行文字を出力しないようにList4-7、List4-8を
 * 書き換えたプログラムを作成せよ。
 *
 *
 */

public class E04_06 {

	public static void main(String[] args) {

		/**
		 * List4-7を改良したプログラム
		 *
		 */

		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		System.out.println("*をいくつ出力しますか？");
		//入力値１
		int inputNum1 = scanner.nextInt();

		int countNum =0;//カウント用の変数

		while (countNum < inputNum1){

			System.out.print('*');

			//カウンタをインクリメント
			countNum++;
		}

		if( 0 < inputNum1){

			//入力値１が0以上のときのみ改行
			System.out.println();

		}

		/**
		 * List4-8を改良したプログラム
		 *
		 */


		System.out.println("*をいくつ出力しますか？");
		//入力値2
		int inputNum2 = scanner.nextInt();

		int countNum2 =1;//カウント用の変数

		while (countNum2 <= inputNum2){

			System.out.print('*');

			//カウンタをインクリメント
			countNum2++;
		}

		if( 0 < inputNum2){

			//入力値2が0以上のときのみ改行
			System.out.println();

		}



	}

}
