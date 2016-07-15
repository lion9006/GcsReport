package src.download.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.download.actionForm.DownloadListSearchForm;
import src.download.business.DownloadListSearchBusiness;
import src.member.action.MemberListSearchAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 検索したファイルリスト初期画面アクション
 * 
 * @author KWON.JUYONG
 * 
 */
public class DownloadListSearchAction implements Action, Preparable,
		ModelDriven<DownloadListSearchForm> {

	static Logger logger = Logger.getLogger(MemberListSearchAction.class);

	private DownloadListSearchForm formData;
	private String returnCode;

	/**
	 * 検索したダウンロードファイルリストアクセスアクション<br>
	 * アクション開始ログ出力する。<br>
	 * アクション終了ログ出力する。<br>
	 * 
	 * @return ERROR ログイン画面に遷移
	 * @return SUCCESS 検索したダウンロード画面に遷移
	 */

	@Override
	public String execute() throws Exception {

		BasicConfigurator.configure();
		logger.info("DownloadListSearchAction[START]" + this.getClass().getName());

		DownloadListSearchBusiness downloadListSearchBusiness = new DownloadListSearchBusiness();
		returnCode = downloadListSearchBusiness.doBusiness(formData);

		logger.info("DownloadListSearchAction[END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public DownloadListSearchForm getModel() {
		return formData;
	}

	@Override
	public void prepare() throws Exception {
		this.formData = new DownloadListSearchForm();
	}

}
