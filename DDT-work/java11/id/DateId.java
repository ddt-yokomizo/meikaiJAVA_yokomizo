package id;
/**
 * List10-12(p356）のクラスDateIdをパッケージidに帰属させるように書き換えよ。
 * なお、クラスDateIdTesterは無名パッケージに所属させること
 * 
 * 
 */

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
/* ====================================================================== */
/**
 * @brief 
 * DateIdクラス
 *
 * @note
 * 演習11-1
 */
/* ====================================================================== */
public class DateId {
	//フォーマットパターンを指定
	static DateTimeFormatter sFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
	
	/* ====フィールド==== */
	private static int sCounter = 0; //何番までの識別番号を与えたか
	private int mId; //識別番号
	
	/* ====クラス初期化ブロック==== */
	static{
		//Time APIから東京のタイムゾーンの現在日を取得
		final LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Tokyo"));
		
		int year = localDate.getYear(); //年
		int month = localDate.getMonthValue(); //月
		int date = localDate.getDayOfMonth(); //日
		
		//現在日を文字列にフォーマット
		String formatDate = localDate.format(sFormatter);
		
		System.out.println("今日の日付は" + formatDate + "です。");
		
		//与える識別番号を現在日準拠にする
		sCounter = year * 1000000 + month * 10000 + date * 100;
		
	}
	
	/* ====コンストラクタ==== */
	public DateId(){
		//識別番号を加算
		mId = ++sCounter;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 識別番号を返却するメソッド
	 *
	 * @param 
	 *
	 * @return 
	 * 識別番号
	 *
	 * @note
	 * 
	 * 
	 */
	/* ====================================================================== */
	public int getId() {
		//識別番号返却
		return mId;
	}
}