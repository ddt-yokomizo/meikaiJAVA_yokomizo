package java03;

import java.util.Scanner;

public class E03_17 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		//０～２の乱数を生成
		int jankenNum = (int) (Math.random() * 10 % 3);


		switch (jankenNum) {
		case 0:
			//乱数が0なら「グー」を表示
			System.out.println("グー");
			break;

		case 1:
			//乱数が1なら「チョキ」を表示
			System.out.println("チョキ");
			break;

		case 2:
			//乱数が2なら「パー」を表示
			System.out.println("パー");
			break;

		default:
			//0～2以外の整数を読み込んだ時のメッセージ
			System.out.println("対象外の値が入力されました。");
			break;
		}


	}

}
