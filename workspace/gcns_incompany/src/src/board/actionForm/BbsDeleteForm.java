package src.board.actionForm;

import src.common.ActionForm;

/**
 * 
 * @author Yun.jaewon
 */

public class BbsDeleteForm extends ActionForm {
	int BBS_NUMBER;
	String searchOption1;
	String searchOption2;
	String searchInfo;
	String page;
	/**
	 * @return return to BBS_NUMBER
	 * */
	public int getBBS_NUMBER() {
		return BBS_NUMBER;
	}
	/**
	 * @param BBS_NUMBER
	 * 			the BBS_NUMBER to set
	 * */
	public void setBBS_NUMBER(int bBS_NUMBER) {
		BBS_NUMBER = bBS_NUMBER;
	}
	
	/**
	 * @return return to searchOption1
	 * */
	public String getSearchOption1() {
		return searchOption1;
	}
	/**
	 * @param searchOption1
	 * 			the searchOption1 to set
	 * */
	public void setSearchOption1(String searchOption1) {
		this.searchOption1 = searchOption1;
	}
	
	/**
	 * @return return to searchOption1
	 * */
	public String getSearchOption2() {
		return searchOption2;
	}
	/**
	 * @param searchOption2
	 * 			the searchOption2 to set
	 * */
	public void setSearchOption2(String searchOption2) {
		this.searchOption2 = searchOption2;
	}
	
	/**
	 * @return return to SearchInfo
	 * */
	public String getSearchInfo() {
		return searchInfo;
	}
	/**
	 * @param SearchInfo
	 * 			the SearchInfo to set
	 * */
	public void setSearchInfo(String searchInfo) {
		this.searchInfo = searchInfo;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
}
