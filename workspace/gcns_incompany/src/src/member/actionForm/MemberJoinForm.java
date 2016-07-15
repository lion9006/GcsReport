package src.member.actionForm;

import java.util.ArrayList;
import java.util.List;

import src.bean.CodeTBLBean;
import src.common.ActionForm;
/**
 * 
 * @author KIM.SEONGHUI
 *
 */
public class MemberJoinForm extends ActionForm{
	private List<CodeTBLBean> departmentList = new ArrayList<CodeTBLBean>();
	private List<CodeTBLBean> rankList = new ArrayList<CodeTBLBean>();
	private String uid;
	private String pw1;
//	private String namae;
	private String ccfname;
	private String cclname;
	private String katafname;
	private String katalname;
	private String rank;
	private String department;
	private String gender;
	private String year;
	private String month;
	private String day;
	private String address;
	private String femail;
	private String lemail;
	private String tel;
	private String kaid;
	private String bigo;	
	private String USER_STATUS;
	private String DEL_FLG;
	private String UPD_DT;
	private String UPD_ID;
	private String TRK_DT;
	private String TRK_ID;

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}	
	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
		
	/**
	 * @return the pw1
	 */	
	
	public String getPw1() {
		return pw1;
	}	
	/**
	 * @param pw1
	 *            the pw1 to set
	 */	
	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}

//	/**
//	 * @return the namae
//	 */	
//	public String getNamae() {
//		return namae;
//	}
//	/**
//	 * @param namae
//	 *            the namae to set
//	 */		
//	public void setNamae(String namae) {
//		this.namae = namae;
//	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address
	 *            the address to set
	 */	
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the tel
	 */	
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the department
	 */	
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 * @return the rank
	 */	
	public String getRank() {
		return rank;
	}
	/**
	 * @param rank
	 *            the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * @return the gender
	 */	
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender
	 *            the gender to set
	 */	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the year
	 */	
	public String getYear() {
		return year;
	}
	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * @return the month
	 */	
	public String getMonth() {
		return month;
	}
	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * @return the day
	 */	
	public String getDay() {
		return day;
	}
	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	
	/**
	 * @return the getFemail
	 */	
	public String getFemail() {
		return femail;
	}
	/**
	 * @param femail
	 *            the femail to set
	 */
	public void setFemail(String femail) {
		this.femail = femail;
	}
	/**
	 * @return the getLemail
	 */	
	public String getLemail() {
		return lemail;
	}
	/**
	 * @param lemail
	 *            the lemail to set
	 */
	public void setLemail(String lemail) {
		this.lemail = lemail;
	}

	/**
	 * @return the kaid
	 */	
	public String getKaid() {
		return kaid;
	}
	/**
	 * @param kaid
	 *            the kaid to set
	 */
	public void setKaid(String kaid) {
		this.kaid = kaid;
	}
	
	/**
	 * @return the bigo
	 */	
	public String getBigo() {
		return bigo;
	}
	/**
	 * @param bigo
	 *            the bigo to set
	 */
	public void setBigo(String bigo) {
		this.bigo = bigo;
	}
	
	/**
	 * @return the USER_STATUS
	 */	
	public String getUSER_STATUS() {
		return USER_STATUS;
	}
	/**
	 * @param USER_STATUS
	 *            the USER_STATUS to set
	 */
	public void setUSER_STATUS(String USER_STATUS) {
		this.USER_STATUS = USER_STATUS;
	}
	
	/**
	 * @return the DEL_FLG
	 */
	public String getDEL_FLG() {
		return DEL_FLG;
	}
	/**
	 * @param DEL_FLG
	 *            the DEL_FLG to set
	 */
	public void setDEL_FLG(String DEL_FLG) {
		this.DEL_FLG = DEL_FLG;
	}

	/**
	 * @return the UPD_DT
	 */	
	public String getUPD_DT() {
		return UPD_DT;
	}
	/**
	 * @param UPD_DT
	 *            the UPD_DT to set
	 */
	public void setUPD_DT(String UPD_DT) {
		this.UPD_DT = UPD_DT;
	}

	/**
	 * @return the UPD_ID
	 */	
	public String getUPD_ID() {
		return UPD_ID;
	}
	/**
	 * @param UPD_ID
	 *            the UPD_ID to set
	 */
	public void setUPD_ID(String UPD_ID) {
		this.UPD_ID = UPD_ID;
	}

	/**
	 * @return the TRK_DT
	 */	
	public String getTRK_DT() {
		return TRK_DT;
	}	
	/**
	 * @param TRK_DT
	 *            the TRK_DT to set
	 */
	public void setTRK_DT(String TRK_DT) {
		this.TRK_DT = TRK_DT;
	}

	/**
	 * @return the TRK_ID
	 */	
	public String getTRK_ID() {
		return TRK_ID;
	}	
	/**
	 * @param TRK_ID
	 *            the TRK_ID to set
	 */
	public void setTRK_ID(String TRK_ID) {
		this.TRK_ID = TRK_ID;
	}
	public List<CodeTBLBean> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<CodeTBLBean> departmentList) {
		this.departmentList = departmentList;
	}
	public List<CodeTBLBean> getRankList() {
		return rankList;
	}
	public void setRankList(List<CodeTBLBean> rankList) {
		this.rankList = rankList;
	}
	public String getCcfname() {
		return ccfname;
	}
	public void setCcfname(String ccfname) {
		this.ccfname = ccfname;
	}
	public String getCclname() {
		return cclname;
	}
	public void setCclname(String cclname) {
		this.cclname = cclname;
	}
	public String getKatafname() {
		return katafname;
	}
	public void setKatafname(String katafname) {
		this.katafname = katafname;
	}
	public String getKatalname() {
		return katalname;
	}
	public void setKatalname(String katalname) {
		this.katalname = katalname;
	}
	

}
