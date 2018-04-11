package java07;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 受け取ったint型引数の値が負であれば−1を返却し、
 * ０であれば０を返却し、
 * 正の値であれば１を返却するメソッドsignOfを作成せよ。
 *
 */

public class E07_01 {
	//返却値
	static int iReturnNum = 0;
	
	//入力値によって返す値−１、０、１に変化するメソッド
	 static int signOf(int getNum){

		if(getNum < 0){
			//パラメータが１未満なら−１を返す
			iReturnNum = -1;
		} else if (getNum == 0){
			//パラメータが０なら０を返す
			iReturnNum = 0;
		} else if (0 < getNum){
			//パラメータが０より大きいなら１を返す
			iReturnNum = 1;
		}
		
		//返却値を返却
		return iReturnNum;
	}

	public static void main(String[] args) {

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("整数を入力してください。＞");
			// 入力値でメソッドsignOfを呼び出して表示する
			System.out.println(signOf(scanner.nextInt()));;
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
