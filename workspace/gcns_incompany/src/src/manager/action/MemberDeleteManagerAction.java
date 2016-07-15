package src.manager.action;

import org.apache.log4j.Logger;

import src.login.action.LoginAction;
import src.manager.actionForm.MemberManagerForm;
import src.manager.business.MemberDeleteManagerBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/**
 * 
 * @author ycj
 *
 */
public class MemberDeleteManagerAction implements Action, Preparable,
		ModelDriven<MemberManagerForm> {
	static Logger logger = Logger.getLogger(LoginAction.class);
	private String returnCode;
	private MemberManagerForm form;
	/**
	 * 社員番号を使用して削除するために使用するメソッド。
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	@Override
	public String execute() throws Exception {
		logger.info("[INFO]  [START]" + this.getClass().getName());
		MemberDeleteManagerBusiness deleteManager = new MemberDeleteManagerBusiness();
		returnCode = deleteManager.doBusiness(form);
		logger.info("[INFO]  [END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public MemberManagerForm getModel() {
		return form;
	}

	@Override
	public void prepare() throws Exception {
		this.form = new MemberManagerForm();
	}

}
