package java07;
/**
 * 　１から入力値までの全整数の和を計算して返却するメソッドを作成せよ。
 */
import java.util.Scanner;

public class E07_04 {
	// １から引数までの合計値を返すメソッド
	static int sumReturn(int getNumA) {
		int sumMun = 0;
		
		//引数までカウントアップして合計値を求める
		for (int i = 0 ; i < getNumA ; i++){
			//１から引数までの合計値を求める
			sumMun += (i + 1);
		}
		
		// 合計値を返却する
		return sumMun;
	}

	public static void main(String[] args) {

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			// 入力値を宣言
			int iInputNum = 0;

				System.out.print("整数を入力してください。＞");
				// 整数を入力
				iInputNum = scanner.nextInt();
				
			// メソッドsumReturnから１から入力値までの全整数の和を受け取る
			System.out.println("１から" + iInputNum + "までの合計の和は" + sumReturn(iInputNum) + "です。");

		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
