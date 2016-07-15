package src.login.actionForm;

import src.common.ActionForm;

public class LoginAccessForm extends ActionForm {

	private String user_id;
	private String user_password;
	private String user_department;
//	private String user_name;
	private String user_ccfname;
	private String user_cclname;
	private String user_katafname;
	private String user_katalname;
	private String user_rank;

	private String user_status;
	

	
	private String loginMessage;

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the user_password
	 */
	public String getUser_password() {
		return user_password;
	}

	/**
	 * @param user_password
	 *            the user_password to set
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	/**
	 * @return the user_department
	 */
	public String getUser_department() {
		return user_department;
	}

	/**
	 * @param user_department
	 *            the user_department to set
	 */
	public void setUser_department(String user_department) {
		this.user_department = user_department;
	}

//	/**
//	 * @return the user_name
//	 */
//	public String getUser_name() {
//		return user_name;
//	}
//
//	/**
//	 * @param user_name
//	 *            the user_name to set
//	 */
//	public void setUser_name(String user_name) {
//		this.user_name = user_name;
//	}

	/**
	 * @return the user_rank
	 */
	public String getUser_rank() {
		return user_rank;
	}

	/**
	 * @param user_rank
	 *            the user_rank to set
	 */
	public void setUser_rank(String user_rank) {
		this.user_rank = user_rank;
	}
	
	/**
	 * @return the loginMessage
	 */
	public String getLoginMessage() {
		return loginMessage;
	}
	/**
	 * @param loginMessage
	 *            the loginMessage to set
	 */
	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public String getUser_ccfname() {
		return user_ccfname;
	}

	public void setUser_ccfname(String user_ccfname) {
		this.user_ccfname = user_ccfname;
	}

	public String getUser_cclname() {
		return user_cclname;
	}

	public void setUser_cclname(String user_cclname) {
		this.user_cclname = user_cclname;
	}

	public String getUser_katafname() {
		return user_katafname;
	}

	public void setUser_katafname(String user_katafname) {
		this.user_katafname = user_katafname;
	}

	public String getUser_katalname() {
		return user_katalname;
	}

	public void setUser_katalname(String user_katalname) {
		this.user_katalname = user_katalname;
	}
	
}
