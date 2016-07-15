package src.manager.business;

import org.apache.ibatis.session.SqlSession;

import src.bean.UserIDTBLBean;
import src.mybatis.SqlMapClient;

public class DuplicationCheckBusiness {
	private SqlSession sqlSession = null;
	/**
	 * ユーザ番号重複確認ビジネス<br>
	 * 入力ユーザ番号とDBに存在したユーザ番号を比較する。<br>
	 * 一致しない場合、DBにユーザ番号を貯蔵する。<br>
	 * 一致する場合、他のユーザ番号を再入力する。 <br>
	 * 
	 * @param USER_ID
	 * @return "error" DB上にユーザ番号が存在した場合。<br>
	 * 		   "success" DB上にユーザ番号が存在しなかった場合。
	 */
	
	public UserIDTBLBean doBusiness(String USER_ID){
		UserIDTBLBean userIDTBLBean=null;
		try {
			sqlSession = SqlMapClient.getSqlSession();

			userIDTBLBean=sqlSession.selectOne("Test.DupCheck", USER_ID); 
	
			return userIDTBLBean;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}
		return userIDTBLBean;
	}
}
	
