package src.manager.actionForm;

import java.util.ArrayList;

import src.bean.CodeTBLBean;
import src.bean.UserTBLBean;
import src.common.ActionForm;

/**
 *　社員を検索するために利用する検索のdataform。
 * @author ヤンチャンジン
 *
 */
public class MemberSearchManagerForm extends ActionForm{
	private ArrayList<UserTBLBean> userList = new ArrayList<UserTBLBean>();
	private ArrayList<CodeTBLBean> codeList = new ArrayList<CodeTBLBean>();
	private String SearchOption;	
	private String SearchInfo;
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
	 */
	public void setUserList(ArrayList<UserTBLBean> userList) {
		this.userList = userList;
	}
	/**
	 * 
	 * @return SearchOption
	 */
	public String getSearchOption() {
		return SearchOption;
	}
	/**
	 * 
	 * @param searchOption
	 * 			set SearchOption
	 */
	public void setSearchOption(String searchOption) {
		SearchOption = searchOption;
	}
	/**
	 * 
	 * @return SearchInfo
	 */
	public String getSearchInfo() {
		return SearchInfo;
	}
	/**
	 * 
	 * @param searchInfo
	 * 			set SearchInfo
	 */
	public void setSearchInfo(String searchInfo) {
		SearchInfo = searchInfo;
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
	 * 			set codeList
	 */
	public void setCodeList(ArrayList<CodeTBLBean> codeList) {
		this.codeList = codeList;
	}

}
