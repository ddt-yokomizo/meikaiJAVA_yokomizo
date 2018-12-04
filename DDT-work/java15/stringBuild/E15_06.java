package stringBuild;
/**
 * コマンドライン引数で与えられた半径を持つ円の演習の長さと面積を求めて表示するプログラムを作成せよ。
 * 
 */

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
			final int SISYA_GONYU_DIGIT = 3; //小数第3位で四捨五入するための定数
			double radius; //半径
			
			//コマンドライン引数の文字列をDouble型へ変換し半径を取得
			radius = Double.parseDouble(args[0]);
			
			//getCircleメソッドで円の面積を取得して表示(小数第3位で四捨五入する)
			System.out.println("面積" + sisyaGonyu(getCircle(radius),SISYA_GONYU_DIGIT));
			
			//getCircleメソッドで円周取得して表示(小数第3位で四捨五入する)
			System.out.println("円周" + sisyaGonyu(getCircumFerence(radius),SISYA_GONYU_DIGIT));
			
		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}
}