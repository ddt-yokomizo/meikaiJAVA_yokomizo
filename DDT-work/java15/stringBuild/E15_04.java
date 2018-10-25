package stringBuild;
import static number.Number.*;
import static number.Constants.*;
	/**
	 * 
	 * @author masahiro
	 *　浮動小数点数値ｘを、小数点以下の部分をｐ桁で、
	 *　全体を少なくともｗ桁でひょうじするメソッドを作成せよ
	 *
	 */

public class E15_04 {
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
			final String INSERT_STRING = "浮動小数値を入力＞"; // 浮動小数値を入力する際に表示するメッセージ
			final String DECIMAL_STRING = "小数点の桁数を入力＞"; // 小数点の桁数を入力する際に表示するメッセージ
			final String ENTIRE_STRING = "全体の桁数を入力＞"; // 全体の桁数を入力する際に表示するメッセージ
			int decimalCheck; //入力値の小数桁数
			int decimalPart; //出力する小数桁数
			int entirePart; //最小全体桁数
			double inputDouble; //入力実数
			
			do {
				//不動小数を入力
				inputDouble = getDouble(INSERT_STRING);
				
				//入力した実数の小数桁数を取得
				decimalCheck = getPrecision(inputDouble);
				
				if(decimalCheck == 0){
					System.out.println("小数部が０桁です。");
				}
				//小数桁数が０の場合はやり直し
			} while (decimalCheck == 0);

			
			//小数部の表示桁を入力(１以上) 
			decimalPart = moreOrLessCheck(sONE, sMORE, DECIMAL_STRING);
			
			//全体の表示桁を入力
			entirePart = moreOrLessCheck(decimalPart, sMORE, ENTIRE_STRING);
			
			//指定した桁数で実数を出力する
			printDouble(inputDouble, decimalPart, entirePart);
			
		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}
	
	/* ====================================================================== */
	/**
	 * @brief 浮動小数点数値ｘを、小数点以下の部分をｐ桁で、
	 *　全体を少なくともｗ桁で表示するメソッド
	 *
	 * @param x 実数 , p 小数点の表示桁 , w 全体の表示桁
	 *
	 * @return　
	 *
	 * @note 
	 * 
	 */
	/* ====================================================================== */
	public static void printDouble(double x , int p , int w){
		
		//仮引数の浮動小数点を、仮引数での桁数で表示する
		System.out.printf(String.format("%%%d.", w) + String.format("%df", p) , x);
		
	}

}