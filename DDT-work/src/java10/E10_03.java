package java10;

import java.util.Scanner;

public class E10_03 {
	/* ====フィールド==== */
	final static int sMORE = 1; //「〜以上」を表すクラス定数
	
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
	public static void main(String[] args){
		try {
			final int START_ONE = 1; //「１〜」の範囲を入力させたい時に利用する定数
			final String INS_HOW_MANY = "配列の要素数を決定してください＞"; //配列の要素数を指定する際に利用する定数
			final String INS_DOUBLE = "実数を入力してください＞"; //実数を入力する際に利用する定数
			int howMany = 0; //配列の要素数
			double minNum = 0; //作業用最小値
			double maxNum = 0; //作業用最大値
			double[] doubleArray; //配列を宣言			
			
			System.out.println("\n=====２値の最小値を求めます=====");
			//作業変数に２値を入力し、小さい値を作業変数へ格納（ユーティリティクラスを利用）
			minNum = MinMax.minNum(inputDoubeNum(INS_DOUBLE), inputDoubeNum(INS_DOUBLE));
			//最小値を出力
			System.out.println("２値の最小値:" + minNum);
			
			System.out.println("\n=====３値の最小値を求めます=====");
			//作業変数に３値を入力し、もっとも小さい値を作業変数へ格納（ユーティリティクラスを利用）
			minNum = MinMax.minNum(inputDoubeNum(INS_DOUBLE), inputDoubeNum(INS_DOUBLE), inputDoubeNum(INS_DOUBLE));
			//最小値を出力
			System.out.println("３値の最小値:" + minNum);
			
			
			System.out.println("\n=====配列の値の最小値を求めます=====");
			//配列の要素数を決定（１以上の整数）
			howMany = inputMoreOrLessCheck(START_ONE, sMORE, INS_HOW_MANY);
			//配列に値を代入
			doubleArray = createDoubleArray(howMany);
			//配列のもっとも小さい値を作業変数へ格納（ユーティリティクラスを利用）
			minNum = MinMax.minNum(doubleArray);
			//最小値を出力
			System.out.println("配列の最小値:" + minNum);
			
			System.out.println("\n=====２値の最大値を求めます=====");
			//作業変数に２値を入力し、大きい値を作業変数へ格納（ユーティリティクラスを利用）
			maxNum = MinMax.maxNum(inputDoubeNum(INS_DOUBLE), inputDoubeNum(INS_DOUBLE));
			//最大値を出力
			System.out.println("２値の最大値:" + maxNum);
			
			System.out.println("\n=====３値の最大値を求めます=====");
			//作業変数に３値を入力し、もっとも大きい値を作業変数へ格納（ユーティリティクラスを利用）
			maxNum = MinMax.maxNum(inputDoubeNum(INS_DOUBLE), inputDoubeNum(INS_DOUBLE), inputDoubeNum(INS_DOUBLE));
			//最小値を出力
			System.out.println("３値の最大値:" + maxNum);
			
			
			System.out.println("\n=====配列の値の最大値を求めます=====");
			//配列の要素数を決定（１以上の整数）
			howMany = inputMoreOrLessCheck(START_ONE, sMORE, INS_HOW_MANY);
			//配列に値を代入
			doubleArray = createDoubleArray(howMany);
			//配列のもっとも大きい値を作業変数へ格納（ユーティリティクラスを利用）
			maxNum = MinMax.maxNum(doubleArray);
			//最大値を出力
			System.out.println("配列の最大値:" + maxNum);
			
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
	public static int inputNum(String outputMsg) {
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
	 * @brief 実数を入力して返却するメソッド
	 *
	 * @param String outputMsg 入力前に出力するメッセージ
	 *
	 * @return double inputNum 入力した値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	public static double inputDoubeNum(String outputMsg) {
		// 実数入力用の変数
		double inputNum = 0;
		// 引数の文字列をメッセージとして出力する
		System.out.print(outputMsg);
		// 試算する値を入力
		inputNum = scanner.nextDouble();

		// 入力した整数値を返却する
		return inputNum;
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
	public static int inputMoreOrLessCheck(int referenceValue, int moreOrLess, String outputMsg) {
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
	 * double型配列に要素を格納して返却するメソッド
	 *
	 * @param 
	 * elementsNum 要素数
	 *
	 * @return 
	 * double型配列
	 *
	 * @note 
	 * 
	 */
	/* ====================================================================== */
	public static double[] createDoubleArray(int elementsNum) {
		final String INS_MSG = "実数を入力してください＞"; //要素の入力時に出力する定数
		
		// 配列を宣言
		double[] array = new double[elementsNum];
		
		//順番に要素に値を格納する
		for (int i = 0 ; i < array.length ; i++){
			//要素に実数を代入
			array[i] = inputDoubeNum(INS_MSG);
		}
		//配列を返却
		return array;
	}
}