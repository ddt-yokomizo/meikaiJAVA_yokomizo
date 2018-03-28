package java05;


/**
 * 
 * @author masahiro
 * 論理型の変数にtrueやfalseを代入して、その結果を表示するプログラムを作成せよ。
 *
 */

public class E05_03 {

	public static void main(String[] args) {
		//boolean型の変数を宣言
		boolean inputFlg = false;
		try {
			System.out.println("inputFlgにtrueを代入します。");
			//inputFlgにtrueを代入
			inputFlg = true;
			System.out.println("出力結果＞" + inputFlg);
			
			System.out.println("inputFlgにfalseを代入します。");
			//inputFlgにfalseを代入
			inputFlg = false;
			System.out.println("出力結果＞" + inputFlg);
			
			
		} finally {

		}

	}

}
