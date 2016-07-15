package src.manager.action;

import java.io.Serializable;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.bean.UserIDTBLBean;
import src.manager.business.DuplicationCheckBusiness;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 重複チェックアクション
 * @author コボムジン
 *
 */
public class DuplicationCheckAction extends ActionSupport implements Serializable{
	static Logger logger = Logger.getLogger(UserIDAction.class);
	private UserIDTBLBean userIDTBLBean;
	private String USER_ID;

	
	public UserIDTBLBean getUserIDTBLBean() {
		return userIDTBLBean;
	}


	public void setUserIDTBLBean(UserIDTBLBean userIDTBLBean) {
		this.userIDTBLBean = userIDTBLBean;
	}


	public String getUSER_ID() {
		return USER_ID;
	}


	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	/**
	 * ユーザ番号重複確認するメソッド。
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String execute() throws Exception {
		BasicConfigurator.configure();
		logger.info("DupCheckAction[START]" + this.getClass().getName());
		DuplicationCheckBusiness duplicationCheckBusiness = new DuplicationCheckBusiness();
		userIDTBLBean=duplicationCheckBusiness.doBusiness(USER_ID);
		logger.info("DupCheckAction[END]" + this.getClass().getName());
		return SUCCESS;
	}
	
}
