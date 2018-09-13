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
	
	/* ====ペット関連==== */
	public final static String INPUT_PET_NAME = "ぺっとの名前は？"; //ペット名入力時のメッセージ
	public final static String INPUT_ROBOT_PET_NAME = "ロボットぺっとの名前は？"; //ペット名入力時のメッセージ
	public final static String INPUT_SUKINNABLE_ROBOT_PET_NAME = "着せ替え可能ロボットぺっとの名前は？"; //ペット名入力時のメッセージ
	public final static String MASTER_NAME = "ご主人様の名前は？"; //ご主人様の名入力時のメッセージ
	public final static String INPUT_SKIN_COLOR = "スキンカラーは？（0・・・黒 /　1・・・赤 /　2・・・緑 /　3・・・青 /　4・・・ヒョウ柄 /　）"; //スキンカラー入力時のメッセージ

	
	/* ====列挙型定数（図形タイプ）==== */
	public static enum shapeType {
		POINT, //図形（点）
		HORZ_LINE,  //図形（水平線）
		VIRT_LINE,//図形（垂直線）
		RECTANGLE, //図形（長方形）	
		ISOS_RIGHT_TRI, //図形（直角二等辺三角形）
		PARALLELOGRAM //図形（平行四辺形）
	}
}
