package src.manager.actionForm;

import java.sql.Timestamp;

import src.common.ActionForm;

public class UserIDForm extends ActionForm{
	String USER_ID;
	String DEL_FLG;
	Timestamp UPD_DT;
	String UPD_ID;
	Timestamp TRK_DT;
	String TRK_ID;
	
	/**
	 * @return the USER_ID
	 */
	public String getUSER_ID() {
		return USER_ID;
	}
	/**
	 * @param uSER_ID
	 *            the USER_ID to set
	 */
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	/**
	 * @return the DEL_FLG
	 */
	public String getDEL_FLG() {
		return DEL_FLG;
	}
	/**
	 * @param dEL_FLG
	 *            the DEL_FLG to set
	 */
	public void setDEL_FLG(String dEL_FLG) {
		DEL_FLG = dEL_FLG;
	}
	/**
	 * @return the UPD_DT
	 */
	public Timestamp getUPD_DT() {
		return UPD_DT;
	}
	/**
	 * @param uPD_DT
	 *            the UPD_DT to set
	 */
	public void setUPD_DT(Timestamp uPD_DT) {
		UPD_DT = uPD_DT;
	}
	/**
	 * @return the UPD_ID
	 */
	public String getUPD_ID() {
		return UPD_ID;
	}
	/**
	 * @param uPD_ID
	 *            the UPD_ID to set
	 */
	public void setUPD_ID(String uPD_ID) {
		UPD_ID = uPD_ID;
	}
	/**
	 * @return the TRK_DT
	 */
	public Timestamp getTRK_DT() {
		return TRK_DT;
	}
	/**
	 * @param tRK_DT
	 *            the TRK_DT to set
	 */
	public void setTRK_DT(Timestamp tRK_DT) {
		TRK_DT = tRK_DT;
	}
	/**
	 * @return the TRK_ID
	 */
	public String getTRK_ID() {
		return TRK_ID;
	}
	/**
	 * @param tRK_ID
	 *            the TRK_ID to set
	 */
	public void setTRK_ID(String tRK_ID) {
		TRK_ID = tRK_ID;
	}
	

}