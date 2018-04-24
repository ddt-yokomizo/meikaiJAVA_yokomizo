package java07;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 配列の全要素の合計を返すメソッドを作成せよ。
 *
 */
public class E07_15 {
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);
	/* ====================================================================== */
	/**
	 * @brief
	 * 整数値を入力して返却するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * int inputNum 入力した値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	static int inputNum(){
		//整数入力用の変数
		int inputNum = 0;
		
		System.out.print("整数を入力してください＞");
		//試算する値を入力
		inputNum = scanner.nextInt();
		
		//入力した整数値を返却する
		return inputNum;
	}
	/* ====================================================================== */
	/**
	 * @brief
	 * 受け取った配列の全要素の合計を返すメソッド
	 *
	 * @param int[] inputArray int型配列
	 *
	 * @return  なし
	 *
	 * @note
	 */
	/* ====================================================================== */
	static int sumOf(int[] inputArray){
		//合計値用の変数
		int sumOfArray = 0;
		//要素全てをチェックし、合計値を算出する
		for(int i = 0 ; i < inputArray.length ; i++){
			//要素を順番に合計値へ足していく
			sumOfArray += inputArray[i];
		}
		//配列の合計値を返却
		return sumOfArray;
	}

	public static void main(String[] args) {
		try {
			//要素数の変数
			int elementNum = 0;
			//計算する配列
			int[] inputArray;
			
			System.out.println("配列の要素の合計を出力します。");
			
			do {
				System.out.print("配列の要素数を設定してください。＞");
				elementNum = scanner.nextInt();
				//０以下が入力された時のメッセージ
				if(elementNum <= 0){
					System.out.println("1以上の整数を入力してください。");
				}
				//０以下が入力されたらループ
			} while (elementNum <= 0);
			
			//配列の要素数の決定
			inputArray = new int[elementNum];
			
			//配列の要素すべてに順番に値を格納する
			for(int i = 0 ; i < inputArray.length ; i++){
				//inputNumメソッドから値を入力して要素へ要素へ値を格納する
				inputArray[i] = inputNum();
			}
			//sumOfメソッドから配列の全要素の合計を受け取って出力する
			System.out.println("配列の合計値は" + sumOf(inputArray) + "です。");
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
