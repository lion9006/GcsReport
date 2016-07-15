package src.manager.action;

import org.apache.log4j.Logger;

import src.login.action.LoginAction;
import src.manager.actionForm.MemberListManagerForm;
import src.manager.business.MemberListManagerBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 社員情報リストアクション<br>
 * 社員リスト
 * 
 * @author ヤンチャンジン
 * 
 */
public class MemberListManagerAction implements Action, Preparable, ModelDriven<MemberListManagerForm> {
	static Logger logger = Logger.getLogger(LoginAction.class);
	private MemberListManagerForm form;
	private String returnCode;

	/**
	 * 社員情報のリストもって来るsuccess　社員リストの画面を出力
	 * 
	 * @return　SUCCESS
	 */
	@Override
	public String execute() throws Exception {
		logger.info("[INFO]  [START]" + this.getClass().getName());
		MemberListManagerBusiness listManager = new MemberListManagerBusiness();
		returnCode = listManager.doBusiness(form);
		logger.info("[INFO]  [END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public MemberListManagerForm getModel() {
		return form;
	}

	@Override
	public void prepare() throws Exception {
		this.form = new MemberListManagerForm();
	}

}
