package src.board.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;




import src.board.actionForm.BbsCommentForm;
import src.board.business.BbsCommentDeleteBusiness;
import src.board.business.BbsCommentWriteBusiness;
/**
 * コメント書くアクション
 * 
 * @author OH.YOUNGHWAN
 * @return SUCCESS 掲示板詳細画面に遷移
 *
 */
public class BbsCommentDeleteAction implements Action, Preparable, ModelDriven<BbsCommentForm> {
static Logger logger = Logger.getLogger(BbsCommentForm.class);
	
	private BbsCommentForm formData;
	private String returnCode;
	
	@Override
	public String execute() throws Exception {
		try{
			BasicConfigurator.configure();
			logger.info("BbsCommentDeleteAction[START]" + this.getClass().getName());
			
			BbsCommentDeleteBusiness BbsCommentDeleteBusiness = new BbsCommentDeleteBusiness();
			returnCode = BbsCommentDeleteBusiness.doBusiness(formData);
			
			logger.info("BbsCommentDeleteAction[END]" + this.getClass().getName());
			return returnCode;
		}catch(Exception e){
			
			return "";
		}
		
	}
	
	@Override
	public BbsCommentForm getModel() {
		return formData;
	}
	
	@Override
	public void prepare() throws Exception {
		this.formData = new BbsCommentForm();
	}

}

