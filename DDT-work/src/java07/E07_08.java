package java07;

import java.util.Scanner;

public class E07_08 {
	// 引数範囲内の乱数を返却するメソッド
	static int makeRandom(int getFrom, int getTo) {
		// 乱数を格納する変数
		int iReturnNum = 0;
		// 乱数の生成範囲
		int iRangeNum = 0;

		// 乱数の範囲を決定
		iRangeNum = (getTo - getFrom) + 1;

		// 引数getToより引数getFromが大きい場合は引数getFromを返却する
		if (iRangeNum < 0) {
			// 引数getFromを返却値とする
			iReturnNum = getFrom;
		// 引数getToより引数getFromが大きくなければ範囲内で乱数を生成する
		} else {
			// 乱数を生成
			iReturnNum = (int) (Math.random() * 1000) % iRangeNum + getFrom;
		}
		// 生成した乱数または引数getFromを返す
		return iReturnNum;
	}

	public static void main(String[] args) {

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			// From用の変数を宣言
			int iFromNum = 0;
			// To用の変数を宣言
			int iToNum = 0;

			System.out.println("設定値の範囲内で乱数を生成します。");

			System.out.print("値（From値）を設定してください＞");
			// 値（From値）を入力
			iFromNum = scanner.nextInt();

			System.out.print("値（To値）を設定してください＞");
			// 値（To値）を入力
			iToNum = scanner.nextInt();

			// 入力範囲内の乱数を返却するメソッドを呼び出して表示する
			System.out.println(makeRandom(iFromNum, iToNum));

		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}