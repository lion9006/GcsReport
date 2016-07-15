package src.board.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.bean.CodeTBLBean;
import src.board.actionForm.BbsUpdateForm;
import src.board.business.BbsUpdateViewBusiness;
import src.common.CodeSearch;
import src.login.action.LoginAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/**
 * 掲示板に修正するための画面アクション。<br>
 * 
 * @author Yun.jaewon
 *
 */

public class BbsUpdateAction implements Action, Preparable ,ModelDriven<BbsUpdateForm>{
	static Logger logger = Logger.getLogger(LoginAction.class);
	public String returnCode;
	public BbsUpdateForm formData;
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
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		
		logger.info("BbsUpdateAction[INFO]  [START]" + this.getClass().getName());
		
		categoryList = CodeSearch.getCodeInfoList(CodeSearch.CATEGORY_CODE);
		
		BbsUpdateViewBusiness bbsUpdateViewBusiness = new BbsUpdateViewBusiness();
		returnCode = bbsUpdateViewBusiness.doBusiness(formData);

		logger.info("BbsUpdateAction[INFO]  [END]" + this.getClass().getName());
		return returnCode;
		
	}
	public List<CodeTBLBean> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CodeTBLBean> CategoryList) {
		this.categoryList = categoryList;
	}
	@Override
	public BbsUpdateForm getModel() {
		// TODO Auto-generated method stub
		return formData;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		this.formData=new BbsUpdateForm();
	}
}
