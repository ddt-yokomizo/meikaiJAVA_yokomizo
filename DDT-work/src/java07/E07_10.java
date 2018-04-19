package java07;

import java.util.Scanner;

/**
 * 
 * @author masahiro ランダムに決定した３桁の数値x,y,zから 以下の４つの問題をランダムに出題するプログラムを作成せよ。
 *
 * * 　　　　x + y +　z 
 *         x + y - z 
 *         x - y + z 
 *         x - y - z
 * 
 */
public class E07_10 {	
	
	// 標準入力ストリーム
	static Scanner scanner = new Scanner(System.in);

	// リトライ判定するメソッド
	static boolean comfilmRetry() {

		// 再度実行するか確認する用の変数を宣言
		int iInputNum = 0;
		// 返却するリトライ用の変数
		boolean isInputRetry = false;

		do {
			System.out.print("もう１度やりますか?　　（ １ ・・・ yes　/ 0 ・・・　no　＞ ");
			// 値を入力
			iInputNum = scanner.nextInt();

			// ０、１以外の値が入力された時のメッセージ
			if (iInputNum != 0 && iInputNum != 1) {
				System.out.println("0か1を入力してください。");
			}
			// ０、１の値が入力されるまでリトライする
		} while (iInputNum != 0 && iInputNum != 1);

		// iInputNumが１ならリトライ用の変数をtrueにする。
		isInputRetry = (iInputNum == 1 ? true : false);

		// リトライ用の変数を返す
		return isInputRetry;
	}

	public static void main(String[] args) {
		// 問題で利用する３桁の乱数を格納する配列（要素は３）
		int[] iRandomList = new int[3];
		// 演算子をランダムに決定するための変数
		int iOperator = 0;
		// 正解値
		int iCorrectValues = 0;
		// 問題文
		StringBuilder sbQestion = new StringBuilder();

		try {
			System.out.println("ランダムに問題を出力します");
			do {
				// 問題に利用する３桁の乱数を３つ作成する
				for (int i = 0; i < iRandomList.length; i++) {
					// 配列に100〜999の乱数を格納( オペランドの決定）
					iRandomList[i] = (int) (Math.random() * 1000) % 899 + 100;
					
					//１周目は正解値iCorrectValuesに決定した値を代入する
					if(i == 0){
						// 問題文に作成したオペランドを結合
						sbQestion.append(String.valueOf(iRandomList[i]));
						//正解値iCorrectValuesに決定した値を代入
						iCorrectValues = iRandomList[i];
					}
					
					//最終ループまではランダムに決定した演算子で計算する
					if (1 <= i && i <= (iRandomList.length - 1)) {
						// 演算子を決定するための0か１の乱数を決定
						iOperator = (int) (Math.random() * 10) % 2;
						if (iOperator == 0) {
							// ０なら「＋」で演算する
							iCorrectValues += iRandomList[i];
							//また、「＋」を問題文に結合する
							sbQestion.append(" ＋ ");
							// 問題文に作成したオペランドを結合
							sbQestion.append(String.valueOf(iRandomList[i]));
						} else if (iOperator == 1) {
							// １なら「ー」で演算する
							iCorrectValues -= iRandomList[i];
							//また、「ー」を問題文に結合する
							sbQestion.append(" ー ");
							// 問題文に作成したオペランドを結合
							sbQestion.append(String.valueOf(iRandomList[i]));
						}
					}
					if((i + 1) == iRandomList.length){
						// オペランドの数までループが周回したら「 ＝ 」を結合する（問題文の完成）
						sbQestion.append(" = ");
					}
				}
				// 問題文を出力する
				System.out.print(sbQestion);
				
				if(iCorrectValues == scanner.nextInt()){
					System.out.println("正解です");
				} else {
					System.out.println("不正解です。正解は" + iCorrectValues + "でした");
				}
				//sbQestionのポインタを0へ戻す
				sbQestion.setLength(0);
				//正解値を０に戻す
				iCorrectValues = 0;

			} while (comfilmRetry());

		} finally {
			// scannerをクローズ
			scanner.close();
		}
	}
}
