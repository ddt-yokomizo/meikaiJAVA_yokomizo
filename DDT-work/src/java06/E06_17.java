package java06;

/**
 * ６人の２教科（国語・数学）の点数を読み込んで、科目ごとの平均点、
 * 学生ごとの平均点を求めるプログラムを作成せよ。
 */
import java.util.Scanner;

public class E06_17 {

	public static void main(String[] args){
		
		//受講者数
		final int TRAINEE_NUM = 6;
		// 受講者数、２科目分の配列を宣言
		int[][] testReward = new int[TRAINEE_NUM][2];
		//国語の合計点
		int kokugoSum = 0;
		//国語の平均点
		double kokugoAvr = 0.0;
		//数学の合計点
		int mathSum = 0;
		//数学の平均点
		double mathAvr = 0.0;
		//個人平均点
		double[] persolAvr = new double[TRAINEE_NUM];
		//個人総合計
		int[] persolSumArray = new int[TRAINEE_NUM];

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			//６人の２教科のテスト結果を順番に入力する
			//テスト受講者６人を順番にカウント
			for(int i = 0 ; i < TRAINEE_NUM ; i++){
				//科目のカウント（２教科）
				for(int j = 0 ; j < 2 ; j++){
					System.out.print((i + 1) + "人目の" + (j == 0 ? "国語" : "数学") + "のテスト結果は？　＞");
					//順番に要素を格納
					testReward[i][j] = scanner.nextInt();
				}
			}
			
			//テスト受講者６人を順番にカウント
			for(int i = 0 ; i < 6 ; i++){
				//科目のカウント（２教科）
				for(int j = 0 ; j < 2 ; j++){
					//制御変数が０（＝国語）なら国語の総合計を計算
					if (j == 0){
						kokugoSum += testReward[i][j];
					}
					
					//制御変数が１（＝数学）なら数学の総合計を計算
					if (j == 1){
						mathSum += testReward[i][j];
					}
					//個人の総合計を計算
					persolSumArray[i] += testReward[i][j];
					//個人の平均点を計算
					persolAvr[i] = (double)persolSumArray[i] / 2;
				}
			}
			//受講人数で割って、国語の平均点を計算
			kokugoAvr = (double)kokugoSum / TRAINEE_NUM;
			
			//受講人数で割って、数学の平均点を計算
			mathAvr = (double)mathSum / TRAINEE_NUM;
			//国語の平均点を出力
			System.out.println("国語の平均点 :" + kokugoAvr);
			//数学の平均点を出力
			System.out.println("数学の平均点 :" + mathAvr);
			
			//受講者全員の平均点を表示
			for (int i = 0 ; i < TRAINEE_NUM ; i++){
				System.out.println((i + 1) + "人目の受講者の平均点は" + persolAvr[i]);
			}
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
