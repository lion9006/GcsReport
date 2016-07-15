package src.main.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

public class HomeAction implements Action {
	static Logger logger = Logger.getLogger(HomeAction.class);

	/**
	 * アクション開始ログ出力<br>
	 * アクション終了ログ出力<br>
	 * 
	 * @return SUCCESS ログイン画面に遷移
	 */
	@Override
	public String execute() throws Exception {
		BasicConfigurator.configure();
		logger.info("HomeAction[INFO]  [START]" + this.getClass().getName());
		logger.info("HomeAction[INFO]  [END]" + this.getClass().getName());
		return SUCCESS;
	}

}
