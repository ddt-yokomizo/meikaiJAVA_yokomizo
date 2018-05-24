package java10;

import java.util.ArrayList;
import java.util.Scanner;

public class E10_02 {
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
	public static void main(String[] args){
		try {

			final int MORE = 1; //「〜以上」を表す定数
			final int START_ONE = 1; //「１〜」の範囲を入力させたい時に利用する定数
			final String INS_HOW_MANY = "連番インスタンスをいくつ生成しますか？＞"; //連番インスタンス改の生成数を指定する際に利用する定数
			final String INS_CHANGE_NUM = "識別番号の加算値を入力＞"; //連番インスタンス改の生成時に加算する識別番号の飛び値を変更する際に出力する定数
			int howMany = 0; //連番インスタンスをいくつ生成するかの変数
			int changeNum = 1; //カウンタを変更する変数
			
			//連番コレクションを宣言
			ArrayList<ExId> idList = new ArrayList<ExId>();
			
			System.out.println("\n2回に分けて連番インスタンス改を生成します。");
			System.out.println("\n========１回目========");
			
			//連番インスタンス改をいくつ生成するかを決定（１以上の整数）
			howMany = inputMoreOrLessCheck(START_ONE, MORE, INS_HOW_MANY);
			
			//指定数分連番インスタンス改を生成
			for(int i = 0 ; i < howMany ; i++){
				//createIdメソッドでインスタンスを生成してリストへ格納する
				idList.add(createId());
			}
			
			System.out.println("\nここで識別番号の加算値を変更します。");
			//変更する識別番号の加算値を入力（１以上の整数）
			changeNum = inputMoreOrLessCheck(START_ONE, MORE, INS_CHANGE_NUM);
			//識別番号の加算値を変更
			ExId.setAddedValue(changeNum);
			
			System.out.println("\n========２回目========");
			
			//連番インスタンス改をいくつ生成するかを決定（１以上の整数）
			howMany = inputMoreOrLessCheck(START_ONE, MORE, INS_HOW_MANY);
			
			//指定数分連番インスタンス改を生成
			for(int i = 0 ; i < howMany ; i++){
				//createIdメソッドでインスタンスを生成してリストへ格納する
				idList.add(createId());
			}
			
			System.out.println("\n連番インスタンス改の識別番号を、生成した順番に出力します");
			
			//連番インスタンスの識別番号を、生成した順番に出力
			for(int i = 0 ; i < idList.size() ; i++){
				//連番インスタンスの識別番号を出力
				System.out.println(idList.get(i).getId());
			}
			
			System.out.println("\n最後に作成した識別番号を取得します。");
			//最後に作成した識別番号を取得
			System.out.println(Id.getMaxId());
			
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
	static int inputMoreOrLessCheck(int referenceValue, int moreOrLess, String outputMsg) {
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
	 * 連番クラス改のインスタンスを生成するメソッド
	 *
	 * @param
	 *
	 * @return 
	 * exId 生成したインスタンス
	 *
	 * @note 
	 * 
	 */
	/* ====================================================================== */
	
	public static ExId createId(){
		//連番インスタンス改を生成
		ExId exId = new ExId();
		//作成した連番インスタンス改を返却
		return exId;
		}
}