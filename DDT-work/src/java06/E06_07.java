package java06;

import java.util.Scanner;

/**
 * 
 * @author masahiro 配列の要素の中に、指定したキーが含まれているかを探索するプログラムを作成せよ。
 *         また、キー値と同じ要素が複数存在しているとき、 もっとも末尾側に位置する要素を特定すること。
 *
 */

public class E06_07 {

	public static void main(String[] args) {

		// 配列を宣言
		int[] inputList;
		// 要素数を宣言
		int yousoNum = 0;
		// 乱数の範囲を宣言(100とする）
		final int RANDOM_RANGE = 100;
		// 探索キーを宣言
		int searchKey = 0;
		// 探索する要素の位置を宣言
		int searchPoint = 0;

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("要素数を設定してください。＞");
			// 要素数を設定
			yousoNum = scanner.nextInt();
			// 設定した要素数の配列を生成
			inputList = new int[yousoNum];

			System.out.print("探索キーを設定してください。（1~100の整数）＞");
			// 探索キーを設定
			searchKey = scanner.nextInt();

			// 配列に順番に１〜１００の乱数を格納する
			for (int i = 0; i < inputList.length; i++) {
				// 要素に１〜１００の乱数を格納（定数を利用）
				inputList[i] = (int) (Math.random() * RANDOM_RANGE) + 1;
			}
			// 配列の要素を全てチェックし、キーと一致する要素の位置を探索する。
			for (int j = 0; j < inputList.length; j++) {
				if (inputList[j] == searchKey) {
					// 要素の値が探索キーと一致していたら、searchPointを該当した要素のインデックスへ更新する。
					// ※配列の要素を全てチェックするため、最後に一致するインデックスが、「探索キーと一致した末尾の要素位置」となる
					searchPoint = j;
				}
			}
			
			// 結果を出力する。（一致する要素が見つかった場合・見つからなかった場合）
			if (searchPoint == 0) {
				//searchPointが「０」のときは、一致する要素が見つからなかった（１〜１００の乱数を格納しており、０は要素に格納されないため）
				System.out.println("残念なことに、探索キーと一致した要素は見つかりませんでした。");
			} else {
				//searchPointが「０」でなければ探索は成功したので、インデックスを表示する。
				System.out.println("探索キーと一致した、もっとも末尾の要素は、inputList[" + searchPoint + "] でした。");
			}
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
