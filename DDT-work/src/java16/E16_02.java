package java16;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * List１６−６（P523）のtry文では、ParameterRangeError例外とResultRangeError例外を
 * 別々の例外ハンドラで捕捉している。
 * ２つの例外を単一の例外ハンドラで捕捉するように変更したプログラムを作成せよ。
 *
 */

//非検査例外を処理するため、RuntimeExceptionから派生する
class RangeError extends RuntimeException{
	//コンストラクタ
	public RangeError(int n) {
		//Throwableクラス(全ての例外クラスの親玉)のコンストラクタを呼び出す
		super("範囲外の値：" + n);
	}
}

//返却値の範囲外例外処理クラス
class ResultRangeError extends RangeError{
	//コンストラクタ
	public ResultRangeError(int n) {
		//スーパクラスRangeErrorのコンストラクタを呼び出す
		super(n);
	}
}

//仮引数の範囲外例外処理クラス
class ParameterRangeError extends RangeError{
	//コンストラクタ
	public ParameterRangeError(int n) {
		//スーパクラスRangeErrorのコンストラクタを呼び出す
		super(n);
	}
}

public class E16_02 {
	
	//n　０〜９か判定するメソッド
	static boolean isValid(int n){
		//判定した結果を返却
		return n >= 0 && n <= 9;
	}
	
	//整数aとbの和を求める
	static int add(int a , int b){
		//仮引数aのチェック
		if(!isValid(a))throw new ParameterRangeError(a);
		//仮引数bのチェック
		if(!isValid(b))throw new ParameterRangeError(b);
		
		//和を変数に格納
		int result = a + b;
		
		//和のツェック
		if(!isValid(result))throw new ResultRangeError(result);
		return result;
		
		
	}

	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("整数a:");
		//整数aを入力
		int a = stdIn.nextInt();
		
		System.out.print("整数b:");
		//整数bを入力
		int b = stdIn.nextInt();
		
		try {
			System.out.println("それらの和は" + add(a, b) + "です");
		} catch (RuntimeException e) {
			// 例外RuntimeExceptionを処理してメッセージを出力
			System.out.println(e.toString());
		}

	}

}
