package test;

import static number.Number.*;
import static number.Constants.*;


import java.util.ArrayList;

import shape.HorzLine;
import shape.Point;
import shape.Shape;
import shape.VirtLine;

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
			final String SELECT_QUANTITY = "図形をいくつ作りますか？＞"; // 図形の個数選択時のメッセージ
			final String SELECT_SHAPE_NUM = "番の図形の種類は？（1・・・点 / 2・・・水平直線 / 3・・・垂直直線 / 4・・・長方形）＞"; // 図形選択時のメッセージ
			final String WIDTH = "幅＞"; // 幅を入力するときのメッセージ
			final String HEIGHT = "高さ＞"; // 高さを入力するときのメッセージ
			final String LENGTH = "長さ＞"; // 長さを入力するときのメッセージ
			final int SELECT_TYPE_MAX = 4; //選択できる図形の種類番号の最大値
			final int SELECT_TYPE_MIN = 1; //選択できる図形の種類番号の最小値
			final int MIN_QUANTITY = 1; //作成する図形の最小個数
			final int POINT = 1; //図形（点）
			final int HORZ_LINE = 2; //図形（水平線）
			final int VIRT_LINE = 3; //図形（垂直線）
			final int RECTANGLE = 4; //図形（長方形）
			int howMany; //作成する図形の個数
			int selectedShape; //作成する図形の種類
			int width; //図形の横幅
			int height; //図形の高さ
			int length; //図形(線)の長さ
			
			//図形コレクションを宣言
			ArrayList<Shape> shapeArray = new ArrayList<Shape>();	
			
			//作成する図形の個数を選択
			howMany = moreOrLessCheck(MIN_QUANTITY, sMORE, SELECT_QUANTITY);
			
			//指定数図形を作成
			for(int i = 0 ; i < howMany ; i++){
				
				//図形のタイプを選択（1・・・点 / 2・・・水平直線 / 3・・・垂直直線 / 4・・・長方形）
				selectedShape = inputRangeCheck(SELECT_TYPE_MIN, SELECT_TYPE_MAX, (i + 1) + SELECT_SHAPE_NUM);
				
				//選択された図形が１（点）の場合
				if(selectedShape == POINT){
					//createPointメソッドで点クラスのインスタンスを生成しコレクションへ格納
					shapeArray.add(createPoint());
				}
				
				//選択された図形が2（水平線）の場合
				if(selectedShape == HORZ_LINE){
					//線の長さを入力（１以上）
					length = moreOrLessCheck(sONE, sMORE, LENGTH);
					//createHorzメソッドで水平線クラスのインスタンスを生成しコレクションへ格納
					shapeArray.add(createHorz(length));
				}
				
				//選択された図形が３（垂直線）の場合
				if(selectedShape == VIRT_LINE){
					//線の長さを入力（１以上）
					length = moreOrLessCheck(sONE, sMORE, LENGTH);
					//createVirtメソッドで垂直クラスのインスタンスを生成しコレクションへ格納
					shapeArray.add(createVirt(length));
				}
				
				//選択された図形が4（長方形）の場合
				if(selectedShape == RECTANGLE){
					//幅を入力（１以上）
					width = moreOrLessCheck(sONE, sMORE, LENGTH);
					//たかさを入力（１以上）
					height = moreOrLessCheck(sONE, sMORE, LENGTH);
					
					//createRectangleメソッドで長方形クラスのインスタンスを生成しコレクションへ格納
					shapeArray.add(createRectangle(width, height));
				}

			}
			
		} finally {
			// scannerをクローズ
			sScanner.close();
		}
	}
	
	/* ====================================================================== */
	/**
	 * @brief 点クラスのインスタンスを生成して返却するメソッド
	 *
	 * @param 
	 *
	 * @return pointShape 生成したインスタンス
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Shape createPoint() {
		// 作成した点インスタンスを返却
		return new Point();
	}
	
	/* ====================================================================== */
	/**
	 * @brief 水平線クラスのインスタンスを生成して返却するメソッド
	 *
	 * @param 線の長さ
	 *
	 * @return horzShape 生成したインスタンス
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Shape createHorz(int length) {
		// 水平線インスタンスを返却
		return new HorzLine(length);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 垂直線クラスのインスタンスを生成して返却するメソッド
	 *
	 * @param 線の長さ
	 *
	 * @return horzShape 生成したインスタンス
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Shape createVirt(int length) {
		// 垂直線インスタンスを返却
		return new VirtLine(length);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 長方形クラスのインスタンスを生成して返却するメソッド
	 *
	 * @param width 幅, height 高さ
	 *
	 * @return rectangleShape 生成したインスタンス
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Shape createRectangle(int width, int height) {
		// 長方形インスタンスを返却
		return new shape.Rectangle(width , height);
	}

}
