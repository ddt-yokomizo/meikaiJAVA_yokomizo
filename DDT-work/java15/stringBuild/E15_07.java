package stringBuild;
/**
 * 
 * @author masahiro
 * List 15-15 のfor文を拡張for文で実現したプログラムを作成せよ
 *
 */

public class E15_07 {
	public static void main(String[] args) {
		double sum = 0.0; //合計値
		
		for(String str : args){
			//引数の文字列をDouble型に変換して合計する
			sum += Double.parseDouble(str);
		}
			System.out.println("合計は" + sum + "です");
		
	}

}
