package src.manager.action;

import org.apache.log4j.Logger;

import src.manager.actionForm.MemberUpdateManagerForm;
import src.manager.business.MemberUpdateManagerBusiness;
import src.member.action.MemberListSearchAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 管理者が社員の情報を変えるために利用するクラス。
 * 
 * @author ヤンチャンジン
 * 
 */
public class MemberUpdateManagerAction implements Action, Preparable,
		ModelDriven<MemberUpdateManagerForm> {
	private String returnCode;
	private MemberUpdateManagerForm form;
	static Logger logger = Logger.getLogger(MemberListSearchAction.class);
	/**
	 * 社員の情報を変えるメソッド。
	 * 
	 * @return　returnCode
	 */

	@Override
	public String execute() throws Exception {
		logger.info("MemberListSearchAction[START]" + this.getClass().getName());
		MemberUpdateManagerBusiness updateBusiness = new MemberUpdateManagerBusiness();
		returnCode = updateBusiness.doBusiness(form);
		logger.info("MemberListSearchAction[END]" + this.getClass().getName());
		
		return returnCode;
	}

	@Override
	public MemberUpdateManagerForm getModel() {
		return form;
	}

	@Override
	public void prepare() throws Exception {
		this.form = new MemberUpdateManagerForm();
	}

}
