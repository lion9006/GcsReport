package src.manager.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import src.bean.CodeTBLBean;
import src.bean.UserTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.common.CodeSearch;
import src.manager.actionForm.MemberListManagerForm;
import src.mybatis.SqlMapClient;
/**
 * 加入させている社員の情報をリストで作るため利用するクラス。
 * @author ヤンチャンジン
 *
 */
public class MemberListManagerBusiness implements BusinessInterface {
	private MemberListManagerForm form;
	private List<UserTBLBean> userList = new ArrayList<UserTBLBean>();
	private SqlSession sqlSession;
	/**
	 * ホームページに加入されている社員の情報を全部出力してリストで作る。<br>
	 * 
	 * @param formData
	 * @return success
	 */
	@Override
	public String doBusiness(ActionForm formData) {
		try{
			this.form = (MemberListManagerForm)formData;
			
			sqlSession = SqlMapClient.getSqlSession();
			userList = sqlSession.selectList("Manager.selectAllUser");

			form.setCodeList((ArrayList<CodeTBLBean>)CodeSearch.getCodeInfoList(CodeSearch.SEARCH_CODE));
			if(userList == null){
				return RESULT_ERROR;
			}else{
				form.setUserList((ArrayList<UserTBLBean>)userList);
				return RESULT_SUCCESS;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}
		return RESULT_ERROR;
	}
}
