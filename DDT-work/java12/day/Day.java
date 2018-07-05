package day;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/* ====================================================================== */
/**
 * @brief 
 * 日付クラス第４版
 *
 * @note
 */
/* ====================================================================== */
public class Day {
	//フォーマットパターンを指定
	static DateTimeFormatter sFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
	//Time APIから東京のタイムゾーンの現在日を取得
	static final LocalDate sLOCAL_DATE = LocalDate.now(ZoneId.of("Asia/Tokyo"));
	
	/* ====フィールド==== */
	private int mYear = 1; //年
	private int mMonth = 1; //月
	private int mDate = 1; //日付
	
	/* ====クラス初期化ブロック==== */
	static{
		//現在日を文字列にフォーマット
		String formatDate = sLOCAL_DATE.format(sFormatter);
		
		System.out.println("今日の日付は" + formatDate + "です。");
		
	}
	
	/* ====コンストラクタ==== */
	public Day(){
		//年を更新(現在日)
		mYear = sLOCAL_DATE.getYear();
		//月を更新(現在日)
		mMonth = sLOCAL_DATE.getMonthValue();
		//日を更新(現在日)
		mDate = sLOCAL_DATE.getDayOfMonth();
	}
	
	public Day(int year){
		//年を更新
		mYear = year;
	}
	
	public Day(int year , int month){
		//多重定義されたコンストラクタから年を更新
		this(year);
		
		int fixedMonth = month; //修正月(初期値を引数の月とする)
		
		//引数の月が１~12でなければ、適当な値に調整する
		//引数の月が1未満の場合
		if (fixedMonth < 1){
			//修正月を１にする
			fixedMonth = 1;
			//引数の月が12を超えている場合
		} else if (12 < fixedMonth){
			//修正月を12にする
			fixedMonth = 12;
		}
		//月を更新
		mMonth = fixedMonth;
	}
	
	public Day(int year , int month , int date){
		//多重定義されたコンストラクタから年と月を更新
		this(year , month);
		
		int fixedDate = date; //修正日付(初期値を引数の日付とする)
		int endDate; //引数の年月の最終日
		
		//getEndDateメソッドから引数の年月の最終日を取得(月は修正済)
		endDate = getEndDate(year, mMonth);
		
		//引数の日付が１~月の最終日でなければ、適当な値に調整する
		//引数の日付が1未満の場合
		if (fixedDate < 1){
			//修正日付を１にする
			fixedDate = 1;
			//引数の日付が引数の年月の最終日を超えている場合
		} else if (endDate < date){
			//修正日付を年月の最終日にする
			fixedDate = endDate;
		}
		
		//日付を更新
		mDate = fixedDate;
	}
	
	public Day(Day d){
		//多重定義されたコンストラクタから年と月と日付を更新
		this(d.mYear , d.mMonth , d.mDate);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 月の最終日を確認するクラスメソッド
	 *
	 * @param year 西暦 ,　month 月
	 *
	 * @return 月の最終日
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public static int getEndDate(int year , int month) {
		//Time APIから引数の年月の初日を取得
		LocalDate localDate = LocalDate.of(year , month , 1);
		
		//アジャスタから引数の年月の最終日を取得
		LocalDate endDate = localDate.with(TemporalAdjusters.lastDayOfMonth());
		
		//月の最終日を返却
		return endDate.getDayOfMonth();
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 閏年であるかを確認するクラスメソッド
	 *
	 * @param year 西暦
	 *
	 * @return trueかfalse
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public static boolean isLeap(int year) {
		//閏年であるかを確認して結果を返却
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 閏年であるかを確認するインスタンスメソッド
	 *
	 * @param
	 *
	 * @return trueかfalse
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public boolean isLeap() {
		//閏年であるかを確認して結果を返却
		return isLeap(mYear);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 年内の経過日数を取得するクラスメソッド
	 *
	 * @param year 年, month 月, date 日付
	 *
	 * @return 年内経過日数
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public static long getProgressDay(int year , int month , int date) {
		//引数から日付を取得
		LocalDate localDate = LocalDate.of(year , month , date);
		
		//年の元旦を取得
		LocalDate localStartDate = LocalDate.of(year , 1 , 1);
		
		//２つの日付から経過日数を取得して返却
		return ChronoUnit.DAYS.between(localStartDate, localDate);		
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 年内の経過日数を取得するインスタンスメソッド
	 *
	 * @param
	 *
	 * @return
	 * 年内の経過日数
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public long getProgressDay() {
		//年内の経過日数を取得するクラスメソッドからインスタンスの年内経過日数を取得して返却
		return getProgressDay(mYear, mMonth, mDate);		
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 年内の残日数を取得するクラスメソッド
	 *
	 * @param year 年, month 月, date 日付
	 *
	 * @return 年内残り日数
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public static int getLeftDay(int year , int month , int date) {
		
		int dateOfYear = 0; //その年の日数
		
		//引数の年の年末を取得
		LocalDate localEndDate = LocalDate.of(year , 12 , 31);
		
		//引数の年の元旦を取得
		LocalDate localStartDate = LocalDate.of(year , 1 , 1);
		
		//その年の日数を算出
		dateOfYear = (int)ChronoUnit.DAYS.between(localStartDate, localEndDate);
		
		//年の日数から経過日数を引いた値を算出して「年の残り日数」を返却
		return dateOfYear - (int)getProgressDay(year, month, date);	
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 年内の残り日数を取得するインスタンスメソッド
	 *
	 * @param
	 *
	 * @return
	 * 年内の残り日数
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public int getLeftDay() {
		//年内の残り日数を取得するクラスメソッドからインスタンスの年内残日数を取得して返却
		return getLeftDay(mYear, mMonth, mDate);		
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 他の日付との前後関係を判定するインスタンスメソッド
	 *
	 * @param Day 日付
	 *
	 * @return
	 * 
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void judgeDate(Day day) {
		//インスタンスの日付をTime型で取得
		LocalDate localDate = LocalDate.of(mYear , mMonth , mDate);
		
		//引数の日付をTime型で取得ß
		LocalDate localDate2 = LocalDate.of(day.mYear , day.mMonth , day.mDate);
		
		//インスタンスの日付と引数の日付の全後関係を判定する
		//インスタンスの日付と引数の日付が同じ日付の場合
		if (localDate.isEqual(localDate2)){
			System.out.println(changeToDay(localDate).toString() + "と" + changeToDay(localDate2).toString() + "は同じ日付です。");
		//インスタンスの日付と引数の日付より前の場合
		}else if(localDate.isBefore(localDate2)){
			System.out.println(changeToDay(localDate).toString() + "は" + changeToDay(localDate2).toString() + "より前の日付です。");
		//インスタンスの日付と引数の日付より後の場合
		}else if(localDate.isAfter(localDate2)){
			System.out.println(changeToDay(localDate).toString() + "は" + changeToDay(localDate2).toString() + "より後の日付です。");
		}
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 2つの日付の前後関係を判定するクラスメソッド
	 *
	 * @param Day1 日付1 , Day2 日付2
	 * 
	 * @return
	 * 
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public static void judgeDate(Day day1 , Day day2) {
		//引数1の日付をTime型で取得
		LocalDate localDate1 = LocalDate.of(day1.mYear , day1.mMonth , day1.mDate);
		
		//引数2の日付をTime型で取得
		LocalDate localDate2 = LocalDate.of(day2.mYear , day2.mMonth , day2.mDate);
		
		//前後関係を調べます(メッセージ)
		System.out.println(changeToDay(localDate1).toString() + "と" + changeToDay(localDate2).toString() + "の前後関係を調べます。");
		
		//引数1の日付と引数の日付の全後関係を判定する
		//引数1の日付と引数2の日付が同じ日付の場合
		if (localDate1.isEqual(localDate2)){
			System.out.println(changeToDay(localDate1).toString() + "と" + changeToDay(localDate2).toString() + "は同じ日付です。");
		//引数1の日付が引数2の日付より前の場合
		}else if(localDate1.isBefore(localDate2)){
			System.out.println(changeToDay(localDate1).toString() + "は" + changeToDay(localDate2).toString() + "より前の日付です。");
		//引数1の日付が引数2の日付より後の場合
		}else if(localDate1.isAfter(localDate2)){
			System.out.println(changeToDay(localDate1).toString() + "は" + changeToDay(localDate2).toString() + "より後の日付です。");
		}
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * Time型日付をDay型に変換して返すクラスメソッド
	 *
	 * @param localDate Time型日付
	 * 
	 * @return
	 * 変換したDay型インスタンス
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public static Day changeToDay(LocalDate localDate) {
		//Time型日付の年月日からDayインスタンスをnewして返却
		return new Day(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 日付を1日進めるインスタンスメソッド
	 *
	 * @param
	 *
	 * @return
	 * 
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void plusOneDay() {
		//インスタンスの日付をTime型で取得
		LocalDate localDate = LocalDate.of(mYear , mMonth , mDate);
		//インスタンスの日付の1日後をTime型で取得
		LocalDate result = localDate.plusDays(1);
		
		//年を更新
		mYear = result.getYear();
		
		//月を更新
		mMonth = result.getMonthValue();
		
		//日を更新
		mDate = result.getDayOfMonth();
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 日付を引数分進めるインスタンスメソッド
	 *
	 * @param days　日数
	 *
	 * @return
	 * 
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void plusSomeDays(int days) {
		//インスタンスの日付をTime型で取得
		LocalDate localDate = LocalDate.of(mYear , mMonth , mDate);
		//インスタンスの日付のn日後をTime型で取得
		LocalDate result = localDate.plusDays(days);
		
		//年を更新
		mYear = result.getYear();
		
		//月を更新
		mMonth = result.getMonthValue();
		
		//日を更新
		mDate = result.getDayOfMonth();
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 1日後の日付を返すクラスメソッド
	 *
	 * @param day　日付
	 *
	 * @return
	 * 
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public static Day plusOneDay(Day day) {
		//引数の日付をTime型で取得
		LocalDate localDate = LocalDate.of(day.mYear , day.mMonth , day.mDate);
		//インスタンスの日付の1日後をTime型で取得
		LocalDate result = localDate.plusDays(1);
		
		//1日後の日付を返却
		return new Day(result.getYear(), result.getMonthValue(), result.getDayOfMonth());
		
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 日付を1日戻すインスタンスメソッド
	 *
	 * @param
	 *
	 * @return
	 * 
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void minusOneDay() {
		//インスタンスの日付をTime型で取得
		LocalDate localDate = LocalDate.of(mYear , mMonth , mDate);
		//インスタンスの日付の1日前をTime型で取得
		LocalDate result = localDate.minusDays(1);
		
		//年を更新
		mYear = result.getYear();
		
		//月を更新
		mMonth = result.getMonthValue();
		
		//日を更新
		mDate = result.getDayOfMonth();
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 日付を引数分戻すインスタンスメソッド
	 *
	 * @param days　日数
	 *
	 * @return
	 * 
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void minusSomeDays(int days) {
		//インスタンスの日付をTime型で取得
		LocalDate localDate = LocalDate.of(mYear , mMonth , mDate);
		//インスタンスの日付のn日前をTime型で取得
		LocalDate result = localDate.minusDays(days);
		
		//年を更新
		mYear = result.getYear();
		
		//月を更新
		mMonth = result.getMonthValue();
		
		//日を更新
		mDate = result.getDayOfMonth();
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 1日後の日付を返すクラスメソッド
	 *
	 * @param day　日付
	 *
	 * @return
	 * 
	 * 
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public static Day minusOneDay(Day day) {
		//引数の日付をTime型で取得
		LocalDate localDate = LocalDate.of(day.mYear , day.mMonth , day.mDate);
		//インスタンスの日付の1日前をTime型で取得
		LocalDate result = localDate.minusDays(1);
		
		//1日前の日付を返却
		return new Day(result.getYear(), result.getMonthValue(), result.getDayOfMonth());
		
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 年を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return year 年を取得
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public int getYear() {
		//年を取得
		return mYear;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 月を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return month 月を取得
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public int getMonth() {
		//月を取得
		return mMonth;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 日付を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return date 日を取得
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public int getDate() {
		//日を取得
		return mDate;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 日付を設定するメソッド
	 *
	 * @param year 年 , month 月 , date 日
	 *
	 * @return 
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void setDay(int year , int month , int date) {
		//年をSet
		this.mYear = year;
		
		//月をSet
		this.mMonth = month;
		
		//日をSet
		this.mDate = date;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 曜日を求めるメソッド
	 *
	 * @param
	 *
	 * @return 
	 * 曜日を表す0~6のint型整数
	 *
	 * @note
	 * 当メソッドは「ツェラーの公式」をそのまま流用したものであるため、
	 * 処理内容についてコメントは省略する（テキストの指示通り）
	 * 
	 * 0 ・・・ 日曜、1 ・・・ 月曜、2 ・・・ 火曜、3 ・・・ 水曜、
	 * 4 ・・・ 木曜、5 ・・・ 金曜、6 ・・・ 土曜、
	 * 
	 */
	/* ====================================================================== */
	public static int dayOfWeek(Day day) {
		int y = day.mYear;
		int m = day.mMonth;
		if(m == 1 || m == 2){
			y--;
			m += 12;
		}
		return (y + y / 4 - y / 100 + y / 400 + (13 * m + 8) / 5 + day.mDate) % 7;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 日付が等しいかを確認するメソッド
	 *
	 * @param d 日付クラスのインスタンス
	 *
	 * @return 
	 * 等しければtrue
	 * 等しくなければfalse
	 *
	 * @note
	 * 参照先が等しくなくても値が等しければtrueを返却する
	 * 
	 */
	/* ====================================================================== */
	public boolean equalTo(Day d) {
		//年、月、日が全て等しい場合にtrueを返却、そうでなければfalseを返却
		return d.mYear == mYear && d.mMonth == mMonth && d.mDate == mDate;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 日付（曜日付き）を、文字列表現にしたものを返却するメソッド
	 *
	 * @param 
	 *
	 * @return 
	 * 日付（曜日付き）を、文字列表現にしたもの
	 *
	 * @note
	 * ●●●●年●●月●●日(曜日)
	 * 
	 */
	/* ====================================================================== */
	public String toString() {
		return toString(new Day(mYear,mMonth,mDate));
		
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 日付（曜日付き）を、文字列表現にしたものを返却するクラスメソッド
	 *
	 * @param 
	 *
	 * @return 
	 * 日付（曜日付き）を、文字列表現にしたもの
	 *
	 * @note
	 * ●●●●年●●月●●日(曜日)
	 * 
	 */
	/* ====================================================================== */
	public static String toString(Day day) {
		//曜日の日本語表現を格納した変数
		final String[] WD_JA = {"日","月","火","水","木","金","土"};
		
		//日付（曜日付き）を、文字列表現にして返却
		return String.format("%04d年%02d月%02d日(%s)", day.mYear,day.mMonth,day.mDate,WD_JA[dayOfWeek(day)]);
	}
}