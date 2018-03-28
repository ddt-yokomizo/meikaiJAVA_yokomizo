package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 要素型がdouble型で、要素数が５の配列を生成し、全要素の値を表示するプログラムを作成せよ。
 *
 */

public class E06_01 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		int yousoNum = 5; //要素数を宣言（５とする）
		double[] inputList = new double[yousoNum]; //要素型がdouble型で、要素数が規定数の配列を生成
		
		try {
			//要素に値を入力するため、yousoNumの回数分ループ
			for (int i = 0; i < yousoNum ; i++){
				System.out.print((i + 1) + "番目の要素を入力　＞");
				//入力値を順番に配列に格納
				inputList[i] = scanner.nextDouble();
			}
			
			//要素を出力するため、リストの要素数分ループ
			for(int j = 0 ; j < inputList.length ; j++){
				//配列の要素を順番に出力する
				System.out.println((j + 1) + "番目の要素 : " + inputList[j]);
			}
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}

}
