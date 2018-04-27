package java07;

/**
 * リストとインデックスと要素数を受け取り、指定の複数の要素を削除するメソッドを作成せよ。
 * 削除に伴い、要素を削除した要素分だけ前に詰めること
 */
import java.util.ArrayList;
import java.util.Scanner;

public class E07_25 {
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
	 * int howMany 要素数
	 *
	 * @return 
	 * ArrayList<Integer> inputList 格納後のリストを返却
	 *
	 * @note
	 * 要素が格納されているリストを受け取った場合でも、洗い替えを行う
	 */
	/* ====================================================================== */
	static ArrayList<Integer> insertElements(ArrayList<Integer> inputList , int howMany) {
		//リストの要素をクリアする
		inputList.clear();
		
		//指定数分ループして要素に値を格納する
		for(int i = 0 ; i < howMany ; i++){
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
	 * リストとインデックスと要素数を受け取り、指定の複数の要素を削除するメソッド
	 * 
	 * @param 
	 * ArrayList<Integer> arrayList 処理するリスト
	 * int posKey 削除する起点となるインデックス
	 * int howMany 削除する要素数
	 *
	 * @return 
	 * ArrayList<Integer> arrayList 処理後のリストを返却する
	 * 
	 *
	 * @note
	 * 削除に伴い、要素を削除した要素分だけ前に詰める
	 */
	/* ====================================================================== */
	static ArrayList<Integer> arrayRemoveSome(ArrayList<Integer> arrayList , int posKey , int howMany){
		//削除する起点のインデックスから、指定回数だけループして要素の削除を行う
		for(int i = 0 ; i < howMany ; i++){
			//要素の削除
			arrayList.remove(posKey);
		}
		System.out.println("\nリストのインデックス[" + posKey + "]から" + howMany + "つの要素を削除しました。\n");
		//指定された位置にある要素を削除したリストを返却
		return arrayList;
	}
	
	public static void main(String[] args) {
		try {
			
			//削除するインデックスの開始位置
			int rmIdxFrom = 0;
			//削除する要素数
			int howManyRm = 0;
			
			// 処理するリスト
			ArrayList<Integer> arrayList = new ArrayList<Integer>();

			//insertElementsメソッドから処理するリストを作成
			// moreOrLessCheckメソッドから1以上の整数値を入力させてリストの要素数を決定する(第２引数の 1 は、「〜以上」を意味する値）
			arrayList = insertElements(arrayList, moreOrLessCheck(1, 1, "リストの要素数を入力してください＞"));
			
			System.out.println("\n処理前のリストを表示\n");
			//リストの要素を表示
			for(int arrayListData : arrayList){
				//順番に要素を表示
				System.out.println(arrayListData);
			}
			//要素を削除する起点のインデックスを入力（入力範囲はinputRangeCheckメソッドでリストのインデックス範囲に限定する）
			rmIdxFrom = inputRangeCheck(0, (arrayList.size() - 1) , "削除するインデックスを入力してください＞");
			
			//要素を削除する起点のインデックスを入力（入力範囲はinputRangeCheckメソッドで１以上〜起点を考慮したリストのインデックス範囲に限定する）
			howManyRm = inputRangeCheck(1, (arrayList.size() - rmIdxFrom) , "幾つ要素を削除しますか？＞");
			
			System.out.println("\n指定位置から要素を" + howManyRm + "個削除します。\n");
			
			//arrayRemoveSomeメソッドで指定位置から複数の要素を削除したリストを取得
			arrayList = arrayRemoveSome(arrayList , rmIdxFrom , howManyRm);
			
			System.out.println("\n処理結果：\n");
			//処理した結果、要素が１以上あれば要素を出力
			//削除後に要素がなくなっていれば、その旨をメッセージで出力する
			if(arrayList.size() != 0){
				System.out.println("指定された位置にある要素を削除したリストを表示します");
				//インデックスを格納したリストの要素を表示
				//リストの要素を表示
				for(int arrayListData : arrayList){
					//順番に要素を表示
					System.out.println(arrayListData);
				}
			}else{
				System.out.println("現在のリストは空です。");
			}
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}