package src.board.business;

import org.apache.ibatis.session.SqlSession;

import src.board.actionForm.BbsDeleteForm;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.mybatis.SqlMapClient;
/**
 * 掲示板に削除するアクション<br>
 * @author Yun.jaewon
 */
public class BbsDeleteBusiness implements BusinessInterface{
	BbsDeleteForm form;
	/**
	 * @param formData
	 * @throws Exception
	 * @return RESULT_SUCCESS : 掲示板を削除してbbsListページを出力。
	 * @return RESULT_ERROR : errorページを出力。
	 */
	public String doBusiness(ActionForm formData) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try{
			this.form = (BbsDeleteForm) formData;
			sqlSession = SqlMapClient.getSqlSession();
			int BBS_NUMBER = form.getBBS_NUMBER();
			/**
			 * BBS_NUMBERによう掲示板削除。 DEL_FLG = 1
			 * */
			sqlSession.insert("BbsInfo.setDeleteBbs", BBS_NUMBER);
			sqlSession.commit();

			return RESULT_SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return RESULT_ERROR;
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}
	}
}
