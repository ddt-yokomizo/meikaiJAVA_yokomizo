package java06;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author masahiro
 * ４行３列の行列と、３行４列の席を求めるプログラムを作成せよ。
 * 各要素の値はキーボードから読み込むこと
 *
 */

public class E06_16 {

	public static void main(String[] args) throws IOException {

		// ４行３列の配列を宣言
		int[][] line4x3 = new int[4][3];
		// ３行４列の配列を宣言
		int[][] line3x4 = new int[3][4];
		// 行列の積を格納する配列を宣言
		int[][] lineAnswers = new int[3][3];

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			//４行３列の配列に要素を格納する
			//行の作成（４行）
			for(int i = 0 ; i < 4 ; i++){
				//列の作成（３列）
				for(int j = 0 ; j < 3 ; j++){
					System.out.print((i + 1) + "行目" + (j + 1) + "列の要素を入力　＞");
					//順番に要素を格納
					line4x3[i][j] = scanner.nextInt();
				}
			}
			
			//3行4列の配列に要素を格納する
			//行の作成（３行）
			for(int i = 0 ; i < 3 ; i++){
				//列の作成（４列）
				for(int j = 0 ; j < 4 ; j++){
					System.out.print((i + 1) + "行目" + (j + 1) + "列の要素を入力　＞");
					//順番に要素を格納
					line3x4[i][j] = scanner.nextInt();
				}
			}
			
			//行列の積を求める
			//行のカウント（４行）
			for(int i = 0 ; i < 3 ; i++){
				//列のカウント（３列）
				for(int j = 0 ; j < 3 ; j++){
					//順番に要素を格納
					lineAnswers[i][j] = line4x3[i][j] * line3x4[i][j];
				}
			}
			
			//求めた行列の積を出力
			//行のカウント（４行）
			for(int i = 0 ; i < 4 ; i++){
				//列のカウント（３列）
				for(int j = 0 ; j < 3 ; j++){
					//行列の積を少なくとも３桁で出力する
					System.out.printf("3%d",lineAnswers[i][j]);
				}
			}			
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
