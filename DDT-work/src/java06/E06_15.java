package java06;

import java.io.IOException;
import java.util.Scanner;

public class E06_15 {

	public static void main(String[] args) throws IOException {

		// 英語の曜日の名前を宣言（定数）
		final String[] WEEKOFDAY_NAME_EN = { "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
		// 日本語の曜日の名前を宣言（定数）
		final String[] WEEKOFDAY_NAME_JA = { "月", "火", "水", "木", "金", "土", "日"};
		// 出題する曜日
		int questionDayOfWeek = 0;
		// 回答曜日
		String answerDayOfWeek = null;
		// 連続した問題が出ないかチェックする作業用の変数
		int tmpNum = 0;
		// リトライ確認用の変数
		int retryNum = 0;

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			// 学習者が「リトライしますか？」の質問に「１」（＝YES)を答えている限りループする。
			do {
				System.out.println("英語の曜日名を全て小文字で入力してください。");
				
				//前回の出題曜日と今回の出題曜日が同じ場合は、ループして別の問題を出題するようにする
				do {
					// 出題する曜日をランダムに決定する
					questionDayOfWeek = (int) (Math.random() * 10) % 7 + 1;
				} while (questionDayOfWeek == tmpNum);

				System.out.print((WEEKOFDAY_NAME_JA[questionDayOfWeek - 1]) + "曜日：");
				// 回答を入力する
				answerDayOfWeek = scanner.next();
				//↑　scanner.nextLine();　とした場合に、リトライした時に入力待ちになりませんでした。なぜでしょうか？
				
				//回答者の回答が、出題した問題の回答とあっているかをチェックする
				if (answerDayOfWeek.equals(WEEKOFDAY_NAME_EN[questionDayOfWeek - 1])){
					//あっていたら正解用のメッセージを出力する。
					System.out.print("正解です！");
				}else{
					//不正解なら不正解用のメッセージを出力する。
					System.out.print("不正解です。");
				}
				
				// リトライするかを聞いて、範囲外の返答が入力されたらループする。
				do {
					System.out.println("もう一度リトライしますか？");
					System.out.print("YES・・・「1」　/ NO・・・「0」 ＞");
					// リトライするかを入力する
					retryNum = scanner.nextInt();

					// 1か0以外の値が入力されたら、メッセージを出力する
					if (retryNum != 1 && retryNum != 0) {
						System.out.println("1か0を入力してください");
					}
				} while (retryNum != 1 && retryNum != 0);
				
				//今回の問題曜日をtmpNumへ格納しおいて、連続して同じ問題を出さないようにする。
				tmpNum = questionDayOfWeek;
				//回答をリセット
				answerDayOfWeek = null;
			} while (retryNum == 1);
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}