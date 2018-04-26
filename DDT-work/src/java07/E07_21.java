package java07;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author masahiro
 * ２つのリストの全要素の値を交換するメソッドを作成せよ。
 * ２つのリストの要素数が等しくない場合には
 * 小さいほうのリストの要素数分だけ交換を実施すること
 * 
 *
 */
public class E07_21 {
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
	 * @brief Integer型のリストに、引数分の要素を入力して返却するメソッド
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
	 * @brief int型の引数を１つと符号を意味する値を受け取り、 基準値以上、または基準値以下の整数値が入力されるまでチェックするメソッド
	 *
	 * @param int referenceValue 基準値 
	 *        int moreOrLess 符号を表す値（以上or以下を判定） 
	 *        String outputMsg 入力前に出力するメッセージ
	 *
	 * @return int checkedNum チェックされた値を返却する
	 *
	 * @note moreOrLessの値によって、「基準値以上の値」を入力させるか 「基準値以下の値」を入力させるか、判定する
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
	 * ２つのリストの全要素の値を交換するメソッドを作成せよ。
	 * 
	 * @param 
	 * ArrayList<Integer> inputList_1 処理するリスト1
	 * ArrayList<Integer> inputList_2 処理するリスト1
	 *
	 * @return 
	 * なし
	 * 
	 *
	 * @note
	 *  ２つのリストの要素数が等しくない場合には小さいほうのリストの要素数分だけ交換を実施すること
	 */
	/* ====================================================================== */
	static void aryExchange(ArrayList<Integer> inputList_1 , ArrayList<Integer> inputList_2){
		//交換処理に使用する変数
		int exchangeNum = 0;
		//要素を幾つ交換するかを制御する変数(小さいリストの要素に合わせる）
		int howManyTimes = 0;
		
		//小さいリストの要素数に合わせて、交換回数を決定
		howManyTimes = inputList_1.size() < inputList_2.size() ? inputList_1.size() : inputList_2.size();
		
		//規定の回数分、要素の交換を行う
		for(int i = 0 ; i < howManyTimes ; i++){
			//１つ目のリストの読み込んだ要素を一旦作業用変数へ格納・・・・①
			exchangeNum = inputList_1.get(i);
			//要素を退避したので、同じインデックスに位置する２つ目のリストの要素を格納する・・・・②
			inputList_1.set(i, inputList_2.get(i));
			//①で退避した要素を２つ目のリストの同じインデックスへ格納する【交換完了】
			inputList_2.set(i, exchangeNum);
		}
		
		System.out.println("交換後のリストを表示します");
		System.out.println("\n１つ目のリストを表示\n");
		//１つ目のリストを表示
		for(int inputListData : inputList_1){
			System.out.println(inputListData);
		}
		System.out.println("\n2つ目のリストを表示\n");
		//２つ目のリストを表示
		for(int inputListData : inputList_2){
			System.out.println(inputListData);
		}
	}
	
	public static void main(String[] args) {
		try {
			// 処理するリスト(1)
			ArrayList<Integer> inputList_1 = new ArrayList<Integer>();	
			// 処理するリスト(2)
			ArrayList<Integer> inputList_2 = new ArrayList<Integer>();

			//insertElementsメソッドから１つ目のリストを作成
			// moreOrLessCheckメソッドから1以上の整数値を入力させてリストの要素数を決定する(第２引数の 1 は、「〜以上」を意味する値）
			inputList_1 = insertElements(inputList_1, moreOrLessCheck(1, 1, "１つめのリストの要素数を入力してください＞"));
			
			//insertElementsメソッドから２つ目のリストを作成
			// moreOrLessCheckメソッドから1以上の整数値を入力させてリストの要素数を決定する(第２引数の 1 は、「〜以上」を意味する値）
			inputList_2 = insertElements(inputList_2, moreOrLessCheck(1, 1, "２つめのリストの要素数を入力してください＞"));
			
			System.out.println("交換前のリストを表示します");
			System.out.println("\n1つ目のリストを表示\n");
			//１つ目のリストを表示
			for(int inputListData : inputList_1){
				System.out.println(inputListData);
			}
			System.out.println("\n2つ目のリストを表示\n");
			//２つ目のリストを表示
			for(int inputListData : inputList_2){
				System.out.println(inputListData);
			}
			
			System.out.println("2つのリストの要素を入れ替えます。（要素数が異なる場合は、小さいリストの要素分交換します）");
			//aryExchangeメソッドで2つのリストの要素を入れ替えて表示する
			aryExchange(inputList_1, inputList_2);

		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
