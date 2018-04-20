package java07;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 整数を右にnビット回転した値を返すメソッドと、
 * 左にnビット回転した値を返すメソッドを作成せよ。
 *
 */

public class E07_12 {
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);	
	
	// 引数の値のbit 構成をそのまんま表示するメソッド
	static void printBits(int iBits){
		//３２ビットを１ビットずつ出力していく
		for(int i = 31 ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」を出力
			System.out.print((iBits >>> i & 1) == 1 ? '1' : '0');
		}
		//改行する
		System.out.println("");
	}
	
	// 引数の値のbit 構成を引数iRotate分右ビット回転して返却するメソッド
	static StringBuilder rRotateBits(int iBits , int iRotate){
		
		//回転後のビット構成を格納する
		StringBuilder sbBit = new StringBuilder();
		//最下位ビットを指定分格納する
		StringBuilder sbLeastBit = new StringBuilder();
		
		System.out.println("右ビット回転前のビット構成を出力");
		//右ビット回転前のビット構成を出力
		printBits(iBits);
		
		//回転数分右ビットシフトした結果をsbBitへ格納する
		for(int i = 31 ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append(((iBits >> iRotate) >>> i & 1) == 1 ? '1' : '0');
		}
		
		//最下位から回転数分のbitを抜き出す
		for(int i = (iRotate - 1) ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を、０なら「０」をsbLeastBitへ結合
			sbLeastBit.append((iBits >>> i & 1) == 1 ? '1' : '0');
		}
		
		//抜き出した最下位ビットをiBitsのビット構成に上位から置換する
		for (int i = 0 ; i < sbLeastBit.length() ; i++){
			//順番に、抜き出した最下位ビットを最上位ビットへ置換する
			sbBit.setCharAt(i, sbLeastBit.charAt(i));
		}
		System.out.println("右ビット回転後のビット構成を返却します");
		//右ビット回転後のビット構成を返却
		return sbBit;
	}
	
	// 引数の値のbit 構成を引数iRotate分左ビット回転して返却するメソッド
	static StringBuilder lRotateBits(int iBits , int iRotate){
		
		//ビット（３２ビット）
		final int I_BITS = 31;
		//回転後のビット構成を格納する
		StringBuilder sbBit = new StringBuilder();
		//最上位ビットを指定分格納する
		StringBuilder sbMostBit = new StringBuilder();
		
		System.out.println("左ビット回転前のビット構成を出力");
		//左ビット回転前のビット構成を出力
		printBits(iBits);
		
		//回転数分左ビットシフトした結果をsbBitへ格納する
		for(int i = I_BITS ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append(((iBits << iRotate) >>> i & 1) == 1 ? '1' : '0');
		}
		
		//最上位から回転数分のbitを抜き出す
		for(int i = I_BITS ; i >= I_BITS - (iRotate - 1) ; i--){
			//読み込んだビットが１なら「１」を、０なら「０」をsbMostBitへ結合
			sbMostBit.append((iBits >>> i & 1) == 1 ? '1' : '0');
		}
		
		//抜き出した最上位ビットをiBitsのビット構成に上位から置換する
		for (int i = 0 ; i < sbMostBit.length() ; i++){
			//順番に、抜き出した最上位ビットを最下位ビットへ置換する
			sbBit.setCharAt(((sbBit.length() - 1) - (sbMostBit.length() - (i + 1))) , sbMostBit.charAt(i));
		}
		System.out.println("左ビット回転後のビット構成を返します");
		//右ビット回転後のビット構成を返却
		return sbBit;
	}

	public static void main(String[] args) {
		//入力用の変数
		int iInputNum = 0;
		//回転するビット数
		int iBitLotation = 0;
		
		try {
			System.out.print("整数を入力してください＞");
			//試算する値を入力
			iInputNum = scanner.nextInt();
			System.out.print("回転するビット数を入力してください＞");
			//回転ビット数を入力
			iBitLotation = scanner.nextInt();
			
			System.out.println("\n" + iInputNum + "を" + iBitLotation + "ビット右回転したビット構成を表示します。\n");
			//入力値を設定分右ビット回転した結果を、rRotateBitsメソッドから呼び出して出力する
			System.out.println(rRotateBits(iInputNum , iBitLotation));
			
			System.out.println("\n" + iInputNum + "を" + iBitLotation + "ビット左回転したビット構成を表示します。\n");
			//入力値を設定分右ビット回転した結果を、rRotateBitsメソッドから呼び出して出力する
			System.out.println(lRotateBits(iInputNum , iBitLotation));
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
