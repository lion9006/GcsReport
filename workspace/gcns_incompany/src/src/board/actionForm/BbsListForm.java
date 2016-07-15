package src.board.actionForm;

import java.util.ArrayList;

import src.bean.BbsBean;
import src.bean.CodeTBLBean;
import src.common.ActionForm;


/**
 * 
 * @author MOON.BYEONGGEUN
 */
public class BbsListForm extends ActionForm{

	private String page="1";
	private ArrayList<BbsBean> list = new ArrayList<BbsBean>();
	private ArrayList<Integer> pagingList = new ArrayList<Integer>();
	private ArrayList<CodeTBLBean> codeList1 = new ArrayList<CodeTBLBean>();
	private ArrayList<CodeTBLBean> codeList2 = new ArrayList<CodeTBLBean>();
	private String searchOption1;
	private String searchOption2;
	private String searchInfo;
	private int beforePage;
	private int nextPage;
	
	/**
	 * 
	 * @return the page
	 */
	
	public String getPage() {
		return page;
	}
	/**
	 * 
	 * @param page
	 * 		今のページのNumber
	 */
	public void setPage(String page) {
		this.page = page;
	}
	/**
	 * 
	 * @return the list
	 */
	public ArrayList<BbsBean> getList() {
		return list;
	}
	/**
	 * 
	 * @param list
	 * 		今のページで字リスト
	 */
	public void setList(ArrayList<BbsBean> list) {
		this.list = list;
	}
	/**
	 * 
	 * @return　the paginglist
	 */
	public ArrayList<Integer> getPagingList() {
		return pagingList;
	}
	/**
	 * 
	 * @param pagingList
	 * 		ページングのリスト
	 */
	public void setPagingList(ArrayList<Integer> pagingList) {
		this.pagingList = pagingList;
	}
	/**
	 * 
	 * @return　the codelist1
	 */
	public ArrayList<CodeTBLBean> getCodeList1() {
		return codeList1;
	}
	/**
	 * 
	 * @param codeList1
	 * 		カテゴリーのコードリスト
	 */
	public void setCodeList1(ArrayList<CodeTBLBean> codeList1) {
		this.codeList1 = codeList1;
	}
	/**
	 * 
	 * @return　the codelist2
	 */
	public ArrayList<CodeTBLBean> getCodeList2() {
		return codeList2;
	}
	/**
	 * 
	 * @param codeList2
	 * 		検索のオプションコードリスト
	 */
	public void setCodeList2(ArrayList<CodeTBLBean> codeList2) {
		this.codeList2 = codeList2;
	}
	/**
	 * 
	 * @return the searchoption1
	 */
	public String getSearchOption1() {
		return searchOption1;
	}
	/**
	 * 
	 * @param searchOption1
	 * 		検索オプション１
	 */
	public void setSearchOption1(String searchOption1) {
		this.searchOption1 = searchOption1;
	}
	/**
	 * 
	 * @return the searchoption2
	 */
	public String getSearchOption2() {
		return searchOption2;
	}
	/**
	 * 
	 * @param searchOption2
	 * 		検索オプション２
	 */
	public void setSearchOption2(String searchOption2) {
		this.searchOption2 = searchOption2;
	}
	/**
	 * 
	 * @return the searchinfo
	 */
	public String getSearchInfo() {
		return searchInfo;
	}
	/**
	 * 
	 * @param searchInfo
	 * 		検索キーワード
	 */
	public void setSearchInfo(String searchInfo) {
		this.searchInfo = searchInfo;
	}
	/**
	 * 
	 * @return the beforepage
	 */
	public int getBeforePage() {
		return beforePage;
	}
	/**
	 * 
	 * @param beforePage
	 * 		前のページングリスト
	 */
	public void setBeforePage(int beforePage) {
		this.beforePage = beforePage;
	}
	/**
	 * 
	 * @return the nextpage
	 */
	public int getNextPage() {
		return nextPage;
	}
	/**
	 * 
	 * @param nextPage
	 * 		次のページングリスト
	 */
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	
	
	
	
	
}
