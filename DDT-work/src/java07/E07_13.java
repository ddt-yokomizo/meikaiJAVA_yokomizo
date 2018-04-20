package java07;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 入力した整数の指定のビット数（最下位から０、１、２・・・）を１にした値を返却するメソッド、
 * 入力した整数の指定のビット数（最下位から０、１、２・・・）を０にした値を返却するメソッド、
 * 入力した整数の指定のビット数を反転した値を返却するメソッドを作成せよ。
 *
 */

public class E07_13 {
	
	//入力用の変数
	static int iInputNum = 0;
	//指定するビット（最下位から、０、１、２・・・とする）
	static int iBitSelect = 0;
	//ビット（３２ビット）
	static final int I_BITS = 31;
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);
	
	//int型整数値の入力のみ行うメソッド
	static void inputNum(){
		System.out.print("整数を入力してください＞");
		//試算する値を入力
		iInputNum = scanner.nextInt();
	}
	
	//入力値と置換するビットの指定を同時に行うメソッド
	static void inputBitSelectAndNum(){
		//整数値を入力するメソッド
		inputNum();
		do {
			System.out.print("置換するビット数を入力してください＞");
			//指定ビット数を入力（最下位から、０、１、２・・・とする）
			iBitSelect = scanner.nextInt();
			if(iBitSelect < 0 || I_BITS < iBitSelect){
				//0~31以外の値が入力された時のメッセージ
				System.out.println("0~31ビットを指定してください。");
			}
			//0~31以外の値が入力されたらループする
		} while (iBitSelect < 0 || I_BITS < iBitSelect);
	}
	
	// 引数の値のbit 構成をそのまんま表示するメソッド
	static void printBits(int iBits){
		//３２ビットを１ビットずつ出力していく
		for(int i = I_BITS ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」を出力
			System.out.print((iBits >>> i & 1) == 1 ? '1' : '0');
		}
		//改行する
		System.out.println("");
	}
	
	// 引数iBitsのbit構成の、最下位から引数iSelectedに位置するビットを１にして返却するメソッド
	static StringBuilder setOneToBit(int iBits , int iSelected){
		
		//置換後のビット構成を格納する
		StringBuilder sbBit = new StringBuilder();
		
		System.out.println("置換前のビット構成を出力");
		//置換前のビット構成を出力
		printBits(iBits);
		
		//引数iBitsのビット構成をsbBitへ格納する
		for(int i = I_BITS ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append((iBits >>> i & 1) == 1 ? '1' : '0');
		}
		//ビット構成を格納したsbBitの、指定のビット数を１に変換する
		sbBit.setCharAt(I_BITS - iSelected , '1');
		
		System.out.println("置換後のビット構成を返却します");
		//置換後のビット構成を返却
		return sbBit;
	}
	
	// 引数iBitsのbit構成の、最下位から引数iSelectedに位置するビットを0にして返却するメソッド
	static StringBuilder setZeroToBit(int iBits , int iSelected){
		
		//置換後のビット構成を格納する
		StringBuilder sbBit = new StringBuilder();
		
		System.out.println("置換前のビット構成を出力");
		//置換前のビット構成を出力
		printBits(iBits);
		
		//引数iBitsのビット構成をsbBitへ格納する
		for(int i = I_BITS ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append((iBits >>> i & 1) == 1 ? '1' : '0');
		}
		//ビット構成を格納したsbBitの、指定のビット数を１に変換する
		sbBit.setCharAt(I_BITS - iSelected , '0');
		
		System.out.println("置換後のビット構成を返却します");
		//置換後のビット構成を返却
		return sbBit;
	}
	
	// 引数iBitsのビット構成を反転して返却するメソッド
	static StringBuilder reverseBit(int iBits){
		
		//置換後のビット構成を格納する
		StringBuilder sbBit = new StringBuilder();
		
		System.out.println("反転前のビット構成を出力");
		//置換前のビット構成を出力
		printBits(iBits);
		
		//引数iBitsのビット構成を反転してsbBitへ格納する
		for(int i = I_BITS ; i >= 0 ; i--){
			//読み込んだビットが１なら「０」を、０なら「１」をsbBitへ結合
			sbBit.append((iBits >>> i & 1) == 1 ? '0' : '1');
		}
		System.out.println("反転後のビット構成を返却します");
		//反転後のビット構成を返却
		return sbBit;
	}

	public static void main(String[] args) {
		try {
			System.out.println("\n入力した整数値の最下位から指定ビット数を 1 に変換します。(最下位を０とする）\n");
			//整数値の入力と、置換ビット位置指定を行うメソッドを呼び出す
			inputBitSelectAndNum();
			
			System.out.println("\n" + iInputNum + "の、最下位から" + iBitSelect + "ビットを１に置換したビット構成を表示します。\n");
			//指定ビットを１に変換したビット構成を、setOneToBitメソッドから呼び出して出力する
			System.out.println(setOneToBit(iInputNum , iBitSelect));
			
			System.out.println("\n入力した整数値の最下位から指定ビット数を 0 に変換します。(最下位を０とする）\n");
			//整数値の入力と、置換ビット位置指定を行うメソッドを呼び出す
			inputBitSelectAndNum();
			
			System.out.println("\n" + iInputNum + "の、最下位から" + iBitSelect + "ビットを0に置換したビット構成を表示します。\n");
			//指定ビットを１に変換したビット構成を、setZeroToBitメソッドから呼び出して出力する
			System.out.println(setZeroToBit(iInputNum , iBitSelect));
			
			System.out.println("\n入力した整数値のビット構成を反転します\n");
			//整数値の入力を行うメソッドを呼び出す
			inputNum();
			//入力値のビット構成を、setZeroToBitメソッドで反転して呼び出す
			System.out.println(reverseBit(iInputNum));
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
