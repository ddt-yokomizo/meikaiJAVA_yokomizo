package test;

import static number.Number.sScanner;
import java.util.ArrayList;
import shape.Shape;

/**
 * @brief 図形クラス群をテストするプログラムを作成せよ。要素が参照するインスタンスはキーボードから読み込むこと
 * @author masahiro
 * 
 *
 */

public class E13_01 {


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
			final String SELECT_SHAPE_NUM = "番の図形の種類は？（1・・・点 / 2・・・水平直線 / 3・・・垂直直線 / 4・・・長方形）＞"; // 図形選択時のメッセージ
			final String WIDTH = "幅＞"; // 幅を表示するときのメッセージ
			final String HEIGHT = "高さ＞"; // 高さを表示するときのメッセージ
			final String LONG = "長さ＞"; // 長さを表示するときのメッセージ
			final int selectNumMax = 4; //選択できる図形の種類番号の最大値
			final int selectNumMin = 1; //選択できる図形の種類番号の最小値
			int howMany; //作成する図形の個数
			int width; //図形の横幅（または水平線の長さ）
			int height; //図形の高さ（または垂直線の長さ）
			
			//図形コレクションを宣言
			ArrayList<Shape> shapeArray = new ArrayList<Shape>();	
			
		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}

}
