package src.member.business;

import org.apache.ibatis.session.SqlSession;

import src.bean.UserTBLBean;
import src.mybatis.SqlMapClient;

public class IdChkDuplicationBusiness {
	private SqlSession sqlSession = null;

	public UserTBLBean doBusiness(String USER_ID){
		UserTBLBean userTBLBean=null;
		
		try {
		    System.out.println(USER_ID);
			sqlSession = SqlMapClient.getSqlSession();
			userTBLBean=sqlSession.selectOne("Test.DupCheck1", USER_ID);
			
			
			
			return userTBLBean;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}
		return userTBLBean;
	}
}
	
//11111111
//1111111
//111111