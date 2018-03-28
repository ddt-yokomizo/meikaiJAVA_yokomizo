package java06;


/**
 * 
 * @author masahiro
 * 要素型がint型で、要素数が５の配列の要素に対して、先頭から順番に
 * ５．４．３．２．１を代入して表示するプログラムを作成せよ。
 *
 */

public class E06_02 {

	public static void main(String[] args) {
		int yousoNum = 5; //要素数を宣言（５とする）
		int[] inputList = new int[yousoNum]; //要素型がint型で、要素数が規定数の配列を生成
		int tmpNum = 5; //作業用変数（初期値を５とする）
		
		try {
			//要素に値を入力するため、作業用変数が１になるまで（５回）ループ
			for (int i = 0; i < yousoNum ; i++){
				System.out.println((i + 1) + "番目の要素に『" + tmpNum + "』を格納します。");
				//作業用変数を順番に配列に格納
				inputList[i] = tmpNum;
				//作業用変数をデクリメント
				tmpNum--;
			}
			
			//要素を出力するため、リストの要素数分ループ
			for(int j = 0 ; j < inputList.length ; j++){
				//配列の要素を順番に出力する
				System.out.println((j + 1) + "番目の要素 : " + inputList[j]);
			}
			
		} finally {

		}

	}

}
