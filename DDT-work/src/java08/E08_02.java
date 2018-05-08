package java08;
/**
 * 
 * @author 自動車クラスCarに対して、フィールドやメソッドを自由に追加せよ。
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

/* ====================================================================== */
/**
 * @brief 演習E08_02クラス
 *
 * @note
 * 
 */
/* ====================================================================== */
public class E08_02 {
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
			//自動車コレクション
			ArrayList<Car> carList = new ArrayList<Car>();
			
			//createCarメソッドから自動車を生成(今回は１台しか作らないため以降のインデックスは「０」固定)
			carList.add(createCar());
			
			//作成した自動車のスペックを表示
			carList.get(0).putSpec();
			
			//作成した自動車の現在地を表示
			carList.get(0).putPosition();
			
			//作成した自動車の現在の燃料を表示
			System.out.println("現在の燃料は" + carList.get(0).getFuel() + "Lです。");
			
			//車を移動する　燃料の関係で移動できる場合と移動できない場合があるため、結果を判定する（移動できない入力を行う）
			System.out.println((carList.get(0).move(getDouble("X軸の移動距離を入力＞"), getDouble("Y軸の移動距離を入力＞")) ? "移動完了。" : "移動できませんでした。"));
			
			//0.0以上の実数を入力して燃料を補給する
			carList.get(0).setFuel(moreOrLessCheck(0.0, 1, "燃料を何リットル補給しますか？＞"));
			
			//現在の燃料を表示
			System.out.println("現在の燃料は" + carList.get(0).getFuel() + "Lです。");
			
			//車を移動する　燃料の関係で移動できる場合と移動できない場合があるため、結果を判定する（移動可能な入力を行う）
			System.out.println((carList.get(0).move(getDouble("X軸の移動距離を入力＞"), getDouble("Y軸の移動距離を入力＞")) ? "移動完了。" : "移動できませんでした。"));
			
			//作成した自動車の現在地を表示
			carList.get(0).putPosition();
			
			//現在の燃料を表示
			System.out.println("現在の燃料は" + carList.get(0).getFuel() + "Lです。");
			
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
	
	static Car createCar(){
		//自動車の名前
		String carName = null;
		
		System.out.print("車を作成します。名前を入力してください＞");
		//自動車の名前を入力
		carName = scanner.nextLine();
		//car　をインスタンス化
		Car car = new Car(
				//自動車の名前
				carName,
				//幅を入力
				moreOrLessCheck(0, 1, "幅を入力"),
				//高さを入力
				moreOrLessCheck(0, 1, "高さを入力"),
				//長さを入力
				moreOrLessCheck(0, 1, "長さを入力"),
				//自動車ナンバーを入力
				moreOrLessCheck(0, 1, "自動車ナンバーを入力"),
				//燃料の容量を入力
				moreOrLessCheck(0.0, 1, "燃料の容量を入力"),
				//燃費を入力
				moreOrLessCheck(0.0, 1, "燃費を入力"),
				//初期燃料を入力
				moreOrLessCheck(0.0, 1, "初期燃料を入力")
				);
		//作成したインスタンスを返却
		return car;
	}
}

/* ====================================================================== */
/**
 * @brief 
 * 自動車クラス
 *
 * @note
 * 車の名前、幅、高さ、長さ、自動車ナンバー、燃料の容量、燃費、初期燃料をコンストラクタに持つ
 */
/* ====================================================================== */
class Car {
	/* ====フィールド==== */
	private String name; // 名前
	private int width; //幅
	private int height; //高さ
	private int length; //長さ
	private int carNumber; //自動車ナンバー
	private double positionX; //X座標
	private double positionY; //Y座標
	private double fuelCapacity; //燃料のキャパシティ
	private double fuelConsumption; //燃費
	private double fuel; //残り燃料
	
	/* ====コンストラクタ==== */
	Car(String name , int width , int height , int length , 
			int carNumber , double fuelCapacity , double fuelConsumption , double fuel){
		//名前を代入
		this.name = name;
		//幅を代入
		this.width = width;
		//高さを代入
		this.height = height;
		//長さを代入
		this.length = length;
		//自動車ナンバーを代入
		this.carNumber = carNumber;
		//燃料のキャパシティを代入
		this.fuelCapacity = fuelCapacity;
		//燃費を代入
		this.fuelConsumption = fuelConsumption;
		//燃料を代入
		this.fuel = fuel;
		//位置・X座標を代入（初期値は０．０とする）
		this.positionX = 0.0;
		//位置・Y座標を代入（初期値は０．０とする）
		this.positionY = 0.0;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 現在地を表示するメソッド
	 *
	 * @param なし
	 *
	 * @return なし
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void putPosition(){
		System.out.println("現在地点を表示");
		//X座標とY座標を出力
		System.out.println("X座標：" + getXposition() + " Y座標" + getYposition());
	}

/* ====================================================================== */
/**
 * @brief 
 * 車のスペックを表示するメソッド
 *
 * @param なし
 *
 * @return 
 *
 * @note
 * 車の名前、幅、高さ、長さ、自動車ナンバー、燃料の容量、燃費を出力
 */
/* ====================================================================== */
public void putSpec() {
	//車の名前、幅、高さ、長さ、自動車ナンバー、燃料の容量、燃費を出力
	//名前を出力
	System.out.println("名前：" + name);
	//幅を出力
	System.out.println("幅：" + width + "mm");
	//高さを出力
	System.out.println("高さ：" + height + "mm");
	//長さを出力
	System.out.println("長さ：" + length + "mm");
	//自動車ナンバーを出力
	System.out.println("自動車ナンバー：" + carNumber);
	//容量を出力
	System.out.println("燃料の容量：" + fuelCapacity + "L");
	//燃費を出力
	System.out.println("燃費：" + fuelConsumption + "Km / 1L");
}
/* ====================================================================== */
/**
 * @brief 
 * X座標を取得するメソッド
 *
 * @param なし
 *
 * @return 
 * positionX X座標
 *
 * @note
 * 
 */
/* ====================================================================== */
public double getXposition() {
	//X座標を返却
	return positionX;
}

/* ====================================================================== */
/**
 * @brief 
 * Y座標を取得するメソッド
 *
 * @param なし
 *
 * @return 
 * positionY Y座標
 *
 * @note
 * 
 */
/* ====================================================================== */
public double getYposition() {
	//Y座標を返却
	return positionY;
}

/* ====================================================================== */
/**
 * @brief 
 * 残り燃料を取得するメソッド
 *
 * @param なし
 *
 * @return 
 * 
 * @note
 * 
 */
/* ====================================================================== */
public double getFuel() {
	//残り燃料を返却
	return fuel;
}

/* ====================================================================== */
/**
 * @brief 
 * 燃料を補給するメソッド
 *
 * @param 
 * fuel 補給する燃料
 *
 * @return 
 * 
 * @note
 * もともと入っている現在の燃料と、インスタンスのタンク容量を考慮し、
 * 容量を超えて補給しようとした場合は満タンにする
 * 
 */
/* ====================================================================== */
public void setFuel(double fuel) {
	//燃料容量を超えて補給しようとした場合は、オーバーロードされた引数なしのsetFuelメソッドで満タンまで補給する
	if((fuelCapacity - this.fuel) < fuel){
		System.out.println("現在、補給できる燃料は" + (fuelCapacity - this.fuel) + "リットルまでです。");
		//setFuelメソッドで満タンまで補給する
		setFuel();
	//補給できる範囲を指定された場合は、指定分燃料を補給
	} else {
		System.out.println("燃料を" + fuel + "リットル補給します。");
		//燃料を補給
		this.fuel += fuel;
	}
}

/* ====================================================================== */
/**
 * @brief 
 * 燃料を満タンに補給するメソッド
 *
 * @param 
 * なし
 *
 * @return 
 * 
 * @note
 * 
 */
/* ====================================================================== */
public void setFuel() {
	System.out.println("燃料を満タンに補充します");
	System.out.println("燃料を" + (fuelCapacity - fuel) + "リットル補給します。");
	//燃料を満タンまで補充する
	fuel = fuelCapacity;
}

/* ====================================================================== */
/**
 * @brief 
 * 車を移動するメソッド
 *
 * @param 
 * dx X軸移動距離
 * dy Y軸移動距離
 *
 * @return 
 * false 移動不可能な場合
 * true 移動可能な場合
 * 
 * @note
 * 移動可能な場合は、現在位置と燃料を更新する
 * 
 */
/* ====================================================================== */
public boolean move(double dx , double dy) {
	//X軸移動距離とY軸移動距離から、自動車の移動距離を算出する
	double moveDist = Math.sqrt(Math.pow(dx, 2.0) + Math.pow(dy, 2.0));
	
	//燃費を考慮し、現在の残り燃料と移動距離を計算して、移動可能か判定する
	//移動可能な場合は現在位置と燃料を更新する。
	if (fuel <= (moveDist / fuelConsumption)){
		System.out.println("燃料が不足しています。" + moveDist + "Km移動するには" + (moveDist / fuelConsumption) + "Lの燃料が必要です。");
		//移動できない場合はfalseを返却
		return false;
	} else {
		//X座標を更新
		positionX += dx;
		//Y座標を更新
		positionY += dy;
		//移動距離で消費した分燃料を減少させる
		fuel -= (moveDist / fuelConsumption);
		
		//移動できる場合はtrueを返却
		return true;
	}
}
}
