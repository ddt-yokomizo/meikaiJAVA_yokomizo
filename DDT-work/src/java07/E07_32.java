package java07;
/**
 * byte型整数、
 * short型整数、
 * int型整数、
 * long型整数の
 * ビット構成を表示する、オーバーロードされたメソッド「printBits」を作成せよ。
 */

import java.util.Scanner;

public class E07_32 {
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);
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
	public static void main(String[] args) {
		try {
			System.out.println("オーバーロードされたメソッド「printBits」から入力値のビット構成を出力します");
			//オーバーロードされたメソッド「printBits」からint型整数のビット構成を出力
			printBits(inputNum("int型整数を入力＞"));
			
			System.out.print("long型整数を入力＞");
			//オーバーロードされたメソッド「printBits」からlong型整数のビット構成を出力
			printBits(scanner.nextLong());
			
			System.out.print("byte型整数を入力＞");
			//オーバーロードされたメソッド「printBits」からbyte型整数のビット構成を出力
			printBits(scanner.nextByte());
			
			System.out.print("short型整数を入力＞");
			//オーバーロードされたメソッド「printBits」からshort型整数のビット構成を出力
			printBits(scanner.nextShort());
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
	/* ====================================================================== */
	/**
	 * @brief
	 * int型整数のビット構成を出力する、オーバーロードされたメソッドprintBits
	 *
	 * @param 
	 * int inputNum int型整数
	 *
	 * @return 
	 * なし
	 * 
	 * @note
	 * オーバーロードされたメソッドprintBits
	 */
	/* ====================================================================== */
	static void printBits(int inputNum){
		
		//２進数の構成を格納する
		StringBuilder sbBit = new StringBuilder();
		
		//３１ビット目から降順にビット構成を出力する
		for(int i = 31 ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append((inputNum >>> i & 1) == 1 ? '1' : '0');
		}
		System.out.println("ビット構成を出力");
		//ビット構成を出力
		System.out.println(sbBit);
	}
	/* ====================================================================== */
	/**
	 * @brief
	 * short型整数のビット構成を出力する、オーバーロードされたメソッドprintBits
	 *
	 * @param 
	 * short inputNum short型整数
	 *
	 * @return 
	 * なし
	 * 
	 * @note
	 * オーバーロードされたメソッドprintBits
	 */
	/* ====================================================================== */
	static void printBits(short inputNum){
		
		//２進数の構成を格納する
		StringBuilder sbBit = new StringBuilder();
		
		//３１ビット目から降順にビット構成を出力する
		for(int i = 31 ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append((inputNum >>> i & 1) == 1 ? '1' : '0');
		}
		System.out.println("ビット構成を出力");
		//ビット構成を出力
		System.out.println(sbBit);
	}
	
	/* ====================================================================== */
	/**
	 * @brief
	 * byte型整数のビット構成を出力する、オーバーロードされたメソッドprintBits
	 *
	 * @param 
	 * byte inputNum byte型整数
	 *
	 * @return 
	 * なし
	 * 
	 * @note
	 * オーバーロードされたメソッドprintBits
	 */
	/* ====================================================================== */
	static void printBits(byte inputNum){
		
		//２進数の構成を格納する
		StringBuilder sbBit = new StringBuilder();
		
		//３１ビット目から降順にビット構成を出力する
		for(int i = 31 ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append((inputNum >>> i & 1) == 1 ? '1' : '0');
		}
		System.out.println("ビット構成を出力");
		//ビット構成を出力
		System.out.println(sbBit);
	}
	
	/* ====================================================================== */
	/**
	 * @brief
	 * long型整数のビット構成を出力する、オーバーロードされたメソッドprintBits
	 *
	 * @param 
	 * int inputNum long型整数
	 *
	 * @return 
	 * なし
	 * 
	 * @note
	 * オーバーロードされたメソッドprintBits
	 */
	/* ====================================================================== */
	static void printBits(long inputNum){
		
		//２進数の構成を格納する
		StringBuilder sbBit = new StringBuilder();
		
		//３１ビット目から降順にビット構成を出力する
		for(int i = 31 ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append((inputNum >>> i & 1) == 1 ? '1' : '0');
		}
		System.out.println("ビット構成を出力");
		//ビット構成を出力
		System.out.println(sbBit);
	}

	/* ====================================================================== */
	/**
	 * @brief 整数値を入力して返却するメソッド
	 *
	 * @param String outputMsg 入力前に出力するメッセージ
	 *
	 * @return int inputNum 入力した値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	static int inputNum(String outputMsg) {
		// 整数入力用の変数
		int inputNum = 0;
		// 引数の文字列をメッセージとして出力する
		System.out.print(outputMsg);
		// 試算する値を入力
		inputNum = scanner.nextInt();

		// 入力した整数値を返却する
		return inputNum;
	}
}