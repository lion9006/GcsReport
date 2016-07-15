package src.main.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.main.business.LogoutActionBusiness;

import com.opensymphony.xwork2.Action;

/**
 * ログアウト期画面アクション
 * 
 * @author キムウンジ
 * 
 */

public class LogoutAction implements Action {
	static Logger logger = Logger.getLogger(LogoutAction.class);
	private String returnCode;

	/**
	 * アクション開始ログ出力<br>
	 * アクション終了ログ出力<br>
	 * 
	 * @return SUCCESS sessionを消してログイン画面に遷移
	 */

	@Override
	public String execute() throws Exception {
		BasicConfigurator.configure();

		logger.info("LogoutAction[INFO]  [START]" + this.getClass().getName());

		LogoutActionBusiness logoutAccessBusiness = new LogoutActionBusiness();
		returnCode = logoutAccessBusiness.doBusiness(null);

		logger.info("LogoutAction[INFO]  [END]" + this.getClass().getName());
		return returnCode;
	}

}
