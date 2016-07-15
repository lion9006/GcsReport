package src.member.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.member.actionForm.MemberListForm;
import src.member.business.MemberListBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 社員リスト初期画面アクション
 * 
 * @author KWON.JUYONG
 * 
 */

public class MemberListAction implements Action, Preparable, ModelDriven<MemberListForm> {

	static Logger logger = Logger.getLogger(MemberListAction.class);

	private MemberListForm formData;
	private String returnCode;
	
	/**
	 * 社員リストアクセスアクション<br>
	 * アクション開始ログ出力する。<br>
	 * アクション終了ログ出力する。<br>
	 * 
	 * @return ERROR ログイン画面に遷移
	 * @return SUCCESS 社員リスト画面に遷移
	 */	

	@Override
	public String execute() throws Exception {
		
		BasicConfigurator.configure();
		logger.info("MemberListAction[START]" + this.getClass().getName());
		
		MemberListBusiness memberListAccessBusiness = new MemberListBusiness();
		returnCode = memberListAccessBusiness.doBusiness(formData);

		logger.info("MemberListAction[END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public MemberListForm getModel() {
		return formData;
	}

	@Override
	public void prepare() throws Exception {
		this.formData = new MemberListForm();
	}
}
