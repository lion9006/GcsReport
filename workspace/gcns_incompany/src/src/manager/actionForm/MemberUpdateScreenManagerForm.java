package src.manager.actionForm;

import java.util.ArrayList;
import java.util.List;

import src.bean.CodeTBLBean;
import src.bean.UserTBLBean;
import src.common.ActionForm;

public class MemberUpdateScreenManagerForm extends ActionForm {
	private String user_id;
	private UserTBLBean user_bean;
	private List<CodeTBLBean> department_code_list = new ArrayList<CodeTBLBean>();
	private List<CodeTBLBean> rank_code_list = new ArrayList<CodeTBLBean>();
	private List<CodeTBLBean> status_code_list = new ArrayList<CodeTBLBean>();
	/**
	 * 
	 * @return　user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	
	/**
	 * 
	 * @param user_id
	 * 				set　user_id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * 
	 * @return　user_bean
	 */
	public UserTBLBean getUser_bean() {
		return user_bean;
	}
	/**
	 * 
	 * @param user_bean
	 * 			set　user_bean
	 */
	public void setUser_bean(UserTBLBean user_bean) {
		this.user_bean = user_bean;
	}
	/**
	 * 
	 * @return department_code_list
	 */
	public List<CodeTBLBean> getDepartment_code_list() {
		return department_code_list;
	}
	/**
	 * 
	 * @param department_code_list
	 * 			set department_code_list
	 */
	public void setDepartment_code_list(List<CodeTBLBean> department_code_list) {
		this.department_code_list = department_code_list;
	}
	/**
	 * 
	 * @return rank_code_list
	 */
	public List<CodeTBLBean> getRank_code_list() {
		return rank_code_list;
	}
	/**
	 * 
	 * @param rank_code_list
	 * 			set rank_code_list
	 */
	public void setRank_code_list(List<CodeTBLBean> rank_code_list) {
		this.rank_code_list = rank_code_list;
	}
	/**
	 * 
	 * @return status_code_list
	 */
	public List<CodeTBLBean> getStatus_code_list() {
		return status_code_list;
	}
	/**
	 * 
	 * @param status_code_list
	 * 			set status_code_list
	 */
	public void setStatus_code_list(List<CodeTBLBean> status_code_list) {
		this.status_code_list = status_code_list;
	}
	
	
}
