package stringBuild;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;

/**
 * 
 * @author masahiro
 * コマンドライン引数で指定された月のカレンダーを表示するプログラムを作成せよ。
 * 要件
 * 年のみが与えられた場合はその年の1月から12月までのカレンダーを表示
 * 年と月が与えられた場合は、その月のカレンダーを表示
 * 年も月も与えたれなかった場合は現在の月のカレンダーを表示
 *
 */

public class E15_08{
	
	//Time APIから東京のタイムゾーンの現在日を取得
	static final LocalDate sLOCAL_DATE = LocalDate.now(ZoneId.of("Asia/Tokyo"));
	
	/* ====フィールド==== */
	private int mYear = 1; //年
	private int mMonth = 1; //月	
	
	/* ====コンストラクタ==== */
	public E15_08(){
		//年を更新(現在日)
		mYear = sLOCAL_DATE.getYear();
		//月を更新(現在日)
		mMonth = sLOCAL_DATE.getMonthValue();

	}
	
	public E15_08(int year){
		//年を更新
		mYear = year;

	}
	
	public E15_08(int year , int month){
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
	
	public static void main(String[] args) {
		
		int calenderType; //カレンダーの表示方法を決定する変数
		int tmpYear; //表示する年
		int tmpMonth; //表示する月
		final int NON = 0; //引数なし
		final int YEAR_ONLY = 1; //引数　年のみ
		final int YEAR_AND_MONTH = 2; //引数　年と月
		final int FIRST_MONTH = 1; //1月
		final int LAST_MONTH = 12; //12月
		
		//パラメータの数によりカレンダーの表示方法を決定
		calenderType = args.length;
		
		//引数がない場合は現在のカレンダーを表示
		if(calenderType == NON){
			
			//引数なしでe15_08オブジェクトを生成
			E15_08 e15_08 = new E15_08();
			
			//showCalenderメソッドで現在月のかれんだーを表示
			showCalender(e15_08.getYear(), e15_08.getMonth());

			//年のみが与えられた場合はその年の1月から12月までのカレンダーを表示
		}else if(calenderType == YEAR_ONLY){
			//引数の年をInteger型に変換
			tmpYear = Integer.parseInt(args[args.length - 1]);
			
			//年を引数にe15_08オブジェクトを生成
			E15_08 e15_08 = new E15_08(tmpYear);
			
			//引数の年の12ヶ月分のカレンダーを順番に出力（1月から12月まで）
			for (int month = FIRST_MONTH ; month <= LAST_MONTH ; month++){
				
				//showCalenderメソッドで引数の年のかれんだーを1月から順番に表示
				showCalender(e15_08.getYear(), month);
				
				//２回改行
				System.out.println("\n");
				
			}
			
			
			//年と月が与えられた場合は、その月のカレンダーを表示
		} else if (calenderType == YEAR_AND_MONTH) {
			
			//引数の年をInteger型に変換
			tmpYear = Integer.parseInt(args[args.length - 2]);
			
			//引数の月をInteger型に変換
			tmpMonth = Integer.parseInt(args[args.length - 1]);
			
			//年と月を引数にe15_08オブジェクトを生成
			E15_08 e15_08 = new E15_08(tmpYear , tmpMonth);
			
			//showCalenderメソッドで引数の年月のカレンダーを表示（月が１未満、１３以上の時はそれぞれ１、１２に訂正される）
			showCalender(e15_08.getYear(), e15_08.getMonth());
		} else{
			System.out.println("引数が不正です");
		}

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
	 * カレンダーを表示するクラスメソッド
	 *
	 * @param year 西暦 ,　month 月
	 *
	 * @return 
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public static void showCalender(int year , int month) {
		int endDate; //月の最終日を格納する変数
		int dayOfWeek; //曜日を示す変数  0　・・・ 日曜、1 ・・・ 月曜、2 ・・・ 火曜、3 ・・・ 水曜 ,4 ・・・ 木曜、5 ・・・ 金曜、6 ・・・ 土曜、
		final int FIRST_DAY = 1; //月の初日
		final int SATURDAY = 6; //土曜日なら改行する
		final int SUNDAY = 0; //土曜日なら改行する
		
		//月の最終日を取得
		endDate = getEndDate(year, month);
		//初日の曜日を格納
		dayOfWeek = dayOfWeek(year, month, FIRST_DAY);
		
		//表題を表示
		System.out.println("==========" + year + "年" + month + "月==========" );
		System.out.println("SUN MON TUE WED THR FRI SAT" );
		
		//日付を順番に表示
		for(int i = 0 ; i < endDate ; i++){
			//初日の曜日に合わせて表示開始する位置を決定
			if(i == 0 && dayOfWeek != 0){
				//初日が日曜でなければ空白で埋める
				for(int j = 0 ; j < dayOfWeek ; j++){
					System.out.print("    ");
				}
			}
			if (10 <= (i + 1)){
				//日付を出力
				System.out.print(" " + (i + 1) + " ");
			}else{
				//日付を出力
				System.out.print("  " + (i + 1) + " ");
			}
			
			//表示した日付が土曜日なら改行する
			if(dayOfWeek == SATURDAY){
				//曜日を日曜に変更
				dayOfWeek = SUNDAY;
				System.out.println("");
			}else {
				//曜日を進める
				dayOfWeek++;
			}
			
		}
		
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
	public static int dayOfWeek(int year , int month , int date) {
		int y = year;
		int m = month;
		if(m == 1 || m == 2){
			y--;
			m += 12;
		}
		return (y + y / 4 - y / 100 + y / 400 + (13 * m + 8) / 5 + date) % 7;
	}

}
