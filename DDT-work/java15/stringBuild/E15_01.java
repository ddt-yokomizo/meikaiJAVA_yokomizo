package stringBuild;

import static number.Number.*;
/**
 * 
 * @author masahiro
 * 文字列を読み込んでその文字列を逆順に表示するプログラムを作成せよ。
 *
 */

public class E15_01 {
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
			final String INSERT_STRING = "文字列を入力してください。＞"; // 文字列を入力する際に表示するメッセージ
			
			//入力した文字列をStringBuffer型に格納
			StringBuffer buffer = new StringBuffer(scannerInputString(INSERT_STRING));
			
			//入力した文字列をそのまま表示
			System.out.println("入力した文字列\n" + buffer);
			//入力した文字列を逆順に表示
			System.out.println("入力した文字列を逆順に表示\n" + buffer.reverse());
			
		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}
}
