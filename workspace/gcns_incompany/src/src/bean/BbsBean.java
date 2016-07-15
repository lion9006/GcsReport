package src.bean;

import java.sql.Timestamp;
import java.util.Arrays;

/**
 * 掲示板ビーン
 * 
 * @since 20150317
 * @author Park.Jaedeok
 * 
 */

public class BbsBean {
	int BBS_NUMBER;
	String BBS_WRITER;
	String BBS_CATEGORY;
	String BBS_TITLE;
	String BBS_CONTENT;
	String BBS_FNAME;
	byte[] BBS_FDATA;
	String DEL_FLG;
	Timestamp UPD_DT;
	String UPD_ID;
	Timestamp TRK_DT;
	String TRK_ID;
	String TRK_DATE;
	String TRK_TIME;
	String CODE_NM;
	String USER_NAME;
	String USER_NAME_KATA;
	

	
	public String getCODE_NM() {
		return CODE_NM;
	}
	public void setCODE_NM(String cODE_NM) {
		CODE_NM = cODE_NM;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	/**
	 * @return the bBS_NUMBER
	 */
	public int getBBS_NUMBER() {
		return BBS_NUMBER;
	}
	/**
	 * @param bBS_NUMBER the bBS_NUMBER to set
	 */
	public void setBBS_NUMBER(int bBS_NUMBER) {
		BBS_NUMBER = bBS_NUMBER;
	}
	/**
	 * @return the bBS_WRITER
	 */
	public String getBBS_WRITER() {
		return BBS_WRITER;
	}
	/**
	 * @param bBS_WRITER the bBS_WRITER to set
	 */
	public void setBBS_WRITER(String bBS_WRITER) {
		BBS_WRITER = bBS_WRITER;
	}
	/**
	 * @return the bBS_CATEGORY
	 */
	public String getBBS_CATEGORY() {
		return BBS_CATEGORY;
	}
	/**
	 * @param bBS_CATEGORY the bBS_CATEGORY to set
	 */
	public void setBBS_CATEGORY(String bBS_CATEGORY) {
		BBS_CATEGORY = bBS_CATEGORY;
	}
	/**
	 * @return the bBS_TITLE
	 */
	public String getBBS_TITLE() {
		return BBS_TITLE;
	}
	/**
	 * @param bBS_TITLE the bBS_TITLE to set
	 */
	public void setBBS_TITLE(String bBS_TITLE) {
		BBS_TITLE = bBS_TITLE;
	}
	/**
	 * @return the bBS_CONTENT
	 */
	public String getBBS_CONTENT() {
		return BBS_CONTENT;
	}
	/**
	 * @param bBS_CONTENT the bBS_CONTENT to set
	 */
	public void setBBS_CONTENT(String bBS_CONTENT) {
		BBS_CONTENT = bBS_CONTENT;
	}
	/**
	 * @return the bBS_FNAME
	 */
	public String getBBS_FNAME() {
		return BBS_FNAME;
	}
	/**
	 * @param bBS_FNAME the bBS_FNAME to set
	 */
	public void setBBS_FNAME(String bBS_FNAME) {
		BBS_FNAME = bBS_FNAME;
	}
	/**
	 * @return the bBS_FDATA
	 */
	public byte[] getBBS_FDATA() {
		return BBS_FDATA;
	}
	/**
	 * @param bBS_FDATA the bBS_FDATA to set
	 */
	public void setBBS_FDATA(byte[] bBS_FDATA) {
		BBS_FDATA = bBS_FDATA;
	}
	/**
	 * @return the dEL_FLG
	 */
	public String getDEL_FLG() {
		return DEL_FLG;
	}
	/**
	 * @param dEL_FLG the dEL_FLG to set
	 */
	public void setDEL_FLG(String dEL_FLG) {
		DEL_FLG = dEL_FLG;
	}
	/**
	 * @return the uPD_DT
	 */
	public Timestamp getUPD_DT() {
		return UPD_DT;
	}
	/**
	 * @param uPD_DT the uPD_DT to set
	 */
	public void setUPD_DT(Timestamp uPD_DT) {
		UPD_DT = uPD_DT;
	}
	/**
	 * @return the uPD_ID
	 */
	public String getUPD_ID() {
		return UPD_ID;
	}
	/**
	 * @param uPD_ID the uPD_ID to set
	 */
	public void setUPD_ID(String uPD_ID) {
		UPD_ID = uPD_ID;
	}
	/**
	 * @return the tRK_DT
	 */
	public Timestamp getTRK_DT() {
		return TRK_DT;
	}
	/**
	 * @param tRK_DT the tRK_DT to set
	 */
	public void setTRK_DT(Timestamp tRK_DT) {
		TRK_DT = tRK_DT;
	}
	/**
	 * @return the tRK_ID
	 */
	public String getTRK_ID() {
		return TRK_ID;
	}
	/**
	 * @param tRK_ID the tRK_ID to set
	 */
	
	public void setTRK_ID(String tRK_ID) {
		TRK_ID = tRK_ID;
	}
	public String getTRK_DATE() {
		return TRK_DATE;
	}
	public void setTRK_DATE(String tRK_DATE) {
		TRK_DATE = tRK_DATE;
	}
	public String getTRK_TIME() {
		return TRK_TIME;
	}
	public void setTRK_TIME(String tRK_TIME) {
		TRK_TIME = tRK_TIME;
	}
	
	
	public String getUSER_NAME_KATA() {
		return USER_NAME_KATA;
	}
	public void setUSER_NAME_KATA(String uSER_NAME_KATA) {
		USER_NAME_KATA = uSER_NAME_KATA;
	}


}
