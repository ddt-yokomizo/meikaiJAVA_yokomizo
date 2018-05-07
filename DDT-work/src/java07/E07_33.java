package java07;
/**
 * int型の１次元配列と、行によって列数が異なる可能性のあるint型２次元配列の全要素の値を
 * 表示する、オーバーロードされたメソッド「printArray」を作成せよ。
 * また、要素の間は１文字分のスペースを確保し、
 * さらに２次元配列の場合は各列の数値の先頭が揃うように、「最低限のスペース」を空けること
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class E07_33 {
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
			// 処理する１次元配列x
			int[] arrayListX;
			// 処理する２次元配列ｙ
			int[][] arrayListY;

			//insert2dimentionArrayメソッドから２次元配列(X)を作成
			// moreOrLessCheckメソッドから1以上の整数値を入力させて配列の要素数を決定する(第２引数の 1 は、「〜以上」を意味する値）
			arrayListX = createArray(moreOrLessCheck(1, 1, "1次元配列(X)の要素数を決定してください＞"));
			
			//insert2dimentionArrayメソッドから２次元配列(Y)を作成
			// moreOrLessCheckメソッドから1以上の整数値を入力させて配列の要素数を決定する(第２引数の 1 は、「〜以上」を意味する値）
			arrayListY = insert2dimentionArray(moreOrLessCheck(1, 1, "２次元配列(Y)の行数を決定してください＞"));
			
			System.out.println("\n処理結果：\n");
			System.out.println("結果を出力します");
			System.out.println("\n1次元配列(X)の要素を出力");
			//printArrayメソッドから1次元配列の要素を出力
			printArray(arrayListX);
			
			System.out.println("\n2次元配列(Y)の要素を出力");
			//printArrayメソッドから2次元配列の要素を出力
			printArray(arrayListY);
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
	 * int型配列を引数分の要素で作成して返却するメソッド
	 *
	 * @param 
	 * int howMany 要素数
	 *
	 * @return 
	 * int[] arrayList 格納後の配列を返却
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	static int[] createArray(int howMany) {
		//引数分の要素を持つ配列を作成
		int[] arrayList = new int[howMany];
		
		//指定数分ループして要素に値を格納する
		for(int i = 0 ; i < arrayList.length ; i++){
			//要素に値を格納する
			arrayList[i] = (inputNum((i + 1) + "番目の要素を入力してください＞"));
		}
		// 格納後の配列を返却
		return arrayList;
	}
	/* ====================================================================== */
	/**
	 * @brief 
	 * １次元配列を受け取り、要素を全て出力するメソッド
	 *
	 * @param 
	 * int[] arrayList 出力する1次元配列
	 *
	 * @return 
	 * なし
	 *
	 * @note
	 * 要素の間は１文字分のスペースを空けること
	 * 
	 */
	/* ====================================================================== */
	static void printArray(int[] arrayList) {
		//配列の要素を表示
		for(int i = 0 ; i < arrayList.length ; i++){
			//順番に要素を出力（最後を除き、要素と要素の間にはスペースを入れる）
			System.out.print(arrayList[i] + (i == (arrayList.length - 1) ? "" : " "));
			}
		//改行
		System.out.println();
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * ２次元配列を受け取り、要素を全て出力するメソッド
	 *
	 * @param 
	 * int[][] listOf2dimention 出力する２次元配列
	 * ArrayList<Integer> maxDigitList 各列の最大桁数を格納したリスト
	 *
	 * @return 
	 * なし
	 *
	 * @note
	 * 要素の間は１文字分のスペースを空けること
	 * さらに、
	 * 各列の数値の先頭が揃うように、最低限のスペースを空けること
	 * 
	 */
	/* ====================================================================== */
	static void printArray(int[][] listOf2dimention) {
		//getMaxDigitListメソッドから各列の最大桁数リストを取得
		ArrayList<Integer> maxDigitList = getMaxDigitList(listOf2dimention);
		
		//配列の要素を表示
		for(int i = 0 ; i < listOf2dimention.length ; i++){
			for(int j = 0 ; j < listOf2dimention[i].length ; j++){
				//要素を順番に出力(行の最後を除き、要素と要素の間にはカンマを入れる)
				System.out.print(listOf2dimention[i][j]);
				//読み込み中の要素の桁数が最大桁数未満なら、先頭を揃えるため最低限のスペースを補填する
				if(String.valueOf(listOf2dimention[i][j]).length() < maxDigitList.get(j)){
					//読み込み中の要素の桁数と、最大桁数の差分だけ、スペースを出力
					for(int l = 0 ; l < (maxDigitList.get(j) - String.valueOf(listOf2dimention[i][j]).length()) ; l++){
						//スペースを出力
						System.out.print(" ");
					}
				}
				//行の最後を除き、要素と要素の間にはスペースを入れる
				System.out.print((j == (listOf2dimention[i].length - 1) ? "" : " "));
			}
			//改行
			System.out.println();
		}
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * ２次元配列を読み込み、各列の最大桁数をリストに格納するメソッド
	 *
	 * @param 
	 * int[][] listOf2dimention チェックする２次元配列
	 *
	 * @return 
	 * ArrayList<Integer> maxDigitList 各列の最大桁数を格納したリスト
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	static ArrayList<Integer> getMaxDigitList(int[][] listOf2dimention) {
		//列の最大桁を格納するリスト
		ArrayList<Integer> maxDigitList = new ArrayList<Integer>();
		//要素確保用作業変数
		int elementsSpace = 0;
		
		//２次元配列の全要素をチェックし、各列の桁数の最大桁数をリストへ格納する
		for(int i = 0 ; i < listOf2dimention.length ; i++){
			for(int j = 0 ; j < listOf2dimention[i].length ; j++){
				//maxDigitListの要素数を、読み込み中の列の要素数と合わせる
				if(maxDigitList.size() < listOf2dimention[i].length){
					//格納用リストの要素数がない場合は、elementsSpaceに一旦いくつ要素を確保すれば良いか保存する
					elementsSpace = (listOf2dimention[i].length - maxDigitList.size());
					//足りない分の要素を要素の最後尾に追加する
					for(int l = 0 ; l < elementsSpace ; l++){
						//IndexOutOfBoundsException防止のため、リストにあらかじめ要素を格納しておく（値は０とする）
						maxDigitList.add(0);
					}
				}
				//２次元配列の要素の桁数がが暫定リストの最大桁数を上回っていた場合、リストの桁数を更新する
				if(maxDigitList.get(j) < String.valueOf(listOf2dimention[i][j]).length()){
					//２次元配列の要素の桁数をリストへ格納（更新）
					maxDigitList.set(j, String.valueOf(listOf2dimention[i][j]).length());
				}
			}
		}
		//各列の最大桁数を格納したリストを返却
		return maxDigitList;
	}
}
