package player;
import static number.Constants.*;

import java.util.EmptyStackException;

/* ====================================================================== */
/**
 * @brief ジャンケンのプレイヤーを表す抽象クラス
 *
 * @note 具体的なプレイヤークラスはここから派生する
 * @see Object
 */
/* ====================================================================== */
public abstract class Player {
	/* ====フィールド==== */
	protected int mHand; //ジャンケンの手(プレイヤーの出す手)
	
	/* ====================================================================== */
	/**
	 * @brief ジャンケンの手ををあらわす文字列を返却する抽象メソッド
	 *
	 * @param 
	 *
	 * @return 
	 *
	 * @note
	 * クラスPlayerから派生するクラスでこのメソッドの本体を実装する
	 * 
	 */
	/* ====================================================================== */
	public abstract String toString();
	
	/* ====================================================================== */
	/**
	 * @brief ジャンケンの出す手を決定する抽象メソッド
	 *
	 * @param 
	 *
	 * @return 
	 *
	 * @note
	 * クラスShapeから派生するクラスでこのメソッドの本体を実装する
	 * 
	 */
	/* ====================================================================== */
	public abstract void setHand();
	
	/* ====================================================================== */
	/**
	 * @brief ジャンケンの出す手を取得するメソッド
	 *
	 * @param 
	 *
	 * @return インスタンスのジャンケンの手
	 *
	 * @note
	 * 
	 * 
	 */
	/* ====================================================================== */
	public int getHand(){
		return mHand;
	}
	
	/* ====================================================================== */
	/**
	 * @brief ジャンケンの勝敗結果を返却するクラスメソッド
	 *
	 * @param myHand 自分の手　,　enemyHand 相手の手
	 *
	 * @return 勝敗結果を表す０〜２の整数
	 *
	 * @note
	 * 引数は「０・・グー」、「１・・チョキ」、「２・・パー」を前提とする
	 * 
	 * 0・・引き分け（０）
	 * 1・・負け（１）
	 * 2・・勝ち（２）
	 * 
	 */
	/* ====================================================================== */
	public static int getResult(int myHand , int enemyHand){
		//ジャンケンの判定結果を返却
		return (myHand - enemyHand + 3) % 3;
	}
	
	/* ====================================================================== */
	/**
	 * @brief ジャンケンの勝敗結果を返却するインスタンスメソッド
	 *
	 * @param enemyPlayer 対戦相手のプレイヤー変数
	 *
	 * @return 勝敗結果を表す０〜２の整数
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	private int getResult(Player enemyPlayer){
		int myHand;		//自分のジャンケンの手
		int enemyHand; //対戦相手のジャンケンの手
		
		//自分の手を取得
		myHand = getHand();
		//対戦相手の手を決定
		enemyPlayer.setHand();
		//対戦相手のジャンケンの手を取得
		enemyHand = enemyPlayer.getHand(); 
		
		//getResultから対戦相手との勝敗結果を取得して返却
		return getResult(myHand , enemyHand);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 *
	 * @param enemyPlayer 対戦相手
	 *
	 * @return 
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void play(Player enemyPlayer){
		int judge; //勝敗判定用の変数
		
		//setHandメソッドを呼び出して出す手を決定
		setHand();
		//対戦相手の手を決定
		enemyPlayer.setHand();
		//toStringメソッドを呼び出して出した手の情報の出力
		System.out.println(toString());
		//toStringメソッドを呼び出して.対戦相手の出した手の情報の出力
		System.out.println(enemyPlayer.toString());
		
		//getResultメソッドを呼び出して勝敗結果を取得
		//judge = getResult(enemyPlayer);
		
		judge = (getHand() - enemyPlayer.getHand() + 3) % 3;
		//結果が引き分けの場合
		if(judge == sDRAW){
			System.out.println("引き分けです。");
		}
		
		//結果が負けの場合
		if(judge == sLOSE){
			System.out.println("あなたの負けです。");
		}
		
		//結果が勝ちの場合
		if(judge == sWIN){
			System.out.println("あなたの勝ちです。");
		}
		
	}

}