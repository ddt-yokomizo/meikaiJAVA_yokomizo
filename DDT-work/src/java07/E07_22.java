package java07;
/**
 * リストを複製して返却するメソッドを作成せよ
 */

import java.util.ArrayList;
import java.util.Scanner;

public class E07_22 {
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);

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
	 * Integer型のリストに、引数分の要素を入力して返却するメソッド
	 *
	 * @param 
	 * ArrayList<Integer> inputList 新しく要素を格納するリスト
	 * int houMany 挿入する要素数
	 *
	 * @return 
	 * ArrayList<Integer> inputList 格納後のリストを返却
	 *
	 * @note
	 * 要素が格納されているリストを受け取った場合でも、洗い替えを行う
	 */
	/* ====================================================================== */
	static ArrayList<Integer> insertElements(ArrayList<Integer> inputList , int houMany) {
		//リストの要素をクリアする
		inputList.clear();
		
		//指定数分ループして要素に値を格納する
		for(int i = 0 ; i < houMany ; i++){
			//要素に値を格納する
			inputList.add(inputNum((i + 1) + "番目の要素を入力してください＞"));
		}
		// 格納後のリストを返却
		return inputList;
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
	 * リストを複製するメソッドを作成せよ。
	 * 
	 * @param 
	 * ArrayList<Integer> arrayList コピーするリスト
	 *
	 * @return 
	 * ArrayList<Integer> arrayList 複製して返却
	 * 
	 *
	 * @note
	 */
	/* ====================================================================== */
	static ArrayList<Integer> copyList(ArrayList<Integer> arrayList){
		System.out.println("\nリストを複製して返却します\n");
		//リストを返却
		return arrayList;
	}
	
	public static void main(String[] args) {
		try {
			// コピー元リスト
			ArrayList<Integer> originalList = new ArrayList<Integer>();
			//複製リスト
			ArrayList<Integer> copyList;

			//insertElementsメソッドからコピー元となるリストを作成
			// moreOrLessCheckメソッドから1以上の整数値を入力させてリストの要素数を決定する(第２引数の 1 は、「〜以上」を意味する値）
			originalList = insertElements(originalList, moreOrLessCheck(1, 1, "コピー元となるリストの要素数を入力してください＞"));
			
			System.out.println("\nコピー元となるリストを表示\n");
			//コピー元となるリストの要素を表示
			for(int originalListData : originalList){
				//順番に要素を表示
				System.out.println(originalListData);
			}
			
			//copyListメソッドでリストを複製
			copyList = copyList(originalList);
			
			System.out.println("\n複製したリストを表示\n");
			//コピーしたリストの要素を表示
			for(int copylListData : copyList){
				//順番に要素を表示
				System.out.println(copylListData);
			}
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
