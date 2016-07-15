package src.board.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.bean.CodeTBLBean;
import src.board.actionForm.BbsUpdateForm;
import src.board.business.BbsUpdateBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/**
 * 掲示板に修正アクション
 * 
 * @author Yun.jaewon
 *
 */
public class BbsUpdateAccessAction implements Action, Preparable, ModelDriven<BbsUpdateForm> {

	static Logger logger = Logger.getLogger(BbsUpdateAccessAction.class);
	
	private BbsUpdateForm formData;
	private String returnCode;
	List<CodeTBLBean> categoryList;
	private List<String> category = new ArrayList<String>();
	/**
	 * アクション開始ログ出力<br>
	 * アクション終了ログ出力<br>
	 * 
	 * @author Yun.jaewon
	 * 
	 * @param BBS_NUMBER ページ交番
	 * @param BBS_CATEGORY カテゴリー
	 * @param BBS_TITLE 題目
	 * @param BBS_CONTENT 内容
	 * @param BBS_FNAME ファイル名前
	 * @param BBS_FDATA ファイルデータ
	 * @param TRK_ID 登録者
	 * 
	 * @return SUCCESS 掲示板画面に戻る
	 * @throws SQLException
	 */	
	@Override
	public String execute() throws Exception {
		BasicConfigurator.configure();
		logger.info("BbsWriteAccessAction[START]" + this.getClass().getName());

		BbsUpdateBusiness BbsUpdateBusiness = new BbsUpdateBusiness();
		returnCode = BbsUpdateBusiness.doBusiness(formData);
		
		logger.info("BbsWriteAccessAction[END]" + this.getClass().getName());
		return returnCode;
	}

	@Override
	public BbsUpdateForm getModel() {
		return formData;
	}
	
	@Override
	public void prepare() throws Exception {
		this.formData = new BbsUpdateForm();
	}
	public List<CodeTBLBean> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CodeTBLBean> CategoryList) {
		this.categoryList = categoryList;
	}

}