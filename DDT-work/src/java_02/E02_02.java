package java_02;
/*
 * 三つのint型変数に値を代入し、合計と平均を求めるプログラムを作成せよ。
 *
 */

public class E02_02 {

	public static void main(String[] args) {
		int x; //Integer型の変数xを宣言
		int y; //Integer型の変数yを宣言
		int z; //Integer型の変数zを宣言

		x = 63; //xに63を代入
		y = 18; //yに18を代入
		z = 57; //zに57を代入

		System.out.println("xの値は"+ x + "です。"); //xの値を表示
		System.out.println("yの値は"+ y + "です。"); //yの値を表示
		System.out.println("yの値は"+ z + "です。"); //zの値を表示

		System.out.println("合計は"+ ( x + y + z ) + "です。"); //xとyとzの合計を表示
		System.out.println("平均は"+ ( x + y + z ) / 3 + "です。"); //xとyとzの平均値を表示

	}

}
