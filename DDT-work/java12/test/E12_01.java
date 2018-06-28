package test;

import java.util.ArrayList;
import java.util.Scanner;

import car.CarMovingDistance;


public class E12_01 {
	/* ====フィールド==== */
	final static int sMORE = 1; //「〜以上」を表すクラス定数
	final static int sLESS = 0; //「〜以下」を表すクラス定数
	
	// 標準入力ストリーム
	static Scanner sScanner = new Scanner(System.in);
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
			final double FROM_D_ZERO = 0.0; // 0以上の値（実数）を入力させるときに使う定数
			
			//自動車コレクション
			ArrayList<CarMovingDistance> carList = new ArrayList<CarMovingDistance>();
			
			//createCarメソッドから自動車を生成(今回は１台しか作らないため以降のインデックスは「０」固定)
			carList.add(createCar());
			
			//作成した自動車のスペックを表示
			carList.get(0).putSpec();
			
			//作成した自動車の現在地を表示
			carList.get(0).putPosition();
			
			//作成した自動車の現在の燃料を表示
			System.out.println("現在の燃料は" + carList.get(0).getFuel() + "Lです。");
			
			
			//車を移動する　燃料の関係で移動できる場合と移動できない場合があるため、結果を判定する（移動可能な入力を行う）
			System.out.println((carList.get(0).movingDist(getDouble("X軸の移動距離を入力＞"), getDouble("Y軸の移動距離を入力＞")) ? "移動完了。" : "移動できませんでした。"));
			
			//総走行距離を出力
			System.out.println("総走行距離は" + carList.get(0).getMovingDist() + "Kmです。");
			
			
			//0.0以上の実数を入力して燃料を補給する
			carList.get(0).setFuel(moreOrLessCheck(FROM_D_ZERO, sMORE, "燃料を何リットル補給しますか？＞"));
			
			//現在の燃料を表示
			System.out.println("現在の燃料は" + carList.get(0).getFuel() + "Lです。");
			
			//車を移動する　燃料の関係で移動できる場合と移動できない場合があるため、結果を判定する（移動可能な入力を行う）
			System.out.println((carList.get(0).movingDist(getDouble("X軸の移動距離を入力＞"), getDouble("Y軸の移動距離を入力＞")) ? "移動完了。" : "移動できませんでした。"));
			
			//作成した自動車の現在地を表示
			carList.get(0).putPosition();
			
			//総走行距離を出力
			System.out.println("総走行距離は" + carList.get(0).getMovingDist() + "Kmです。");
			
			//現在の燃料を表示
			System.out.println("現在の燃料は" + carList.get(0).getFuel() + "Lです。");
			
		} finally {
			// scannerをクローズ
			sScanner.close();
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
		inputNum = sScanner.nextInt();

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
		inputNum = sScanner.nextDouble();

		// 入力した整数値を返却する
		return inputNum;
	}
	/* ====================================================================== */
	/**
	 * @brief 
	 * double型の引数を２つ受け取り、 その間の実数値が入力されるまでチェックするメソッド
	 *
	 * @param 
	 * double fromNum 値(from) 
	 * double toNum 値(to) 
	 * String outputMsg 入力前に出力するメッセージ
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
			// inputNumメソッドからチェックする値を入力（引数outputMsgの文字列を渡す）
			checkedNum = inputNum(outputMsg);
			// 要素数の範囲外の値が入力された時にメッセージを出力
			if (checkedNum < fromNum || toNum < checkedNum) {
				System.out.println("範囲外の数値が入力されました。\n" + fromNum + "から" + toNum + "の範囲の実数値を入力してください。\n");
			}
			// 範囲外の値が入力されたらループ
		} while (checkedNum < fromNum || toNum < checkedNum);

		// チェック後に値を返却
		return checkedNum;
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
		if (moreOrLess == sLESS) {
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
		} else if (moreOrLess == sMORE) {
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
		if (moreOrLess == sLESS) {
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
		} else if (moreOrLess == sMORE) {
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
	 * 自動車クラスのインスタンスを生成するメソッド
	 *
	 * @param 
	 *
	 * @return 
	 * car 生成したインスタンス
	 *
	 * @note 
	 * moreOrLessの値によって、「基準値以上の値」を入力させるか 「基準値以下の値」を入力させるか、判定する
	 *  0 ・・・・ 以下 /  1 ・・・・ 以上
	 */
	/* ====================================================================== */
	
	static CarMovingDistance createCar(){
		final int FROM_ZERO = 0; // 0以上の値を入力させるときに使う定数
		final double FROM_D_ZERO = 0.0; // 0以上の値（実数）を入力させるときに使う定数
		final String INS_NAME = "車を作成します。名前を入力してください＞"; // 自動車の名前を入力する際に出力する定数
		final String INS_WIDTH = "自動車の幅を入力してください＞"; // 口座番号を入力する際に出力する定数
		final String INS_HEIGHT = "自動車の高さを入力してください＞"; // 自動車の高さを入力する際に出力する定数
		final String INS_LENGTH = "自動車の長さを入力してください＞"; // 自動車の長さを入力する際に出力する定数
		final String INS_CARNUMBER= "自動車のナンバーを入力してください＞"; // 自動車のナンバーを入力する際に出力する定数
		final String INS_CAPA = "燃料の容量を入力＞"; // 燃料の容量を入力する際に出力する定数
		final String INS_CONSUM = "燃費（Lあたり）を入力＞"; // 口燃費（Lあたり）を入力する際に出力する定数
		final String INS_FUEL = "初期燃料を入力＞"; // 初期燃料を入力する際に出力する定数
		String carName = null; // 自動車の名前
		int width; // 自動車の幅
		int height; // 自動車の高さ
		int length; // 自動車の長さ
		int carNumber; // 自動車のナンバー
		double fuelCapacity; // 燃料の容量
		double fuelConsumption; // 燃費
		double fuel; // 初期燃料
		
		System.out.print(INS_NAME);
		//自動車の名前を入力
		carName = sScanner.nextLine();
		//幅を入力
		width = moreOrLessCheck(FROM_ZERO, sMORE, INS_WIDTH);
		//高を入力
		height = moreOrLessCheck(FROM_ZERO, sMORE, INS_HEIGHT);
		//長さを入力
		length = moreOrLessCheck(FROM_ZERO, sMORE, INS_LENGTH);
		//自動車ナンバーを入力
		carNumber = moreOrLessCheck(FROM_ZERO, sMORE, INS_CARNUMBER);
		//燃料の容量を入力
		fuelCapacity = moreOrLessCheck(FROM_D_ZERO, sMORE, INS_CAPA);
		//燃費を入力
		fuelConsumption = moreOrLessCheck(FROM_D_ZERO, sMORE, INS_CONSUM);
		//初期燃料を入力
		fuel = inputRangeCheck(FROM_D_ZERO, fuelCapacity, INS_FUEL);
		
		//car　をインスタンス化
		CarMovingDistance car = new CarMovingDistance(
				carName,width,height,length,carNumber,fuelCapacity,fuelConsumption,fuel
				);
		//作成したインスタンスを返却
		return car;
	}
}