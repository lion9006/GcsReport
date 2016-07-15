package src.board.actionForm;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;

import src.bean.BbsBean;
import src.bean.CommentBean;
import src.common.ActionForm;

	/**
	 *  
	 * @author OH.YOUNGHWAN
	 *
	 */

	public class BbsViewForm extends ActionForm{
	
		private String bbs_fname;
		private int bbs_number;
		private ArrayList<BbsBean> bbslist= new ArrayList<BbsBean>();
		private ArrayList<CommentBean> commentlist= new ArrayList<CommentBean>();
		private String searchOption1;
		private String searchOption2;
		private String searchInfo;
		private String page;
		private String UPD_ID;
		private int login_TRK_ID;
		private String login_status;
		
		
	     private String contentDispostion;
	     private InputStream inputStream;
	     private long contentLength;
	                   

		
		
		
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
		 * @return bbslist
		 */
		public ArrayList<BbsBean> getBbslist() {
			return bbslist;
		}
		/**
		 * 
		 * @param bbslist
		 */
		public void setBbslist(ArrayList<BbsBean> bbslist) {
			this.bbslist = bbslist;
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
		 * @return commentlist
		 */
		public ArrayList<CommentBean> getCommentlist() {
			return commentlist;
		}
		
		/**
		 * 
		 * @param commentlist
		 */
		public void setCommentlist(ArrayList<CommentBean> commentlist) {
			this.commentlist = commentlist;
		}
		public String getBbs_fname() {
			return bbs_fname;
		}
		public void setBbs_fname(String bbs_fname) {
			this.bbs_fname = bbs_fname;
		}

		public String getPage() {
			return page;
		}
		public void setPage(String page) {
			this.page = page;
		}
		public int getLogin_TRK_ID() {
			return login_TRK_ID;
		}
		public void setLogin_TRK_ID(int login_TRK_ID) {
			this.login_TRK_ID = login_TRK_ID;
		}

		public String getLogin_status() {
			return login_status;
		}

		public void setLogin_status(String login_status) {
			this.login_status = login_status;
		}
	    public String getUPD_ID() {
				return UPD_ID;
			}

		public void setUPD_ID(String uPD_ID) {
				UPD_ID = uPD_ID;
			}

		


		
		
		
		
	}