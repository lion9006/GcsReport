package src.manager.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.login.action.LoginAction;

import com.opensymphony.xwork2.Action;

/**
 * ユーザ番号アクション
 * @author コボムジン
 *
 */
public class UserIDAction implements Action{

	static Logger logger = Logger.getLogger(LoginAction.class);

	/**
	 * 
	 * @return SUCCESS 
	 */
	public String execute() throws Exception {
		BasicConfigurator.configure();
		logger.info("UserIDAction[INFO]  [START]" + this.getClass().getName());
		logger.info("UserIDAction[INFO]  [END]" + this.getClass().getName());
		return SUCCESS;
	}
}