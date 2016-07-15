package src.member.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.member.actionForm.MemberListSearchForm;
import src.member.business.MemberListSearchBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 検索した社員リスト初期画面アクション
 * 
 * @author KWON.JUYONG
 * 
 */
public class MemberListSearchAction implements Action, Preparable,
		ModelDriven<MemberListSearchForm> {

	static Logger logger = Logger.getLogger(MemberListSearchAction.class);

	private MemberListSearchForm formData;
	private String returnCode;

	/**
	 * 検索した社員リストアクセスアクション<br>
	 * アクション開始ログ出力する。<br>
	 * アクション終了ログ出力する。<br>
	 * 
	 * @return ERROR ログイン画面に遷移
	 * @return SUCCESS 検索した社員リスト画面に遷移
	 */

	@Override
	public String execute() throws Exception {
		BasicConfigurator.configure();
		logger.info("MemberListSearchAction[START]" + this.getClass().getName());

		MemberListSearchBusiness memberListSearchBusiness = new MemberListSearchBusiness();
		returnCode = memberListSearchBusiness.doBusiness(formData);

		logger.info("MemberListSearchAction[END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public MemberListSearchForm getModel() {
		return formData;
	}

	@Override
	public void prepare() throws Exception {
		this.formData = new MemberListSearchForm();
	}

}
