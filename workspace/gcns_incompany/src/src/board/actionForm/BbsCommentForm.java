package src.board.actionForm;


import java.util.ArrayList;





import src.bean.CommentBean;
import src.common.ActionForm;
  /**
縲� *  
縲� * @author OH.YOUNGHWAN
縲� * 
縲� *
 縲�*/

public class BbsCommentForm extends ActionForm{
	
	private ArrayList<CommentBean>comlist = new ArrayList<CommentBean>();
	private int com_number;
	private int bbs_number;
	private String com_content;
	private String TRK_ID;
	//
	private String searchOption1;
	private String searchOption2;
	private String searchInfo;
	private String page;
	//新しいソース
	
	
	
	/**
	 * 
	 * @return comlist
	 */
	

	public ArrayList<CommentBean> getComlist() {
		return comlist;
	}
	/**
	 * 
	 * @param comlist
	 */
	
	public void setComlist(ArrayList<CommentBean> comlist) {
		this.comlist = comlist;
	}
	/**
	 * 
	 * @return bbs_number
	 */
	
	public int getBbs_number() {
		return bbs_number;
	}
	/**
	 * 
	 * @param bbs_number
	 */
	public void setBbs_number(int bbs_number) {
		this.bbs_number = bbs_number;
	}
	/**
	 * 
	 * @return com_content
	 */
	
	public String getCom_content() {
		return com_content;
	}
	/**
	 * 
	 * @param com_content
	 */
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
	/**
	 * 
	 * @return TRK_ID
	 */
	
	public String getTRK_ID() {
		return TRK_ID;
	}
	/**
	 * 
	 * @param tRK_ID
	 */
	public void setTRK_ID(String TRK_ID) {
		this.TRK_ID = TRK_ID;
	}
	/**
	 * 
	 * @return com_number
	 */
	
	public int getCom_number() {
		return com_number;
	}
	
	/**
	 * 
	 * @param com_number
	 */
	public void setCom_number(int com_number) {
		this.com_number = com_number;
	}
	public String getSearchOption1() {
		return searchOption1;
	}
	public void setSearchOption1(String searchOption1) {
		this.searchOption1 = searchOption1;
	}
	public String getSearchOption2() {
		return searchOption2;
	}
	public void setSearchOption2(String searchOption2) {
		this.searchOption2 = searchOption2;
	}
	public String getSearchInfo() {
		return searchInfo;
	}
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

