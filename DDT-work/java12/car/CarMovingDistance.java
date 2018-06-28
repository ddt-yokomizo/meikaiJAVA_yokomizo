package car;
/* ====================================================================== */
/**
 * @brief 拡張自動車クラス
 *
 * @note 総走行距離を表すフィールドとその値を調べるメソッドを持つ
 */
/* ====================================================================== */
public class CarMovingDistance extends Car {
	/* ====フィールド==== */
	private double mMovingDist = 0.0; //総走行距離 
	
	/* ====コンストラクタ==== */
	public CarMovingDistance(String name, int width, int height, int length, int carNumber, double fuelCapacity,
			double fuelConsumption, double fuel) {
		//スーパークラスのコンストラクタを呼び出す
		super(name, width, height, length, carNumber, fuelCapacity, fuelConsumption, fuel);
	}
	
	CarMovingDistance(String name, int width, int height, int length, int carNumber, double fuelCapacity,
			double fuelConsumption, double fuel, long movingDist) {
		//スーパークラスのコンストラクタを呼び出す
		super(name, width, height, length, carNumber, fuelCapacity, fuelConsumption, fuel);
		//総移動距離を更新
		mMovingDist = movingDist;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 車を移動して総移動距離を更新するメソッド
	 *
	 * @param dx X軸移動距離 dy Y軸移動距離
	 *
	 * @return false 移動不可能な場合 true 移動可能な場合
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public boolean movingDist(double dx, double dy) {
		//スーパークラスの移動メソッドで移動可能かを判定
		//移動可能な時処理する
		if(super.move(dx, dy)){
			//総移動距離を加算
			mMovingDist += Math.sqrt(Math.pow(dx, 2.0) + Math.pow(dy, 2.0));
			//trueを返却
			return true;
		} else {
			//移動できなかったらfalseを返却
			return false;
		}
	}
	
	/* ====================================================================== */
	/**
	 * @brief 走行移動距離を取得するメソッド
	 *
	 * @param 
	 *
	 * @return 総走行距離
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public double getMovingDist() {
		//総移動距離を返却
		return mMovingDist;
	}
}
