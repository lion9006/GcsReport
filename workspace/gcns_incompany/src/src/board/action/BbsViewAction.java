package src.board.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.board.actionForm.BbsViewForm;
import src.board.business.BbsViewBusiness;
import src.member.action.MemberListSearchAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 掲示板詳細アクション
 * 
 * @author OH.YOUNGHWAN
 *
 */
public class BbsViewAction  implements Action, Preparable,ModelDriven<BbsViewForm>{

	
	/**

		 * アクション開始ログ出力<br>
		 * アクション終了ログ出力<br>
		 * 
		 * @author OH.YOUNGHWAN
		 * @return SUCCESS 掲示板詳細画面に遷移
	 */	
   static Logger logger = Logger.getLogger(MemberListSearchAction.class);
	
	private String returnCode;
	private BbsViewForm formData;

	
	@Override
	public BbsViewForm getModel() {
		
		return formData ;
	}

	@Override
	public void prepare() throws Exception {
		this.formData=new BbsViewForm();
		
	}

	@Override
	public String execute() throws Exception {
		BasicConfigurator.configure();
		logger.info("BbsViewAction[start]"+this.getClass().getName());
	
		BbsViewBusiness BbsViewBusiness = new BbsViewBusiness();
		returnCode = BbsViewBusiness.doBusiness(formData);
		
	   logger.info("BbsViewAction[end]"+this.getClass().getName());
		

		return returnCode;

	}


		
	
}
