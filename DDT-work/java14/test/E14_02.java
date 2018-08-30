package test;
/**
 * ロボット型ペットクラスRobotPet（p.407）を拡張した着せ替え可能なロボット型ペットクラスを作成せよ。
 * インターフェースSkinnableを実装すること
 */

import static number.Constants.*;
import static number.Number.*;

import java.util.ArrayList;

import model.Skinnable;
import pet.Pet;

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

	public static void main(String[] args) {
		try {
			final String SELECT_QUANTITY = "ペットをいくつ作りますか？＞"; // ペット数選択時のメッセージ
			final String SELECT_PET_TYPE = "番のペットの種類は？（1・・・ただのペット / 2・・・ロボットペット / 3・・・着せ替え可能なロボットペット)"; // ペット選択時のメッセージ
			final String SELECT_SKIN = "スキンは？（0・・・黒 / 1・・・赤 / 2・・・緑 / 3・・・青 / 4・・・ヒョウ柄）＞"; // スキン選択時のメッセージ
			final int SELECT_TYPE_MAX = 3; //選択できるペットの種類番号の最大値
			final int SELECT_TYPE_MIN = 1; //選択できるペットの種類番号の最小値
			final int NOMAL_PET= 1; //ただのペット
			final int ROBOT_PET= 2; //ロボットペット
			final int SKINNABLE_ROBOT_PET= 3; //着せ替え可能なロボットペット
			int howMany; //作成するペットの個数
			int selectedSkin; //選択したスキンの種類
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
					petArray.add(e)
					break;
				// ロボットペットの場合
				case ROBOT_PET:
					System.out.print("赤");
					break;
				// 着せ替え可能なロボットペットの場合
				case SKINNABLE_ROBOT_PET:
					System.out.print("緑");
					break;
				default:
					break;
				}
			}
			
	
	


}
