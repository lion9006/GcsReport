package src.login.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

/**
 * ログイン初期画面アクション
 * 
 * @author キムウンジ
 * 
 */
public class LoginAction implements Action {
	static Logger logger = Logger.getLogger(LoginAction.class);

	/**
	 * アクション開始ログ出力<br>
	 * アクション終了ログ出力<br>
	 * 
	 * @return SUCCESS ログイン画面に遷移
	 */
	@Override
	public String execute() throws Exception {
		BasicConfigurator.configure();
		logger.info("LoginAction[INFO]  [START]" + this.getClass().getName());
		logger.info("LoginAction[INFO]  [END]" + this.getClass().getName());
		return SUCCESS;
	}

}
