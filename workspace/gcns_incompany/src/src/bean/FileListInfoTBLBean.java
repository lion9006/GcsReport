package src.bean;

import java.sql.Timestamp;

/**
 * ファイル登録テーブル情報を保存するビーン
 * 
 * @since 20150218
 * @author KWON.JUYUONG
 * 
 */

public class FileListInfoTBLBean {
	int FILE_LIST_INDEX;
	int FILE_INDEX;
	String FILE_NAME;
	String FILE_TYPE;
	String FILE_INFO;
	String FILE_SIZE;
	byte[] FILE_DATA;
	String DEL_FLG;
	Timestamp UPD_DT;
	String UPD_ID;
	Timestamp TRK_DT;
	String TRK_ID;
	String USER_NAME;
	
	/**
	 * @return the FILE_LIST_INDEX
	 */
	public int getFILE_LIST_INDEX() {
		return FILE_LIST_INDEX;
	}

	/**
	 * @param FILE_LIST_INDEX
	 *            the FILE_LIST_INDEX to set
	 */
	
	public void setFILE_LIST_INDEX(int FILE_LIST_INDEX) {
		this.FILE_LIST_INDEX = FILE_LIST_INDEX;
	}
	
	/**
	 * @return the FILE_INDEX
	 */
	public int getFILE_INDEX() {
		return FILE_INDEX;
	}

	/**
	 * @param fILE_INDEX
	 *            the FILE_INDEX to set
	 */
	
	public void setFILE_INDEX(int fILE_INDEX) {
		FILE_INDEX = fILE_INDEX;
	}
	
	/**
	 * @return the fILE_NAME
	 */
	public String getFILE_NAME() {
		return FILE_NAME;
	}

	/**
	 * @param fILE_NAME
	 *            the fILE_NAME to set
	 */
	public void setFILE_NAME(String fILE_NAME) {
		FILE_NAME = fILE_NAME;
	}
	
	/**
	 * @return the fILE_TYPE
	 */
	public String getFILE_TYPE() {
		return FILE_TYPE;
	}

	/**
	 * @param fILE_TYPE
	 *            the fILE_TYPE to set
	 */
	public void setFILE_TYPE(String fILE_TYPE) {
		FILE_TYPE = fILE_TYPE;
	}
	
	/**
	 * @return the fILE_INFO
	 */
	public String getFILE_INFO() {
		return FILE_INFO;
	}

	/**
	 * @param fILE_INFO
	 *            the fILE_INFO to set
	 */
	public void setFILE_INFO(String fILE_INFO) {
		FILE_INFO = fILE_INFO;
	}
	
	/**
	 * @return the fILE_SIZE
	 */
	public String getFILE_SIZE() {
		return FILE_SIZE;
	}

	/**
	 * @param fILE_SIZE
	 *            the fILE_SIZE to set
	 */
	public void setFILE_SIZE(String fILE_SIZE) {
		FILE_SIZE = fILE_SIZE;
	}
	
	/**
	 * @return the fILE_DATA
	 */
	public byte[] getFILE_DATA() {
		return FILE_DATA;
	}

	/**
	 * @param fILE_DATA
	 *            the fILE_DATA to set
	 */
	public void setFILE_DATA(byte[] fILE_DATA) {
		FILE_DATA = fILE_DATA;
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

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	
	
}
