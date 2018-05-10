package java09;
/**
 * 
 * @author masahiro
 * 日付クラスDay第三版（P.322）を利用するプログラムを作成せよ。
 * また、全てのコンストラクタの働きを確認できるように作成すること
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

/* ====================================================================== */
/**
 * @brief 
 * 演習E09_02クラス
 *
 * @note
 * 
 */
/* ====================================================================== */

public class E09_02 {
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);
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
			//定数のメッセージ（西暦）
			final String INS_DOMINO = "西暦を入力＞";
			//定数のメッセージ（月）
			final String INS_MONTH = "月を入力＞";
			//定数のメッセージ（日）
			final String INS_DATE = "日を入力＞";
			
			System.out.println("\nDayインスタンスを５つ作成します。（最初の１つと最後の１つは自動的に作成されます）");
			
			//コンストラクタのパターン分インスタンスを生成(今回は実在しない日付も入力可能とする)
			System.out.println("\n====１つ目のインスタンスは自動生成されます====");
			//引数なしのコンストラクタを呼び出す
			dayList.add(new Day());
			
			System.out.println("\n====２つ目のインスタンス====");
			//引数yearのみのコンストラクタを呼び出す
			dayList.add(new Day(inputRangeCheck(1, 9999, INS_DOMINO)));
			
			System.out.println("\n====３つ目のインスタンス====");
			//引数year,monthのコンストラクタを呼び出す
			dayList.add(new Day(inputRangeCheck(1, 9999, INS_DOMINO) , inputRangeCheck(1, 12, INS_MONTH)));
			
			System.out.println("\n====４つ目のインスタンス====");
			//引数year,month, dateのコンストラクタを呼び出す
			dayList.add(new Day(inputRangeCheck(1, 9999, INS_DOMINO) , inputRangeCheck(1, 12, INS_MONTH) , inputRangeCheck(1, 31, INS_DATE)));
			
			System.out.println("\n====５つ目のインスタンスは自動生成されます====");
			//引数Day型インスタンスのコンストラクタを呼び出す（今回は４番目に呼び出したインスタンスを渡す）
			dayList.add(new Day(dayList.get(3)));
			
			System.out.println("\n作成したDayインスタンスを５つ出力します");
			
			//day型リストを順番に出力
			for(int i = 0 ; i < dayList.size() ; i++){
				//toStringメソッドでDay型リストの文字列表現を出力
				System.out.println((i + 1) + "番目の日付 : " + dayList.get(i).toString());
			}
			
			System.out.print("\ndayListの３番目の要素と４番目の要素が等しいかを調べます＞");
			//dayListの３番目の要素と４番目の要素が等しいかを調べる(true or false)			
			System.out.println(dayList.get(3).equalTo(dayList.get(4)));
			
			System.out.print("\ndayListの４番目の日付を更新します。");
			dayList.get(4).setDay(inputRangeCheck(1, 9999, INS_DOMINO) , inputRangeCheck(1, 12, INS_MONTH) , inputRangeCheck(1, 31, INS_DATE));
			
			System.out.print("\nまたdayListの３番目の要素と４番目の要素が等しいかを調べます＞");
			//dayListの３番目の要素と４番目の要素が等しいかを調べる(true or false)			
			System.out.println(dayList.get(3).equalTo(dayList.get(4)));
			
			System.out.println("\nもう一度Dayインスタンスを５つ出力します");
			//day型リストを順番に出力
			for(int i = 0 ; i < dayList.size() ; i++){
				//toStringメソッドでDay型リストの文字列表現を出力
				System.out.println((i + 1) + "番目の日付 : " + dayList.get(i).toString());
			}
			
		} finally {
			// scannerをクローズ
			scanner.close();
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
		inputNum = scanner.nextInt();

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
}
