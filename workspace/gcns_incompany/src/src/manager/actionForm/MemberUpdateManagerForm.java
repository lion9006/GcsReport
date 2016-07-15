package src.manager.actionForm;

import src.common.ActionForm;

/**
 * 管理者が社員の情報を買えるために利用するdataform。
 * 
 * @author ヤンチャンジン
 * 
 */
public class MemberUpdateManagerForm extends ActionForm {
	private String user_id;
	private String user_password;
	private String user_department;
	private String user_rank;
	private String user_status;
	private String code_no;
	/**
	 * 
	 * @return user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * 
	 * @param user_id
	 * 			set user_id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * 
	 * @return user_password
	 */
	public String getUser_password() {
		return user_password;
	}

	/**
	 * 
	 * @param user_password
	 *            set user_password
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	/**
	 * 
	 * @return user_department
	 */
	public String getUser_department() {
		return user_department;
	}

	/**
	 * 
	 * @param user_department
	 *            set user_department
	 */
	public void setUser_department(String user_department) {
		this.user_department = user_department;
	}

	/**
	 * 
	 * @return user_rank
	 */
	public String getUser_rank() {
		return user_rank;
	}

	/**
	 * 
	 * @param user_rank
	 *            set user_rank
	 */
	public void setUser_rank(String user_rank) {
		this.user_rank = user_rank;
	}

	/**
	 * 
	 * @return user_status
	 */
	public String getUser_status() {
		return user_status;
	}

	/**
	 * 
	 * @param user_status
	 *            set user_status
	 */
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	/**
	 * 
	 * @return code_no
	 */
	public String getCode_no() {
		return code_no;
	}
	/**
	 * 
	 * @param code_no
	 * 			set code_no
	 */
	public void setCode_no(String code_no) {
		this.code_no = code_no;
	}
	
}
