package java04;

import java.util.Scanner;

/**
 * 
 * @author masahiro 整数値を読み込み、それが素数であるかを判定するプログラムを作成せよ。
 *
 */

public class E04_24 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		// 素数判定フラグ(初期値をtrueとする）
		boolean primeNumber = true;

		try {
			System.out.print("整数値＞");
			// 入力値１
			int inputNum1 = scanner.nextInt();

			/*******************************
			 * 素数判定
			 ******************************/
			System.out.println("入力値が素数であるかを判定します。");

			// 素数を判定するため１から入力値までループ
			for (int i = 1; i < (inputNum1 - 1); i++) {
				//　割り切れる場合、素数判定フラグをfalseにする
				if(inputNum1 % (i + 1) == 0){
					primeNumber = false;
					//素数でなければ処理を抜ける
					break;
				}

			}
			//素数判定の結果を出力
			System.out.println("入力値は" + (primeNumber ? "素数" : "素数ではない"));
		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}

}