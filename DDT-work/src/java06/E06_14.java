package java06;


import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author masahiro 月を１〜１２の数値として表示して、その英語表現を入力させる英単語学習プログラムを作成せよ。 【条件】
 *         ・出題する月の値は乱数で生成する。 ・学習者が望む限り、何度でも実行可能。 ・同一の月を連続して出題しない。
 *
 */

public class E06_14 {

	public static void main(String[] args) throws IOException {

		// 月の名前を宣言（定数）
		final String[] MONTH_NAME = { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		// 出題する月
		int questionMonth = 0;
		// 回答月
		String answerMonth = null;
		// 連続した問題が出ないかチェックする作業用の変数
		int tmpNum = 0;
		// リトライ確認用の変数
		int retryNum = 0;

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// 学習者が「リトライしますか？」の質問に「１」（＝YES)を答えている限りループする。
			do {
				System.out.println("英語の月数を入力してください。");
				System.out.println("なお、先頭は大文字で、２文字目以降は小文字で答えなければ不正解です。");
				
				//前回の出題月と今回の出題月が同じ場合は、ループして別の問題を出題するようにする
				do {
					// 出題する１〜１２の月をランダムに決定する
					questionMonth = (int) (Math.random() * 100) % 12 + 1;
				} while (questionMonth == tmpNum);

				System.out.print(questionMonth + "月：");
				// 回答を入力する
				//answerMonth = br.readLine();
				answerMonth = scanner.next();
				//↑　scanner.nextLine();　とした場合に、リトライした時に入力待ちになりませんでした。なぜでしょうか？
				
				//回答者の回答が、出題した問題の回答とあっているかをチェックする
				if (answerMonth.equals(MONTH_NAME[questionMonth - 1])){
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
				
				//今回の問題月をtmpNumへ格納しおいて、連続して同じ問題を出さないようにする。
				tmpNum = questionMonth;
				//回答をリセット
				answerMonth = null;
			} while (retryNum == 1);
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
