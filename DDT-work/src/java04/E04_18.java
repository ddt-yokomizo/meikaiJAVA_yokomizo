package java04;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 1から入力値までの整数値の２乗値を表示するプログラムを作成せよ
 *
 */

public class E04_18 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		//累乗数は2
		int perfectPower = 2;
		
		System.out.print("整数値＞");
		//入力値１
		int inputNum1 = scanner.nextInt();
		
		//【処理概要】入力値の回数分ループし読み込んだ値の２乗値を出力する
		for (int i = 0 ; i < inputNum1 ; i++){
			//値の累乗を出力
			System.out.println((i + 1) + "の" + perfectPower +"乗は" + (int)Math.pow((double)(i + 1), perfectPower));
		}

	}

}
