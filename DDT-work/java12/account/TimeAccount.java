package account;
/**
 * 定期預金つきの銀行口座クラス型変数A,Bの普通預金と定期預金残高の合計額を
 * 比較した結果を返却するメソッドを作成せよ。
 * AやBの参照先が定期預金を持たないAccount型のインスタンスであれば
 * 普通預金の金額を比較対象とすること
 * 
 * 
 */

import day.Day;

/* ====================================================================== */
/**
 * @brief 
 * 定期預金月銀行口座クラス
 *
 * @note
 * 銀行口座クラスのサブクラス
 */
/* ====================================================================== */
public class TimeAccount extends Account {

	/* ====フィールド==== */
	private long mTimeBalance = 0; // 定期預金残高
	
	/* ====コンストラクタ==== */
	//普通口座開設しない
	public TimeAccount(String acName, String acNo, Day opeingDay, int typeOfAc, long timeBalance) {
		//スーパークラスAccountのコンストラクタを呼び出す。
		super(acName, acNo, opeingDay, typeOfAc);
		//定期預金残高を更新
		mTimeBalance = timeBalance;
	}
	//普通口座開設する
	public TimeAccount(String acName , String acNo , long acBalance , Day opeingDay , int typeOfAc, long timeBalance){
		//スーパークラスAccountのコンストラクタを呼び出す。
		super(acName, acNo, acBalance , opeingDay, typeOfAc);
		//定期預金残高を更新
		mTimeBalance = timeBalance;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 定期預金残高を調べる
	 *
	 * @param 
	 *
	 * @return timeBalance 定期預金残高を取得
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public long getTimeBalance() {
		//定期預金残高を取得
		return mTimeBalance;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 定期預金残高を解約して全額を普通預金へ写す
	 *
	 * @param 
	 *
	 * @return timeBalance 定期預金残高を取得
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void cancel() {
		//定期預金残高の全額を普通預金へ写す
		deposit(mTimeBalance);
		//定期預金残高を０にする
		mTimeBalance = 0;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 銀行口座クラス型インスタンスの預金残高（定期預金含む）を比較判定するメソッド
	 *
	 * @param a 定期預金付きの銀行口座クラス型変数A , b 定期預金付きの銀行口座クラス型変数B
	 *
	 * @return aが多ければ１、等しければ０、ｂが多ければ−１を返却
	 *
	 * @note
	 * 引数が定期預金を持たないAccount型のインスタンスの場合は、普通預金の残高を比較する
	 * 
	 */
	/* ====================================================================== */
	public static int compBalance(Account a , Account b) {
		long balanceA; //銀行口座Aの残高
		long balanceB; //銀行口座Bの残高
		final int EQUAL = 0; //残高が等しいときに返却する定数
		final int A_IS_MORE = 1; //Aの残高が多いときに返却する定数
		final int B_IS_MORE = -1; //Bの残高が多いときに返却する定数
		
		//AccountAが定期預金口座を持っているか調べる
		//定期預金口座を持っている場合は定期預金残高を取得
		if(a instanceof TimeAccount){
			//Account変数をダウンキャストして定期預金残高を取得
			balanceA = ((TimeAccount) a).getTimeBalance() + a.getAcBalance();
		//定期預金口座を持っていない場合は普通預金残高を取得
		} else {
			//普通預金残高を取得
			balanceA = a.getAcBalance();
		}
		
		//AccountBが定期預金口座を持っているか調べる
		//定期預金口座を持っている場合は定期預金残高を取得
		if(b instanceof TimeAccount){
			//Account変数をダウンキャストして定期預金残高を取得
			balanceB = ((TimeAccount) b).getTimeBalance() + b.getAcBalance();
		//定期預金口座を持っていない場合は普通預金残高を取得
		} else {
			//普通預金残高を取得
			balanceB = b.getAcBalance();
		}
		
		//残高を評価する
		//残高が等しいとき
		if(balanceA == balanceB){
			//残高が等しいので０を返却
			return EQUAL;
			
			//Aの残高が多いとき
		} else if (balanceB < balanceA){
			//Aの残高が多いので１を返却
			return A_IS_MORE;
			
			//Bの残高が多いとき
		} else {
			//Bの残高が多いので１を返却
			return B_IS_MORE;
		}		
	}
}
