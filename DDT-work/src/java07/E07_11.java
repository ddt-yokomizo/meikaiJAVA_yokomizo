package java07;

import java.util.Scanner;

/**
 * 
 * @author masahiro 整数を左右にシフトした値が、２のべき乗での乗算や、除算とひとしくなることを確認するプログラムを作成せよ。
 *
 */

public class E07_11 {
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);	
	
	// 引数の値のbit 構成を出力するメソッド
	static void printBits(int iBits){
		
		//２進数の構成を格納する
		StringBuilder sbBit = new StringBuilder();
		
		//３１ビット目から降順にビット構成を出力する
		for(int i = 31 ; i >= 0 ; i--){
			//読み込んだビットが１なら「１」を出力、０なら「０」をsbBitへ結合
			sbBit.append((iBits >>> i & 1) == 1 ? '1' : '0');
		}
		System.out.println("ビット構成を出力");
		//ビット構成を出力
		System.out.println(sbBit);
		System.out.println("ビット構成を10進数に変換して出力");
		//ビット構成を10進数で出力
		System.out.println(Integer.parseInt(sbBit.toString(),2));
	}

	public static void main(String[] args) {
		//入力用の変数
		int iInputNum = 0;
		//シフトするビット数
		int iBitShift = 0;
		//べき乗した値
		double dPowerNum = 0.0;
		//除算した値
		double dDivisionNum = 0.0;
		
		try {
			System.out.print("整数を入力してください＞");
			//試算する値を入力
			iInputNum = scanner.nextInt();
			System.out.print("シフトするビット数を入力してください＞");
			//シフトするビット数を入力
			iBitShift = scanner.nextInt();
			
			//入力値にビット数分２のべき乗した値を乗算した値を計算
			dPowerNum = iInputNum * Math.pow(2.0, (double)iBitShift);
			//入力値にビット数分２のべき乗した値を乗算した値を出力
			System.out.println(iInputNum + " × 2の" + iBitShift + "乗は" + dPowerNum + "です。");
			
			//入力値にビット数分２のべき乗した値を除算した値を計算
			dDivisionNum = iInputNum / Math.pow(2.0, (double)iBitShift);
			//入力値にビット数分２のべき乗した値を除算した値を出力
			System.out.println(iInputNum + " ÷ 2の" + iBitShift + "乗は" + dDivisionNum + "です。");
			
			System.out.println(iInputNum + "を" + iBitShift + "ビット左シフトした値を表示します。");
			//入力値を設定分左ビットシフトした結果を、printBitsメソッドから出力する
			printBits(iInputNum << iBitShift);
			
			System.out.println(iInputNum + "を" + iBitShift + "ビット右シフトした値を表示します。");
			//入力値を設定分右ビットシフトした結果を、printBitsメソッドから出力する
			printBits(iInputNum >> iBitShift);
		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}

}
