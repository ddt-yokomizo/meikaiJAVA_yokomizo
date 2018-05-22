package java09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class E09_04 {
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
	public static void main(String[] args) throws IOException {
		try {

			final int MORE = 1; //「〜以上」を表す定数
			final int START_ONE = 1; //「１〜」の範囲を入力させたい時に利用する定数
			final int START_TWO = 2; //「2〜」の範囲を入力させたい時に利用する定数
			final String INS_MORE_2 = "2以上の整数を入力してください。＞"; //匿名インスタンスを生成する際に利用する定数
			final String INS_ONE = "1を入力してください。＞"; //命名インスタンスを作成する際のメッセージ
			int nameOrNoName = 0; //人間インスタンス生成時に渡す作業整数。1なら匿名、１以外なら命名する
			
			//人間コレクションを宣言
			ArrayList<Human> humanList = new ArrayList<Human>();
			
			System.out.println("\n人間インスタンスを2つ作成します。");
			
			System.out.println("\nはじめに、命名する人間インスタンスを作成します。");
			//作業変数に２以上の整数を格納
			nameOrNoName = moreOrLessCheck(START_TWO, MORE, INS_MORE_2);
			//createHumanメソッドで匿名の人間インスタンスを生成してコレクションに格納　引数は1（匿名で作成する）以外の正の整数
			humanList.add(createHuman(nameOrNoName));
			
			System.out.println("\nつぎに、匿名人間インスタンスを作成します。");
			//作業変数に1を格納
			nameOrNoName = inputRangeCheck(START_ONE, START_ONE, INS_ONE);
			//createHumanメソッドで匿名の人間インスタンスを生成してコレクションに格納　引数は1（匿名で作成する）
			humanList.add(createHuman(nameOrNoName));
			
			System.out.println("\n人間インスタンス情報を順番に出力");
			//Human型リストの情報を順番に出力
			for(int i = 0 ; i < humanList.size() ; i++){
				
				System.out.println("\n====" + (i + 1) + "つ目の人間インスタンス====");
				//名前を出力
				System.out.println("名前 :" + humanList.get(i).getName());
				
				//年齢を出力
				System.out.println("年齢 :" + humanList.get(i).getAge());
				
				//誕生日を出力
				System.out.println("誕生日 :" + humanList.get(i).toString());
				
				//身長を出力
				System.out.println("身長 :" + humanList.get(i).getHeight() + "cm");
				
				//体重を出力
				System.out.println("体重 :" + humanList.get(i).getWeight() + "Kg");
			}
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
	 * @brief 実数を入力して返却するメソッド
	 *
	 * @param String outputMsg 入力前に出力するメッセージ
	 *
	 * @return double inputNum 入力した値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	static double getDouble(String outputMsg) {
		// 実数入力用の変数
		double inputNum = 0.0;
		// 引数の文字列をメッセージとして出力する
		System.out.print(outputMsg);
		// 試算する値を入力
		inputNum = scanner.nextDouble();

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
	 * double型の基準値と符号を示す値を受け取り、 基準値以上、または基準値以下の実数値が入力されるまでチェックするメソッド
	 *
	 * @param 
	 * double referenceValue 基準値 
	 * int moreOrLess 符号を表す値（以上or以下を判定） 
	 * String outputMsg 入力前に出力するメッセージ
	 *
	 * @return 
	 * double checkedNum チェックされた値を返却する
	 *
	 * @note 
	 * moreOrLessの値によって、「基準値以上の値」を入力させるか 「基準値以下の値」を入力させるか、判定する
	 *  0 ・・・・ 以下 /  1 ・・・・ 以上
	 */
	/* ====================================================================== */
	static double moreOrLessCheck(double referenceValue, int moreOrLess, String outputMsg) {
		// チェック後に返却する値
		double checkedNum = 0.0;

		// moreOrLessの値によって、「基準値以上の値」を入力させるか
		// 「基準値以下の値」を入力させるか、判定する
		// 0 ・・・・ 以下 / 1 ・・・・ 以上

		// 基準値"以下"の値を入力させる【moreOrLessの値が 0 の場合】
		if (moreOrLess == 0) {
			do {
				// inputNumメソッドからチェックする値を入力（引数outputMsgの文字列を渡す）
				checkedNum = getDouble(outputMsg);
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
				checkedNum = getDouble(outputMsg);
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
	 * fromNum 値(from) 
	 * toNum 値(to) 
	 * outputMsg 入力前に出力するメッセージ
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
				System.out.println("範囲外の数値が入力されました。\n" + fromNum + "から" + toNum + "の範囲の整数値を入力してください。\n");
			}
			// 範囲外の値が入力されたらループ
		} while (checkedNum < fromNum || toNum < checkedNum);

		// チェック後に値を返却
		return checkedNum;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * double型の引数を２つ受け取り、 その間の実数値が入力されるまでチェックするメソッド
	 *
	 * @param 
	 * fromNum 値(from) 
	 * toNum 値(to) 
	 * outputMsg 入力前に出力するメッセージ
	 *
	 * @return 
	 * double checkedNum チェックされた範囲内の値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	static double inputRangeCheck(double fromNum, double toNum, String outputMsg) {
		// チェック後に返却する範囲内の値
		double checkedNum = 0.0;
		do {
			// getDoubleメソッドからチェックする値を入力（引数outputMsgの文字列を渡す）
			checkedNum = getDouble(outputMsg);
			// 要素数の範囲外の値が入力された時にメッセージを出力
			if (checkedNum < fromNum || toNum < checkedNum) {
				System.out.println("範囲外の数値が入力されました。\n" + fromNum + "から" + toNum + "の範囲の整数値を入力してください。\n");
			}
			// 範囲外の値が入力されたらループ
		} while (checkedNum < fromNum || toNum < checkedNum);

		// チェßック後に値を返却
		return checkedNum;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 人間クラスのインスタンスを生成するメソッド
	 *
	 * @param noName 匿名にするかしないかを示す整数（匿名 ...１　名前をつける ・・・1以外）
	 *
	 * @return 
	 * human 生成したインスタンス
	 *
	 * @note 
	 * 
	 */
	/* ====================================================================== */
	
	static Human createHuman(int noName) throws IOException{
		final int YES = 1; //匿名にするコンストラクタを呼ぶための定数
		final int MORE = 1; //「〜以上」を表す定数
		final int START_ONE = 1; //「１〜」の範囲を入力させたい時に利用する定数
		final int START_ZERO = 0; //「0〜」の範囲を入力させたい時に利用する定数
		final double START_ZERO_DB = 0.0; //「0〜」の範囲を入力させたい時に利用する定数
		final int MAX_DOMINO = 9999; //入力できる最大の西暦
		final int MAX_MONTH = 12; //入力できる最大の月
		final int MAX_DATE = 31; //入力できる最大の日付
		final String INS_NAME = "人間を作成します。名前を入力してください＞"; //名前を入力する際に出力する定数
		final String MAKE_NONAME = "匿名で人間を作成します。"; //匿名で人間を作成する際のメッセージ
		final String INS_AGE = "年齢を入力してください＞"; //年齢を入力する際に出力する定数
		final String INS_HEIGHT = "身長を入力してください＞"; //身長を入力する際に出力する定数
		final String INS_WEIGHT = "体重を入力してください＞"; //体重を入力する際に出力する定数
		final String INS_DOMINO = "誕生日(西暦)を入力＞";		//誕生日(西暦)を入力する際に出力する定数
		final String INS_MONTH = "誕生日(月)を入力＞";		//誕生日(月)を入力する際に出力する定数
		final String INS_DATE = "誕生日(日)を入力＞";		//誕生日(日)を入力する際に出力する定数
		String humanName = null; //名前
		
		//標準入力（ScannerクラスのnextLineメソッドでは入力情報が残ってしまうため）
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//引数が１なら名無しでインスタンス生成
		if(YES == noName){
			System.out.print(MAKE_NONAME);
			//human　をインスタンス化
			Human human = new Human(
					//年齢を入力(０歳以上)
					moreOrLessCheck(START_ZERO, MORE, INS_AGE),
					//誕生日を入力
					new Day(inputRangeCheck(START_ONE, MAX_DOMINO, INS_DOMINO) , inputRangeCheck(START_ONE, MAX_MONTH, INS_MONTH) , inputRangeCheck(START_ONE, MAX_DATE, INS_DATE)),
					//身長を入力
					moreOrLessCheck(START_ZERO_DB, MORE, INS_HEIGHT),
					//体重を入力
					moreOrLessCheck(START_ZERO_DB, MORE, INS_WEIGHT)
					);
			
			//作成した、名無しの人間インスタンスを返却
			return human;
		//引数が１以外なら名前を入力したインスタンスを生成する
		} else {
			System.out.print(INS_NAME);
			//名前を入力
			humanName = br.readLine();
			//human　をインスタンス化
			Human human = new Human(
					//名前
					humanName,
					//年齢を入力(０歳以上)
					moreOrLessCheck(START_ZERO, MORE, INS_AGE),
					//誕生日を入力
					new Day(inputRangeCheck(START_ONE, MAX_DOMINO, INS_DOMINO) , inputRangeCheck(START_ONE, MAX_MONTH, INS_MONTH) , inputRangeCheck(START_ONE, MAX_DATE, INS_DATE)),
					//身長を入力
					moreOrLessCheck(START_ZERO_DB, MORE, INS_HEIGHT),
					//体重を入力
					moreOrLessCheck(START_ZERO_DB, MORE, INS_WEIGHT)
					);
			
			//作成した、名前ありの人間インスタンスを返却
			return human;
		}
	}
}
