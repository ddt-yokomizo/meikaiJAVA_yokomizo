package java04;

import java.util.Scanner;

/**
 * 
 * @author masahiro do文の中にdo文が入る２重ループ処理を用いて、 1~12の値が入力された時は月に対応した季節を表示し、
 *         1~12以外の値が入力された時は再度入力を促すプログラムを作成せよ。
 *
 */
public class E04_19 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		// 入力用変数
		int inputMonth = 0;
		// 季節格納用の変数
		String inputSeason = null;
		// リトライ判定用変数
		int retryNum = 0;
		
		try {
			// 【処理概要】入力月に対応する季節を出力し、再度実行まで可能
			do {
				// 【処理概要】１〜１２の整数値が入力されるまでループ
				do {
					System.out.print("整数値＞");
					// 入力値１
					inputMonth = scanner.nextInt();

					if (1 <= inputMonth && inputMonth <= 12) {
						//1~12の値が入力されたら処理を抜ける
					} else {
						// 1~12以外の値が入力されたらメッセージ出力
						System.out.println("1~12の整数値を入力してください。");
					}
				} while (inputMonth < 1 || 12 < inputMonth);

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
					break;
				}
				// 判定した季節を出力
				System.out.println(inputMonth + "月は" + inputSeason + "です");

				// 【処理概要】再度実行するか聞いて、対象外（1か2以外）の値が入力されたらループ
				do {
					System.out.print("再度実行しますか？　1  ・・・ YES　/ 2　・・・　NO ＞");
					// リトライ判定用変数を入力
					retryNum = scanner.nextInt();

					if (retryNum == 1 || retryNum == 2) {
						//１か２が入力されたら処理を抜ける
						break;
					} else {
						// 1か２以外の値が入力されたらメッセージ出力
						System.out.println("1か2を入力してください。");
					}
				} while (retryNum != 1 || retryNum != 2);

			} while (retryNum == 1);

		} finally {
			// scanner をクローズ
			scanner.close();
		}

	}

}
