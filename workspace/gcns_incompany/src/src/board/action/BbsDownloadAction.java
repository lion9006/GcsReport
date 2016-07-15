package src.board.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.board.actionForm.BbsViewForm;
import src.board.business.BbsDownloadBusiness;
import src.board.business.BbsWriteBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BbsDownloadAction implements Action, Preparable, ModelDriven<BbsViewForm> {

	static Logger logger = Logger.getLogger(BbsWriteAccessAction.class);
	
	private BbsViewForm formData;
	private String returnCode;

	/**
	 * 
	 * 
	 * @return RESULT_ERROR エラー画面に遷移
	 * 
	 */
	@Override
	public String execute() throws Exception{
		BasicConfigurator.configure();
		logger.info("BbsDownloadAction[START]" + this.getClass().getName());
		
		BbsDownloadBusiness BbsDownloadBusiness = new BbsDownloadBusiness();
		returnCode = BbsDownloadBusiness.doBusiness(formData);
		
		logger.info("BbsDownloadAction[END]" + this.getClass().getName());
		return returnCode;		
	}
	
	@Override
	public BbsViewForm getModel() {
		return formData;
	}
	
	@Override
	public void prepare() throws Exception {
		this.formData = new BbsViewForm();
	}

}