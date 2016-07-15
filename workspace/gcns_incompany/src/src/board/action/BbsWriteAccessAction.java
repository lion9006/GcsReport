package src.board.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.board.actionForm.BbsWriteForm;
import src.board.business.BbsWriteBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 掲示板に作成するアクション
 * 
 * @author Park.Jaedeok
 *  
 */
public class BbsWriteAccessAction implements Action, Preparable, ModelDriven<BbsWriteForm> {

	static Logger logger = Logger.getLogger(BbsWriteAccessAction.class);
	
	private BbsWriteForm formData;
	private String returnCode;

	/**
	 * 作成アクセスアクション<br>
	 * アクション開始ログ出力する。<br>
	 * 作成ビジネスを呼び出す。 <br>
	 * アクション終了ログ出力する。<br>
	 * 
	 * @return SUCCESS 一覧画面に遷移
	 * @return RESULT_ERROR エラー画面に遷移
	 * 
	 */
	@Override
	public String execute(){
		BasicConfigurator.configure();
		logger.info("BbsWriteAccessAction[START]" + this.getClass().getName());
		
		BbsWriteBusiness BbsWriteBusiness = new BbsWriteBusiness();
		returnCode = BbsWriteBusiness.doBusiness(formData);
		
		logger.info("BbsWriteAccessAction[END]" + this.getClass().getName());
		return returnCode;		
	}
	
	@Override
	public BbsWriteForm getModel() {
		return formData;
	}
	
	@Override
	public void prepare() throws Exception {
		this.formData = new BbsWriteForm();
	}

}