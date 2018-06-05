package java10;

import java.util.Arrays;

/**
 * 
 * ２値、３値、配列の最小値を求めるメソッドや、最大値を求めるメソッドを集めたユーティリティ
 * クラスを作成せよ。
 */

/* ====================================================================== */
/**
 * @brief 
 * 最小、最大を求めるユーティリティクラス
 *
 * @note
 * 
 */
/* ====================================================================== */
public class MinMax {
	/* ====フィールド==== */
	private static double mMin = 0.0; //最小値
	private static double mMax = 0.0; //最大値
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * ２値から最小値を返す
	 *
	 * @param num1 値1, num2 値2
	 *
	 * @return 
	 * ２値の最小値
	 *
	 * @note
	 * 実数で返却
	 */
	/* ====================================================================== */
	public static double minNum(double num1 , double num2){
		//２値の最小値を返却
		return num1 < num2 ? num1 : num2;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 3値から最小値を返す
	 *
	 * @param num1 値1, num2 値2, num3 値3
	 *
	 * @return 
	 * 3値の最小値
	 *
	 * @note
	 * 実数で返却
	 */
	/* ====================================================================== */
	public static double minNum(double num1 , double num2 , double num3){
		//暫定最小値を計算
		mMin = num1 < num2 ? num1 : num2;
		//3値の最小値を返却
		return mMin < num3 ? mMin : num3;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 3値から最小値を返す
	 *
	 * @param num1 値1, num2 値2, num3 値3
	 *
	 * @return 
	 * 3値の最小値
	 *
	 * @note
	 * 実数で返却
	 */
	/* ====================================================================== */
	public static double minNum(double[] numArray){
		//配列を昇順並列ソート
		Arrays.parallelSort(numArray);
		//配列の最小値を返却
		return numArray[0];
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * ２値から最大値を返す
	 *
	 * @param num1 値1, num2 値2
	 *
	 * @return 
	 * ２値の最大値
	 *
	 * @note
	 * 実数で返却
	 */
	/* ====================================================================== */
	public static double maxNum(double num1 , double num2){
		//２値の最大値を返却
		return num1 < num2 ? num2 : num1;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 3値から最大値を返す
	 *
	 * @param num1 値1, num2 値2, num3 値3
	 *
	 * @return 
	 * 3値の最大値
	 *
	 * @note
	 * 実数で返却
	 */
	/* ====================================================================== */
	public static double maxNum(double num1 , double num2 , double num3){
		//暫定最小値を計算
		mMax = num1 < num2 ? num2 : num1;
		//3値の最小値を返却
		return mMax < num3 ? mMax : num3;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 3値から最大値を返す
	 *
	 * @param num1 値1, num2 値2, num3 値3
	 *
	 * @return 
	 * 3値の最大値
	 *
	 * @note
	 * 実数で返却
	 */
	/* ====================================================================== */
	public static double maxNum(double[] numArray){
		//配列を昇順並列ソート
		Arrays.parallelSort(numArray);
		//配列の最大値を返却
		return numArray[(numArray.length - 1)];
	}

}
