package src.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 文字列のチェック、変換、修正、トリムなどを処理する共通ツール<br>
 * 
 * @author KIM.MINSU
 * 
 */
public class StringUtility {
	/**
	 * 同じ文字列が渡された場合trueを返却。<br>
	 * 比較文字列のいずれかがNULLの場合falseを返却。<br>
	 * 文字列を比較して同じ値の場合trueを返却。<br>
	 * 
	 * @param str1
	 *            　比較文字列１
	 * @param str2
	 *            　比較文字列２
	 * @return true 比較文字列が同じである場合。
	 * @return false 比較文字列のいずれかがNULLまたは異なるばあい。
	 */
	public static boolean checkEqual(String str1, String str2) {
		if (str1 == str2) {
			return true;
		}
		if (str1 == null || str2 == null) {
			return false;
		}
		if (str1.equals(str2)) {
			return true;
		}
		return false;
	}

	/**
	 * sha-256暗号化
	 * 
	 * @param str
	 *            暗号化する文字列
	 * @return 暗号化された文字列
	 */
	public static String getSHA256(String str) {
		String SHA;
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			SHA = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}
}
