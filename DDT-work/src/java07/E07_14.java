package java07;

/**
 * 
 * @author masahiro
 * 入力した整数の指定のビット（最下位から０、１、２・・・）から指定数の連続したビットを
 * ・１に置換した値を返却するメソッド、
 * ・０に置換した値を返却するメソッド、
 * ・ビット構成を反転した値を返却するメソッド
 * を作成せよ。
 *
 */

import java.util.Scanner;

public class E07_14 {
	//入力用の変数
	static int iInputNum = 0;
	//指定するビット（最下位から、０、１、２・・・とする）
	static int iBitSelect = 0;
	//指定するビット距離
	static int iBitDistance = 0;
	//ビット（３２ビット）
	static final int I_BITS_32 = 31;
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);
	
	/* ====================================================================== */
	/**
	 * @brief  整数を入力するメソッド
	 *
	 * @param なし
	 *
	 * @return  なし
	 *
	 * @note
	 */
	/* ====================================================================== */

	static void inputNum(){
		System.out.print("整数を入力してください＞");
		//試算する値を入力
		iInputNum = scanner.nextInt();
	}
	
	/* ====================================================================== */
	/**
	 * @brief  入力値と置換するビットの指定と置換するビット数指定を同時に行うメソッド
	 *
	 * @param なし
	 *
	 * @return  なし
	 *
	 * @note
	 */
	/* ====================================================================== */
	static void inputBitsSelectAndNum(){
		//整数値を入力するメソッド
		inputNum();
		do {
			System.out.print("置換するビットの入力（最下位から、０、１、２・・・とする）＞");
			//指定ビットを入力（最下位から、０、１、２・・・とする）
			iBitSelect = scanner.nextInt();
			if(iBitSelect < 0 || I_BITS_32 < iBitSelect){
				//0~31以外の値が入力された時のメッセージ
				System.out.println("0~31ビットを指定してください。");
			}
			//0~31以外の値が入力されたらループする
		} while (iBitSelect < 0 || I_BITS_32 < iBitSelect);
		//置換するビット数を入力するメソッド
		inputDistance();
	}
	/* ====================================================================== */
	/**
	 * @brief  	置換するビット数を決定するメソッド
	 *
	 * @param なし
	 *
	 * @return  なし
	 *
	 * @note　
	 * inputBitSelectAndNumメソッドで決定した置換を開始するビットを考慮して、
	 * 31ビットを超えないように入力させる(指定ビットは０〜３１とする）
	 */
	/* ====================================================================== */
	static void inputDistance(){
		do {
			System.out.print("連続して置換するビット数を入力してください（０以上、３２ビットの範囲を超えないように入力する）＞");
			//置換するビット数を入力
			iBitDistance = scanner.nextInt();
			if(iBitSelect < 0 || (I_BITS_32 - iBitSelect) < iBitDistance){
				//0~31以外の値が入力された時のメッセージ
				System.out.println("容量が" + (I_BITS_32 + 1) + "ビットなので、開始位置が" + iBitSelect + "ビットの場合、" + (I_BITS_32 - iBitSelect) + "ビットまでしか指定できません。");
			}
			//0~31以外の値が入力されたらループする
		} while (iBitSelect < 0 || (I_BITS_32 - iBitSelect) < iBitDistance);
	}
	
	/* ====================================================================== */
	/**
	 * @brief  	引数のbit構成をそのまんま表示するメソッド
	 *
	 * @param なし
	 *
	 * @return  なし
	 *
	 * @note　
	 */
	/* ====================================================================== */
	static void printBits(int iBits){
		//３２ビットを１ビットずつ出力していく
		for(int i = I_BITS_32 ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」を出力
			System.out.print((iBits >>> i & 1) == 1 ? '1' : '0');
		}
		//改行する
		System.out.println("");
	}

	/* ====================================================================== */
	/**
	 * @brief  	
	 * 引数iBitsのbit構成の、引数iSelectedに位置するビットから、
	 * 引数iDistance個のビット構成を１にして返却するメソッド
	 *
	 * @param 
	 * int iBits 処理する整数,
	 * int iSelected 置換ビット開始位置(０〜３１),
	 * int iDistance 置換ビット数（31 - iSelected）
	 * 
	 *
	 * @return 
	 * StringBuilder sbBit 指定範囲のビット構成を１に変換したビット構成を返却する
	 *
	 * @note　
	 */
	/* ====================================================================== */
	static StringBuilder setOneToBits(int iBits , int iSelected , int iDistance){
		
		//置換後のビット構成を格納する変数
		StringBuilder sbBit = new StringBuilder();
		
		System.out.println("置換前のビット構成を出力");
		//置換前のビット構成を出力
		printBits(iBits);
		
		//引数iBitsのビット構成をsbBitへ格納する
		for(int i = I_BITS_32 ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append((iBits >>> i & 1) == 1 ? '1' : '0');
		}
		
		//sbBitの指定範囲のビット構成を順番に１に置換する
		for(int i = (sbBit.length() - 1) - iSelected ; i >= (sbBit.length() - 1) - (iDistance + iSelected) ; i--){
			//開始位置から指定ビットを順番に１に置換する
			sbBit.setCharAt(i , '1');
		}

		System.out.println("置換後のビット構成を返却します");
		//置換後のビット構成を返却
		return sbBit;
	}
	
	/* ====================================================================== */
	/**
	 * @brief  	
	 * 引数iBitsのbit構成の、引数iSelectedに位置するビットから、
	 * 引数iDistance個のビット構成を0にして返却するメソッド
	 *
	 * @param 
	 * int iBits 処理する整数,
	 * int iSelected 置換ビット開始位置(０〜３１),
	 * int iDistance 置換ビット数（31 - iSelected）
	 * 
	 *
	 * @return 
	 * StringBuilder sbBit 
	 * 指定範囲のビット構成を0に変換したビット構成を返却する
	 *
	 * @note　
	 */
	/* ====================================================================== */
	static StringBuilder setZeroToBits(int iBits , int iSelected , int iDistance){
		
		//置換後のビット構成を格納する変数
		StringBuilder sbBit = new StringBuilder();
		
		System.out.println("置換前のビット構成を出力");
		//置換前のビット構成を出力
		printBits(iBits);
		
		//引数iBitsのビット構成をsbBitへ格納する
		for(int i = I_BITS_32 ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append((iBits >>> i & 1) == 1 ? '1' : '0');
		}
		
		//sbBitの指定範囲のビット構成を順番に0に置換する
		for(int i = (sbBit.length() - 1) - iSelected ; i >= (sbBit.length() - 1) - (iDistance + iSelected) ; i--){
			//開始位置から指定ビットを順番に0に置換する
			sbBit.setCharAt(i , '0');
		}

		System.out.println("置換後のビット構成を返却します");
		//置換後のビット構成を返却
		return sbBit;
	}
	
	/* ====================================================================== */
	/**
	 * @brief  	
	 * 引数iBitsのビット構成を指定範囲だけ反転して返却するメソッド
	 *
	 * @param 
	 * int iBits 処理する整数,
	 * int iSelected 置換ビット開始位置(０〜３１),
	 * int iDistance 置換ビット数（31 - iSelected）
	 * 
	 *
	 * @return 
	 * StringBuilder sbBit 
	 * 指定範囲のビット構成を反転したビット構成を返却する
	 *
	 * @note　
	 */
	/* ====================================================================== */
	static StringBuilder reverseBits(int iBits , int iSelected , int iDistance){
		
		//反転後のビット構成を格納する変数
		StringBuilder sbBit = new StringBuilder();
		
		System.out.println("反転前のビット構成を出力");
		//置換前のビット構成を出力
		printBits(iBits);
		
		//一旦引数iBitsのビット構成をそのままsbBitへ格納する
		for(int i = I_BITS_32 ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append((iBits >>> i & 1) == 1 ? '1' : '0');
		}
		
		//sbBitのビット構成を指定範囲だけ反転する
		for(int i = (sbBit.length() - 1) - iSelected ; i >= (sbBit.length() - 1) - (iDistance + iSelected) ; i--){
			//読み込んだビットが１なら「０」を、０なら「１」へビットを反転する
			sbBit.setCharAt(i, sbBit.charAt(i) == '1' ? '0' : '1');
		}
		System.out.println("反転後のビット構成を返却します");
		//反転後のビット構成を返却
		return sbBit;
	}

	public static void main(String[] args) {
		try {
			System.out.println("\n入力した整数値の最下位から指定したビットを 1 に変換します。(最下位を０とする）\n");
			//整数値の入力と、置換ビット位置と置換するビット数の指定を行うメソッドを呼び出す
			inputBitsSelectAndNum();
			
			System.out.println("\n" + iInputNum + "の、最下位" + iBitSelect + "ビットと、連続する" + iBitDistance + "ビットを１に置換したビット構成を表示します。\n");
			//指定ビットを１に変換したビット構成を、setOneToBitメソッドから呼び出して出力する
			System.out.println(setOneToBits(iInputNum , iBitSelect , iBitDistance));
			
			System.out.println("\n入力した整数値の最下位から指定ビットを 0 に変換します。(最下位を０とする）\n");
			//整数値の入力と、置換ビット位置指定を行うメソッドを呼び出す
			inputBitsSelectAndNum();
			
			System.out.println("\n" + iInputNum + "の、最下位" + iBitSelect + "ビットと、連続する" + iBitDistance + "ビットを0に置換したビット構成を表示します。\n");
			//指定ビットを0に変換したビット構成を、setZeroToBitsメソッドから呼び出して出力する
			System.out.println(setZeroToBits(iInputNum , iBitSelect , iBitDistance));
			
			System.out.println("\n入力した整数値の指定範囲のビット構成を反転します\n");
			//整数値の入力と、置換ビット位置指定を行うメソッドを呼び出す
			inputBitsSelectAndNum();
			//入力値のビット構成を、setZeroToBitsメソッドで反転して呼び出す
			System.out.println(reverseBits(iInputNum , iBitSelect , iBitDistance));
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}