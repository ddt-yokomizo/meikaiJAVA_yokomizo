package java07;

import java.util.Scanner;

/**
 * 
 * @author masahiro 3つのint型引数の最小値を求めるメソッドを作成せよ
 *
 */

public class E07_02 {
	//３つの引数から最小値を返すメソッド
	static int minReturn(int getNumA, int getNumB, int getNumC){
		//最小値を宣言
		int iMinNum = 0;
		//引数を配列へ格納
		int[] iGetNumsList = {getNumA, getNumB ,getNumC};
		
		//要素０を暫定最小値とする
		iMinNum = iGetNumsList[0];
		
		//引数の配列から最小値を求める（要素１からスタート）
		for(int i = 1; i < iGetNumsList.length ; i++){
			//読み込んだ値が暫定最小値より小さければ更新する
			if(iGetNumsList[i] < iMinNum){
				//最小値を更新
				iMinNum = iGetNumsList[i];
			}
		}
		//最小値を返却する
		return iMinNum;
	}
	
	public static void main(String[] args) {

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			//入力回数を宣言（定数３）
			final int iINPUT_TIMES = 3;
			//入力値を宣言（要素数３）
			int[] iInputNumsList = new int[3];
			
			//整数を３回入力する
			for(int i = 0 ; i < iINPUT_TIMES ; i++){
				System.out.print("整数" + (i + 1) + "を入力してください。＞");
				// 整数を入力
				iInputNumsList[i] = scanner.nextInt();
			}
			//メソッドminReturnから最小値を呼び出す
			System.out.println("最小値は" + minReturn(iInputNumsList[0], iInputNumsList[1], iInputNumsList[2]) + "です。");
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
