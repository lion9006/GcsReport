package src.download.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.download.actionForm.DownloadForm;
import src.download.business.DownloadBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * ファイル ダウンロード
 * 
 * @author KWON.JUYONG
 * 
 */
public class DownloadAction implements Action, Preparable,
		ModelDriven<DownloadForm> {

	static Logger logger = Logger.getLogger(DownloadAction.class);

	private DownloadForm formData;
	private String returnCode;

	/**
	 * 
	 * ファイル名クリック時ダウンロード
	 * 
	 * 
	 */

	@Override
	public String execute() throws Exception {

		BasicConfigurator.configure();
		logger.info("DownloadAction[START]" + this.getClass().getName());

		DownloadBusiness downloadBusiness = new DownloadBusiness();
		returnCode = downloadBusiness.doBusiness(formData);

		logger.info("DownloadAction[END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public DownloadForm getModel() {
		return formData;
	}

	@Override
	public void prepare() throws Exception {
		this.formData = new DownloadForm();
	}

}
