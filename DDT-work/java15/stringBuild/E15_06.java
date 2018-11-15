package stringBuild;
/**
 * コマンドライン引数で与えられた半径を持つ円の演習の長さと面積を求めて表示するプログラムを作成せよ。
 * 
 */

import static number.Constants.*;
import static number.Number.*;


public class E15_06 {
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
			final String INPUT_RADIUS = "半径を入力＞"; // 円の半径を入力する際に表示するメッセージ
			final String ONEMORE = "もう一度行う?（０・・no / 1・・yes）＞"; // もう一度行う場合のメッセージ
			double radius; //半径
			int reStart = 0; //もう一度行うか判定する変数
			
			do {
				//半径を入力
				radius = moreOrLessCheck(MORE_D, sMORE, INPUT_RADIUS);
				
				//getCircleメソッドで円の面積を取得して表示(小数第3位で四捨五入する)
				System.out.println("面積" + sisyaGonyu(getCircle(radius),3));
				
				//getCircleメソッドで円周取得して表示(小数第3位で四捨五入する)
				System.out.println("円周" + sisyaGonyu(getCircumFerence(radius),3));
				
				//もう一度行うか判定する
				reStart = inputRangeCheck(NO, YES, ONEMORE);
				
			} while (reStart == YES);
			
		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}
}