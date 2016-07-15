package src.board.actionForm;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.MultipartStream;
import org.apache.struts2.dispatcher.multipart.MultiPartRequest;

import src.bean.BbsBean;
import src.common.ActionForm;
/**
 *  
 * @author Yun.jaewon
 *
 */

public class BbsUpdateForm extends ActionForm{
	int BBS_NUMBER;
	String BBS_WRITER;
	String BBS_CATEGORY;
	String BBS_TITLE;
	String BBS_CONTENT;
	String BBS_FNAME;
	File BBS_FDATA;
	String DEL_FLG;
	Timestamp UPD_DT;
	String UPD_ID;
	Timestamp TRK_DT;
	String TRK_ID;
	String searchOption1;
	String searchOption2;
	String searchInfo;
	String page;
	ArrayList<BbsBean> bbslist= new ArrayList<BbsBean>();
	
	
	
	/**
	 * @param BBS_NUMBER
	 * 			the BBS_NUMBER to set
	 */
	public int getBBS_NUMBER() {
		return BBS_NUMBER;
	}
	/**
	 * @return the BBS_NUMBER
	 */
	public void setBBS_NUMBER(int bBS_NUMBER) {
		BBS_NUMBER = bBS_NUMBER;
	}
	
	/**
	 * @param BBS_WRITER
	 * 			the BBS_WRITER to set
	 */
	public String getBBS_WRITER() {
		return BBS_WRITER;
	}
	/**
	 * @return the BBS_WRITER
	 */
	public void setBBS_WRITER(String bBS_WRITER) {
		BBS_WRITER = bBS_WRITER;
	}
	
	/**
	 * @param BBS_CATEGORY
	 * 			the BBS_CATEGORY to set
	 */
	public String getBBS_CATEGORY() {
		return BBS_CATEGORY;
	}
	/**
	 * @return the BBS_CATEGORY
	 */
	public void setBBS_CATEGORY(String bBS_CATEGORY) {
		BBS_CATEGORY = bBS_CATEGORY;
	}
	
	/**
	 * @param BBS_TITLE
	 * 			the BBS_TITLE to set
	 */
	public String getBBS_TITLE() {
		return BBS_TITLE;
	}
	/**
	 * @return the BBS_TITLE
	 */
	public void setBBS_TITLE(String bBS_TITLE) {
		BBS_TITLE = bBS_TITLE;
	}
	
	/**
	 * @param BBS_CONTENT
	 * 			the BBS_CONTENT to set
	 */
	public String getBBS_CONTENT() {
		return BBS_CONTENT;
	}
	/**
	 * @return the BBS_CONTENT
	 */
	public void setBBS_CONTENT(String bBS_CONTENT) {
		BBS_CONTENT = bBS_CONTENT;
	}
	
	/**
	 * @param BBS_FNAME
	 * 			the BBS_FNAME to set
	 */
	public String getBBS_FNAME() {
		return BBS_FNAME;
	}
	/**
	 * @return the BBS_FNAME
	 */
	public void setBBS_FNAME(String bBS_FNAME) {
		BBS_FNAME = bBS_FNAME;
	}
	
	/**
	 * @param BBS_FDATA
	 * 			the BBS_FDATA to set
	 */
	public File getBBS_FDATA() {
		return BBS_FDATA;
	}
	/**
	 * @return the BBS_FDATA
	 */
	public void setBBS_FDATA(File bBS_FDATA) {
		BBS_FDATA = bBS_FDATA;
	}
	
	/**
	 * @param DEL_FLG
	 * 			the DEL_FLG to set
	 */
	public String getDEL_FLG() {
		return DEL_FLG;
	}
	/**
	 * @return the DEL_FLG
	 */
	public void setDEL_FLG(String dEL_FLG) {
		DEL_FLG = dEL_FLG;
	}
	
	/**
	 * @param UPD_DT
	 * 			the UPD_DT to set
	 */
	public Timestamp getUPD_DT() {
		return UPD_DT;
	}
	/**
	 * @return the UPD_DT
	 */
	public void setUPD_DT(Timestamp uPD_DT) {
		UPD_DT = uPD_DT;
	}
	
	/**
	 * @param UPD_ID
	 * 			the UPD_ID to set
	 */
	public String getUPD_ID() {
		return UPD_ID;
	}
	/**
	 * @return the UPD_ID
	 */
	public void setUPD_ID(String uPD_ID) {
		UPD_ID = uPD_ID;
	}
	
	/**
	 * @param TRK_DT
	 * 			the TRK_DT to set
	 */
	public Timestamp getTRK_DT() {
		return TRK_DT;
	}
	/**
	 * @return the TRK_DT
	 */
	public void setTRK_DT(Timestamp tRK_DT) {
		TRK_DT = tRK_DT;
	}
	
	/**
	 * @param TRK_ID
	 * 			the TRK_ID to set
	 */
	public void setTRK_ID(String tRK_ID) {
		TRK_ID = tRK_ID;
	}
	/**
	 * @return the TRK_ID
	 */
	public String getTRK_ID() {
		return TRK_ID;
	}
	
	/**
	 * @param bbslist
	 * 			the bbslist to set
	 */
	public void setBbslist(ArrayList<BbsBean> bbslist) {
		this.bbslist = bbslist;
	}
	/**
	 * @return the bbslist
	 */
	public ArrayList<BbsBean> getBbslist() {
		return bbslist;
	}
	
	/**
	 * @return the searchOption1
	 */
	public String getSearchOption1() {
		return searchOption1;
	}
	/**
	 * @param searchOption1
	 * 			the searchOption1 to set
	 */
	public void setSearchOption1(String searchOption1) {
		this.searchOption1 = searchOption1;
	}
	
	/**
	 * @return the searchOption2
	 */
	public String getSearchOption2() {
		return searchOption2;
	}
	/**
	 * @param searchOption2
	 * 			the searchOption2 to set
	 */
	public void setSearchOption2(String searchOption2) {
		this.searchOption2 = searchOption2;
	}
	
	/**
	 * @return the SearchInfo
	 */
	public String getSearchInfo() {
		return searchInfo;
	}
	/**
	 * @param SearchInfo
	 * 			the SearchInfo to set
	 */
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
