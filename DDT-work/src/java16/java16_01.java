package java16;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * List１６−４（P518）のtry文では、Exception例外とRuntimeException例外を
 * 単一の例外ハンドラで捕捉している。
 * ２つの例外を別々に捕捉するように変更したプログラムを作成せよ。
 *
 */

public class java16_01 {
	
	//swの値によって例外を発生
	static void check(int sw) throws Exception{
		switch (sw) {
		case 1: throw new Exception("検査例外発生");
		case 2: throw new Exception("非検査例外発生");
		
		}
	}
	
	//checkを呼び出す
	static void test(int sw) throws Exception{
		check(sw);
	}

	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("ｓｗ：");
		int sw = stdIn.nextInt();
		
		try {
			test(sw);
		} catch (RuntimeException e) {
			// 例外RuntimeExceptionを処理してメッセージを出力
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// 例外Exceptionを処理してメッセージを出力
			System.out.println(e.getMessage());
		}

	}

}
