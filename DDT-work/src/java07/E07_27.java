package java07;
/**
 *3つの２次元配列（ｘ、ｙ、ｚ）を受け取り、全ての要素数が等しければ
 *ｘの要素とｙの要素をｚに加算してtrueを返却、
 *等しくなければ加算せずfalseを返却する戻り値boolean型のメソッドを作成せよ
 */

import java.util.Scanner;

public class E07_27 {
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
			// 処理する２次元配列x
			int[][] arrayListX;
			// 処理する２次元配列ｙ
			int[][] arrayListY;
			// 処理する２次元配列ｚ
			int[][] arrayListZ;
			//２次元配列(Z)の行数
			int inputLineZ = 0;

			//insert2dimentionArrayメソッドから２次元配列(X)を作成
			// moreOrLessCheckメソッドから1以上の整数値を入力させて配列の要素数を決定する(第２引数の 1 は、「〜以上」を意味する値）
			arrayListX = insert2dimentionArray(moreOrLessCheck(1, 1, "２次元配列(X)の行数を決定してください＞"));
			
			//insert2dimentionArrayメソッドから２次元配列(Y)を作成
			// moreOrLessCheckメソッドから1以上の整数値を入力させて配列の要素数を決定する(第２引数の 1 は、「〜以上」を意味する値）
			arrayListY = insert2dimentionArray(moreOrLessCheck(1, 1, "２次元配列(Y)の行数を決定してください＞"));
			
			//２次元配列(Z)の行数を決定（１以上の整数）
			inputLineZ = moreOrLessCheck(1, 1, "２次元配列(Z)の行数を決定してください＞");
			
			//任意の要素数で２次元配列(Z)を作成
			//入力した行数で配列を宣言
			arrayListZ = new int[inputLineZ][];
			//任意の入力値で２次元配列の列数を決定
			for(int i = 0 ; i < arrayListZ.length ; i++){
				arrayListZ[i] = new int[moreOrLessCheck(1, 1, "２次元配列(Z)の" + (i + 1) + "行目の列数を決定してください＞")];
			}
			
			System.out.println("\n処理結果：\n");
			System.out.println("結果を出力します");
			//addMatrixメソッドへ３つの２次元配列を渡して、結果を出力する
			//渡した全ての２次元配列の要素数が一致していれば
			System.out.println(addMatrix(arrayListX, arrayListY, arrayListZ));
		} finally {
			// scannerをクローズ
			scanner.close();
		}
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
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 引数で受け取った行数の２次元配列を作成して返却するメソッド
	 *
	 * @param 
	 * int insertLine 作成する２次元配列の行数
	 *
	 * @return 
	 * int[][] listOf2dimention 作成した２次元配列を返却
	 *
	 * @note
	 * 各行の要素数はこのメソッド内部で定義する
	 */
	/* ====================================================================== */
	static int[][] insert2dimentionArray(int insertLine) {

		//2次元配列をnewする
		int[][] listOf2dimention = new int[insertLine][];
		//列数(作業用の変数）
		int insertRow = 0;
		
		//指定数分ループして要素に値を格納する
		for(int i = 0 ; i < insertLine ; i++){
			//moreOrLessCheckメソッドから、読み込み中の行の要素数を決定する
			//（１以上の整数）
			insertRow = moreOrLessCheck(1, 1, (i + 1) + "行目の列数を入力してください＞");
			//２次元配列の列を決定
			listOf2dimention[i] = new int[insertRow];
			
			//決定した要素数分ループし、行列の要素に値を入力（作業用の配列へ）
			for(int j = 0 ; j < insertRow ; j++){
				//行列の要素に値を入力（作業用の配列へ）
				listOf2dimention[i][j] = (inputNum((i + 1) + "行目" + (j + 1) + "列目の要素を入力してください＞"));
			}
		}
		
		System.out.println("２次元配列に要素を格納しました。");
		//配列の要素を表示
		for(int i = 0 ; i < listOf2dimention.length ; i++){
			for(int j = 0 ; j < listOf2dimention[i].length ; j++){
				//要素を順番に出力
				System.out.print(listOf2dimention[i][j]);
			}
			//改行
			System.out.println();
		}
		// 格納後の２次元配列を返却
		return listOf2dimention;
	}

	/* ====================================================================== */
	/**
	 * @brief 
	 * int型の引数を１つと符号を意味する値を受け取り、 基準値以上、または基準値以下の整数値が入力されるまでチェックするメソッド
	 *
	 * @param 
	 * int referenceValue 基準値 
	 * int moreOrLess 符号を表す値（以上or以下を判定） 
	 * String outputMsg 入力前に出力するメッセージ
	 *
	 * @return 
	 * int checkedNum チェックされた値を返却する
	 *
	 * @note 
	 * moreOrLessの値によって、「基準値以上の値」を入力させるか 「基準値以下の値」を入力させるか、判定する
	 *  0 ・・・・ 以下 /  1 ・・・・ 以上
	 */
	/* ====================================================================== */
	static int moreOrLessCheck(int referenceValue, int moreOrLess, String outputMsg) {
		// チェック後に返却する値
		int checkedNum = 0;

		// moreOrLessの値によって、「基準値以上の値」を入力させるか
		// 「基準値以下の値」を入力させるか、判定する
		// 0 ・・・・ 以下 / 1 ・・・・ 以上

		// 基準値"以下"の値を入力させる【moreOrLessの値が 0 の場合】
		if (moreOrLess == 0) {
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
		} else if (moreOrLess == 1) {
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
	 * @brief 
	 * int型の引数を２つ受け取り、 その間の整数値が入力されるまでチェックするメソッド
	 *
	 * @param 
	 * int fromNum 値(from) 
	 * int toNum 値(to) 
	 * String outputMsg 入力前に出力するメッセージ
	 *
	 * @return 
	 * int checkedNum チェックされた範囲内の値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	static int inputRangeCheck(int fromNum, int toNum, String outputMsg) {
		// チェック後に返却する範囲内の値
		int checkedNum = 0;
		do {
			// inputNumメソッドからチェックする値を入力（引数outputMsgの文字列を渡す）
			checkedNum = inputNum(outputMsg);
			// 要素数の範囲外の値が入力された時にメッセージを出力
			if (checkedNum < fromNum || toNum < checkedNum) {
				System.out.println("\n範囲外の数値が入力されました。\n" + fromNum + "から" + toNum + "の範囲の整数値を入力してください。\n");
			}
			// 範囲外の値が入力されたらループ
		} while (checkedNum < fromNum || toNum < checkedNum);

		// チェック後に値を返却
		return checkedNum;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 3つの２次元配列（ｘ、ｙ、ｚ）を受け取り、全ての要素数が等しければ
	 * ｘの要素とｙの要素をｚに加算してtrueを返却、
	 * 等しくなければ加算せずfalseを返却する戻り値boolean型のメソッド
	 *
	 * @param 
	 * int[][] listOf2dimentionX 配列X
	 * int[][] listOf2dimentionY 配列Y
	 * int[][] listOf2dimentionZ 配列Z
	 * 
	 *
	 * @return 
	 * int[][] listOf2dimention 作成した２次元配列を返却
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	static boolean addMatrix(int[][] listOf2dimentionX , int[][] listOf2dimentionY , int[][] listOf2dimentionZ) {

		//チェック用の変数（０ならfalse,1ならtrue)
		int checkNum = 1;
		
		//引数の２次元配列の要素数が全て一致しているかを確認する
		//一致していたら配列Zに加算してTrueを返却する
		if(listOf2dimentionX.length == listOf2dimentionY.length && listOf2dimentionY.length == listOf2dimentionZ.length){
			//要素（ｘ軸）が等しければ、要素（ｘ軸）分ループして要素（ｙ軸）の長さをしらべる
			for(int i = 0 ; i < listOf2dimentionX.length ; i++){
				//要素（ｙ軸）が等しければ、ループして配列Zに行列を加算する
				if(listOf2dimentionX[i].length == listOf2dimentionY[i].length && listOf2dimentionY[i].length == listOf2dimentionZ[i].length){
					//ループして配列Zに行列を加算する
					for(int j = 0 ; j < listOf2dimentionX[i].length ; j++){
						//配列Zに行列を加算する
						listOf2dimentionZ[i][j] = listOf2dimentionX[i][j] + listOf2dimentionY[i][j];
					}
					
				} else {
					//X軸要素数が全て一致しない場合はチェック変数をfalse用に変更する
					checkNum = 0;
				}
			}
		} else {
			//Y軸要素数が全て一致しない場合はチェック変数をfalse用に変更する
			checkNum = 0;
		}
		
		// チェック変数によって返却値を決定する（０ならfalse,1ならtrue)
		if(checkNum == 0){
			//配列の解放
			listOf2dimentionZ = null;
			System.out.println("要素数が一致しません");
			//要素数が一致しなかった場合falseを返却
			return false;
		} else {
			System.out.println("配列Zに行列の値を加算しました。");
			//配列の要素を表示
			for(int i = 0 ; i < listOf2dimentionZ.length ; i++){
				for(int j = 0 ; j < listOf2dimentionZ[i].length ; j++){
					//要素を順番に出力
					System.out.print(listOf2dimentionZ[i][j]);
				}
				//改行
				System.out.println();
			}
			//要素数が一致し加算した場合trueを返却
			return true;
		}
	}
}
