package java05;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 10進整数を読み込んで、その値を８進数と１６進数で表示するプログラムを作成せよ。
 *
 */

public class E05_01 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		
		 try {
				System.out.print("整数値＞");
				//入力値１
				int inputNum1 = scanner.nextInt();
				
				//入力値を８進数で表示
				System.out.printf("8進数：%o",inputNum1);
				System.out.println("");
				//入力値を16進数で表示
				System.out.printf("16進数：%x",inputNum1);
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}

}
