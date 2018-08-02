package number;
/* ====================================================================== */
/**
 * @brief 定数クラス
 *
 * @note 定数のみ持つクラス
 */
/* ====================================================================== */

public class Constants {
	//インスタンスの生成を禁止する
	private Constants(){};
	
	/* ====定数==== */
	public final static int sMORE = 1; //「〜以上」を表すクラス定数
	public final static int sLESS = 0; //「〜以下」を表すクラス定数
	public final static int sZERO = 0; //定数0
	public final static int sONE = 1; //定数1
	
	/* ====ジャンケン関連==== */
	public final static String[] sHANDS = {"グー","チョキ","パー"}; //ジャンケンの手(定数)
	public final static String sINPUT_MSG = "ジャンケンの手を入力（０・・グー/ １・・チョキ / ２・・パー ）"; //ジャンケン入力時のメッセージ
	public final static int sWIN = 2; //勝利の定数
	public final static int sLOSE = 1; //負けの定数
	public final static int sDRAW = 0; //引き分けの定数
	public final static int sJK_MIN = 0; //ジャンケンで出せる最小値
	public final static int sJK_MAX = 2; //ジャンケンで出せる最大値
	public final static int sPLAYER1ON1 = 2; //２人対戦用の定数
}
