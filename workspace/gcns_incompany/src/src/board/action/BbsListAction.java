package src.board.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.board.actionForm.BbsListForm;
import src.board.business.BbsListBusiness;
import src.member.action.MemberListSearchAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


/**
 * 掲示板リスト初期仮面アクション
 * 
 * @author MOON.BYEONGGEUN
 */
public class BbsListAction implements Action, Preparable,ModelDriven<BbsListForm> {
	
	
	static Logger logger = Logger.getLogger(MemberListSearchAction.class);
	
	private BbsListForm formData;
	private String returnCode;
	
	/**
	 * アクション開始ログ出力<br>
	 * アクション終了ログ出力<br>
	 * 
	 * @return ERROR ログイン画面に遷移
	 * @return SUCCESS 掲示板リスト画面に遷移
	 * 
	 */
	
	@Override
	public BbsListForm getModel() {

		return formData;
	}

	@Override
	public void prepare() throws Exception {

		this.formData=new BbsListForm();
		
	}

	@Override
	public String execute() throws Exception {
		
		BasicConfigurator.configure();
		logger.info("BbsListAction[start]"+this.getClass().getName());
		
		BbsListBusiness bbsListBusiness = new BbsListBusiness();
		returnCode = bbsListBusiness.doBusiness(formData);
		
		logger.info("BbsListAction[end]"+this.getClass().getName());
		

		return returnCode;
	}
	
	
}
