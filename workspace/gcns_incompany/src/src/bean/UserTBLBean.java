package src.bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * ユーザ登録テーブル情報を保存するビーン
 * 
 * @author KIM.SEONGHUI
 * 
 */
public class UserTBLBean {
	private int USER_LIST_INDEX;
	String USER_ID;
	String USER_PASSWORD;
//	String USER_NAME;
	String USER_CCFNAME;
	String USER_CCLNAME;
	String USER_KATAFNAME;
	String USER_KATALNAME;
	String USER_ADDRESS;
	String USER_PHONE;
	String USER_DEPARTMENT;
	String USER_RANK;
	String USER_GENDER;
	Date USER_BIRTHDAY;
	String USER_EMAIL;
	String USER_KAKAOTALK;
	String USER_INFO;
	String USER_STATUS;
	String DEL_FLG;
	Timestamp UPD_DT;
	String UPD_ID;
	Timestamp TRK_DT;
	String TRK_ID;

	/**
	 * @return the USER_LIST_INDEX
	 */
	public int getUSER_LIST_INDEX() {
		return USER_LIST_INDEX;
	}//End of getPage
	
	/**
	 * @param USER_LIST_INDEX
	 *            the USER_LIST_INDEX to set
	 */
	public void setUSER_LIST_INDEX(int USER_LIST_INDEX) {
		this.USER_LIST_INDEX = USER_LIST_INDEX;
	}//End of setPage
	
	/**
	 * @return the uSER_ID
	 */
	public String getUSER_ID() {
		return USER_ID;
	}

	/**
	 * @param uSER_ID
	 *            the uSER_ID to set
	 */
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	/**
	 * @return the uSER_PASSWORD
	 */
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}

	/**
	 * @param uSER_PASSWORD
	 *            the uSER_PASSWORD to set
	 */
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}

//	/**
//	 * @return the uSER_NAME
//	 */
//	public String getUSER_NAME() {
//		return USER_NAME;
//	}
//
//	/**
//	 * @param uSER_NAME
//	 *            the uSER_NAME to set
//	 */
//	public void setUSER_NAME(String uSER_NAME) {
//		USER_NAME = uSER_NAME;
//	}

	/**
	 * @return the uSER_ADDRESS
	 */
	public String getUSER_ADDRESS() {
		return USER_ADDRESS;
	}

	/**
	 * @param uSER_ADDRESS
	 *            the uSER_ADDRESS to set
	 */
	public void setUSER_ADDRESS(String uSER_ADDRESS) {
		USER_ADDRESS = uSER_ADDRESS;
	}

	/**
	 * @return the uSER_PHONE
	 */
	public String getUSER_PHONE() {
		return USER_PHONE;
	}

	/**
	 * @param uSER_PHONE
	 *            the uSER_PHONE to set
	 */
	public void setUSER_PHONE(String uSER_PHONE) {
		USER_PHONE = uSER_PHONE;
	}

	/**
	 * @return the uSER_DEPARTMENT
	 */
	public String getUSER_DEPARTMENT() {
		return USER_DEPARTMENT;
	}

	/**
	 * @param uSER_DEPARTMENT
	 *            the uSER_DEPARTMENT to set
	 */
	public void setUSER_DEPARTMENT(String uSER_DEPARTMENT) {
		USER_DEPARTMENT = uSER_DEPARTMENT;
	}

	/**
	 * @return the uSER_RANK
	 */
	public String getUSER_RANK() {
		return USER_RANK;
	}

	/**
	 * @param uSER_RANK
	 *            the uSER_RANK to set
	 */
	public void setUSER_RANK(String uSER_RANK) {
		USER_RANK = uSER_RANK;
	}

	/**
	 * @return the uSER_GENDER
	 */
	public String getUSER_GENDER() {
		return USER_GENDER;
	}

	/**
	 * @param uSER_GENDER
	 *            the uSER_GENDER to set
	 */
	public void setUSER_GENDER(String uSER_GENDER) {
		USER_GENDER = uSER_GENDER;
	}

	/**
	 * @return the uSER_BIRTHDAY
	 */
	public Date getUSER_BIRTHDAY() {
		return USER_BIRTHDAY;
	}

	/**
	 * @param uSER_BIRTHDAY
	 *            the uSER_BIRTHDAY to set
	 */
	public void setUSER_BIRTHDAY(Date uSER_BIRTHDAY) {
		USER_BIRTHDAY = uSER_BIRTHDAY;
	}

	/**
	 * @return the uSER_EMAIL
	 */
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	/**
	 * @param uSER_EMAIL
	 *            the uSER_EMAIL to set
	 */
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	/**
	 * @return the uSER_KAKAOTALK
	 */
	public String getUSER_KAKAOTALK() {
		return USER_KAKAOTALK;
	}

	/**
	 * @param uSER_KAKAOTALK
	 *            the uSER_KAKAOTALK to set
	 */
	public void setUSER_KAKAOTALK(String uSER_KAKAOTALK) {
		USER_KAKAOTALK = uSER_KAKAOTALK;
	}

	/**
	 * @return the uSER_INFO
	 */
	public String getUSER_INFO() {
		return USER_INFO;
	}

	/**
	 * @param uSER_INFO
	 *            the uSER_INFO to set
	 */
	public void setUSER_INFO(String uSER_INFO) {
		USER_INFO = uSER_INFO;
	}

	/**
	 * @return the uSER_STATUS
	 */
	public String getUSER_STATUS() {
		return USER_STATUS;
	}

	/**
	 * @param uSER_STATUS
	 *            the uSER_STATUS to set
	 */
	public void setUSER_STATUS(String uSER_STATUS) {
		USER_STATUS = uSER_STATUS;
	}

	/**
	 * @return the dEL_FLG
	 */
	public String getDEL_FLG() {
		return DEL_FLG;
	}

	/**
	 * @param dEL_FLG
	 *            the dEL_FLG to set
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
	 * @param uPD_DT
	 *            the uPD_DT to set
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
	 * @param uPD_ID
	 *            the uPD_ID to set
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
	 * @param tRK_DT
	 *            the tRK_DT to set
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
	 * @param tRK_ID
	 *            the tRK_ID to set
	 */
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

	public String getUSER_KATALNAME() {
		return USER_KATALNAME;
	}

	public void setUSER_KATALNAME(String uSER_KATALNAME) {
		USER_KATALNAME = uSER_KATALNAME;
	}


	
	
}
