package java07;
/**
 * int型整数の絶対値、
 * long型整数の絶対値、
 * float型実数の絶対値、
 * double型実数の絶対値
 * を返却する、オーバーロードされたメソッド「absoluteNum」を作成せよ。
 */
import java.util.Scanner;

public class E07_31 {
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
	public static void main(String[] args) {
		try {
			System.out.println("オーバーロードされたメソッド「absolute」から入力値の絶対値を出力します");
			//オーバーロードされたメソッド「absoluteNum」からint型整数の絶対値を取得
			System.out.println("絶対値は" + absoluteNum(inputNum("int型整数を入力＞")) + "です");
			
			System.out.print("long型整数を入力＞");
			//オーバーロードされたメソッド「absoluteNum」からlong型整数の絶対値を取得
			System.out.println("絶対値は" + absoluteNum(scanner.nextLong()) + "です");
			
			System.out.print("float型実数を入力＞");
			//オーバーロードされたメソッド「absoluteNum」からfloat型実数の絶対値を取得
			System.out.println("絶対値は" + absoluteNum(scanner.nextFloat()) + "です");
			
			System.out.print("double型実数を入力＞");
			//オーバーロードされたメソッド「absoluteNum」からdouble型実数の絶対値を取得
			System.out.println("絶対値は" + absoluteNum(scanner.nextDouble()) + "です");
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
	/* ====================================================================== */
	/**
	 * @brief
	 * int型整数の絶対値を返却する、オーバーロードされたメソッドabsolute
	 *
	 * @param 
	 * int inputNum int型整数
	 *
	 * @return 
	 * int absoluteNum 絶対値
	 * 
	 *
	 * @note
	 * オーバーロードされたメソッドabsoluteNum
	 */
	/* ====================================================================== */
	static int absoluteNum(int inputNum) {
		//Mathクラスのabsメソッドから値の絶対値を求める
		int absoluteNum = Math.abs(inputNum);
		//絶対値を返却
		return absoluteNum;
	}
	/* ====================================================================== */
	/**
	 * @brief
	 * long型整数の絶対値を返却する、オーバーロードされたメソッドabsolute
	 *
	 * @param 
	 * int inputNum long型整数
	 *
	 * @return 
	 * long absoluteNum 絶対値
	 * 
	 *
	 * @note
	 * オーバーロードされたメソッドabsoluteNum
	 */
	/* ====================================================================== */
	static long absoluteNum(long inputNum) {
		//Mathクラスのabsメソッドから値の絶対値を求める
		long absoluteNum = Math.abs(inputNum);
		//絶対値を返却
		return absoluteNum;
	}
	
	/* ====================================================================== */
	/**
	 * @brief
	 * float型実数の絶対値を返却する、オーバーロードされたメソッドabsolute
	 *
	 * @param 
	 * float inputNum float型実数
	 *
	 * @return 
	 * float absoluteNum 絶対値
	 * 
	 *
	 * @note
	 * オーバーロードされたメソッドabsoluteNum
	 */
	/* ====================================================================== */
	static float absoluteNum(float inputNum) {
		//Mathクラスのabsメソッドから値の絶対値を求める
		float absoluteNum = Math.abs(inputNum);
		//絶対値を返却
		return absoluteNum;
	}
	
	/* ====================================================================== */
	/**
	 * @brief
	 * double型実数の絶対値を返却する、オーバーロードされたメソッドabsolute
	 *
	 * @param 
	 * double inputNum double型実数
	 *
	 * @return 
	 * double absoluteNum 絶対値
	 * 
	 *
	 * @note
	 * オーバーロードされたメソッドabsoluteNum
	 */
	/* ====================================================================== */
	static double absoluteNum(double inputNum) {
		//Mathクラスのabsメソッドから値の絶対値を求める
		double absoluteNum = Math.abs(inputNum);
		//絶対値を返却
		return absoluteNum;
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
	static int inputNum(String outputMsg) {
		// 整数入力用の変数
		int inputNum = 0;
		// 引数の文字列をメッセージとして出力する
		System.out.print(outputMsg);
		// 試算する値を入力
		inputNum = scanner.nextInt();

		// 入力した整数値を返却する
		return inputNum;
	}
}
