package test;
/**
 * ロボット型ペットクラスRobotPet（p.407）を拡張した着せ替え可能なロボット型ペットクラスを作成せよ。
 * インターフェースSkinnableを実装すること
 */

import static number.Constants.*;
import static number.Number.*;


import java.io.IOException;

import java.util.ArrayList;
import model.Skinnable;
import pet.Pet;
import pet.RobotPet;
import pet.SkinnableRobotPet;
import static model.Skinnable.*;
public class E14_02 {


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

	public static void main(String[] args) throws IOException{
		try {
			final String SELECT_QUANTITY = "ペットをいくつ作りますか？＞"; // ペット数選択時のメッセージ
			final String SELECT_PET_TYPE = "番のペットの種類は？（1・・・ただのペット / 2・・・ロボットペット / 3・・・着せ替え可能なロボットペット)"; // ペット選択時のメッセージ
			final int SELECT_TYPE_MAX = 3; //選択できるペットの種類番号の最大値
			final int SELECT_TYPE_MIN = 1; //選択できるペットの種類番号の最小値
			final int NOMAL_PET= 1; //ただのペット
			final int ROBOT_PET= 2; //ロボットペット
			final int SKINNABLE_ROBOT_PET= 3; //着せ替え可能なロボットペット
			int howMany; //作成するペットの個数
			int selectedPet; //選択したペットの種類
			
			//ペットコレクションを宣言
			ArrayList<Pet> petArray = new ArrayList<Pet>();
			//着せ替えインターフェース配列を宣言
			Skinnable[] skinnableArray;
			
			//作成するペットの個数を選択
			howMany = moreOrLessCheck(sONE, sMORE, SELECT_QUANTITY);
			
			//着せ替えインターフェースの要素数を決定
			skinnableArray = new Skinnable[howMany];
			
			//指定数ペットを作成
			for(int i = 0 ; i < howMany ; i++){
				
				//ペットのタイプを選択（1・・・ただのペット / 2・・・ロボットペット / 3・・・着せ替え可能なロボットペット)
				selectedPet = inputRangeCheck(SELECT_TYPE_MIN, SELECT_TYPE_MAX, (i + 1) + SELECT_PET_TYPE);
				
				// 引数に応じてスキンを変更してメッセージを表示
				switch (selectedPet) {
				// ただのペットの場合
				case NOMAL_PET:
					//createNomalPetメソッドから取得したインスタンスをコレクションに格納
					petArray.add(createNomalPet());
					break;
				// ロボットペットの場合
				case ROBOT_PET:
					//createRobotPetメソッドから取得したインスタンスをコレクションに格納
					petArray.add(createRobotPet());
					break;
				// 着せ替え可能なロボットペットの場合
				case SKINNABLE_ROBOT_PET:
					//createRobotPetメソッドから取得したインスタンスをコレクションに格納
					petArray.add(createSkinnableRobotPet());
					//着せ替えインターフェース配列へ格納
					skinnableArray[i] = (Skinnable) petArray.get(i);
					break;
				default:
					break;
				}
				
			}
			
			System.out.println("順番にペットの情報を出力");
			for(int i = 0 ; i < petArray.size() ; i++){
				//introduceメソッドで自己紹介を行う
				petArray.get(i).introduce();
				
				//着せ替え可能なロボットペットのオブジェクトの場合はスキンの変更を行う
				if (petArray.get(i) instanceof SkinnableRobotPet){
					//changeSkinメソッドでスキンカラーの変更を行う
					skinnableArray[i].changeSkin();
					
					//もう一度introduceメソッドで自己紹介を行い、スキンカラーが変更されたことを確認
					petArray.get(i).introduce();
				}
			}
			
			}catch (IOException e) {
			// IOException が発生したとき、メッセージを出力
				System.out.println("IOExceptionが発生");
		} finally {
				// scannerをクローズ
				sScanner.close();
			}
	}
	
	/* ====================================================================== */
	/**
	 * @brief ペットクラスのインスタンスを生成して返却するメソッド
	 *
	 * @param 
	 *
	 * @return 生成したインスタンス
	 * @throws IOException 
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Pet createNomalPet() throws IOException {
		try {
			String name; //ペットの名前
			String masterName;//ご主人様の名前
			
			//ペットの名前
			name = inputString(INPUT_PET_NAME);
			
			//ご主人様の名前を入力
			masterName = inputString(MASTER_NAME);
			
			// 作成したペットインスタンスを返却
			return new Pet(name, masterName);
			
		} catch (IOException e) {
			// IOException が発生したとき、メッセージを出力
			System.out.println("名前を入力する際にエラーが発生。nullを返却します。（IOException）");
			//nullを返却
			return null;
		}
	}
	
	/* ====================================================================== */
	/**
	 * @brief ロボットペットクラスのインスタンスを生成して返却するメソッド
	 *
	 * @param 
	 *
	 * @return 生成したインスタンス
	 * @throws IOException 
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Pet createRobotPet() throws IOException {
		try {
			String name; //ロボットペットの名前
			String masterName;//ご主人様の名前
			
			//ロボットペットの名前
			name = inputString(INPUT_ROBOT_PET_NAME);
			
			//ご主人様の名前を入力
			masterName = inputString(MASTER_NAME);
			
			// 作成したペットインスタンスを返却
			return new RobotPet(name, masterName);
			
		} catch (IOException e) {
			// IOException が発生したとき、メッセージを出力
			System.out.println("名前を入力する際にエラーが発生。nullを返却します。（IOException）");
			//nullを返却
			return null;
		}
	}
	
	/* ====================================================================== */
	/**
	 * @brief 着せ替え可能なロボットペットクラスのインスタンスを生成して返却するメソッド
	 *
	 * @param 
	 *
	 * @return 生成したインスタンス
	 * @throws IOException 
	 *
	 * @note
	 */
	/* ====================================================================== */

	public static Pet createSkinnableRobotPet() throws IOException {
		
		try {
			String name; //着せ替え可能なロボットペットの名前
			String masterName;//ご主人様の名前
			int skinColor;//スキンカラー
			
			//着せ替え可能なロボットペットの名前
			name = inputString(INPUT_SUKINNABLE_ROBOT_PET_NAME);
			
			//ご主人様の名前を入力
			masterName = inputString(MASTER_NAME);
			
			//スキンの色を入力
			skinColor = inputRangeCheck(sSKIN_MIN, sSKIN_MAX, INPUT_SKIN_COLOR);
			
			// 作成したペットインスタンスを返却
			return new SkinnableRobotPet(name, masterName , skinColor);
			
		} catch (IOException e) {
			// IOException が発生したとき、メッセージを出力
			System.out.println("名前を入力する際にエラーが発生。nullを返却します。（IOException）");
			//nullを返却
			return null;
		}

	}
}
