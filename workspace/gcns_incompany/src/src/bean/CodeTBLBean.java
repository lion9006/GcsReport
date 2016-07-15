package src.bean;

import java.sql.Timestamp;

/**
 * コードテーブルビーン
 * 
 * @since 20150228
 * @author 金　龍光
 * 
 */

public class CodeTBLBean {

	private String code_bunrui_no;
	private String code_bunrui_nm;
	private String code_no;
	private String code_nm;
	private String ssk_nm;
	private String del_flg;
	private Timestamp upd_dt;
	private String upd_id;
	private Timestamp trk_dt;
	private String trk_id;
	
	/**
	 * @return the code_bunrui_no
	 */
	public String getCode_bunrui_no() {
		return code_bunrui_no;
	}
	
	/**
	 * @param code_bunrui_no
	 *            the code_bunrui_no to set
	 */
	public void setCode_bunrui_no(String code_bunrui_no) {
		this.code_bunrui_no = code_bunrui_no;
	}
	
	/**
	 * @return the code_bunrui_nm
	 */
	public String getCode_bunrui_nm() {
		return code_bunrui_nm;
	}
	
	/**
	 * @param code_bunrui_nm
	 *            the code_bunrui_nm to set
	 */
	public void setCode_bunrui_nm(String code_bunrui_nm) {
		this.code_bunrui_nm = code_bunrui_nm;
	}
	
	/**
	 * @return the code_no
	 */
	public String getCode_no() {
		return code_no;
	}
	
	/**
	 * @param code_no
	 *            the code_no to set
	 */
	public void setCode_no(String code_no) {
		this.code_no = code_no;
	}
	
	/**
	 * @return the code_nm
	 */
	public String getCode_nm() {
		return code_nm;
	}
	
	/**
	 * @param code_nm
	 *            the code_nm to set
	 */
	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}
	
	/**
	 * @return the getSsk_nm
	 */
	public String getSsk_nm() {
		return ssk_nm;
	}
	
	/**
	 * @param ssk_nm
	 *            the ssk_nm to set
	 */
	public void setSsk_nm(String ssk_nm) {
		this.ssk_nm = ssk_nm;
	}
	
	/**
	 * @return the del_flg
	 */
	public String getDel_flg() {
		return del_flg;
	}
	
	/**
	 * @param del_flg
	 *            the del_flg to set
	 */
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	
	/**
	 * @return the upd_dt
	 */
	public Timestamp getUpd_dt() {
		return upd_dt;
	}
	
	/**
	 * @param upd_dt
	 *            the upd_dt to set
	 */
	public void setUpd_dt(Timestamp upd_dt) {
		this.upd_dt = upd_dt;
	}
	
	/**
	 * @return the upd_id
	 */
	public String getUpd_id() {
		return upd_id;
	}
	
	/**
	 * @param upd_id
	 *            the upd_id to set
	 */
	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}
	
	/**
	 * @return the trk_dt
	 */
	public Timestamp getTrk_dt() {
		return trk_dt;
	}
	
	/**
	 * @param trk_dt
	 *            the trk_dt to set
	 */
	public void setTrk_dt(Timestamp trk_dt) {
		this.trk_dt = trk_dt;
	}
	
	/**
	 * @return the trk_id
	 */
	public String getTrk_id() {
		return trk_id;
	}
	
	/**
	 * @param trk_id
	 *            the trk_id to set
	 */
	public void setTrk_id(String trk_id) {
		this.trk_id = trk_id;
	}

}
