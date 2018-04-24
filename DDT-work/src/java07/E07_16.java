package java07;
/**
 * 配列の要素の最小値を求めるメソッドを作成せよ。
 */
import java.util.Scanner;

public class E07_16 {
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);
	/* ====================================================================== */
	/**
	 * @brief
	 * 整数値を入力して返却するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * int inputNum 入力した値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	static int inputNum(){
		//整数入力用の変数
		int inputNum = 0;
		
		System.out.print("整数を入力してください＞");
		//試算する値を入力
		inputNum = scanner.nextInt();
		
		//入力した整数値を返却する
		return inputNum;
	}
	/* ====================================================================== */
	/**
	 * @brief
	 * 受け取った配列の最小値を返すメソッド
	 *
	 * @param int[] inputArray int型配列
	 *
	 * @return 
	 * int minOfArray　受け取った配列の要素の最小値
	 *
	 * @note
	 */
	/* ====================================================================== */
	static int minOf(int[] inputArray){
		//最小値用の変数(初期値に１番目の要素を格納）
		int minOfArray = inputArray[0];

		//２番目の要素から全てをチェックし、最小値を算出する
		for(int i = 1 ; i < inputArray.length ; i++){
			//読み込んだ値が暫定最小値より小さい場合、最小値を更新する
			if(inputArray[i] < minOfArray){
				minOfArray = inputArray[i];
			}
		}
		//配列の最小値を返却
		return minOfArray;
	}

	public static void main(String[] args) {
		try {
			//要素数の変数
			int elementNum = 0;
			//計算する配列
			int[] inputArray;
			
			System.out.println("配列の要素の合計を出力します。");
			
			do {
				System.out.print("配列の要素数を設定してください。＞");
				elementNum = scanner.nextInt();
				//０以下が入力された時のメッセージ
				if(elementNum <= 0){
					System.out.println("1以上の整数を入力してください。");
				}
				//０以下が入力されたらループ
			} while (elementNum <= 0);
			
			//配列の要素数の決定
			inputArray = new int[elementNum];
			
			//配列の要素すべてに順番に値を格納する
			for(int i = 0 ; i < inputArray.length ; i++){
				//inputNumメソッドから値を入力して要素へ要素へ値を格納する
				inputArray[i] = inputNum();
			}
			//minOfメソッドから配列の全要素の最小値を受け取って出力する
			System.out.println("配列の最小値は" + minOf(inputArray) + "です。");
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}