package player;

import static number.Constants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	protected int mHand; // ジャンケンの手(プレイヤーの出す手)
	protected String mName; // プレーヤ名

	/* ====コンストラクタ==== */
	protected Player(String name) {
		// プレーヤ名をSet
		setName(name);
	}

	/* ====================================================================== */
	/**
	 * @brief ジャンケンの手ををあらわす文字列を返却する抽象メソッド
	 *
	 * @param
	 *
	 * @return
	 *
	 * @note クラスPlayerから派生するクラスでこのメソッドの本体を実装する
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
	 * @note クラスShapeから派生するクラスでこのメソッドの本体を実装する
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
	public int getHand() {
		return mHand;
	}

	/* ====================================================================== */
	/**
	 * @brief プレーヤ名を決定するメソッド
	 *
	 * @param name
	 *            プレーヤ名
	 *
	 * @return
	 *
	 * @note
	 * 
	 * 
	 */
	/* ====================================================================== */
	public void setName(String name) {
		mName = name;
	};

	/* ====================================================================== */
	/**
	 * @brief プレーヤ名を取得するメソッド
	 *
	 * @param
	 *
	 * @return プレーヤ名
	 *
	 * @note
	 * 
	 * 
	 */
	/* ====================================================================== */
	public String getName() {
		return mName;
	}

	/* ====================================================================== */
	/**
	 * @brief ジャンケンの勝敗結果を返却するクラスメソッド
	 *
	 * @param myHand
	 *            自分の手 , enemyHand 相手の手
	 *
	 * @return 勝敗結果を表す０〜２の整数
	 *
	 * @note 引数は「０・・グー」、「１・・チョキ」、「２・・パー」を前提とする
	 * 
	 *       0・・引き分け（０） 1・・負け（１） 2・・勝ち（２）
	 * 
	 */
	/* ====================================================================== */
	public static int getResult(int myHand, int enemyHand) {
		// ジャンケンの判定結果を返却
		return (myHand - enemyHand + 3) % 3;
	}

	/* ====================================================================== */
	/**
	 * @brief
	 *
	 * @param enemyPlayer
	 *            対戦相手
	 *
	 * @return
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	public void play(Player enemyPlayer) {
		int judge; // 勝敗判定用の変数

		// setHandメソッドを呼び出して出す手を決定
		setHand();
		// 対戦相手の手を決定
		enemyPlayer.setHand();
		// toStringメソッドを呼び出して出した手の情報の出力
		System.out.println(toString());
		// toStringメソッドを呼び出して.対戦相手の出した手の情報の出力
		System.out.println(enemyPlayer.toString());

		// 勝敗を判定
		judge = (getHand() - enemyPlayer.getHand() + 3) % 3;
		// 結果が引き分けの場合
		if (judge == sDRAW) {
			System.out.println("引き分けです。");
		}

		// 結果が負けの場合
		if (judge == sLOSE) {
			System.out.println("負けです。");
		}

		// 結果が勝ちの場合
		if (judge == sWIN) {
			System.out.println("勝ちです。");
		}
	}
	
	/* ====================================================================== */
	/**
	 * @brief まだ負けていないプレイヤーのコレクションを作成する
	 *
	 * @param players　ジャンケンプレイヤーオブジェクトのコレクション , tmpWinnersHands 前回出した手のコレクション
	 * 　　　　notLosePlayers　まだ負けていないプレイヤーのコレクション , hashMap 勝ち負けの値を持ったプレイヤーのMap
	 *
	 * @return 
	 *
	 * @note
	 * 
	 * 
	 */
	/* ====================================================================== */
	private static void setNotLosePlayer(ArrayList<Player> players , ArrayList<Integer> tmpWinnersHands , ArrayList<Player> notLosePlayers ,Map<Player, Integer> hashMap){
		//tmpArrayの要素をクリア
		tmpWinnersHands.clear();
		//notLosePlayersの要素をクリア
		notLosePlayers.clear();
		
		//プレイヤーのMap値が「残留」のプレイヤを、敗退していないプレイヤーコレクションに格納
		for(int i = 0 ; i < players.size() ; i++){
			
			//プレイヤーのMap値が「残留」のキーを探索
			if(hashMap.get(players.get(i)) == RESIDUAL){
				//「残留」のプレイヤーオブジェクトを敗退していないプレイヤーコレクションへ格納
				notLosePlayers.add(players.get(i));
			}
			
		}
	}

	/* ====================================================================== */
	/**
	 * @brief 複数人のプレイヤーオブジェクトでジャンケンを実施するクラスメソッド
	 *
	 * @param players　ジャンケンプレイヤーオブジェクトのコレクション
	 *
	 * @return 
	 *
	 * @note
	 * 勝敗判定用の変数について、
	 * RESIDUAL・・・残留
	 * ELIMINATED・・・敗退
	 * として扱い、勝者が１人になるまで繰り返し処理を行う
	 * 
	 */
	/* ====================================================================== */
	public static void playOn(ArrayList<Player> players){
		
		int winner; //残留数（敗退していないプレイヤー数）
		int rematch = NO; //あいこ用の変数（0・・あいこ / 1・・・あいこではない）
		
		//初めは残留数＝プレイヤ数とする
		winner = players.size(); 
		
		//勝敗判定に利用する手変数のコレクション
		ArrayList<Integer> tmpWinnersHands = new ArrayList<Integer>();
		
		//プレイヤオブジェクトをキーとし、勝敗判定用の変数を値に持つMapを宣言
		Map<Player, Integer> hashMap = new HashMap<Player, Integer>(players.size());
		
		//敗退していないプレイヤーコレクションを宣言
		ArrayList<Player> notLosePlayers = new ArrayList<Player>();
		
		//プレイヤーのMap値に「残留」をSetする
		for(int i = 0 ; i < players.size() ; i++){
			hashMap.put(players.get(i), RESIDUAL);
		}
		
		//勝者が１人になるまで繰り返し処理を行う
		do {
			
			//setNotLosePlayerメソッドでまだ負けていないプレイヤーコレクションを作成
			setNotLosePlayer(players, tmpWinnersHands, notLosePlayers, hashMap);
			
			System.out.println("\nじゃん、けん、ぽん。\n");
			
			//あいこの判定を行う
			do {
				//再戦変数をYESにする
				rematch = YES;
				
				//tmpWinnersHandsにプレイヤーの出した手を格納
				for(int i = 0 ; i < notLosePlayers.size() ; i++){
					//敗退していないプレイヤーの手を決定
					notLosePlayers.get(i).setHand();
					
					//tmpWinnersHandsにプレイヤーの出した手を格納
					tmpWinnersHands.add(notLosePlayers.get(i).getHand());
				}
				
				//プレイヤーの出した手の情報を順番に出力
				for(int i = 0 ; i < notLosePlayers.size() ; i++){
					//敗退していないプレイヤーの手の情報を出力
					System.out.println(notLosePlayers.get(i).toString());
				}
				
				//tmpWinnersHandsに「ぐー」「ちょき」「ぱあ」が含まれている場合あいこと判定する
				if(tmpWinnersHands.contains(BATTLE_HANDS.GOO.getEnumHand()) 
						&& tmpWinnersHands.contains(BATTLE_HANDS.CHOKI.getEnumHand())
						&& tmpWinnersHands.contains(BATTLE_HANDS.PAA.getEnumHand())){
					
					//再戦変数をYESにする
					rematch = YES;
					
				}else{

					
					//残留者の全ての手が同じ場合あいことする
					for(int i = 0 ; i < tmpWinnersHands.size() ; i++){
						
						//隣の要素と異なる値の場合
						if((i + 1) != tmpWinnersHands.size()){
							if(tmpWinnersHands.get(i) != tmpWinnersHands.get(i + 1)){
								//隣どおしが異なる要素を発見した場合、処理を抜ける
								rematch = NO;
								break;
							}
						}

					}
				}
				
				//再戦変数がYESの場合あいこのメッセージを表示
				if(rematch == YES){
					System.out.println("\nあいこでしょ。\n");
					//tmpArrayの要素をクリア
					tmpWinnersHands.clear();

				}
				
				//再戦変数がYESの間は処理を繰り返す
			} while (rematch == YES);
		
			//総当たりで１対１のジャンケンを行い、勝敗を決定する。
			//あいこのパターンは前処理で潰しているため、負けたら無条件で敗退とする
			for(int i = 0 ; i < notLosePlayers.size() ; i++){
				for (int j = 0 ; j < notLosePlayers.size() ; j++){
					
					if(i != j){
						//負けたらMap値を「敗退」に更新する
						if(getResult(notLosePlayers.get(i).getHand(), notLosePlayers.get(j).getHand()) == sLOSE){
							
							//すでに負けている場合はなにもしない
							if(hashMap.get(notLosePlayers.get(i)) != ELIMINATED){
								
								//Map値を「敗退」に更新する
								hashMap.put(notLosePlayers.get(i), ELIMINATED);
								// 残留者をデクリメント
								winner--;
								
								if((i + 1) != notLosePlayers.size()){
									i++;
								}
							}
							

						}
					}
					
				}
			}
			
		} while (winner != 1);
		
		//setNotLosePlayerメソッドで残留者を更新
		setNotLosePlayer(players, tmpWinnersHands, notLosePlayers, hashMap);
		
		System.out.println("勝者は" + notLosePlayers.get(sZERO).getName());

	}
}