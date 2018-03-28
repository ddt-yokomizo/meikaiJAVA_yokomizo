package java05;

/**
 * 
 * @author masahiro 0.0から1.0まで0.001おきに、その値とその値の２乗を表示するプロジェクトを作成せよ。
 *
 */

public class E05_07 {

	public static void main(String[] args) {

		double squareNum = 0.0; // 2乗を格納する変数
		double tmpNum = 0.0; // 作業用変数

		// 0.0から1.0まで0.001おきの値を表示するため1001回ループ
		for (int i = 0; i < 1000 + 1; i++) {
			//制御用変数を１０００割ることで０．００１単位の値を生成
			tmpNum = i / 1000.0;
			//tmpNumの２乗の値を取得
			squareNum = Math.pow(tmpNum, 2);
			System.out.println(tmpNum + ":　その２乗は＞" +  squareNum);

		}

	}

}
