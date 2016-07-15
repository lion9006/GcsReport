package src.manager.actionForm;

import java.util.ArrayList;

import src.bean.CodeTBLBean;
import src.bean.UserTBLBean;
import src.common.ActionForm;

public class MemberListManagerForm extends ActionForm {
	private ArrayList<UserTBLBean> userList = new ArrayList<UserTBLBean>();
	private ArrayList<CodeTBLBean> codeList = new ArrayList<CodeTBLBean>();
	/**
	 * 
	 * @return userList
	 */
	public ArrayList<UserTBLBean> getUserList() {
		return userList;
	}
	/**
	 * 
	 * @param userList
	 * 			set userList
	 */
	public void setUserList(ArrayList<UserTBLBean> userList) {
		this.userList = userList;
	}
	/**
	 * 
	 * @return codeList
	 */
	public ArrayList<CodeTBLBean> getCodeList() {
		return codeList;
	}
	/**
	 * 
	 * @param codeList
	 * 			set userList
	 */
	public void setCodeList(ArrayList<CodeTBLBean> codeList) {
		this.codeList = codeList;
	}
	
	
}
