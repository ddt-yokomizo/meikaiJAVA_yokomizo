package java04;
/**
 * ０から正の整数値までカウントアップするプログラムを作成せよ
 * 
 */
import java.util.Scanner;

public class E04_12 {

	public static void main(String[] args) {
		//標準入力ストリーム
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("整数値＞");
		//入力値１
		int inputNum1 = scanner.nextInt();
		
		//入力回数+1分ループ
		for(int i = 0 ; i < inputNum1 + 1 ; i++){
			//０から出力値までカウントアップ
			System.out.println(i);
		}

	}

}
