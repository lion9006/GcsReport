package src.manager.business;

import org.apache.ibatis.session.SqlSession;

import src.common.ActionForm;
import src.common.BusinessInterface;
import src.common.StringUtility;
import src.manager.actionForm.MemberUpdateManagerForm;
import src.mybatis.SqlMapClient;
/**
 * 管理者が社員の情報を修正するBusinessクラス。
 * @author ヤンチャンジン
 *
 */
public class MemberUpdateManagerBusiness implements BusinessInterface {
	/**
	 * 管理者が社員の情報をupdateする時利用。
	 * @param　formData
	 * @return　error　updateする社員番号がない時。<br>
	 * 		　　　success　updateが成功する時。
	 * 
	 */
	private MemberUpdateManagerForm form;
	private SqlSession sqlSession = null;
	@Override
	public String doBusiness(ActionForm formData) {
		try {
			form = (MemberUpdateManagerForm)formData;
			sqlSession = SqlMapClient.getSqlSession();
			if(form.getUser_password().equals("")){
				form.setUser_department(form.getUser_department());
				form.setUser_rank(form.getUser_rank());
				form.setUser_status(form.getUser_status());
				sqlSession.update("Manager.updateMember_nopassword",form);
				sqlSession.commit();
				
				return RESULT_SUCCESS;
			}else{
				form.setUser_password(StringUtility.getSHA256(form.getUser_password()));
				form.setUser_department(form.getUser_department());
				form.setUser_rank(form.getUser_rank());
				form.setUser_status(form.getUser_status());
				sqlSession.update("Manager.updateMemberpassword",form);
				sqlSession.commit();
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
