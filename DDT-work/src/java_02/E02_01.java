package java_02;

/*
 * List2-6の「2」の箇所を、小数部をもつ実数値をxとyに代入するように変更して、その結果を考察せよ。
 */


public class E02_01 {

	public static void main(String[] args) {
		int x; //Integer型の変数xを宣言
		int y; //Integer型の変数yを宣言

		x = 63.4; //xに63.4を代入
		y = 18.5; //yに18.5を代入

		System.out.println("xの値は"+ x + "です。"); //xの値を表示
		System.out.println("yの値は"+ y + "です。"); //yの値を表示

		System.out.println("合計は"+ ( x + y ) + "です。"); //xとyの合計を表示
		System.out.println("平均は"+ ( x + y ) / 2 + "です。"); //xとyの平均値を表示

		/*【考察】
		 * Integerがたの変数にDouble型の値を代入できないため
		 *型の不一致が発生し、エラーとなる
		 *
		 *
		 */





	}

}
