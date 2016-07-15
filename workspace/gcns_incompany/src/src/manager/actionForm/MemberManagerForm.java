package src.manager.actionForm;

import src.common.ActionForm;
/**
 * 社員情報削除と一人の社員の情報を呼ぶために利用するクラス。
 * @author ヤンチャンジン
 *
 */
public class MemberManagerForm extends ActionForm {
	private String user_id;

	/**
	 * @return user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * 
	 * @param user_id
	 *            set user_id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
