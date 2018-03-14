package java04;

import java.util.Scanner;

/**
 *
 * 読み込んだ値の個数だけ記号文字を表示するプログラムを作成せよ。
 * 表示は*と+を交互に行うこと
 *
 *
 */
public class E04_07 {

	public static void main(String[] args) {

		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		System.out.println("記号をいくつ出力しますか？");
		//入力値１
		int inputNum1 = scanner.nextInt();

		int countNum =1;//カウント用の変数

		while (countNum <= inputNum1){

			if(countNum % 2 == 1){
				//カウントが奇数回の時は「*」を出力
				System.out.print('*');
			} else if (countNum % 2 == 0){
				//カウントが偶数回の時は「+」を出力
				System.out.print('+');

			}
			//カウンタをインクリメント
			countNum++;
		}


	}

}
