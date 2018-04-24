package java07;
/**
 * キーを指定し、合致する配列の要素を探索してインデックスを返却するメソッドを作成せよ。
 * 同じ値の要素が複数存在する場合、もっとも末尾側に存在するインデックスを返却すること
 */

import java.util.Scanner;

public class E07_17 {
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
	 * 配列とキーを受け取り、キーと一致するもっとも末尾側のインデックスを返却するメソッド
	 *
	 * @param 
	 * int[] inputArray int型配列
	 * int searchKey 探索キー
	 *
	 * @return 
	 * int linearSearchR　
	 * 配列inputArrayの、キーと一致するもっとも末尾側のインデックスか、−１
	 * 
	 *
	 * @note
	 * 一致する要素がない場合は、int型　−1　を返却する
	 */
	/* ====================================================================== */
	static int linearSearchR(int[] inputArray , int searchKey){
		//キーと一致するもっとも末尾側のインデックス(初期値を−１とする）
		int linearSearchR = -1;

		//配列の最後の要素から一番初めの要素まで、探索キーと一致していないか調べる
		for(int i = (inputArray.length - 1) ; i >= 0 ; i--){
			//読み込んだ要素が探索キーと一致していた場合、返却するインデックスを決定する
			if(inputArray[i] == searchKey){
				//返却するインデックスを決定
				linearSearchR = i;
				//返却するインデックスが決定したらループ処理を抜ける
				break;
			}
		}
		//キーと一致するもっとも末尾側のインデックスか,見つからなかった場合は−１を返却する
		return linearSearchR;
	}

	public static void main(String[] args) {
		try {
			//要素数の変数
			int elementNum = 0;
			//探索キーと一致する配列要素のインデックス
			int idxNum = 0;
			//計算する配列
			int[] inputArray;
			
			System.out.println("配列の要素から値を探索します。");
			
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
			//linearSearchRメソッドから探索キーと一致する要素のインデックスを受け取る。
			//※見つからなかった時は-1 が帰ってくる
			idxNum = linearSearchR(inputArray,inputNum("探索キーを入力＞"));
			
			//探索結果を出力する。
			//見つかった場合はもっとも末尾側の一致したインデックス、一致しない場合は要素がなかった旨のメッセージを出力
			System.out.println((idxNum != -1 ? "その値は末尾から探索したところ、inputArray[" + idxNum + "]に発見しました。" : "その値の要素は存在しません"));
			
		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
