package src.download.action;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.download.actionForm.DownloadListForm;
import src.download.business.DownloadListBusiness;
import src.member.action.MemberListSearchAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * ファイルリスト初期画面アクション
 * 
 * @author KWON.JUYONG
 * 
 */
public class DownloadListAction implements Action, Preparable,
		ModelDriven<DownloadListForm> {

	static Logger logger = Logger.getLogger(MemberListSearchAction.class);

	private DownloadListForm formData;
	private String returnCode;

	/**
	 * ダウンロードファイルリストアクセスアクション<br>
	 * アクション開始ログ出力する。<br>
	 * アクション終了ログ出力する。<br>
	 * 
	 * @return ERROR ログイン画面に遷移
	 * @return SUCCESS ダウンロード画面に遷移
	 */

	@Override
	public String execute() throws Exception {

		BasicConfigurator.configure();
		logger.info("DownloadListAction[START]" + this.getClass().getName());

		DownloadListBusiness downloadListBusiness = new DownloadListBusiness();
		returnCode = downloadListBusiness.doBusiness(formData);

		logger.info("DownloadListAction[END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public DownloadListForm getModel() {
		return formData;
	}

	@Override
	public void prepare() throws Exception {
		this.formData = new DownloadListForm();
	}
}
