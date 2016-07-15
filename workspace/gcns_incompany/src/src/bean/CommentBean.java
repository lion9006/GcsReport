package src.bean;

import java.sql.Timestamp;

/**
 * 掲示板コメント
 * 
 * @since 20150323
 * @author OH.YOUNGHWAN
 * 
 */
public class CommentBean {

	int COM_NUMBER;
	int  BBS_NUMBER;
//	String USER_NAME;
	String USER_CCFNAME;
	String USER_CCLNAME;
	String USER_KATAFNAME;
	String USER_KATANNAME;
	String COM_CONTENT;
	String DEL_FLG;
	Timestamp TRK_DT;
	String TRK_ID;
	String UPD_ID;
	
	public String getUPD_ID() {
		return UPD_ID;
	}
	public void setUPD_ID(String uPD_ID) {
		UPD_ID = uPD_ID;
	}
	public Timestamp getUPD_DT() {
		return UPD_DT;
	}
	public void setUPD_DT(Timestamp uPD_DT) {
		UPD_DT = uPD_DT;
	}
	Timestamp UPD_DT;

//	public String getUSER_NAME() {
//		return USER_NAME;
//	}
//	public void setUSER_NAME(String uSER_NAME) {
//		USER_NAME = uSER_NAME;
//	}
	public int getCOM_NUMBER() {
		return COM_NUMBER;
	}
	public void setCOM_NUMBER(int cOM_NUMBER) {
		COM_NUMBER = cOM_NUMBER;
	}
	public int getBBS_NUMBER() {
		return BBS_NUMBER;
	}
	public void setBBS_NUMBER(int bBS_NUMBER) {
		BBS_NUMBER = bBS_NUMBER;
	}
	public String getCOM_CONTENT() {
		return COM_CONTENT;
	}
	public void setCOM_CONTENT(String cOM_CONTENT) {
		COM_CONTENT = cOM_CONTENT;
	}

	public String getDEL_FLG() {
		return DEL_FLG;
	}
	public void setDEL_FLG(String dEL_FLG) {
		DEL_FLG = dEL_FLG;
	}
	public Timestamp getTRK_DT() {
		return TRK_DT;
	}
	public void setTRK_DT(Timestamp tRK_DT) {
		TRK_DT = tRK_DT;
	}
	public String getTRK_ID() {
		return TRK_ID;
	}
	public void setTRK_ID(String tRK_ID) {
		TRK_ID = tRK_ID;
	}
	public String getUSER_CCFNAME() {
		return USER_CCFNAME;
	}
	public void setUSER_CCFNAME(String uSER_CCFNAME) {
		USER_CCFNAME = uSER_CCFNAME;
	}
	public String getUSER_CCLNAME() {
		return USER_CCLNAME;
	}
	public void setUSER_CCLNAME(String uSER_CCLNAME) {
		USER_CCLNAME = uSER_CCLNAME;
	}
	public String getUSER_KATAFNAME() {
		return USER_KATAFNAME;
	}
	public void setUSER_KATAFNAME(String uSER_KATAFNAME) {
		USER_KATAFNAME = uSER_KATAFNAME;
	}
	public String getUSER_KATANNAME() {
		return USER_KATANNAME;
	}
	public void setUSER_KATANNAME(String uSER_KATANNAME) {
		USER_KATANNAME = uSER_KATANNAME;
	}

	
	
}
