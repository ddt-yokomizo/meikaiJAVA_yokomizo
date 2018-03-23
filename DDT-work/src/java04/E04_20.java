package java04;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 単位を■として、一辺が入力値分の正方形を表示するプログラムを作成せよ。
 * 例
 * ■■■
 * ■■■
 * ■■■
 *
 */
public class E04_20 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("整数値＞");
		//入力値１
		int inputNum1 = scanner.nextInt();
		//入力値と同じ長さで正方形を作成する（入力値の行数になるまでループ）
		for (int i = 0 ; i < inputNum1 ; i++){
			
			for(int j = 0 ; j < inputNum1 ; j++){
				//入力値分、＊を横に並べる
				System.out.print("＊");
			}
			//１行分全て終了したタイミングで改行
			System.out.println("");
		}
		
		
		

	}

}
