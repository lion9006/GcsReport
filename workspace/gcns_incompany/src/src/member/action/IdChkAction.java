package src.member.action;

import java.io.Serializable;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.bean.UserTBLBean;
import src.login.action.LoginAction;
import src.member.business.IdChkDuplicationBusiness;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 重複チェックアクション
 * @author 金ソンヒ
 *
 */
public class IdChkAction extends ActionSupport implements Serializable{
	static Logger logger = Logger.getLogger(LoginAction.class);
	private UserTBLBean userTBLBean;
	private String USER_ID;
	
	
	public UserTBLBean getUserTBLBean() {
		return userTBLBean;
	}

	public void setUserTBLBean(UserTBLBean userTBLBean) {
		this.userTBLBean = userTBLBean;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}	
	@Override
	public String execute() throws Exception {
		
		BasicConfigurator.configure();
		logger.info("IdChkAction[INFO]  [START]" + this.getClass().getName());
		
		IdChkDuplicationBusiness idChkDuplicationBusiness = new IdChkDuplicationBusiness();
		userTBLBean = idChkDuplicationBusiness.doBusiness(USER_ID);
		
		logger.info("IdChkAction[INFO]  [END]" + this.getClass().getName());
		return SUCCESS;
	}

}
