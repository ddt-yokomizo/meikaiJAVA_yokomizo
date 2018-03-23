package java04;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 *  入力した整数値までの約数を順番に出力し、
 *  最後に約数の個数を表示するプログラムを作成せよ。
 *
 */
public class E04_17 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("整数値＞");
		//入力値１
		int inputNum1 = scanner.nextInt();
		//カウント用の変数
		int tmpNum = 0;
		
		//【処理概要】入力値の回数分ループし、約数をチェックして順番に表示する
		for (int i = 0 ; i < inputNum1 ; i++){
			
			if(inputNum1 % (i + 1) == 0){
				//割り切れたら表示
				System.out.println((i + 1));
				//約数の数カウント＋１
				tmpNum++;
			}
		}
		
		//約数の数を出力
		System.out.println("約数の数は" + tmpNum + "個です。");

	}

}
