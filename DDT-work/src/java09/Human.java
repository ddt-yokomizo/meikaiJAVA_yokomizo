package java09;

/* ====================================================================== */
/**
 * @brief 
 * 人間クラス
 *
 * @note
 * 
 */
/* ====================================================================== */
class Human {
	/* ====フィールド==== */
	private String name = "名無しさん"; // 名前
	private int age = 0; //年齢
	private Day  birthDay; //誕生日
	private double height = 0.0; //身長
	private double weight = 0.0; //体重
	
	/* ====コンストラクタ==== */
	//全ての情報を入力するコンストラクタ
	Human(String name , int age , Day birthDay , double height , double weight){
		//名前を代入
		this.name = name;
		//年齢を代入
		this.age = age;
		//誕生日を代入
		this.birthDay = new Day(birthDay);
		//身長を代入
		this.height = height;
		//体重を代入
		this.weight = weight;
	}
	
	//匿名で作成するコンストラクタ
	Human(int age , Day birthDay , double height , double weight){
		//年齢を代入
		this.age = age;
		//誕生日を代入
		this.birthDay = new Day(birthDay);
		//身長を代入
		this.height = height;
		//体重を代入
		this.weight = weight;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 名前を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * name 名前
	 *
	 * @note
	 */
	/* ====================================================================== */
	public String getName() {
		//名前を取得
		return name;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 名前をSetするメソッド
	 *
	 * @param 
	 * name 名前
	 *
	 * @return なし
	 *
	 * @note
	 */
	/* ====================================================================== */
	public void setName(String name) {
		//名前をSet
		this.name = name;
	}
	/* ====================================================================== */
	/**
	 * @brief 
	 * 年齢を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * age 年齢
	 *
	 * @note
	 */
	/* ====================================================================== */

	public int getAge() {
		//年齢を返却
		return age;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 年齢をsetするメソッド
	 *
	 * @param 
	 * age　年齢
	 *
	 * @return なし
	 *
	 * @note
	 */
	/* ====================================================================== */

	public void setAge(int age) {
		//年齢に値を代入
		this.age = age;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 身長を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * height　身長
	 *
	 * @note
	 */
	/* ====================================================================== */

	public double getHeight() {
		//身長を返却
		return height;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 身長をSetするメソッド
	 *
	 * @param 
	 * height　身長
	 *
	 * @return なし
	 *
	 * @note
	 */
	/* ====================================================================== */

	public void setHeight(double height) {
		//身長に値を代入
		this.height = height;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 体重を取得するメソッド
	 *
	 * @param なし
	 *
	 * @return 
	 * weight 体重
	 *
	 * @note
	 */
	/* ====================================================================== */

	public double getWeight() {
		return weight;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 体重をSetするメソッド
	 *
	 * @param 
	 * weight　体重
	 *
	 * @return なし
	 *
	 * @note
	 */
	/* ====================================================================== */

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 誕生日を、文字列表現にしたものを返却するメソッド
	 *
	 * @param 
	 *
	 * @return 
	 * 誕生日を、文字列表現にしたもの
	 *
	 * @note
	 * ●●●●年●●月●●日(曜日)
	 * 
	 */
	/* ====================================================================== */
	public String toString() {
		//曜日の日本語表現を格納した変数
		final String[] WD_JA = {"日","月","火","水","木","金","土"};
		
		//誕生日を、文字列表現にして返却
		return String.format("%04d年%02d月%02d日(%s)",birthDay.getYear() ,birthDay.getMonth(),birthDay.getDate(),WD_JA[birthDay.dayOfWeek()]);
	}
	
	/* ====================================================================== */
	/**
	 * @brief 
	 * 誕生日をSetするメソッド
	 *
	 * @param 
	 * name 名前
	 *
	 * @return なし
	 *
	 * @note
	 */
	/* ====================================================================== */
	public void setBirthDay(Day birthDay) {
		//誕生日をSet
		this.birthDay = birthDay;
	}
		
}
