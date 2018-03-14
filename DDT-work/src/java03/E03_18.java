package java03;
/**
 * 月を1～12の整数値として読み込んで、それに対応する季節を表示するプログラムを作成せよ。
 */

import java.util.Scanner;

public class E03_18 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		System.out.print("月(1～12の整数)を入力してください＞");
		// 月を入力(１～１２の整数）
		int inputMonth = scanner.nextInt();

		String inputSeason = null; // 季節を格納する変数

		switch (inputMonth) {
		case 12:

		case 1:

		case 2:
			// 入力値が12、1、2なら「冬」
			inputSeason = "冬";
			break;

		case 3:

		case 4:

		case 5:
			// 入力値が3～5なら「春」
			inputSeason = "春";
			break;

		case 6:

		case 7:

		case 8:
			// 入力値が6～8なら「夏」
			inputSeason = "夏";
			break;

		case 9:

		case 10:

		case 11:
			// 入力値が9～11なら「秋」
			inputSeason = "秋";
			break;

		default:
			// 1～12以外の整数を読み込んだ時のメッセージ
			System.out.println("対象外の値が入力されました。");
			break;
		}

		// 入力値に対する季節を出力
		System.out.println(inputMonth + "月は" + inputSeason + "です。");

	}

}
