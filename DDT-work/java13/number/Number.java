package number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;
import static number.Constants.*;

/**
 * 
 * @author masahiro 数字の入力を行う際に使うクラス
 *
 */
public class Number {
	// 標準入力ストリーム
	public static Scanner sScanner = new Scanner(System.in);
	public static BufferedReader sBr = new BufferedReader(new InputStreamReader(System.in));

	/* ====================================================================== */
	/**
	 * @brief String型の文字列を入力して返却するメソッド
	 *
	 * @param String
	 *            outputMsg 入力前に出力するメッセージ
	 *
	 * @return
	 * @throws IOException
	 *
	 * @note
	 */
	/* ====================================================================== */
	public static String inputString(String outputMsg) throws IOException {
		// 引数の文字列をメッセージとして出力する
		System.out.print(outputMsg);

		// 入力した文字列を返却する
		return sBr.readLine();
	}

	/* ====================================================================== */
	/**
	 * @brief String型の文字列を入力して返却するメソッド(Scanner型)
	 *
	 * @param String
	 *            outputMsg 入力前に出力するメッセージ
	 *
	 * @return
	 *
	 * @note
	 */
	/* ====================================================================== */
	public static String scannerInputString(String outputMsg) {
		// 引数の文字列をメッセージとして出力する
		System.out.print(outputMsg);

		// 入力した文字列を返却する
		return sScanner.nextLine();
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
	public static int inputNum(String outputMsg) {
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
	 * @brief 実数を入力して返却するメソッド
	 *
	 * @param String
	 *            outputMsg 入力前に出力するメッセージ
	 *
	 * @return double inputNum 入力した値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	public static double getDouble(String outputMsg) {
		// 実数入力用の変数
		double inputNum = 0.0;
		// 引数の文字列をメッセージとして出力する
		System.out.print(outputMsg);
		// 試算する値を入力
		inputNum = sScanner.nextDouble();

		// 入力した整数値を返却する
		return inputNum;
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
	public static int inputRangeCheck(int fromNum, int toNum, String outputMsg) {
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
	 * @brief double型の引数を２つ受け取り、 その間の実数値が入力されるまでチェックするメソッド
	 *
	 * @param double
	 *            fromNum 値(from) double toNum 値(to) String outputMsg
	 *            入力前に出力するメッセージ
	 *
	 * @return double checkedNum チェックされた範囲内の値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	public static double inputRangeCheck(double fromNum, double toNum, String outputMsg) {
		// チェック後に返却する範囲内の値
		double checkedNum = 0.0;
		do {
			// inputNumメソッドからチェックする値を入力（引数outputMsgの文字列を渡す）
			checkedNum = inputNum(outputMsg);
			// 要素数の範囲外の値が入力された時にメッセージを出力
			if (checkedNum < fromNum || toNum < checkedNum) {
				System.out.println("範囲外の数値が入力されました。\n" + fromNum + "から" + toNum + "の範囲の実数値を入力してください。\n");
			}
			// 範囲外の値が入力されたらループ
		} while (checkedNum < fromNum || toNum < checkedNum);

		// チェック後に値を返却
		return checkedNum;
	}

	/* ====================================================================== */
	/**
	 * @brief 小数以下の桁数を数えて返却
	 *
	 * @param val
	 *            実数
	 *
	 * @return 小数以下の桁数
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public static int getPrecision(double val) {
		// 実数を文字列に変換
		String str = String.valueOf(val);

		// 小数点以下が０桁の場合は0を返却
		if (str.matches("^.*\\.0+$")) {
			return 0;
		}
		// 小数点のインデックスを調べる
		int index = str.indexOf(".");
		// 小数以下の桁数を取得して返却
		return str.substring(index + 1).length();
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
	public static int moreOrLessCheck(int referenceValue, int moreOrLess, String outputMsg) {
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
	 * @brief double型の基準値と符号を示す値を受け取り、 基準値以上、または基準値以下の実数値が入力されるまでチェックするメソッド
	 *
	 * @param double
	 *            referenceValue 基準値 int moreOrLess 符号を表す値（以上or以下を判定） String
	 *            outputMsg 入力前に出力するメッセージ
	 *
	 * @return double checkedNum チェックされた値を返却する
	 *
	 * @note moreOrLessの値によって、「基準値以上の値」を入力させるか 「基準値以下の値」を入力させるか、判定する 0 ・・・・ 以下 /
	 *       1 ・・・・ 以上
	 */
	/* ====================================================================== */
	public static double moreOrLessCheck(double referenceValue, int moreOrLess, String outputMsg) {
		// チェック後に返却する値
		double checkedNum = 0.0;

		// moreOrLessの値によって、「基準値以上の値」を入力させるか
		// 「基準値以下の値」を入力させるか、判定する
		// 0 ・・・・ 以下 / 1 ・・・・ 以上

		// 基準値"以下"の値を入力させる【moreOrLessの値が 0 の場合】
		if (moreOrLess == sLESS) {
			do {
				// inputNumメソッドからチェックする値を入力（引数outputMsgの文字列を渡す）
				checkedNum = getDouble(outputMsg);
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
				checkedNum = getDouble(outputMsg);
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
	 * @brief 円の半径を受け取り、円の面積を返却するメソッド
	 *
	 * @param radius
	 *            円の半径
	 *
	 * @return 引数を半径としたときの円の面積
	 *
	 * @note 
	 * 
	 */
	/* ====================================================================== */
	public static double getCircle(double radius) {
		// 仮引数を半径として円の面積を返却
		return radius * radius * Math.PI;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 円の半径を受け取り、円周を返却するメソッド
	 *
	 * @param radius 円の半径
	 *
	 * @return 引数を半径としたときの円周
	 *
	 * @note 
	 * 
	 */
	/* ====================================================================== */
	public static double getCircumFerence(double radius) {
		// 仮引数を半径として円周を返却
		return (radius * 2) * Math.PI;
	}

	/* ====================================================================== */
	/**
	 * @brief 実数を任意の小数位で四捨五入するメソッド
	 *
	 * @param val 実数 , digit 小数位
	 *
	 * @return 引数の小数位で四捨五入した実数
	 *
	 * @note 
	 * 
	 */
	/* ====================================================================== */
	public static double sisyaGonyu(double val , int digit) {
		// 引数valを渡してBigDecimalを宣言
		BigDecimal bigDeci = new BigDecimal(String.valueOf(val));
		
		//引数の小数位で四捨五入した実数を返却
		return bigDeci.setScale((digit - 1), BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
