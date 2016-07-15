package src.error;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

public class ErrorAction  implements Action {
	static Logger logger = Logger.getLogger(ErrorAction.class);

	/**
	 * 
	 * @return SUCCESS エラー画面に遷移
	 */
	@Override
	public String execute() throws Exception {
		BasicConfigurator.configure();
		logger.info("ErrorAction[INFO]  [START]" + this.getClass().getName());
		logger.info("ErrorAction[INFO]  [END]" + this.getClass().getName());
		return SUCCESS;
	}

}

