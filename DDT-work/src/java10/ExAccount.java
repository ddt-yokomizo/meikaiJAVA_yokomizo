package java10;
/**
 * インスタンス初期化子を使って
 * インスタンス生成時に
 * 「明解銀行での口座開設ありがとうございます」
 * と表示するようにAccountクラスを変更すること
 */

import java10.Day;

/* ====================================================================== */
/**
 * @brief 
 * 銀行口座クラス改
 *
 * @note
 * インスタンス初期化子を使って
 * インスタンス生成時に
 * 「明解銀行での口座開設ありがとうございます」
 * と表示するように変更
 */
/* ====================================================================== */
public class ExAccount {
	
	/* ====フィールド==== */
	private String acName; // 口座名義
	private int acNo = 000000; //口座番号(6桁）
	private long acBalance = 0; //預金残高（初期値０）
	private Day opeingDay; //口座開設日
	private int typeOfAc = 0; //口座種別
	
	/* ====インスタンス初期化ブロック==== */
	{
		System.out.println("「明解銀行での口座開設ありがとうございます」");
		
	}
	
	/* ====コンストラクタ==== */
	
	//開設と同時に預金を行わないコンストラクタ
	ExAccount(String acName , int acNo , Day opeingDay , int typeOfAc){
		//口座名義を代入
		this.acName = acName;
		//口座番号(6桁）を代入
		this.acNo = acNo;
		//口座開設日を代入
		this.opeingDay = new Day(opeingDay);
		//口座種別を代入
		this.typeOfAc = typeOfAc;
	}
	
	//開設と同時に預金をするコンストラクタ
	ExAccount(String acName , int acNo , long acBalance , Day opeingDay , int typeOfAc){
		//口座名義を代入
		this.acName = acName;
		//口座番号(6桁）を代入
		this.acNo = acNo;
		//預金残高を代入
		this.acBalance = acBalance;
		//口座開設日を代入
		this.opeingDay = new Day(opeingDay);
		//口座種別を代入
		this.typeOfAc = typeOfAc;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 口座名義を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return acName 口座名義を取得
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public String getAcName() {
		//口座名義を取得
		return acName;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 口座番号を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return acNo 口座番号を取得
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public int getAcNo() {
		//口座番号を取得
		return acNo;
	}
	/* ====================================================================== */
	/**
	 * @brief 
	 * 口座種別を返却するメソッド
	 *
	 * @param
	 *
	 * @return 
	 * TYPE_AC　口座種別を返却
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public String getTypeOfAc() {
		final String[] TYPE_AC = {"普通口座" , "総合口座"};
		//口座種別を返却
		return TYPE_AC[typeOfAc];
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 口座開設日を取得するメソッド
	 *
	 * @param 
	 *
	 * @return 
	 *
	 * @note
	 * 開設日は書き換え防止のためフィールドのコピーを返却する
	 * 
	 */
	/* ====================================================================== */
	public Day getOpeningAcDay() {
		//開設日を返却
		return new Day(opeingDay);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 口座開設日を、文字列表現にしたものを返却するメソッド
	 *
	 * @param 
	 *
	 * @return 
	 * 口座開設日を、文字列表現にしたもの
	 *
	 * @note
	 * ●●●●年●●月●●日(曜日)
	 * 
	 */
	/* ====================================================================== */
	public String toString() {
		//曜日の日本語表現を格納した変数
		final String[] WD_JA = {"日","月","火","水","木","金","土"};
		
		//口座開設日、文字列表現にして返却
		return String.format("%04d年%02d月%02d日(%s)",opeingDay.getYear() ,opeingDay.getMonth(),opeingDay.getDate(),WD_JA[Day.dayOfWeek(opeingDay)]);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 預金残高を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return acBalance 預金残高を取得
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public long getAcBalance() {
		//預金残高を取得
		return acBalance;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 預金残高を下ろすメソッド
	 *
	 * @param howMuch 下ろす金額
	 *
	 * @return 
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void withDraw(long howMuch) {
		//預金残高から指定分引く
		acBalance -= howMuch;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 預金するメソッド
	 *
	 * @param howMuch 預金する金額
	 *
	 * @return 
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void deposit(long howMuch) {
		//預金残高へ指定分預ける
		acBalance += howMuch;
	}

}