package java16;

import java.util.Scanner;

/**
 * 
 * @author masahiro
 * List１６−７のメソッドreverseは仮引数aに受け取った参照が空参照ではないことを前提としているが、
 * 受け取ったのが空参照であった場合にNullPointerException例外を捕捉する処理を実装せよ
 *
 */

public class E16_03 {
	
	//配列の要素を入れ替えるメソッド
	static void swap(int[] a , int idx1 , int idx2){
		//要素１を退避
		int tmp = a[idx1];
		
		//要素１に要素２の値を上書き
		a[idx1] = a[idx2];
		
		//要素2に退避していた要素１の値を上書き
		a[idx2] = tmp;
	}
	
	//配列の要素を反転するメソッド(バグが埋め込まれたメソッド)
	static void reverse(int[] a){
		try {
			for(int i = 0 ; i < a.length / 2 ; i++){
				//誤った反転処理(正しくは第３引数が a.length - i - 1 )
				swap(a, i, a.length - 1);
			}
			
		} catch (NullPointerException e) {
			System.out.println("要素がnullです　" + e.toString());
			e.printStackTrace();
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		try {
		System.out.print("要素数：");
		
		//要素数を入力
		int num = stdIn.nextInt();
		//指定の要素数を持つ配列を宣言
		int[] array = new int[num];
		
		for(int i = 0 ; i < array.length ; i++){
			System.out.print("要素を入力＞");
			//要素に値を入力
			array[i] = stdIn.nextInt();
		}
		//配列をnullにする
		array = null;
		
		//要素を反転
		reverse(array);
		
		for(int i = 0 ; i < array.length ; i++){
			//要素を順番に出力
			System.out.println("array[" + i +"]" + "=" + array[i] );
		}

		
		}finally{
			//Scannerをクローズ
			stdIn.close();
		}

	}

}