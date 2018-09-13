package pet;


import static number.Constants.INPUT_SKIN_COLOR;
import static number.Number.inputRangeCheck;

import model.Skinnable;

/* ====================================================================== */
/**
 * @brief 着せ替え可能なロボットペットクラス
 *
 * @note 演習１４−２ スーパークラスRobotPetのサブクラス かつ インターフェースSkinnableを実装
 */
/* ====================================================================== */

public class SkinnableRobotPet extends RobotPet implements Skinnable {

	/* ====フィールド==== */
	private int mColor; // スキンの色（）

	/* ====コンストラクタ==== */
	public SkinnableRobotPet(String name, String masterName , int color) {
		// スーパークラスのコンストラクタを呼び出す
		super(name, masterName);
		//スキンの色を決定
		setSkin(color);
	}
	/* ====================================================================== */
	/**
	 * @brief スキンナンバーを返却するメソッド
	 *
	 * @param
	 *
	 * @return スキンの色　mColor
	 *
	 * @note 
	 * 
	 * @Override
	 */
	/* ====================================================================== */
	public int getSkinColorNum() {
		// スキンの色を返却
		return mColor;
	}
	/* ====================================================================== */
	/**
	 * @brief スキンナンバーをsetするメソッド
	 *
	 * @param　スキンの色　skinColor
	 *
	 * @return 
	 *
	 * @note 
	 * 
	 * @Override
	 */
	/* ====================================================================== */
	public void setSkin(int skinColor) {
		// スキンの色をset
		mColor = skinColor;
	}
	/* ====================================================================== */
	/**
	 * @brief スキンナンバーを返却するメソッド
	 *
	 * @param
	 *
	 * @return スキンの色　mColor
	 *
	 * @note 
	 * 
	 * @Override
	 */
	/* ====================================================================== */
	public String getSkinColor() {
		
		String skinName = null; //スキンネーム
		
		//getSkinColorNumメソッドで取得した整数をキーにスキン名を格納
		switch (getSkinColorNum()) {

		// 黒の場合
		case sBLACK:
			skinName ="黒";
			break;
		// 赤の場合
		case sRED:
			skinName ="赤";
			break;
		// 緑の場合
		case sGREEN:
			skinName ="緑";
			break;
		// 青の場合
		case sBLUE:
			skinName ="青";
			break;
		// ヒョウ柄の場合
		case sLEOPARD:
			skinName ="ヒョウ柄";
			break;
		default:
			break;
		}
		
		//スキン名を返却
		return skinName;
	}

	/* ====================================================================== */
	/**
	 * @brief 自己紹介するメソッド
	 *
	 * @param
	 *
	 * @return
	 *
	 * @note スーパークラスのintroduceメソッドをオーバーライド
	 * 
	 * @Override
	 */
	/* ====================================================================== */
	public void introduce() {
		// 自己紹介（自分の名前）
		System.out.println("◇僕は着せ替え可能なロボットであり名前は️" + getName() + "。");
		// 自己紹介（主人の名前）
		System.out.println("◇ご主人様は️" + getMasterName() + "。");
		// 自己紹介（スキン）
		System.out.println("◇現在のスキンカラーは️" + getSkinColor() + "。");
	}

	/* ====================================================================== */
	/**
	 * @brief スキンの変更をするインターフェースの実装メソッド
	 *
	 * @param skin 色
	 *
	 * @return
	 *
	 * @note
	 * 
	 */
	/* ====================================================================== */
	@Override
	public void changeSkin() {
		int skinColorNum; //スキンカラー番号
		
		//スキンの色を入力
		skinColorNum = inputRangeCheck(sSKIN_MIN, sSKIN_MAX, INPUT_SKIN_COLOR);
		
		//スキンを変更
		setSkin(skinColorNum);
		
		System.out.print("スキンを");
		//getSkinColorメソッドでスキンカラー名を取得して表示
		System.out.println(getSkinColor());
		System.out.println("へ変更しました。");
		
	}

}