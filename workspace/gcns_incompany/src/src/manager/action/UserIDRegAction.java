package src.manager.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.manager.actionForm.UserIDForm;
import src.manager.business.InsertUserIDBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * ユーザ番号入力アクション
 * @author コボムジン
 *
 */
public class UserIDRegAction implements Action, Preparable,ModelDriven<UserIDForm>{
	static Logger logger = Logger.getLogger(UserIDAction.class);
	private UserIDForm formData;
	private String returnCode;
	private String nowSavedId;
	
	public UserIDForm getModel() {
		return formData;
	}

	public void prepare() throws Exception {
		this.formData = new UserIDForm();
	}
	/**
	 * 新しいユーザ番号を入力するメソッド。
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String execute() throws Exception {
		
		BasicConfigurator.configure();
		
		logger.info("UserIDAction[START]" + this.getClass().getName());
		
		nowSavedId=formData.getUSER_ID();

		InsertUserIDBusiness insertUseridBusiness = new InsertUserIDBusiness();
		returnCode = insertUseridBusiness.doBusiness(formData);

		logger.info("UserIDAction[END]" + this.getClass().getName());
		
		return returnCode;
	}

	public String getNowSavedId() {
		return nowSavedId;
	}

	public void setNowSavedId(String nowSavedId) {
		this.nowSavedId = nowSavedId;
	}
	
	
}
