package test;

import static number.Constants.*;
import static number.Number.*;
import java.util.ArrayList;
import shape.HorzLine;
import shape.Parallelogram;
import shape.Point;
import shape.Rectangle;
import shape.Shape;
import shape.VirtLine;
import shapeInterface.Plane2D;

public class E14_01 {


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
			final String SELECT_SHAPE_NUM = "番の図形の種類は？（1・・・点 / 2・・・水平直線 / 3・・・垂直直線 / 4・・・長方形 / 5・・・直角二等辺三角形 / 6・・・平行四辺形）＞"; // 図形選択時のメッセージ
			final String SELECT_ANGLE_DIRECTION = "直角の向きは？（1・・・右上 / 2・・・左上 / 3・・・右下 / 4・・・左下）＞"; // 直角二等辺三角形の直角方向選択時のメッセージ
			final String WIDTH = "幅＞"; // 幅を入力するときのメッセージ
			final String HEIGHT = "高さ＞"; // 高さを入力するときのメッセージ
			final String LENGTH = "長さ＞"; // 長さを入力するときのメッセージ
			final String SIDES = "二等辺三角形の辺の長さ＞"; // 二等辺三角形の辺の長さを入力するときのメッセージ
			final int SELECT_TYPE_MAX = 6; //選択できる図形の種類番号の最大値
			final int SELECT_TYPE_MIN = 1; //選択できる図形の種類番号の最小値
			final int SELECT_ANGLE_MAX = 4; //選択できる直角の向きの最大値
			final int MIN_QUANTITY = 1; //作成する図形の最小個数
			final int POINT = 1; //図形（点）
			final int HORZ_LINE = 2; //図形（水平線）
			final int VIRT_LINE = 3; //図形（垂直線）
			final int RECTANGLE = 4; //図形（長方形）	
			final int ISOS_RIGHT_TRI= 5; //図形（直角二等辺三角形）
			final int PARALLELOGRAM = 6; //図形（平行四辺形）
			final int UPPER_RIGHT_TRI= 1; //二等辺三角形の直角の方向（右上）
			final int UPPER_LEFT_TRI= 2; //二等辺三角形の直角の方向（左上）
			final int DOWN_RIGHT_TRI= 3; //二等辺三角形の直角の方向（右下）
			final int DOWN_LEFT_TRI= 4; //二等辺三角形の直角の方向（左下）
			int howMany; //作成する図形の個数
			int selectedShape; //作成する図形の種類
			int selectedAngle; //選択した直角二等辺三角形の向き
			int width; //図形の横幅
			int height; //図形の高さ
			int length; //図形(線)の長さ
			int sides; //二等辺三角形の辺の長さ
			
			//図形コレクションを宣言
			ArrayList<Shape> shapeArray = new ArrayList<Shape>();
			//２次元インターフェースコレクションを宣言
			ArrayList<Plane2D> plane2DArray = new ArrayList<Plane2D>();	
			
			//作成する図形の個数を選択
			howMany = moreOrLessCheck(MIN_QUANTITY, sMORE, SELECT_QUANTITY);
			
			//指定数図形を作成
			for(int i = 0 ; i < howMany ; i++){
				
				//図形のタイプを選択（1・・・点 / 2・・・水平直線 / 3・・・垂直直線 / 4・・・長方形 / 5・・・二等辺三角形 / 6・・・平行四辺形）
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
					width = moreOrLessCheck(sONE, sMORE, WIDTH);
					//たかさを入力（１以上）
					height = moreOrLessCheck(sONE, sMORE, HEIGHT);
					
					//createRectangleメソッドで長方形クラスのインスタンスを生成しコレクションへ格納
					shapeArray.add(createRectangle(width, height));
				}
				
				//選択された図形が5（直角二等辺三角形）の場合
				if(selectedShape == ISOS_RIGHT_TRI){
					
					//直角二等辺三角形の直角の向きを選択（1・・・右上 / 2・・・左上 / 3・・・右下 / 4・・・左下）
					selectedAngle = inputRangeCheck(sONE, SELECT_ANGLE_MAX, SELECT_ANGLE_DIRECTION);
					//二等辺三角形の辺の長さを入力（１以上）
					sides = moreOrLessCheck(sONE, sMORE, SIDES);
					
					
					//選択された直角の向きが１（右上）の場合
					if(selectedAngle == UPPER_RIGHT_TRI){
						//createUpperRightTriメソッドで右上直角二等辺三角形クラスのインスタンスを生成しコレクションへ格納
						shapeArray.add(createUpperRightTri(sides));
					}
					
					//選択された直角の向きが２（左上）の場合
					if(selectedAngle == UPPER_LEFT_TRI){
						//createUpperLeftTriメソッドで左上直角二等辺三角形クラスのインスタンスを生成しコレクションへ格納
						shapeArray.add(createUpperLeftTri(sides));
					}
					
					//選択された直角の向きが３（右下）の場合
					if(selectedAngle == DOWN_RIGHT_TRI){
						//createDownRightTriメソッドで右下直角二等辺三角形クラスのインスタンスを生成しコレクションへ格納
						shapeArray.add(createDownRightTri(sides));
					}
					
					//選択された直角の向きが４（左下）の場合
					if(selectedAngle == DOWN_LEFT_TRI){
						//createDownLeftTriメソッドで左下直角二等辺三角形クラスのインスタンスを生成しコレクションへ格納
						shapeArray.add(createDownLeftTri(sides));
					}
				}
				
				//選択された図形が６（平行四辺形）の場合
				if(selectedShape == PARALLELOGRAM){
					//幅を入力（１以上）
					width = moreOrLessCheck(sONE, sMORE, WIDTH);
					//たかさを入力（１以上）
					height = moreOrLessCheck(sONE, sMORE, HEIGHT);
					
					//createRectangleメソッドで平行四辺形クラスのインスタンスを生成しコレクションへ格納
					shapeArray.add(createParallelogram(width, height));
				}
			}
			
			//格納した図形コレクションの要素数分周回して図形情報を出力
			for(int i = 0 ; i < shapeArray.size() ; i++){
				//printメソッドで図形情報を出力
				shapeArray.get(i).print();
				
				//面積を求めるメソッドを持つオブジェクトは面積を表示
				if (shapeArray.get(i) instanceof shape.Rectangle || shapeArray.get(i) instanceof shape.Parallelogram ){
					System.out.println(shapeArray.get(i).);
					System.out.println(plane2DArray.get(i).getArea());
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
	
	
	/* ====================================================================== */
	/**
	 * @brief 二等辺三角形（右上直角）のインスタンスを生成して返却するメソッド
	 *
	 * @param sides 辺の長さ
	 *
	 * @return 生成したインスタンス
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Shape createUpperRightTri(int sides) {
		// 二等辺三角形（右上直角）インスタンスを返却
		return new shape.UpperRightTri(sides);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 二等辺三角形（左上直角）のインスタンスを生成して返却するメソッド
	 *
	 * @param sides 辺の長さ
	 *
	 * @return 生成したインスタンス
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Shape createUpperLeftTri(int sides) {
		// 二等辺三角形（左上直角）インスタンスを返却
		return new shape.UpperLeftTri(sides);
	}
	
	
	/* ====================================================================== */
	/**
	 * @brief 二等辺三角形（右下直角）のインスタンスを生成して返却するメソッド
	 *
	 * @param sides 辺の長さ
	 *
	 * @return rectangleShape 生成したインスタンス
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Shape createDownRightTri(int sides) {
		// 二等辺三角形（右下直角）インスタンスを返却
		return new shape.DownRightTri(sides);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 二等辺三角形（左下直角）のインスタンスを生成して返却するメソッド
	 *
	 * @param sides 辺の長さ
	 *
	 * @return rectangleShape 生成したインスタンス
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Shape createDownLeftTri(int sides) {
		// 二等辺三角形（左下直角）インスタンスを返却
		return new shape.DownLeftTri(sides);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 平行四辺形クラスのインスタンスを生成して返却するメソッド
	 *
	 * @param width 幅, height 高さ
	 *
	 * @return 生成したインスタンス
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Shape createParallelogram(int width, int height) {
		// 平行四辺形インスタンスを返却
		return new shape.Parallelogram(width , height);
	}

}