package java04;

import java.util.Scanner;

/**
 *
 * 2桁の整数値(10～99)を当てさせる数あてゲームプログラムを作成せよ。
 *
 */

public class E04_02 {

	public static void main(String[] args) {

		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		//10～99の乱数を生成(当てるべき数)
		int answerNum = (int) (Math.random() * 100 % 89) + 10;
		//入力用の変数を宣言
		int inputNum1;

		System.out.print("10～99の数を当ててください。＞");

		do {

			//答えを入力
			inputNum1 = scanner.nextInt();

			if (inputNum1 < answerNum) {
				//入力値が答えより小さい場合
				System.out.print("違います。もっと大きな値です。");
			} else if (answerNum < inputNum1) {
				//入力値が答えより大きな場合
				System.out.print("違います。もっと小さな値です。");
			}

			//答えと入力値が一致するまでループ
		}while(inputNum1 != answerNum);

		//答えと入力値が一致した場合のメッセージ
		System.out.println("正解！！");




	}

}
