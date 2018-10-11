package stringBuild;
import static number.Number.*;
	/**
	 * 
	 * @author masahiro
	 *　文字列を読み込んで、その全文字の文字コードを表示するプログラムを作成せよ。
	 *
	 */

	public class E15_02 {
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
				int stringLength; //文字列の長さ
				String inputString = null; //文字列
				char tmpchar; //作業用文字
				
				//文字列を入力
				inputString = scannerInputString(INSERT_STRING);
				
				//入力した文字列をそのまま表示
				System.out.println("入力した文字列\n" + inputString);
				
				//文字列の長さを格納
				stringLength = inputString.length();
				
				//入力した全文字の文字コードを順番に出力する
				for(int i = 0 ; i < stringLength ; i++){
					//文字コードを出力
					System.out.println("'" + inputString.charAt(i) + "’は、" + inputString.codePointAt(i) + "です");
				}
				
			} finally {
				// scannerをクローズ
				sScanner.close();
			}
		}
	}
