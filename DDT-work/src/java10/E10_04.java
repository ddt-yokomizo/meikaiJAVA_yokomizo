package java10;

import java.util.ArrayList;
import java.util.Scanner;

import java10.Day;

/* ====================================================================== */
/**
 * @brief 
 * 演習E10_04クラス
 *
 * @note
 * 
 */
/* ====================================================================== */

public class E10_04 {
	
	/* ====フィールド==== */
	final static int sMORE = 1; //「〜以上」を表すクラス定数
	final static int sLESS = 0; //「〜以下」を表すクラス定数
	// 標準入力ストリーム
	static Scanner sScanner = new Scanner(System.in);
	
	/* ====================================================================== */
	/**
	 * @brief メインメソッド
	 *
	 * @param なし
	 *
	 * @return なし
	 *
	 * @note
	 */
	/* ====================================================================== */
	public static void main(String[] args) {
		try {
			//日付コレクションを宣言
			ArrayList<Day> dayList = new ArrayList<Day>();
			final String INS_DOMINO = "西暦を入力＞";		//定数のメッセージ（西暦）
			final String INS_MONTH = "月を入力＞";			//定数のメッセージ（月）
			final String INS_DATE = "日を入力＞";			//定数のメッセージ（日）
			final String INS_MORE_ONE = "1以上の値を入力＞"; //定数のメッセージ（１以上の値を入力）
			
			System.out.println("\nDayインスタンスを５つ作成します。（最初の１つと最後の１つは自動的に作成されます）");
			
			//コンストラクタのパターン分インスタンスを生成(今回は実在しない日付も入力可能とする)
			System.out.println("\n====１つ目のインスタンスは自動生成されます====");
			//引数なしのコンストラクタを呼び出す
			dayList.add(new Day());
			
			System.out.println("\n====２つ目のインスタンス====");
			//引数yearのみのコンストラクタを呼び出す
			dayList.add(new Day(inputNum(INS_DOMINO)));
			
			System.out.println("\n====３つ目のインスタンス====");
			//引数year,monthのコンストラクタを呼び出す
			dayList.add(new Day(inputNum(INS_DOMINO) , inputNum(INS_MONTH)));
			
			System.out.println("\n====４つ目のインスタンス====");
			//引数year,month, dateのコンストラクタを呼び出す
			dayList.add(new Day(inputNum(INS_DOMINO) , inputNum(INS_MONTH) , inputNum(INS_DATE)));
			
			System.out.println("\n====５つ目のインスタンスは自動生成されます====");
			//引数Day型インスタンスのコンストラクタを呼び出す（今回は４番目に呼び出したインスタンスを渡す）
			dayList.add(new Day(dayList.get(3)));
			
			System.out.println("\n作成したDayインスタンスの情報を出力します");
			
			//day型リストを順番に出力
			for(int i = 0 ; i < dayList.size() ; i++){
				System.out.println("\n====" + (i + 1) + "番目====");
				//toStringメソッドでDay型リストの文字列表現を出力
				System.out.println((i + 1) + "番目の日付 : " + dayList.get(i).toString());
				//getProgressDayメソッドで年内の経過日数を取得
				System.out.println((i + 1) + "番目の日付の年内の経過日数 : " + dayList.get(i).getProgressDay() + "日");
				//getLeftDayメソッドで年内の残り日数を取得
				System.out.println((i + 1) + "番目の日付の年内の残日数 : " + dayList.get(i).getLeftDay() + "日");
				
				//比較対象の４番以降避ける
				if(i < 3){
					System.out.println("\nインスタンスにとって４番目のインスタンスがどのような関係か調べます。＞");
					//４番目の要素との前後関係を調べる			
					dayList.get(i).judgeDate(dayList.get(3));
				}
			}
			
			System.out.println("\ndayListの２番目の日付と５番目の日付の前後関係を調べます＞\n");
			//dayListの2番目の要素と5番目の要素の前後関係を調べる			
			Day.judgeDate(dayList.get(1),dayList.get(4));
			
			System.out.println("\ndayListの４番目の日付を1日進めます＞");
			//４番目の日付を1日進める			
			dayList.get(3).plusOneDay();
			System.out.print("\n結果＞");
			//４番目の日付を出力
			System.out.println(dayList.get(3).toString());
			
			System.out.println("\ndayListの４番目の日付をn日進めます＞");
			//４番目の日付を指定数分進める			
			dayList.get(3).plusSomeDays(inputMoreOrLessCheck(1, sMORE, INS_MORE_ONE));
			System.out.print("\n結果＞");
			//４番目の日付を出力
			System.out.println(dayList.get(3).toString());
			
			System.out.print("\ndayListの3番目の日付の1日後を取得して表示します＞");
			System.out.print("\n結果＞");
			//dayListの3番目の日付の1日後を取得して表示
			System.out.println(Day.plusOneDay(dayList.get(2)).toString());
			
			
			System.out.println("\ndayListの４番目の日付を1日戻します＞");
			//４番目の日付を1日戻す			
			dayList.get(3).minusOneDay();
			System.out.print("\n結果＞");
			//４番目の日付を出力
			System.out.println(dayList.get(3).toString());
			
			System.out.println("\ndayListの４番目の日付をn日戻します＞");
			//４番目の日付を指定数分戻す			
			dayList.get(3).minusSomeDays(inputMoreOrLessCheck(1, sMORE, INS_MORE_ONE));
			System.out.print("\n結果＞");
			//４番目の日付を出力
			System.out.println(dayList.get(3).toString());
			
			System.out.println("\ndayListの3番目の日付の1日前を取得して表示します＞");
			//dayListの３番目の日付の1日前を取得して表示
			System.out.println(Day.minusOneDay(dayList.get(2)).toString());
			
		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}

	/* ====================================================================== */
	/**
	 * @brief 整数値を入力して返却するメソッド
	 *
	 * @param String outputMsg 入力前に出力するメッセージ
	 *
	 * @return int inputNum 入力した値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	static int inputNum(String outputMsg) {
		// 整数入力用の変数
		int inputNum = 0;
		// 引数の文字列をメッセージとして出力する
		System.out.print(outputMsg);
		// 試算する値を入力
		inputNum = sScanner.nextInt();

		// 入力した整数値を返却する
		return inputNum;
	}

	/* ====================================================================== */
	/**
	 * @brief 
	 * int型の引数を２つ受け取り、 その間の整数値が入力されるまでチェックするメソッド
	 *
	 * @param 
	 * fromNum 値(from) 
	 * toNum 値(to) 
	 * outputMsg 入力前に出力するメッセージ
	 *
	 * @return 
	 * int checkedNum チェックされた範囲内の値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	static int inputRangeCheck(int fromNum, int toNum, String outputMsg) {
		// チェック後に返却する範囲内の値
		int checkedNum = 0;
		do {
			// inputNumメソッドからチェックする値を入力（引数outputMsgの文字列を渡す）
			checkedNum = inputNum(outputMsg);
			// 要素数の範囲外の値が入力された時にメッセージを出力
			if (checkedNum < fromNum || toNum < checkedNum) {
				System.out.println("範囲外の数値が入力されました。\n" + fromNum + "から" + toNum + "の範囲の整数値を入力してください。\n");
			}
			// 範囲外の値が入力されたらループ
		} while (checkedNum < fromNum || toNum < checkedNum);

		// チェック後に値を返却
		return checkedNum;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * int型の引数を１つと符号を意味する値を受け取り、 基準値以上、または基準値以下の整数値が入力されるまでチェックするメソッド
	 *
	 * @param 
	 * int referenceValue 基準値 
	 * int moreOrLess 符号を表す値（以上or以下を判定） 
	 * String outputMsg 入力前に出力するメッセージ
	 *
	 * @return 
	 * int checkedNum チェックされた値を返却する
	 *
	 * @note 
	 * moreOrLessの値によって、「基準値以上の値」を入力させるか 「基準値以下の値」を入力させるか、判定する
	 *  0 ・・・・ 以下 /  1 ・・・・ 以上
	 */
	/* ====================================================================== */
	static int inputMoreOrLessCheck(int referenceValue, int moreOrLess, String outputMsg) {
		// チェック後に返却する値
		int checkedNum = 0;

		// moreOrLessの値によって、「基準値以上の値」を入力させるか
		// 「基準値以下の値」を入力させるか、判定する
		// 0 ・・・・ 以下 / 1 ・・・・ 以上

		// 基準値"以下"の値を入力させる【moreOrLessの値が 0 の場合】
		if (moreOrLess == sLESS) {
			do {
				// inputNumメソッドからチェックする値を入力（引数outputMsgの文字列を渡す）
				checkedNum = inputNum(outputMsg);
				// 基準値より大きい値が入力された時のメッセージ
				if (referenceValue < checkedNum) {
					System.out.println(referenceValue + "以下の整数値を入力してください。");
				}
				// 基準値より大きい値が入力されたらループ
			} while (referenceValue < checkedNum);

			// 基準値"以上"の値を入力させる処理【moreOrLessの値が 1 の場合】
		} else if (moreOrLess == sMORE) {
			do {
				// inputNumメソッドからチェックする値を入力（引数outputMsgの文字列を渡す）
				checkedNum = inputNum(outputMsg);
				// 基準値未満の値が入力された時のメッセージ
				if (checkedNum < referenceValue) {
					System.out.println(referenceValue + "以上の整数値を入力してください。");
				}
				// 基準値未満の値が入力されたらループ
			} while (checkedNum < referenceValue);
		}
		// チェック後に値を返却
		return checkedNum;
	}
}