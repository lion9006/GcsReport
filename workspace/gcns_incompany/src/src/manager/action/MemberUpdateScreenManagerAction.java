package src.manager.action;

import org.apache.log4j.Logger;

import src.login.action.LoginAction;
import src.manager.actionForm.MemberUpdateScreenManagerForm;
import src.manager.business.MemberUpdateScreenManagerBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/**
 * 修正の画面を出力するために利用するクラス。
 * @author ヤンチャンジン
 *
 */
public class MemberUpdateScreenManagerAction implements Action, Preparable,
		ModelDriven<MemberUpdateScreenManagerForm> {
	static Logger logger = Logger.getLogger(LoginAction.class);
	private String returnCode;
	private MemberUpdateScreenManagerForm form;
	/**
	 * 画面を出力するために利用するメソッド。
	 * @return　returnCode
	 */
	@Override
	public String execute() throws Exception {
		logger.info("[INFO]  [START]" + this.getClass().getName());
		MemberUpdateScreenManagerBusiness screenBusiness = new MemberUpdateScreenManagerBusiness();
		returnCode = screenBusiness.doBusiness(form);
		logger.info("[INFO]  [END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public MemberUpdateScreenManagerForm getModel() {
		return form;
	}

	@Override
	public void prepare() throws Exception {
		this.form = new MemberUpdateScreenManagerForm();
	}

}
