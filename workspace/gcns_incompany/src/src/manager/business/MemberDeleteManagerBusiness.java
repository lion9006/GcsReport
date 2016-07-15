package src.manager.business;

import org.apache.ibatis.session.SqlSession;

import src.common.ActionForm;
import src.common.BusinessInterface;
import src.manager.actionForm.MemberManagerForm;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;
/**
 * 
 * @author ycj
 *
 */
public class MemberDeleteManagerBusiness implements BusinessInterface{
	private MemberManagerForm form;
	private SqlSession sqlSession;
	/**
	 * 社員番号を利用して削除する。<br>
	 * 削除したい人の社員番号を利用する。<br>
	 * @param　formData
	 * @return　error 削除したい人の社員番号がない時。<br>
	 *         success　社員の情報を削除する。
	 * 
	 */
	@Override
	public String doBusiness(ActionForm formData) {
		try{
			this.form = (MemberManagerForm)formData;
			System.out.println("deleteId : "+form.getUser_id());
			ActionContext con = ActionContext.getContext();
			sqlSession = SqlMapClient.getSqlSession();
			sqlSession.update("Manager.deleteMember",form.getUser_id());
			sqlSession.commit();
			return RESULT_SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			SqlMapClient.closeSession(sqlSession);
		}
		return RESULT_ERROR;
	}

}
