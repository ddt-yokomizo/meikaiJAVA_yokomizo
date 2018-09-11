package pet;

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
	// なし

	/* ====コンストラクタ==== */
	public SkinnableRobotPet(String name, String masterName) {
		// スーパークラスのコンストラクタを呼び出す
		super(name, masterName);
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
	public void changeSkin(int skin) {
		System.out.print("スキンを");
		// 引数に応じてスキンを変更してメッセージを表示
		switch (skin) {

		// 黒の場合
		case sBLACK:
			System.out.print("黒");
			break;
		// 赤の場合
		case sRED:
			System.out.print("赤");
			break;
		// 緑の場合
		case sGREEN:
			System.out.print("緑");
			break;
		// 青の場合
		case sBLUE:
			System.out.print("青");
			break;
		// ヒョウ柄の場合
		case sLEOPARD:
			System.out.print("ヒョウ柄");
			break;
		default:
			break;
		}
		
		System.out.println("へ変更しました。");

	}

}