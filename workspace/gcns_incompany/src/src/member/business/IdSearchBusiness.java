package src.member.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import src.bean.UserTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.member.actionForm.IdSearchForm;
import src.mybatis.SqlMapClient;
/**
 * メールを利用して、ユーザIDを探すために使用するクラス。
 * @author KIM.SEONGHUI
 *
 */

public class IdSearchBusiness implements BusinessInterface {
	private IdSearchForm form;
	SqlSession sqlSession = null;
	
	/**
	 *　社員ID検索ビジネス
	 *　メールを利用してDBで社員IDを照会。
	 *　一致する場合、alertウィンドウで社員番号を表示した後、ログイン画面に遷移する。 <br>
	 *　失敗する場合、alertウィンドウで表示した後、検索画面に遷移する。 <br>
	 * 
	 *　@param　formData
	 *　@return　error DB上に該当メールがない場合。<br>
	 *　			 success 社員番号持って来る場合。
	 */
	
	@Override
	public String doBusiness(ActionForm formData) {
		// TODO Auto-generated method stub
		String result = RESULT_ERROR;
		List<UserTBLBean> list=new ArrayList<UserTBLBean>();
		try {

			this.form = (IdSearchForm) formData;
			sqlSession = SqlMapClient.getSqlSession();
			list = sqlSession.selectList("Test.getUserId",form.getFemail()+"@"+form.getLemail());  
			
			if (list.size() == 0) {	
				result = RESULT_ERROR;
			} else {
				System.out.println(list.size());
				form.setList((ArrayList<UserTBLBean>)list);
				result = RESULT_SUCCESS;			
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			
			SqlMapClient.closeSession(sqlSession);
		}
		return result;
	}
}
