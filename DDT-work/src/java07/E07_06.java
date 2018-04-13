package java07;
/**
 * 入力値分の「＊」を連続表示するメソッドを、（List７−７を）
 * 内部で別のメソッドを呼び出して表示するように変更せよ。
 */
import java.util.Scanner;

public class E07_06 {
	
	// 引数に対応段数で左下が直角の三角形を作成するメソッド
	static void makeStages(int getStage) {
		//段を作成（引数の数だけループ）
		for(int i = 0 ; i < getStage ; i++){
			//読み込み段数に対応して記号を出力するメソッドを呼び出す
			printMark((i + 1));
		}
	}
	
	// メソッドmakeStagesが読み込んでいる段数に対応してマークを出力するメソッド
	static void printMark(int getElements) {
		//メソッドmakeStagesが読み込んでいる段数に対応して出力する要素数を決定する
		for(int i = 0 ; i < getElements ; i++){
			//記号を出力
			System.out.print('＊');
		}
		//１行出力終わったら改行
		System.out.println("");
	}

	public static void main(String[] args) {

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		try {
			// 段数を宣言
			int iInputStage = 0;

			System.out.println("左下が直角の三角形を表示します。");
			System.out.print("段数を設定してください＞");
			// 段数を入力
			iInputStage = scanner.nextInt();
			
			//引数に対応段数で左下が直角の三角形を作成するメソッドを呼び出す
			makeStages(iInputStage);

		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}