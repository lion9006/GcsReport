package src.board.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import src.board.actionForm.BbsCommentForm;
import src.board.business.BbsCommentWriteBusiness;
import src.board.business.BbsWriteBusiness;
/**
 * コメント書くアクション
 * 
 * @author OH.YOUNGHWAN
 * @return SUCCESS 掲示板詳細画面に遷移
 *
 */



public class BbsCommentWriteAction implements Action, Preparable, ModelDriven<BbsCommentForm> {
static Logger logger = Logger.getLogger(BbsCommentForm.class);
	
	private BbsCommentForm comData;
	private String returnCode;
	
	@Override
	public String execute() throws Exception {
		try{
			BasicConfigurator.configure();
			logger.info("BbsCommentWriteAction[START]" + this.getClass().getName());
			
			BbsCommentWriteBusiness BbsCommentWriteBusiness = new BbsCommentWriteBusiness();
			returnCode = BbsCommentWriteBusiness.doBusiness(comData);
			
			logger.info("BbsCommentWriteAction[END]" + this.getClass().getName());
			return returnCode;
		}catch(Exception e){
			
			return "";
		}
		
	}
	
	@Override
	public BbsCommentForm getModel() {
		return comData;
	}
	
	@Override
	public void prepare() throws Exception {
		this.comData = new BbsCommentForm();
	}

}

