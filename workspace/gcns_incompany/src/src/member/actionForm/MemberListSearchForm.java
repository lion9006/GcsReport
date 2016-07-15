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

public class MemberListSearchForm extends ActionForm {
		
	private String page = "1";
	private ArrayList<UserTBLBean> list = new ArrayList<UserTBLBean>();
	private ArrayList<CodeTBLBean> codeList = new ArrayList<CodeTBLBean>();
	private ArrayList<Integer> pagingSearchList = new ArrayList<Integer>();
	private String SearchOption;	
	private String SearchInfo;
	
	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}//End of getPage
	
	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}//End of setPage
	
	
	/**
	 * @return the list
	 */
	public ArrayList<UserTBLBean> getList(){
		return list;
	}//End of getList
 
	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(ArrayList<UserTBLBean> list) {
		this.list = list;
	}//End of setList
	
	/**
	 * @return the pagingSearchList
	 */
	public ArrayList<Integer> getPagingSearchList() {
		return pagingSearchList;
	}//End of getPagingSearchList

	/**
	 * @param pagingSearchList
	 *            the pagingSearchList to set
	 */
	public void setPagingSearchList(ArrayList<Integer> pagingSearchList) {
		this.pagingSearchList = pagingSearchList;
	}//End of setPagingSearchList
	
	/**
	 * @return the SearchOption
	 */
	public String getSearchOption() {
		return SearchOption;
	}//End of getSearchOption
	
	/**
	 * @param SearchOption
	 *            the SearchOption to set
	 */
	public void setSearchOption(String SearchOption) {
		this.SearchOption = SearchOption;
	}//End of setSearchOption
	
	/**
	 * @return the SearchInfo
	 */
	public String getSearchInfo() {
		return SearchInfo;
	}//End of getSearchInfo
	
	/**
	 * @param SearchInfo
	 *            the setSearchInfo to set
	 */
	public void setSearchInfo(String SearchInfo) {
		this.SearchInfo = SearchInfo;
	}//End of setSearchInfo
	
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
