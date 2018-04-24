package java07;
/**
 * 配列から指定のインデックスの要素を削除するメソッドを作成せよ。
 * 削除後、後方に1するインデックスを１つ前にずらすこと。
 * また、削除後の末尾要素の値は、変更しなくてもよい
 */
import java.util.Scanner;

public class E07_18 {
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);
	/* ====================================================================== */
	/**
	 * @brief
	 * 整数値を入力して返却するメソッド
	 *
	 * @param String outputMsg 入力前に出力するメッセージ
	 *
	 * @return 
	 * int inputNum 入力した値を返却する
	 *
	 * @note
	 */
	/* ====================================================================== */
	static int inputNum(String outputMsg){
		//整数入力用の変数
		int inputNum = 0;
		//引数の文字列をメッセージとして出力する
		System.out.print(outputMsg);
		//試算する値を入力
		inputNum = scanner.nextInt();
		
		//入力した整数値を返却する
		return inputNum;
	}
	/* ====================================================================== */
	/**
	 * @brief
	 * 配列とキーを受け取り、キーに対応する要素を削除して表示
	 *
	 * @param 
	 * int[] inputArray int型配列
	 * int delIdx 削除する要素（何番目か、という形で受け取る）
	 *
	 * @return 
	 * なし
	 * 
	 *
	 * @note
	 *  削除後、後方に1するインデックスを１つ前にずらすこと。
	 *  また、削除後の末尾要素の値は、変更しなくてもよい
	 */
	/* ====================================================================== */
	static void arrayRemove(int[] inputArray , int delIdx){
		
		System.out.println("削除後の配列を表示します");
		//配列の要素を順番に確認し、指定のインデックスの要素を削除して表示
		for(int i = 0 ; i < inputArray.length ; i++){
			//指定のインデックス以降、次の要素を読み込み中の要素へ格納する(最後の要素はのぞく）
			if((delIdx - 1) <= i && i != (inputArray.length - 1)){
				//次の要素を読み込み中の要素へ格納する
				inputArray[i] = inputArray[i + 1];
			}
			//削除後の配列を表示
			System.out.println(inputArray[i]);
		}
	}

	public static void main(String[] args) {
		try {
			//要素数の変数
			int elementNum = 0;
			//削除する要素（何番目？という投げ方をするので１〜要素数）
			int selectIdx = 0;
			//処理する配列
			int[] inputArray;
			
			System.out.println("配列から指定の要素を削除します。");
			do {
				//inputNumメソッドから配列の要素数を入力
				elementNum = inputNum("配列の要素数を入力してください＞");
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
				inputArray[i] = inputNum((i + 1) + "番目の要素を入力＞");
			}
			
			do {
				//inputNumメソッドから削除する配列の要素を決定
				selectIdx = inputNum("何番目の要素を削除しますか？＞");
				//要素数の範囲外の値がが入力された時のメッセージ
				if(selectIdx < 1 || inputArray.length < selectIdx){
					System.out.println("1〜" + inputArray.length + "番目を指定してください。");
				}
				//要素数の範囲外の値が入力されたらループ
			} while (selectIdx < 1 || inputArray.length < selectIdx);

			//arrayRemoveメソッドで指定の要素を削除して表示
			arrayRemove(inputArray, selectIdx);
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}