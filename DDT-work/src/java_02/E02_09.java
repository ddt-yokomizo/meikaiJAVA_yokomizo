package java_02;

/**
 *
 * 以下に示すプログラムを作成せよ。
 *
 * ・0.0以上1.0未満の実数値をランダムに生成して表示。
 * ・0.0以上10.0未満の実数値をランダムに生成して表示。
 * ・-1.0以上1.0未満の実数値をランダムに生成して表示。
 */

public class E02_09 {

	public static void main(String[] args) {

		// 0.0以上1.0未満の乱数を生成
		double num1 = (double) Math.random();

		// 0.0以上10.0未満の乱数を生成
		double num2 = (double) (Math.random() * 10);

		// -1.0以上1.0未満の乱数を生成
		double num3 = (double) (Math.random() * 2) -1;

		//0.0以上1.0未満の実数値をランダムに生成して表示
		System.out.println("0.0以上1.0未満の実数値をランダムに生成して表示>" + num1);
		//0.0以上10.0未満の実数値をランダムに生成して表示
		System.out.println("0.0以上1.0未満の実数値をランダムに生成して表示>" + num2);
		//-1.0以上1.0未満の実数値をランダムに生成して表示
		System.out.println("0.0以上1.0未満の実数値をランダムに生成して表示>" + num3);

	}

}
