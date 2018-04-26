package java07;

/**
 * 配列の指定の要素に値を挿入するメソッドを作成せよ。
 * 挿入後、末尾の要素は削除し、挿入に伴い要素を１つ後方へずらすこと
 */
import java.util.ArrayList;
import java.util.Scanner;

public class E07_20 {
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);

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
		inputNum = scanner.nextInt();

		// 入力した整数値を返却する
		return inputNum;
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
		if (moreOrLess == 0) {
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
		} else if (moreOrLess == 1) {
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
	 * @brief int型の引数を２つ受け取り、 その間の整数値が入力されるまでチェックするメソッド
	 *
	 * @param int
	 *            fromNum 値(from) int toNum 値(to) String outputMsg 入力前に出力するメッセージ
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
				System.out.println("範囲外の数値が入力されました。\n" + fromNum + "から" + toNum + "の範囲の整数値を入力してください。");
			}
			// 範囲外の値が入力されたらループ
		} while (checkedNum < fromNum || toNum < checkedNum);

		// チェック後に値を返却
		return checkedNum;
	}

	/* ====================================================================== */
	/**
	 * @brief リストとキーを受け取り、キーに対応する要素の位置に値を挿入する
	 *
	 * @param ArrayList<Integer>
	 *            inputList 処理するリスト int delIdx 挿入する要素の位置（何番目か、という形で受け取る） int
	 *            insertNum 挿入する値
	 *
	 * @return なし
	 * 
	 *
	 * @note 挿入後、末尾の要素は削除し、挿入に伴い要素を１つ後方へずらすこと
	 */
	/* ====================================================================== */
	static void arrayInsertNum(ArrayList<Integer> inputList, int delIdx, int insertNum) {

		//指定の位置に引数insertNumを挿入する
		inputList.add((delIdx - 1), insertNum);
		//末尾の要素を削除
		inputList.remove((inputList.size() - 1));
		
		System.out.println("挿入後の配列を表示します");
		//inputListの値を順番に出力
		for(int inputListData : inputList){
			System.out.println(inputListData);
		}
	}

	public static void main(String[] args) {
		try {
			// 要素数の変数
			int elementNum = 0;
			// 挿入する要素の位置（何番目の？という投げ方をするので１〜要素数）
			int selectIdx = 0;
			// 挿入する値
			int insertNum = 0;
			// 処理するリスト
			ArrayList<Integer> inputList = new ArrayList<Integer>();

			System.out.println("リストから指定の要素に値を挿入します。");

			// moreOrLessCheckメソッドから1以上の整数値を入力させてリストの要素数を決定する(第２引数の 1
			// は、「〜以上」を意味する値）
			elementNum = moreOrLessCheck(1, 1, "はじめに、リストの要素数を入力してください＞");

			// 設定した要素数分、addメソッドを使ってリストに要素を追加
			for (int i = 0; i < elementNum; i++) {
				// inputNumメソッドから値を入力して要素へ要素へ値を格納する
				inputList.add(inputNum((i + 1) + "番目の要素を入力＞"));
			}

			// inputRangeCheckメソッドから1番目〜リストの要素数までの整数値を入力させて挿入する要素の位置を決定する
			selectIdx = inputRangeCheck(1, inputList.size(), "何番目に値を挿入しますか？＞");

			// inputNumメソッドから挿入する値を入力する
			insertNum = inputNum("挿入する値を入力＞");

			// arrayInsertNumメソッドで指定の位置に値を挿入してリストを表示
			arrayInsertNum(inputList, selectIdx, insertNum);
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}