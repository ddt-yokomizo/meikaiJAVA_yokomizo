package model;

/* ====================================================================== */
/**
 * @brief 拡張プレーヤーインターフェース
 *
 * @note プレーヤーインターフェースから拡張したサブインターフェース
 * スロー再生を行う。
 * 
 * @see Player
 * 
 * 
 */
/* ====================================================================== */
public interface ExPlayer extends Player {
	
	/* ====フィールド==== */
	//なし

	/* ====================================================================== */
	/**
	 * @brief スロー再生再生（Slow Play）する抽象メソッド
	 *
	 * @param
	 *
	 * @return 
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	void slowPlay();

}
