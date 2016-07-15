package src.main.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.login.actionForm.LoginAccessForm;
import src.main.business.MainBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * メイン画面にアクション
 * 
 * @author キムソンヒ
 * 
 */
public class MainAction implements Action, Preparable,
ModelDriven<LoginAccessForm> {
	static Logger logger = Logger.getLogger(MainAction.class);
	private LoginAccessForm formData;
	private String returnCode;
	
	/**
	 * アクション開始ログ出力<br>
	 * アクション終了ログ出力<br>
	 * 
	 * @return SUCCESS 修正する画面でcancelボタン押す時、メイン画面に遷移
	 */
	@Override
	public String execute() throws Exception {
		BasicConfigurator.configure();

		logger.info("MainAction[INFO]  [START]" + this.getClass().getName());

		MainBusiness mainBusiness = new MainBusiness();
		returnCode = mainBusiness.doBusiness(formData);

		logger.info("MainAction[INFO]  [END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public LoginAccessForm getModel() {
		// TODO Auto-generated method stub
		return formData;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		this.formData = new LoginAccessForm();
	}

}
