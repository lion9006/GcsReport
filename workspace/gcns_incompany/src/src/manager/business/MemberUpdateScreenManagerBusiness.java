package src.manager.business;

import org.apache.ibatis.session.SqlSession;

import src.bean.UserTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.common.CodeSearch;
import src.manager.actionForm.MemberUpdateScreenManagerForm;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;
/**
 * 社員の情報を持ってDB上からくれるクラス。
 * @author ヤンチャンジン
 *
 */
public class MemberUpdateScreenManagerBusiness implements BusinessInterface {
	private MemberUpdateScreenManagerForm form = null;
	private UserTBLBean user_bean;
	SqlSession sqlSession;
	/**
	 * DBで社員の情報を持って修正画面を出力。
	 * @return　RESULT_ERROR　DBでuserの情報がない時。<br>
	 * 			RESULT_SUCCESS　DBでuserの情報がある時。
	 */
	@Override
	public String doBusiness(ActionForm formData) {
		try {
			form = (MemberUpdateScreenManagerForm) formData;
			ActionContext con = ActionContext.getContext();
			sqlSession = SqlMapClient.getSqlSession();
			user_bean = sqlSession.selectOne("Manager.selectOneUser",form.getUser_id());
			if(user_bean==null){
				return RESULT_ERROR;
			}else{
				form.setUser_bean(user_bean);
				form.setDepartment_code_list(CodeSearch.getCodeInfoList(CodeSearch.DIVISIOM_CODE));
				form.setRank_code_list(CodeSearch.getCodeInfoList(CodeSearch.POSION_CODE));
				form.setStatus_code_list(CodeSearch.getCodeInfoList(CodeSearch.STATUS_CODE));
				return RESULT_SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			SqlMapClient.closeSession(sqlSession);
		}
		
		return RESULT_ERROR;
	}

}
