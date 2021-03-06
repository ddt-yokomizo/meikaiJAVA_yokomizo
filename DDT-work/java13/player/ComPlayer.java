package player;

import static number.Constants.*;

public class ComPlayer extends Player {
	
	/* ====フィールド==== */
	
	//フィールドなし
	
	/* ====コンストラクタ==== */
	public ComPlayer(){
		//プレーヤ名をSet
		this("名無し");
	}
	/* ====コンストラクタ==== */
	public ComPlayer(String name){
		//プレーヤ名をSet
		super(name);
		//プレーヤ名を表示
		System.out.println("COM : " + getName());
	}
	
	/* ====================================================================== */
	/**
	 * @brief 出した手の情報を表す文字列を返却する実装メソッド
	 *
	 * @param
	 *
	 * @return 
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	@Override
	public String toString() {
		//直線に関する情報を文字列で返却
		return getName() + "の出した手(" + sHANDS[getHand()] + ")";
	}
	
	/* ====================================================================== */
	/**
	 * @brief 出す手を決定する実装メソッド
	 *
	 * @param
	 *
	 * @return 
	 *
	 * @note
	 * 出すてはランダムに決定する（０〜２）
	 */
	/* ====================================================================== */
	@Override
	public void setHand() {
		
		// 出すジャンケンの手をランダムに決定（０・・グー/ １・・チョキ / ２・・パー ）
		mHand = (int)(Math.random() * 3 ) % 3;

	}

}