package src.manager.action;

import org.apache.log4j.Logger;

import src.manager.actionForm.MemberSearchManagerForm;
import src.manager.business.MemberSearchManagerBusiness;
import src.member.action.MemberListSearchAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/**
 * 社員の情報を検索するために利用するクラス。
 * @author ヤンチャンジン
 *
 */
public class MemberSearchManagerAction implements Action, Preparable, ModelDriven<MemberSearchManagerForm>  {
	private MemberSearchManagerForm form;
	private String returnCode;
	static Logger logger = Logger.getLogger(MemberListSearchAction.class);
	/**
	 * 検索した社員の情報をリストで出力するメソッド。
	 * @return　returnCode
	 */
	@Override
	public String execute() throws Exception {
		logger.info("MemberListSearchAction[START]" + this.getClass().getName());
		MemberSearchManagerBusiness searchBusiness = new MemberSearchManagerBusiness();
		returnCode = searchBusiness.doBusiness(form);
		logger.info("MemberListSearchAction[END]" + this.getClass().getName());
		return returnCode;
	}
	
	@Override
	public MemberSearchManagerForm getModel() {
		return form;
	}

	@Override
	public void prepare() throws Exception {
		this.form = new MemberSearchManagerForm();
	}

	

}
