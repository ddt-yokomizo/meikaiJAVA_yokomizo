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
	final String SELECT_QUANTITY = "図形をいくつ作りますか？＞"; // 図形の個数選択時のメッセージ
	final String SELECT_SHAPE_NUM = "番の図形の種類は？（1・・・点 / 2・・・水平直線 / 3・・・垂直直線 / 4・・・長方形 / 5・・・直角二等辺三角形）＞"; // 図形選択時のメッセージ
	final String SELECT_ANGLE_DIRECTION = "直角の向きは？（1・・・右上 / 2・・・左上 / 3・・・右下 / 4・・・左下）＞"; // 直角二等辺三角形の直角方向選択時のメッセージ
	final String WIDTH = "幅＞"; // 幅を入力するときのメッセージ
	final String HEIGHT = "高さ＞"; // 高さを入力するときのメッセージ
	final String LENGTH = "長さ＞"; // 長さを入力するときのメッセージ
	final String SIDES = "二等辺三角形の辺の長さ＞"; // 二等辺三角形の辺の長さを入力するときのメッセージ
	public static enum Message{
		SELECT_QUANTITY("図形をいくつ作りますか？＞"),
		
	}
}
