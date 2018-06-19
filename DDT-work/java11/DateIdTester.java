import java.util.ArrayList;
import java.util.Scanner;
import id.DateId;


/* ====================================================================== */
/**
 * @brief 
 * DateIdTesterクラス
 *
 * @note
 * 演習11-1
 */
/* ====================================================================== */
public class DateIdTester {
	final static int sMORE = 1; //「〜以上」を表すクラス定数
	final static int sLESS = 0; //「〜以下」を表すクラス定数
	
	//標準入力
	static Scanner sScanner = new Scanner(System.in);

	/* ====================================================================== */
	/**
	 * @brief メインメソッド
	 *
	 * @param なし
	 *
	 * @return なし
	 *
	 * @note
	 */
	/* ====================================================================== */
	public static void main(String[] args){
		try {
			//DateIdリストを宣言
			ArrayList<DateId> DateIdrray = new ArrayList<DateId>();
			
			//DateIdインスタンスを５つnewする
			DateIdrray.add(new DateId());
			DateIdrray.add(new DateId());
			DateIdrray.add(new DateId());
			DateIdrray.add(new DateId());
			DateIdrray.add(new DateId());
			
			for (int i = 0 ; i < DateIdrray.size() ; i++){
				//識別番号を出力
				System.out.println((i + 1) + "番目のインスタンスの識別番号は" + DateIdrray.get(i).getId());
			}

		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}
}