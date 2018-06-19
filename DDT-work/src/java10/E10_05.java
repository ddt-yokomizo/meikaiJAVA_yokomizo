package java10;
/**
 * 演習１０−５検証クラス
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import java10.ExAccount;
import java10.Day;

public class E10_05 {
	/* ====フィールド==== */
	final static int sMORE = 1; //「〜以上」を表すクラス定数
	final static int sLESS = 0; //「〜以下」を表すクラス定数
	
	//標準入力
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
	public static void main(String[] args) throws IOException {
		try {
			final String INPUT_ONE = "1（預金する）を入力してください。＞"; // 預金するコンストラクタを作らせるためのメッセージ
			final String DONT_INPUT_ONE = "1（預金する）以外の正の整数を入力してください。＞"; // 預金しないコンストラクタを作らせるためのメッセージ
			final String DEPOSIT_HOW = "いくら預金しますか？＞"; // 預金する金額を促すメッセージ
			final String DRAW_HOW = "いくら引きだしますか？＞"; // 引き出す金額を促すメッセージ

			// 口座コレクションを宣言
			ArrayList<ExAccount> accountList = new ArrayList<ExAccount>();

			System.out.println("\nAccountインスタンスを2つ作成します。");

			System.out.println("\nはじめに、開設時に預金しないタイプのAccountインスタンスを作成します。");
			// createAccountメソッドで口座インスタンス生成してコレクションに格納(開設時に預金しない)
			// 引数は1（預金する）以外の正の整数
			accountList.add(createAccount(moreOrLessCheck(2, 1, DONT_INPUT_ONE)));

			System.out.println("\nつぎに、開設時に預金するタイプのAccountインスタンスを作成します。");
			// createAccountメソッドで口座インスタンス生成してコレクションに格納(開設時に預金する) 引数は1（預金する）
			accountList.add(createAccount(inputRangeCheck(1, 1, INPUT_ONE)));

			System.out.println("\n口座インスタンス情報を順番に出力");
			// Account型リストの情報を順番に出力
			for (int i = 0; i < accountList.size(); i++) {

				System.out.println("\n====" + i + "つ目の口座インスタンス====");
				// 口座名義を出力
				System.out.println("口座名義 :" + accountList.get(i).getAcName());

				// 口座番号を出力
				System.out.println("口座番号 :" + accountList.get(i).getAcNo());

				// 残高を出力
				System.out.println("残高 :" + accountList.get(i).getAcBalance());

				// 口座種類を出力
				System.out.println("口座種類 :" + accountList.get(i).getTypeOfAc());

				// 口座開設日を出力
				System.out.println("口座開設日 :" + accountList.get(i).toString());
			}

			System.out.println("\n残高がない口座インスタンスに預金します。");
			// １番目の口座インスタンスに預金する
			accountList.get(0).deposit(moreOrLessCheck((long) 0, 1, DEPOSIT_HOW));
			// 残高を確認
			System.out.println("残高 :" + accountList.get(0).getAcBalance());

			System.out.println("\nつぎは引き出してみます。（残高以上は引き出せません）");
			// １番目の口座インスタンスから金額を引き出す
			accountList.get(0).withDraw(inputRangeCheck((long) 1, accountList.get(0).getAcBalance(), DRAW_HOW));
			;
			// 残高を確認
			System.out.println("残高 :" + accountList.get(0).getAcBalance());

		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}

	/* ====================================================================== */
	/**
	 * @brief 整数値を入力して返却するメソッド
	 *
	 * @param String
	 *            outputMsg 入力前に出力するメッセージ
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
	 * @brief long型整数値を入力して返却するメソッド
	 *
	 * @param String
	 *            outputMsg 入力前に出力するメッセージ
	 *
	 * @return long inputNum 入力した値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	static long getLong(String outputMsg) {
		// 整数入力用の変数
		long inputNum = 0;
		// 引数の文字列をメッセージとして出力する
		System.out.print(outputMsg);
		// 試算するlong型の値を入力
		inputNum = sScanner.nextLong();

		// 入力したlong型整数値を返却する
		return inputNum;
	}

	/* ====================================================================== */
	/**
	 * @brief int型の引数を２つ受け取り、 その間の整数値が入力されるまでチェックするメソッド
	 *
	 * @param fromNum
	 *            値(from) toNum 値(to) outputMsg 入力前に出力するメッセージ
	 *
	 * @return int checkedNum チェックされた範囲内の値を返却する
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
	 * @brief long型の引数を２つ受け取り、 その間の整数値が入力されるまでチェックするメソッド
	 *
	 * @param fromNum
	 *            値(from) toNum 値(to) outputMsg 入力前に出力するメッセージ
	 *
	 * @return long checkedNum チェックされた範囲内の値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	static long inputRangeCheck(long fromNum, long toNum, String outputMsg) {
		// チェック後に返却する範囲内の値
		long checkedNum = 0;
		do {
			// inputNumメソッドからチェックする値を入力（引数outputMsgの文字列を渡す）
			checkedNum = getLong(outputMsg);
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
	 * @brief long型の基準値と符号を示す値を受け取り、 基準値以上、または基準値以下の実数値が入力されるまでチェックするメソッド
	 *
	 * @param long
	 *            referenceValue 基準値 int moreOrLess 符号を表す値（以上or以下を判定） String
	 *            outputMsg 入力前に出力するメッセージ
	 *
	 * @return double checkedNum チェックされた値を返却する
	 *
	 * @note moreOrLessの値によって、「基準値以上の値」を入力させるか 「基準値以下の値」を入力させるか、判定する 0 ・・・・ 以下 /
	 *       1 ・・・・ 以上
	 */
	/* ====================================================================== */
	static long moreOrLessCheck(long referenceValue, int moreOrLess, String outputMsg) {
		// チェック後に返却する値
		long checkedNum = 0;

		// moreOrLessの値によって、「基準値以上の値」を入力させるか
		// 「基準値以下の値」を入力させるか、判定する
		// 0 ・・・・ 以下 / 1 ・・・・ 以上

		// 基準値"以下"の値を入力させる【moreOrLessの値が 0 の場合】
		if (moreOrLess == sLESS) {
			do {
				// inputNumメソッドからチェックする値を入力（引数outputMsgの文字列を渡す）
				checkedNum = getLong(outputMsg);
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
				checkedNum = getLong(outputMsg);
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

	/* ====================================================================== */
	/**
	 * @brief int型の引数を１つと符号を意味する値を受け取り、 基準値以上、または基準値以下の整数値が入力されるまでチェックするメソッド
	 *
	 * @param int
	 *            referenceValue 基準値 int moreOrLess 符号を表す値（以上or以下を判定） String
	 *            outputMsg 入力前に出力するメッセージ
	 *
	 * @return int checkedNum チェックされた値を返却する
	 *
	 * @note moreOrLessの値によって、「基準値以上の値」を入力させるか 「基準値以下の値」を入力させるか、判定する 0 ・・・・ 以下 /
	 *       1 ・・・・ 以上
	 */
	/* ====================================================================== */
	static int moreOrLessCheck(int referenceValue, int moreOrLess, String outputMsg) {
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

	/* ====================================================================== */
	/**
	 * @brief 口座クラスのインスタンスを生成するメソッド
	 *
	 * @param yesOrNo
	 *            預金するかしないかを示す整数（yes ...１ no ・・・1以外）
	 *
	 * @return account 生成したインスタンス
	 *
	 * @note yesが１、NOが１以外
	 */
	/* ====================================================================== */

	static ExAccount createAccount(int yesOrNo) throws IOException {

		final int YES = 1; // 口座開設時に預金するコンストラクタを呼ぶための定数
		final String INS_NAME = "銀行口座を作成します。口座名義を入力してください＞"; // 口座名義を入力する際に出力する定数
		final String INS_ACNO = "口座番号を入力してください＞"; // 口座番号を入力する際に出力する定数
		final String INS_ACBAL = "預金残高を入力してください＞"; // 預金残高を入力する際に出力する定数
		final String INS_ACTYPE = "口座種別を入力してください（0　・・・　普通口座 / 1 ・・・ 総合口座）＞"; // 口座種別を入力する際に出力する定数
		final String INS_DOMINO = "口座開設日(西暦)を入力＞"; // 口座開設日(西暦)を入力する際に出力する定数
		final String INS_MONTH = "口座開設日(月)を入力＞"; // 口座開設日(月)を入力する際に出力する定数
		final String INS_DATE = "口座開設日(日)を入力＞"; // 口座開設日(日)を入力する際に出力する定数
		String accountName = null; // 口座名義

		// 標準入力（ScannerクラスのnextLineメソッドでは入力情報が残ってしまうため）
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 引数が１なら口座開設時に預金残高を設定する
		if (YES == yesOrNo) {
			System.out.print(INS_NAME);
			// 口座名義を入力
			accountName = br.readLine();
			// account をインスタンス化
			ExAccount account = new ExAccount(
					// 口座名義
					accountName,
					// 口座番号を入力
					String.format("%06d", (inputRangeCheck((int) 0, 999999, INS_ACNO))),
					// 預金残高を設定（１円以上のlong整数）
					moreOrLessCheck((long) 1, sMORE, INS_ACBAL),
					// 口座開設日を入力
					new Day(inputNum(INS_DOMINO), inputNum(INS_MONTH),inputNum(INS_DATE)),
					// 口座種別を入力する
					inputRangeCheck((int) 0, 1, INS_ACTYPE));

			// 作成した、預金残高ありの口座インスタンスを返却
			return account;
			// 引数が１以外なら口座開設時に預金残高を設定しない
		} else {
			System.out.print(INS_NAME);
			// 口座名義を入力
			accountName = br.readLine();
			// account をインスタンス化
			ExAccount account = new ExAccount(
					// 口座名義
					accountName,
					// 口座番号を入力
					String.format("%06d", (inputRangeCheck((int) 0, 999999, INS_ACNO))),
					// 口座開設日を入力
					new Day(inputNum(INS_DOMINO), inputNum(INS_MONTH),inputNum(INS_DATE)),
					// 口座種別を入力する
					inputRangeCheck((int) 0, 1, INS_ACTYPE));

			// 作成した、預金残高なしの口座インスタンスを返却
			return account;
		}

	}
}