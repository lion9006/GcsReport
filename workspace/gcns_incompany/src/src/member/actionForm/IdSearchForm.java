package src.member.actionForm;

import java.util.ArrayList;
import java.util.List;

import src.bean.CodeTBLBean;
import src.bean.UserTBLBean;
import src.common.ActionForm;

/**
 * 
 * @author KIM.SEONGHUI
 *
 */
public class IdSearchForm extends ActionForm{

	private String femail;
	private String lemail;
	private String USER_ID;
	private ArrayList<UserTBLBean> list = new ArrayList<UserTBLBean>();
	/**
	 * @return the USER_ID;
	 */
	public String getUSER_ID() {
		return USER_ID;
	}
	/**
	 * @param USER_ID
	 *            the USER_ID to set
	 */
	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}	
	
	/**
	 * @return the femail;
	 */
	public String getFemail() {
		return femail;
	}

	/**
	 * @param femail
	 *            the femail to set
	 */
	public void setFemail(String femail) {
		this.femail = femail;
	}	
	/**
	 * @return the lemail;
	 */
	public String getLemail() {
		return lemail;
	}

	/**
	 * @param lemail
	 *            the lemail to set
	 */
	public void setLemail(String lemail) {
		this.lemail = lemail;
	}
	
	public ArrayList<UserTBLBean> getList() {
		return list;
	}
	
	public void setList(ArrayList<UserTBLBean> list) {
		this.list = list;
	}
	
}
