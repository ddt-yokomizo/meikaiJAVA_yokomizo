package java07;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * キーボードから正の整数値を読み込んで、その値を返却する引数なしのメソッドを作成せよ。
 * ０や負の値が入力されたら再入力させること
 *
 */

public class E07_09 {
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);
	
	// 入力用の変数を宣言
	static int iInputNum = 0;
	
	// 正の整数値を入力して返却するメソッド
	static int returnNum() {
		do {
			System.out.print("正の整数値を入力してください＞");
			//値を入力
			iInputNum = scanner.nextInt();
			
			//０や負の値が入力された時のメッセージ
			if(iInputNum < 0 || iInputNum == 0){
				System.out.println("０や負の値はダメです");
			}
		//正の整数値が入力されるまでやり直させる
		} while (iInputNum < 0 || iInputNum == 0);

		// 入力した整数値を返す
		return iInputNum;
	}

	public static void main(String[] args) {

		try {
			System.out.println("入力した正の整数値を表示します。（０や負の値はNG）");

			// 正の整数値を入力して返却するメソッドを呼び出して表示する
			System.out.println(returnNum());
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
