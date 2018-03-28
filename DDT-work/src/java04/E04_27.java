package java04;

/**
 * 0~99の数当てゲームを作成し、回答できる回数制限を設けて
 * 制限回数内に当てられなかった場合は正解を表示してゲームを終了すること。
 * 
 */
import java.util.Scanner;

public class E04_27 {

	public static void main(String[] args) {

		// 標準入力ストリーム
		Scanner scanner = new Scanner(System.in);

		// 0～99の乱数を生成(正解の値)
		int answerNum = (int) (Math.random() * 100 % 100);
		// 入力用の変数を宣言
		int inputNum1 = 0;
		// 回答回数
		int answerChance = 0;
		// チェックフラグ
		boolean checkFlg = false;
		
		try {
			System.out.print("回答回数を設定してください。＞");
			// 回答回数を入力
			answerChance = scanner.nextInt();

			System.out.print("0～99の数を当ててください。＞");
			
			//設定した回数分ループし、回答を入力（Outerループ）
			Outer: //Outerループ
			for (int i = 0; i < answerChance; i++) {

					inputNum1 = scanner.nextInt();
					// 入力値が答えより小さい場合
					if (inputNum1 < answerNum) {
						// それが最後の回答権だった場合
						if (i == (answerChance -1)){
							//最後の回答を外したらチェックフラグを trueにして、
							checkFlg = true;
							//Outerループを抜ける
							break Outer;
						}else{
							// 入力値が答えより小さい場合
							System.out.println("違います。もっと大きな値です。");
							System.out.print("チャンスはあと" + (answerChance - (i + 1)) + "回＞");
							//回答権があるなら次のループへ
							continue Outer;
						}
						// 入力値が答えより小さな場合
					} else if (answerNum < inputNum1) {
						// それが最後の回答権だった場合
						if (i == (answerChance -1)){
							//最後の回答を外したらチェックフラグを trueにして、
							checkFlg = true;
							//Outerループを抜ける
							break Outer;
						}else{
							System.out.println("違います。もっと小さな値です。");
							System.out.print("チャンスはあと" + (answerChance - (i + 1)) + "回＞");
							//回答権があるなら次のループへ
							continue Outer;
						}
					}else if (answerNum == inputNum1){
						checkFlg = false;
						//Outerループを抜ける
						break Outer;
					}
			}
			// 結果発表のメッセージを出力
			System.out.println((checkFlg ? "不正解。正解は" + answerNum + "でした。" : "正解。"));

		} finally {
			// scannerをクローズ
			scanner.close();
		}

	}
}