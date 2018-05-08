package java09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 演習８−１で作成した人間クラスの配列を作成するプログラムを作成せよ。
 * また、生成時に要素を格納するパターンと、生成後に要素を格納するパターンを作ること
 */

/* ====================================================================== */
/**
 * @brief 
 * 人間クラス
 *
 * @note
 * 
 */
/* ====================================================================== */
class Human {
	/* ====フィールド==== */
	private String name; // 名前
	private int age; //年齢
	private double height; //身長
	private double weight; //体重
	
	/* ====コンストラクタ==== */
	Human(String name , int age , double height , double weight){
		//名前を代入
		this.name = name;
		//年齢を代入
		this.age = age;
		//身長を代入
		this.height = height;
		//体重を代入
		this.weight = weight;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 人間のスペックを出力するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 *
	 * @note
	 * 名前、年齢、身長、体重を出力
	 */
	/* ====================================================================== */
	public void putSpec() {
		//インスタンスの情報を出力
		System.out.println(
				"名前：" + name + "\n"
				+ "年齢：" + age + "歳\n"
				+ "身長：" + height + "cm\n"
				+ "体重：" + weight + "Kg\n");
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 名前を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * name 名前
	 *
	 * @note
	 */
	/* ====================================================================== */
	public String getName() {
		//名前を取得
		return name;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 名前をSetするメソッド
	 *
	 * @param 
	 * name 名前
	 *
	 * @return なし
	 *
	 * @note
	 */
	/* ====================================================================== */
	public void setName(String name) {
		//名前をSet
		this.name = name;
	}
	/* ====================================================================== */
	/**
	 * @brief 
	 * 年齢を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * age 年齢
	 *
	 * @note
	 */
	/* ====================================================================== */

	public int getAge() {
		//年齢を返却
		return age;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 年齢をsetするメソッド
	 *
	 * @param 
	 * age　年齢
	 *
	 * @return なし
	 *
	 * @note
	 */
	/* ====================================================================== */

	public void setAge(int age) {
		//年齢に値を代入
		this.age = age;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 身長を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * height　身長
	 *
	 * @note
	 */
	/* ====================================================================== */

	public double getHeight() {
		//身長を返却
		return height;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 身長をSetするメソッド
	 *
	 * @param 
	 * height　身長
	 *
	 * @return なし
	 *
	 * @note
	 */
	/* ====================================================================== */

	public void setHeight(double height) {
		//身長に値を代入
		this.height = height;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 体重を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * weight 体重
	 *
	 * @note
	 */
	/* ====================================================================== */

	public double getWeight() {
		return weight;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 体重をSetするメソッド
	 *
	 * @param 
	 * weight　体重
	 *
	 * @return なし
	 *
	 * @note
	 */
	/* ====================================================================== */

	public void setWeight(double weight) {
		this.weight = weight;
	}
		
}
/* ====================================================================== */
/**
 * @brief 
 * 演習E09_01クラス
 *
 * @note
 * 
 */
/* ====================================================================== */
public class E09_01 {
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
			//作成する人間の要素数（作業用変数）
			int arrayNum = 0;
			//人間クラスの配列　（配列生成時に要素を初期化するバージョン）※要素数は仮に３とする
			Human[] humanArray1 = {createHuman() , createHuman() , createHuman()};
			//人間クラスの配列　（配列生成後、要素に値を代入するバージョン）
			Human[] humanArray2;
			
			//要素数を決定
			arrayNum = moreOrLessCheck(1, 1, "人間配列（２）の要素数を入力してください＞");
			//人間配列２の要素数を決定
			humanArray2 = new Human[arrayNum];
			
			//人間配列２の要素に順番に値を代入していく
			for(int i = 0 ; i < humanArray2.length ; i++){
				//createHumanメソッドで人間インスタンスを作成し、配列に格納
				humanArray2[i] = createHuman();
			}
			
			System.out.println("\n人間配列１のインスタンスを出力します\n");
			for(int i = 0 ; i < humanArray1.length ; i++){
				System.out.println("====" + (i + 1) + "番目の人間====");
				//putSpecメソッドで、順番にインスタンス情報を出力
				humanArray1[i].putSpec();
			}
			
			System.out.println("\n人間配列2のインスタンスを出力します\n");
			for(int i = 0 ; i < humanArray2.length ; i++){
				System.out.println("====" + (i + 1) + "番目の人間====");
				//putSpecメソッドで、順番にインスタンス情報を出力
				humanArray2[i].putSpec();
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
	 * 人間クラスのインスタンスを生成するメソッド
	 *
	 * @param 
	 *
	 * @return 
	 * human 生成したインスタンス
	 *
	 * @note 
	 * 
	 */
	/* ====================================================================== */
	
	static Human createHuman() throws IOException{
		//標準入力（ScannerクラスのnextLineメソッドでは入力情報が残ってしまうため）
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//名前
		String humanName = null;
		System.out.print("人間を作成します。名前を入力してください＞");

		//名前を入力
		humanName = br.readLine();
		//human　をインスタンス化
		Human human = new Human(
				//名前
				humanName,
				//年齢を入力
				moreOrLessCheck(0, 1, "年齢を入力"),
				//身長を入力
				moreOrLessCheck(0.0, 1, "身長を入力"),
				//体重を入力
				moreOrLessCheck(0.0, 1, "体重を入力")
				);
		//作成したインスタンスを返却
		return human;
	}
}
