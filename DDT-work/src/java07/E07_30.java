package java07;
/**
 * 2つのint型整数値の最小値、
 * 3つのint型整数値の最小値、
 * int型配列の要素の最小値
 * を返す、オーバーロードされたメソッド「minNum」を作成せよ。
 */

import java.util.Scanner;

public class E07_30 {
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
			
			System.out.println("オーバーロードされたメソッド「minNum」から２つの整数の最小値を出力します");
			//オーバーロードされたメソッド「minNum」から２つの整数の最小値を取得
			System.out.println("最小値は" + minNum(inputNum("整数1を入力＞") , inputNum("整数2を入力＞")) + "です");
			
			System.out.println("オーバーロードされたメソッド「minNum」から3つの整数の最小値を出力します");
			//オーバーロードされたメソッド「minNum」から3つの整数の最小値を取得
			System.out.println("最小値は" + minNum(inputNum("整数1を入力＞") , inputNum("整数2を入力＞") , inputNum("整数3を入力＞")) + "です");
			
			System.out.println("オーバーロードされたメソッド「minNum」から配列の最小値を出力します");
			//オーバーロードされたメソッド「minNum」から配列の要素の最小値を取得
			//insertArrayメソッドから配列を作成
			// moreOrLessCheckメソッドから1以上の整数値を入力させて配列の要素数を決定する(第２引数の 1 は、「〜以上」を意味する値）
			System.out.println("最小値は" + minNum(insertArray(moreOrLessCheck(1, 1, "配列の要素数を決定してください＞"))) + "です");
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
	/* ====================================================================== */
	/**
	 * @brief
	 * 2つの整数の最小値を返却する、オーバーロードされたメソッドminNum
	 *
	 * @param 
	 * int inputNumA 整数１
	 * int inputNumB 整数2
	 *
	 * @return 
	 * int minNum 最小値
	 * 
	 *
	 * @note
	 * オーバーロードされたメソッドminNum
	 */
	/* ====================================================================== */
	static int minNum(int inputNumA , int inputNumB) {
		//引数inputNumAとinputNumBの小さい方をminNumとする
		int minNum = (inputNumA < inputNumB ? inputNumA : inputNumB);
		//最小値を返却
		return minNum;
	}
	/* ====================================================================== */
	/**
	 * @brief
	 * 3つの整数の最小値を返却する、オーバーロードされたメソッドminNum
	 *
	 * @param 
	 * int inputNumA 整数１
	 * int inputNumB 整数2
	 * int inputNumB 整数3
	 *
	 * @return 
	 * int minNum 最小値
	 * 
	 *
	 * @note
	 * オーバーロードされたメソッドminNum
	 */
	/* ====================================================================== */
	static int minNum(int inputNumA , int inputNumB , int inputNumC) {
		//引数inputNumAとinputNumBの小さい方を一旦minNumとする
		int minNum = (inputNumA < inputNumB ? inputNumA : inputNumB);
		//minNumとinputNumCの小さい方をminNumとする(確定)		
		minNum = (minNum < inputNumC ? minNum : inputNumC);
		
		//最小値を返却
		return minNum;
	}
	
	/* ====================================================================== */
	/**
	 * @brief
	 * 配列の最小値を返却する、オーバーロードされたメソッドminNum
	 *
	 * @param 
	 * int[] inputArray 配列
	 * int inputNumB 整数2
	 * int inputNumB 整数3
	 *
	 * @return 
	 * int minNum 最小値
	 * 
	 *
	 * @note
	 * オーバーロードされたメソッドminNum
	 */
	/* ====================================================================== */
	static int minNum(int[] inputArray) {
		//一旦、配列の１番目の要素を暫定の最小値とする
		int minNum = inputArray[0];
		
		//配列2番目の要素からすべて確認し、要素の最小値を探索する
		for(int i = 1 ; i < inputArray.length ; i++){
			//暫定最小値よりも小さい要素があれば、最小値を更新する
			minNum = (minNum < inputArray[i] ? minNum : inputArray[i]);
		}
		//最小値を返却
		return minNum;
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
	 * 整数型の配列に、引数分の要素を入力して返却するメソッド
	 *
	 * @param 
	 * int howMany 要素数
	 *
	 * @return 
	 * int[] inputArray 格納後のリストを返却
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	static int[] insertArray(int howMany) {
		//配列をクリアする
		int[] inputArray = new int[howMany];
		
		//指定数分ループして要素に値を格納する
		for(int i = 0 ; i < inputArray.length ; i++){
			//要素に値を格納する
			inputArray[i] = (inputNum((i + 1) + "番目の要素を入力してください＞"));
		}
		// 格納後の配列を返却
		return inputArray;
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
}
