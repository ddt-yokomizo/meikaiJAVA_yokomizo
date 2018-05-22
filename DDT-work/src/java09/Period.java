package java09;

/**
 * 
 * @author masahiro
 * 開始日と終了日から構成される、期間を表すクラスPeriodを作成せよ。
 * メソッドやコンストラクタを自由に定義する
 *
 */

public class Period {
	/* ====フィールド==== */
	private Day fromDay; //開始日
	private Day toDay; //終了日
	
	/* ====コンストラクタ==== */
	//開始日だけ持つコンストラクタ
	Period(Day fromDay){
		//開始日を代入
		this.fromDay = new Day(fromDay);
	}
	
	//開始日と終了日を持つコンストラクタ
	Period(Day fromDay , Day toDay){
		//開始日を代入
		this.fromDay = new Day(fromDay);
		//終了日を代入
		this.toDay = new Day(toDay);
	}
	/* ====================================================================== */
	/**
	 * @brief 
	 * 開始日を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * fromDay 開始日
	 *
	 * @note
	 * 開始日は変更できない
	 * 書き換え防止のため参照値ではなくコピーを返却
	 */
	/* ====================================================================== */
	public Day getFromDay() {
		//開始日を取得(書き換え防止のため参照値ではなくコピーを返却)
		return new Day(fromDay);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 終了日を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * toDay 終了日
	 *
	 * @note
	 * 終了日を変更する際はsettoDayメソッドを使ってください
	 */
	/* ====================================================================== */
	public Day getToDay() {
		//終了日を取得(書き換え防止のため参照値ではなくコピーを返却)
		return new Day(toDay);
	}
	/* ====================================================================== */
	/**
	 * @brief 
	 * 終了日をsetするメソッド
	 *
	 * @param toDay 終了日
	 *
	 * @return 
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void setToDay(Day toDay) {
		//終了日を更新
		this.toDay = toDay;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 開始日を、文字列表現にしたものを返却するメソッド
	 *
	 * @param 
	 *
	 * @return 
	 * 開始日を、文字列表現にしたもの
	 *
	 * @note
	 * ●●●●年●●月●●日(曜日)
	 * 
	 */
	/* ====================================================================== */
	public String toStringFromDay() {
		//曜日の日本語表現を格納した変数
		final String[] WD_JA = {"日","月","火","水","木","金","土"};
		
		//開始日を、文字列表現にして返却
		return String.format("%04d年%02d月%02d日(%s)",fromDay.getYear() ,fromDay.getMonth(),fromDay.getDate(),WD_JA[fromDay.dayOfWeek()]);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 終了日を、文字列表現にしたものを返却するメソッド
	 *
	 * @param 
	 *
	 * @return 
	 * 終了日を、文字列表現にしたもの
	 *
	 * @note
	 * ●●●●年●●月●●日(曜日)
	 * 
	 */
	/* ====================================================================== */
	public String toStringToDay() {
		//曜日の日本語表現を格納した変数
		final String[] WD_JA = {"日","月","火","水","木","金","土"};
		
		//終了日を、文字列表現にして返却
		return String.format("%04d年%02d月%02d日(%s)",toDay.getYear() ,toDay.getMonth(),toDay.getDate(),WD_JA[toDay.dayOfWeek()]);
	}
	
}
