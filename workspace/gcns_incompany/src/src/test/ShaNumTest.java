/**
 * 
 */
package src.test;

import src.common.StringUtility;

/**
 * SHA-256のコード値抽出様テストクラス
 * @author KIM.MINSU
 *
 */
public class ShaNumTest {

	/**
	 * 一般文字列をSHA-256コードに変換して標準出力に出力する。
	 * 
	 * @param args　入力なし
	 */
	public static void main(String[] args) {
		System.out.println(StringUtility.getSHA256("11111111"));
	}

}
