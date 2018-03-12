package java03;
/**
 * 月を1～12の整数値として読み込んで、それに対応する季節を表示するプログラムを作成せよ。
 */

import java.util.Scanner;

public class E03_18 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		System.out.print("月(1～12の整数)を入力してください＞");
		//月を入力(１～１２の整数）
		int inputMonth = scanner.nextInt();

		String inputSeason = null; //季節を格納する変数




		switch (inputMonth) {
		case 1:
			//入力値が1なら「冬」
			inputSeason = "冬";
			break;

		case 2:
			//入力値が2なら「冬」
			inputSeason = "冬";
			break;

		case 3:
			//入力値が3なら「春」
			inputSeason = "春";
			break;
		case 4:
			//入力値が4なら「春」
			inputSeason = "春";
			break;

		case 5:
			//入力値が5なら「春」
			inputSeason = "春";
			break;


		case 6:
			//入力値が6なら「夏」
			inputSeason = "夏";
			break;

		case 7:
			//入力値が7なら「夏」
			inputSeason = "夏";
			break;

		case 8:
			//入力値が8なら「夏」
			inputSeason = "夏";
			break;

		case 9:
			//入力値が9なら「秋」
			inputSeason = "秋";
			break;

		case 10:
			//入力値が10なら「秋」
			inputSeason = "秋";
			break;

		case 11:
			//入力値が11なら「秋」
			inputSeason = "秋";
			break;

		case 12:
			//入力値が12なら「冬」
			inputSeason = "冬";
			break;


		default:
			//1～12以外の整数を読み込んだ時のメッセージ
			System.out.println("対象外の値が入力されました。");
			break;
		}

		//入力値に対する季節を出力
		System.out.println(inputMonth + "月は" + inputSeason + "です。");


	}

}
