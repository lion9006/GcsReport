package src.manager.business;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import src.common.ActionForm;
import src.common.BusinessInterface;
import src.manager.actionForm.UserIDForm;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;

public class InsertUserIDBusiness implements BusinessInterface {
	private UserIDForm form;
	private SqlSession sqlSession = null;
	/**
	 * 新しいユーザ番号を入力ビジネス
	 * ユーザ番号重複確認を終わってDBにユーザ番号を入力する
	 * 
	 * @param formData
	 * @return "success" DBにユーザ番号を入力した場合。<br>
	 * 			"error" DB上にユーザ番号入力を失敗した場合。
	 */
	@Override
	public String doBusiness(ActionForm formData) {
		try {

			this.form = (UserIDForm)formData;
			ActionContext con = ActionContext.getContext();
			Map<String, Object> session = con.getSession();
			sqlSession = SqlMapClient.getSqlSession();
			
			String USER_ID;
			String TRK_ID;
			String UPD_ID;
			String DEL_FLG;
			USER_ID=form.getUSER_ID();
			TRK_ID=(String)session.get("id");
			UPD_ID=(String)session.get("id");
			DEL_FLG="0";
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("USER_ID",USER_ID);
			map.put("TRK_ID",TRK_ID);
			map.put("UPD_ID", UPD_ID);
			map.put("DEL_FLG", DEL_FLG);
			
			sqlSession.insert("Test.InsertUserID", map);
			sqlSession.insert("Test.IDJOIN1", map);
			sqlSession.commit();	
		
			return RESULT_SUCCESS;			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}
		return RESULT_ERROR;
	}
	}

	

