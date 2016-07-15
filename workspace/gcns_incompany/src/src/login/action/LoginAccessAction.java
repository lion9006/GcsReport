package src.login.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.login.actionForm.LoginAccessForm;
import src.login.business.LoginAccessBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * ログイン初期画面アクション
 * 
 * @author キムウンジ
 * 
 */
public class LoginAccessAction implements Action, Preparable,
		ModelDriven<LoginAccessForm> {

	static Logger logger = Logger.getLogger(LoginAccessAction.class);

	private LoginAccessForm formData;
	private String returnCode;

	/**
	 * ログインアクセスアクション<br>
	 * アクション開始ログ出力する。<br>
	 * ログインユーザ確認ビジネスを呼び出す。 <br>
	 * アクション終了ログ出力する。<br>
	 * 
	 * @return ERROR ログイン画面に遷移
	 * @return SUCCESS メイン画面に遷移
	 */
	@Override
	public String execute() throws Exception {
		BasicConfigurator.configure();
		logger.info("LoginAccessAction[START]" + this.getClass().getName());

		LoginAccessBusiness loginAccessBusiness = new LoginAccessBusiness();
		returnCode = loginAccessBusiness.doBusiness(formData);

		logger.info("LoginAccessAction[END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public LoginAccessForm getModel() {
		return formData;
	}

	@Override
	public void prepare() throws Exception {
		this.formData = new LoginAccessForm();
	}

}
