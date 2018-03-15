package java04;

import java.util.Scanner;

/**
 *
 * 読み込んだ整数の符号を判定するプログラムを、好きなだけ何度でも繰り返し入力、
 * 表示ができるようにしたプログラムを作成せよ。
 *
 */
public class E04_01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int retryNum; //リトライフラグ

		do {

			System.out.print("整数１＞");
			//整数１を入力
			int inputNum1 = scanner.nextInt();

			if (inputNum1 < 0){
				//入力値が負の時のメッセージ
				System.out.println("入力値は負の値です。");
			} else if (0 < inputNum1 ) {
				//入力値が正の値の時のメッセージ
				System.out.println("入力値は正の値です。");
			}else if (inputNum1 == 0){
				//入力値が0の時のメッセージ
				System.out.println("入力値は0です。");
			}

			do {

				System.out.println("もう一度処理を実行しますか？　1 … はい / 2 …　いいえ");
				//リトライフラグを入力
				retryNum = scanner.nextInt();

				if (retryNum != 1 && retryNum != 2){
					System.out.println("1か2の整数を入力してください。");
				}
				//1か2以外の整数が入力されたらループする
			} while (retryNum != 1 && retryNum != 2);


			//1が入力されたらループ
		} while (retryNum == 1);



	}

}
