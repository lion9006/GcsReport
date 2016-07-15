package src.board.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.board.actionForm.BbsDeleteForm;
import src.board.actionForm.BbsUpdateForm;
import src.board.business.BbsDeleteBusiness;
import src.board.business.BbsUpdateBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 掲示板に削除するアクション<br>
 * 
 * @author Yun.jaewon
 *
 */
public class BbsDeleteAction implements Action, Preparable, ModelDriven<BbsDeleteForm>{
	static Logger logger = Logger.getLogger(BbsUpdateAccessAction.class);
	
	private BbsDeleteForm formData;
	private String returnCode;
	/**
	 * アクション開始ログ出力<br>
	 * アクション終了ログ出力<br>
	 * 
	 * @param BBS_NUMBERページ交番
	 * @return returnCodeがSUCCESSしたら一覧画面に戻る,ERRORしたらERRORページへ。
	 * @throws SQLException
	 */	
	
	public String execute() throws Exception{
		BasicConfigurator.configure();
		logger.info("BbsWriteAccessAction[START]" + this.getClass().getName());
		
		System.out.println("DeleteAction");
		BbsDeleteBusiness bbsDeleteBusiness = new BbsDeleteBusiness();
		returnCode = bbsDeleteBusiness.doBusiness(formData);
		
		logger.info("BbsWriteAccessAction[END]" + this.getClass().getName());
		return returnCode;
		
	}
	@Override
	public BbsDeleteForm getModel() {
		return formData;
	}
	
	@Override
	public void prepare() throws Exception {
		this.formData = new BbsDeleteForm();
	}
}
