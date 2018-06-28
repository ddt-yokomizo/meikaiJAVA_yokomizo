package car;

/* ====================================================================== */
/**
 * @brief 自動車クラス
 *
 * @note 車の名前、幅、高さ、長さ、自動車ナンバー、燃料の容量、燃費、初期燃料をコンストラクタに持つ
 */
/* ====================================================================== */
class Car {
	/* ====フィールド==== */
	private String name; // 名前
	private int width; // 幅
	private int height; // 高さ
	private int length; // 長さ
	private int carNumber; // 自動車ナンバー
	private double positionX; // X座標
	private double positionY; // Y座標
	private double fuelCapacity; // 燃料のキャパシティ
	private double fuelConsumption; // 燃費
	private double fuel; // 残り燃料

	/* ====コンストラクタ==== */
	Car(String name, int width, int height, int length, int carNumber, double fuelCapacity, double fuelConsumption,
			double fuel) {
		// 名前を代入
		this.name = name;
		// 幅を代入
		this.width = width;
		// 高さを代入
		this.height = height;
		// 長さを代入
		this.length = length;
		// 自動車ナンバーを代入
		this.carNumber = carNumber;
		// 燃料のキャパシティを代入
		this.fuelCapacity = fuelCapacity;
		// 燃費を代入
		this.fuelConsumption = fuelConsumption;
		// 燃料を代入
		this.fuel = fuel;
		// 位置・X座標を代入（初期値は０．０とする）
		this.positionX = 0.0;
		// 位置・Y座標を代入（初期値は０．０とする）
		this.positionY = 0.0;
	}

	/* ====================================================================== */
	/**
	 * @brief 現在地を表示するメソッド
	 *
	 * @param なし
	 *
	 * @return なし
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void putPosition() {
		System.out.println("現在地点を表示");
		// X座標とY座標を出力
		System.out.println("X座標：" + getXposition() + " Y座標" + getYposition());
	}

	/* ====================================================================== */
	/**
	 * @brief 車のスペックを表示するメソッド
	 *
	 * @param なし
	 *
	 * @return
	 *
	 * @note 車の名前、幅、高さ、長さ、自動車ナンバー、燃料の容量、燃費を出力
	 */
	/* ====================================================================== */
	public void putSpec() {
		// 車の名前、幅、高さ、長さ、自動車ナンバー、燃料の容量、燃費を出力
		// 名前を出力
		System.out.println("名前：" + name);
		// 幅を出力
		System.out.println("幅：" + width + "mm");
		// 高さを出力
		System.out.println("高さ：" + height + "mm");
		// 長さを出力
		System.out.println("長さ：" + length + "mm");
		// 自動車ナンバーを出力
		System.out.println("自動車ナンバー：" + carNumber);
		// 容量を出力
		System.out.println("燃料の容量：" + fuelCapacity + "L");
		// 燃費を出力
		System.out.println("燃費：" + fuelConsumption + "Km / 1L");
	}

	/* ====================================================================== */
	/**
	 * @brief X座標を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return positionX X座標
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public double getXposition() {
		// X座標を返却
		return positionX;
	}

	/* ====================================================================== */
	/**
	 * @brief Y座標を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return positionY Y座標
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public double getYposition() {
		// Y座標を返却
		return positionY;
	}

	/* ====================================================================== */
	/**
	 * @brief 残り燃料を取得するメソッド
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
		// 残り燃料を返却
		return fuel;
	}

	/* ====================================================================== */
	/**
	 * @brief 燃料を補給するメソッド
	 *
	 * @param fuel
	 *            補給する燃料
	 *
	 * @return
	 * 
	 * @note もともと入っている現在の燃料と、インスタンスのタンク容量を考慮し、 容量を超えて補給しようとした場合は満タンにする
	 * 
	 */
	/* ====================================================================== */
	public void setFuel(double fuel) {
		// 燃料容量を超えて補給しようとした場合は、オーバーロードされた引数なしのsetFuelメソッドで満タンまで補給する
		if ((fuelCapacity - this.fuel) < fuel) {
			System.out.println("現在、補給できる燃料は" + (fuelCapacity - this.fuel) + "リットルまでです。");
			// setFuelメソッドで満タンまで補給する
			setFuel();
			// 補給できる範囲を指定された場合は、指定分燃料を補給
		} else {
			System.out.println("燃料を" + fuel + "リットル補給します。");
			// 燃料を補給
			this.fuel += fuel;
		}
	}

	/* ====================================================================== */
	/**
	 * @brief 燃料を満タンに補給するメソッド
	 *
	 * @param なし
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
		// 燃料を満タンまで補充する
		fuel = fuelCapacity;
	}

	/* ====================================================================== */
	/**
	 * @brief 車を移動するメソッド
	 *
	 * @param dx
	 *            X軸移動距離 dy Y軸移動距離
	 *
	 * @return
	 * 
	 * @note 移動可能な場合は、現在位置と燃料を更新する
	 * 
	 */
	/* ====================================================================== */
	public boolean move(double dx, double dy) {
		// X軸移動距離とY軸移動距離から、自動車の移動距離を算出する
		double moveDist = Math.sqrt(Math.pow(dx, 2.0) + Math.pow(dy, 2.0));

		// 燃費を考慮し、現在の残り燃料と移動距離を計算して、移動可能か判定する
		// 移動可能な場合は現在位置と燃料を更新する。
		if (fuel <= (moveDist / fuelConsumption)) {
			System.out.println("燃料が不足しています。" + moveDist + "Km移動するには" + (moveDist / fuelConsumption) + "Lの燃料が必要です。");
			// 移動できない場合はfalseを返却
			return false;
		} else {
			// X座標を更新
			positionX += dx;
			// Y座標を更新
			positionY += dy;
			// 移動距離で消費した分燃料を減少させる
			fuel -= (moveDist / fuelConsumption);

			// 移動できる場合はtrueを返却
			return true;
		}
	}
}
