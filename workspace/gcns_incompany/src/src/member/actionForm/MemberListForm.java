package src.member.actionForm;

/**
 * 
 * @author KWON.JUYONG
 *
 */
import java.util.ArrayList;

import src.bean.CodeTBLBean;
import src.bean.UserTBLBean;
import src.common.ActionForm;

public class MemberListForm extends ActionForm {

	private String page = "1";
	private ArrayList<UserTBLBean> list = new ArrayList<UserTBLBean>();
	private ArrayList<CodeTBLBean> codeList = new ArrayList<CodeTBLBean>();
	private ArrayList<Integer> pagingList = new ArrayList<Integer>();

	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}// End of getPage

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}// End of setPage

	/**
	 * @return the list
	 */
	public ArrayList<UserTBLBean> getList() {
		return list;
	}// End of getList

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(ArrayList<UserTBLBean> list) {
		this.list = list;
	}// End of setList

	/**
	 * @return the pagingList
	 */
	public ArrayList<Integer> getPagingList() {
		return pagingList;
	}// End of getPagingList

	/**
	 * @param pagingList
	 *            the pagingList to set
	 */
	public void setPagingList(ArrayList<Integer> pagingList) {
		this.pagingList = pagingList;
	}// End of setPagingList
	
	/**
	 * @return codeList
	 */
	public ArrayList<CodeTBLBean> getCodeList() {
		return codeList;
	}//End of getCodeList
	
	/**
	 * @param codeList
	 * 			set codeList
	 */
	public void setCodeList(ArrayList<CodeTBLBean> codeList) {
		this.codeList = codeList;
	}//End of setCodeList

}
