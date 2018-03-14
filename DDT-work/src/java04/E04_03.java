package java04;

import java.util.Scanner;

/**
 *
 * 2つの整数値を読み込んで小さい数以上で大きい数以下の全整数を昇順で表示するプログラムを作成せよ。
 *
 */
public class E04_03 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		System.out.print("整数１＞");
		//入力値１
		int inputNum1 = scanner.nextInt();

		System.out.print("整数２＞");
		//入力値２
		int inputNum2 = scanner.nextInt();

		//入力値１と入力値２の小さい方を格納
		int minNum = (inputNum1 < inputNum2 ? inputNum1 : inputNum2);
		//入力値１と入力値２の大きい方を格納
		int maxNum = (inputNum1 < inputNum2 ? inputNum2 : inputNum1);

		do {
			//小さい値を表示
			System.out.println(minNum);

			//小さい値に+1
			minNum+=1;
			//小さい値-1が大きい値と一致するまでループ
		} while (( minNum - 1 ) != maxNum);

	}

}
