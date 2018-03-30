package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * 配列の要素数と要素の値を読み込んで、各要素の値を表示するプログラムを作成せよ。
 * 表示の形式は、初期化子と同じ形式とすること。
 *
 */
public class E06_05 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		// 配列を宣言
		int[] inputList;
		// 要素数を宣言
		int yousoNum = 0;

		System.out.print("要素数を設定してください。＞");
		// 要素数を設定
		yousoNum = scanner.nextInt();
		// 設定した要素数の配列を生成
		inputList = new int[yousoNum];

		try {
			// 要素に値を順番に入力する
			for (int i = 0; i < inputList.length; i++) {
				System.out.print((i + 1) + "番目の要素は？＞");
				// 要素に値を格納
				inputList[i] = scanner.nextInt();
			}
			
			System.out.print("inputList = {");
			// 配列の要素を順番に出力する
			for (int j = 0; j < inputList.length; j++) {
				//読み込んだ要素を出力
				System.out.print(inputList[j]);

				if(j != (inputList.length - 1)){
					//要素が最後ではない時は加えて「,」を出力する
					System.out.print(',');
				}
			}
			System.out.print('}');
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
