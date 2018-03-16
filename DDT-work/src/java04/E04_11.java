package java04;

import java.util.Scanner;

/**
 * 
 * @author yokomizomasahiro
 * 正の整数値を０までカウントダウンするfor分のプログラムを作成せよ
 *
 */

public class E04_11 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("整数値＞");
		//入力値１
		int inputNum1 = scanner.nextInt();
		//出力変数(初期値は入力値と同じ）
		int outputNum = inputNum1;
		
		//入力回数+1分ループ
		for(int i = 0 ; i < inputNum1 + 1 ; i++){
			//出力値を表示してデクリメント
			System.out.println(outputNum--);
		}

	}

}
