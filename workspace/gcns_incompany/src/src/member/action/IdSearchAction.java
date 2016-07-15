package src.member.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.bean.CodeTBLBean;
import src.common.CodeSearch;

import com.opensymphony.xwork2.Action;

/**
 * ID検索初期画面アクション
 * 
 * @author KIM.SEONGHUI
 * 
 */ 

public class IdSearchAction implements Action{
	
	static Logger logger = Logger.getLogger(IdSearchAction.class); 

	List<CodeTBLBean> emailList;
	
	private List<String> email = new ArrayList<String>();
	
	/**
	 * アクション開始ログ出力<br>
	 * アクション終了ログ出力<br>
	 * 
	 * @return SUCCESS ID検索画面に遷移
	 */	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		logger.info("[INFO]  [START]" + this.getClass().getName());

		emailList = CodeSearch.getCodeInfoList(CodeSearch.MAIL_CODE);
		
		logger.info("[INFO]  [END]" + this.getClass().getName());
		return SUCCESS;
	}

	public List<CodeTBLBean> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<CodeTBLBean> emailList) {
		this.emailList = emailList;
	}
	
}