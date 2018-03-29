package java04;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 入力した回数だけ＊を出力するプログラムを作成せよ。
 * また、５個表示するごとに改行すること。
 *
 */

public class E04_16 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		int timingNew = 5; //改行のタイミングを宣言
		int inputNum1 = 0; //入力値１を宣言
		
		System.out.print("いくつ＊を出力しますか＞");
		//入力値１
		inputNum1 = scanner.nextInt();
		
		//【処理概要】入力回数分ループし、＊を表示する。
		for(int i = 0 ; i < inputNum1 ; i++){
			//＊を出力
			System.out.print('＊');
			if (timingNew <= (i + 1) && ((i + 1) % timingNew) == 0){
				//改行のタイミングがきたら改行する。
				System.out.println("");
			}
			
		}
		
		

	}

}
