package src.member.action;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.member.actionForm.IdSearchForm;
import src.member.business.IdSearchBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * ID検索機能画面アクション
 * 
 * @author KIM.SEONGHUI
 * 
 */
public class IdSearchAccessAction implements Action, Preparable,ModelDriven<IdSearchForm> {

	static Logger logger = Logger.getLogger(IdSearchAccessAction.class);
	
	/**
	 *社員情報を持って来る
	 * 
	 * @return SUCCESS ログイン画面に遷移
	 */
	
	private IdSearchForm formData;
	private String returnCode;
	
	@Override
	public String execute() throws Exception {
		BasicConfigurator.configure();
		logger.info("IdSearchAccessAction[START]" + this.getClass().getName());

		IdSearchBusiness idSearchBusiness = new IdSearchBusiness();
		returnCode = idSearchBusiness.doBusiness(formData);

		logger.info("IdSearchAccessAction[END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public IdSearchForm getModel() {
		return formData;
	}

	@Override
	public void prepare() throws Exception {
		this.formData = new IdSearchForm();
	}

}
