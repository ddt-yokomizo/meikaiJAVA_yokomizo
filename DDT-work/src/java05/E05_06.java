package java05;

import java.util.Scanner;

/**
 * 
 * 
 * @author masahiro float型の変数を0.0から1.0まで0.001ずつ増やしていく様子と、 int型の変数を0から1000まで
 *         インクリメントした値を1000で割った値を求める様子を横に並べて表示するプログラムを作成せよ。
 *
 */
public class E05_06 {

	public static void main(String[] args) {
		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		// float型作業用変数
		float tmpnum = 0.0F;
		// int型の作業用変数
		int tmpNum2 = 0;

		try {
			System.out.println("  float                   int  ");
			System.out.println("----------------------------------");
			// 繰り返しをfloatで制御して0.0から1.0まで0.001ずつ増やして出力する。
			for (float i = 0.0F; i < 1.0F; i += 0.001F) {
				// 繰り返しをfloatで制御した値を出力
				System.out.print(i);
				// 空白
				System.out.print("　　　　　　　　　　　　");
				// 制御変数を1000で割って、0.001ずつ計算するようにする。
				tmpnum = (float) (tmpNum2 / 1000.0);
				// 繰り返しをintで制御した値を出力
				System.out.println(tmpnum);
				// tmpNum2をインクリメント
				tmpNum2++;
			}

		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}

}
