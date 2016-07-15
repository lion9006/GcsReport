package src.board.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

import src.bean.CodeTBLBean;
import src.common.CodeSearch;
import src.login.action.LoginAction;

/**
 * 作成画面を表示する
 * 
 * @author Park.Jaedeok
 *  
 */
public class BbsWriteAction implements Action{
	static Logger logger = Logger.getLogger(LoginAction.class);

	List<CodeTBLBean> categoryList;	
	private List<String> category = new ArrayList<String>();
	
	/**
	 * 作成アクセスアクション<br>
	 * アクション開始ログ出力する。<br>
	 * カテゴリーロードビジネスを呼び出す。 <br>
	 * アクション終了ログ出力する。<br>
	 * 
	 * @return SUCCESS 作成画面に遷移
	 * @return ERROR エラー画面に遷移
	 * 
	 */
	@Override
	public String execute(){
		
		BasicConfigurator.configure();
		logger.info("BbsWriteAction[INFO]  [START]" + this.getClass().getName());
		
		categoryList = CodeSearch.getCodeInfoList(CodeSearch.CATEGORY_CODE);
		
		logger.info("BbsWriteAction[INFO]  [END]" + this.getClass().getName());
		return SUCCESS;
	}
	
	public List<CodeTBLBean> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CodeTBLBean> CategoryList) {
		this.categoryList = categoryList;
	}
}
