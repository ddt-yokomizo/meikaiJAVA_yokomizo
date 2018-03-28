package java05;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * float型の変数と、double型の変数に値を読み込んで表示するプログラムを作成せよ。
 *
 */

public class E05_02 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("float型の入力値＞");
			//入力値１
			float inputNum1 = scanner.nextFloat();
			
			System.out.print("double型の入力値＞");
			//入力値2
			double inputNum2 = scanner.nextDouble();
			
			//float型の入力値を出力
			System.out.println("float型：" + inputNum1);
			//double型の入力値を出力
			System.out.println("double型：" + inputNum2);
			
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}

}
