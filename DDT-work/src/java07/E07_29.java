package java07;
/**
 * 2次元配列を１つ受け取り、同じ配列を生成して返却するメソッドを作成せよ。
 */

import java.util.Scanner;

public class E07_29 {
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
			// 複製する２次元配列x
			int[][] arrayListX;
			// クローン２次元配列
			int[][] cloneArray;

			//insert2dimentionArrayメソッドから２次元配列(X)を作成
			// moreOrLessCheckメソッドから1以上の整数値を入力させて配列の要素数を決定する(第２引数の 1 は、「〜以上」を意味する値）
			arrayListX = insert2dimentionArray(moreOrLessCheck(1, 1, "２次元配列(X)の行数を決定してください＞"));
			
			System.out.println("\n処理結果：\n");
			System.out.println("2次元配列を複製します");
			//arrayCloneメソッドで２次元配列を複製する
			cloneArray = arrayClone(arrayListX);
			//複製配列を出力（viewListOf2dimentionメソッド）
			viewListOf2dimention(cloneArray);
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
	 * 引数で受け取った行数の２次元配列を作成して返却するメソッド
	 *
	 * @param 
	 * int insertLine 作成する２次元配列の行数
	 *
	 * @return 
	 * int[][] listOf2dimention 作成した２次元配列を返却
	 *
	 * @note
	 * 各行の要素数はこのメソッド内部で定義する
	 */
	/* ====================================================================== */
	static int[][] insert2dimentionArray(int insertLine) {

		//2次元配列をnewする
		int[][] listOf2dimention = new int[insertLine][];
		//列数(作業用の変数）
		int insertRow = 0;
		
		//指定数分ループして要素に値を格納する
		for(int i = 0 ; i < insertLine ; i++){
			//moreOrLessCheckメソッドから、読み込み中の行の要素数を決定する
			//（１以上の整数）
			insertRow = moreOrLessCheck(1, 1, (i + 1) + "行目の列数を入力してください＞");
			//２次元配列の列を決定
			listOf2dimention[i] = new int[insertRow];
			
			//決定した要素数分ループし、行列の要素に値を入力（作業用の配列へ）
			for(int j = 0 ; j < insertRow ; j++){
				//行列の要素に値を入力（作業用の配列へ）
				listOf2dimention[i][j] = (inputNum((i + 1) + "行目" + (j + 1) + "列目の要素を入力してください＞"));
			}
		}
		
		System.out.println("２次元配列に要素を格納しました。");
		//viewListOf2dimentionメソッドで２次元配列の要素を出力
		viewListOf2dimention(listOf2dimention);
		// 格納後の２次元配列を返却
		return listOf2dimention;
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
	 * @brief 
	 * int型の引数を２つ受け取り、 その間の整数値が入力されるまでチェックするメソッド
	 *
	 * @param 
	 * int fromNum 値(from) 
	 * int toNum 値(to) 
	 * String outputMsg 入力前に出力するメッセージ
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
				System.out.println("\n範囲外の数値が入力されました。\n" + fromNum + "から" + toNum + "の範囲の整数値を入力してください。\n");
			}
			// 範囲外の値が入力されたらループ
		} while (checkedNum < fromNum || toNum < checkedNum);

		// チェック後に値を返却
		return checkedNum;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * ２次元配列を受け取り、要素を全て出力するメソッド
	 *
	 * @param 
	 * int[][] listOf2dimention 出力する２次元配列
	 *
	 * @return 
	 * なし
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	static void viewListOf2dimention(int[][] listOf2dimention) {
		//配列の要素を表示
		for(int i = 0 ; i < listOf2dimention.length ; i++){
			for(int j = 0 ; j < listOf2dimention[i].length ; j++){
				//要素を順番に出力(行の最後を除き、要素と要素の間にはカンマを入れる)
				System.out.print(listOf2dimention[i][j] + (j == (listOf2dimention[i].length - 1) ? "" : ","));
			}
			//改行
			System.out.println();
		}
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 2次元配列を２つ受け取り、要素の和を格納した２次元配列を返却するメソッドを作成せよ。
	 *
	 * @param 
	 * int[][] listOf2dimentionX 配列X
	 * int[][] listOf2dimentionY 配列Y
	 * 
	 *
	 * @return 
	 * int[][] listOf2dimentionZ 配列Xと配列Yの要素を合計した２次元配列を返却
	 *
	 * @note
	 * 受け取る行数および列数は同一のものを受け取ることを前提とする
	 */
	/* ====================================================================== */
	static int[][] arrayClone(int[][] listOf2dimentionX) {

		//受け取った２次元配列を複製する
		int[][] listOf2dimentionZ = listOf2dimentionX;
		//複製した２次元配列を返却
		return listOf2dimentionZ;
	}
}
