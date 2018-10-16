	package stringBuild;
	import static number.Number.*;
		/**
		 * 
		 * @author masahiro
		 *　文字列探索のプログラム（P４８９）を書き換えて、一致する部分が上下で揃うように
		 *　表示するよう改修せよ
		 *
		 */

		public class E15_03 {
			/* ====================================================================== */
			/**
			 * @brief メインメソッド
			 *
			 * @param なし
			 *
			 * @return なし
			 *
			 * @note 
			 */
			/* ====================================================================== */

			public static void main(String[] args) {
				try {
					final String INSERT_STRING = "文字列を入力してください。＞"; // 文字列を入力する際に表示するメッセージ
					final String SEARCH_STRING = "検索する文字列を入力してください。＞"; // 検索文字列を入力する際に表示するメッセージ
					int indexOf; //検索文字列が最初にヒットしたインデックス
					String inputString = null; //文字列１
					String searchString2 = null; //検索文字列
					
					//文字列1を入力
					inputString = scannerInputString(INSERT_STRING);
					
					//StringBufferオブジェクトを生成
					StringBuffer buffer = new StringBuffer(inputString.length());
					
					//検索文字列を入力
					searchString2 = scannerInputString(SEARCH_STRING);
					
					//検索文字列が文字列に含まれているかを調べる
					indexOf = inputString.indexOf(searchString2);
					
					//検索文字列が存在しない場合
					if(indexOf == -1){
						System.out.println("「" + inputString + "」の中に「" + searchString2 + "」は含まれていない。");
					} else {
						
						//検索文字が最初にヒットするインデックスまでは半角スペースを追加
						for(int i = 0 ; i < indexOf ; i++){
							buffer.append(' ');
						}
						//検索した文字列を、StringBufferオブジェクトに対して取得したインデックスから挿入
						buffer.append(searchString2);
						
						//一致する部分が上下で揃うように表示
						System.out.println("入力文字:" + inputString);
						System.out.println("検索文字:" + buffer);
					}
					
				} finally {
					// scannerをクローズ
					sScanner.close();
				}
			}
		}