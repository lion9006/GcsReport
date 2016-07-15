package src.member.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.member.actionForm.MemberJoinForm;
import src.member.business.MemberJoinBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 *会員登録機能画面アクション
 * @author KIM.SEONGHUI
 *
 */
public class MemberJoinAccessAction implements Action, Preparable,ModelDriven<MemberJoinForm> {

	/**
	 * 会員登録のためのアクション
	 * 
	 * @return SUCCESS ログイン画面に遷移
	 */
	
	static Logger logger = Logger.getLogger(MemberJoinAccessAction.class);
	
	private MemberJoinForm formData;
	private String returnCode;
	
	
	@Override
	public String execute() throws Exception {
		BasicConfigurator.configure();
		logger.info("MemberJoinAccessAction[START]" + this.getClass().getName());
		
		MemberJoinBusiness memberJoinBusiness = new MemberJoinBusiness();
		returnCode = memberJoinBusiness.doBusiness(formData);
		
		logger.info("MemberJoinAccessAction[END]" + this.getClass().getName());
		return returnCode;
	}
	
	@Override
	public MemberJoinForm getModel() {
		return formData;
	}
	
	@Override
	public void prepare() throws Exception {
		this.formData = new MemberJoinForm();
	}

}