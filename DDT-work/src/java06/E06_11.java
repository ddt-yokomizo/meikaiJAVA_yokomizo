package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro 要素型がint型である配列を作成し、全要素を１〜１０の乱数で埋め尽くすプログラムを作成せよ。
 *         また、異なる要素が同じ値をもつことが無いように作成すること。（配列の個数は１０以下とする）
 * 
 *
 */
public class E06_11 {

	public static void main(String[] args) {

		// 配列を宣言
		int[] inputList;
		// 要素数を宣言
		int yousoNum = 0;
		// 乱数の範囲を宣言(10とする）
		final int RANDOM_RANGE = 10;

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			do {
				System.out.print("要素数を設定してください。(1~10の整数）＞");
				// 要素数を設定
				yousoNum = scanner.nextInt();
				// １〜１０の整数が入力されるまでループ
				if (yousoNum < 1 || 10 < yousoNum) {
					System.out.println("１〜１０の整数を入力してください。");
				}
			} while (yousoNum < 1 || 10 < yousoNum);

			// 設定した要素数の配列を生成
			inputList = new int[yousoNum];

			// 配列に順番に１〜１０の乱数を格納する
			for (int i = 0; i < inputList.length; i++) {
				// 要素に１〜１０の乱数を格納（定数を利用）
				inputList[i] = (int) (Math.random() * RANDOM_RANGE) + 1;
				//２週目のループから、要素の重複が発生していないかチェックする
				if(i != 0){
					//直近に格納した要素が、今までに格納した要素と同値でないかチェックする
					for(int j =  0 ; j < i ; j++){
						if(inputList[i] == inputList[j]){
							//直近に格納した要素が、今までに格納した要素と同値なら、
							//ループカウンタiを１つカウントダウンして要素の格納をやり直す
							i--;
						}
					}
				}
			}
			// 配列の全ての要素を出力する
			for (int j : inputList) {
				// 配列の要素を順番に出力
				System.out.println(j);
			}
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
