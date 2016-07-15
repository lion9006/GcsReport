package src.board.business;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import src.board.actionForm.BbsCommentForm;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;
/**
*  
 * コメント書くビジネス
 * 
 * @author OH.YOUNGHWAN
 * 
 * @param BBS_NUMBER カテゴリー
 * @param COM_CONTENT 内容
 * @param TRK_ID 登録者
 * @return SUCCESS 詳細画面に移動する
 * @return RESULT_ERROR エラー画面に移動する
 * 
 */

public class BbsCommentWriteBusiness  implements BusinessInterface{
	private BbsCommentForm form;
	SqlSession sqlSession = null;

	public String doBusiness(ActionForm comData) {
		// TODO Auto-generated method stub
				try{
					this.form = (BbsCommentForm)comData;
					
					ActionContext con = ActionContext.getContext();
					Map<String, Object>session = con.getSession();
					sqlSession = SqlMapClient.getSqlSession();
					
					String UPD_ID;
					String TRK_ID;
					String COM_CONTENT;
					int BBS_NUMBER;
					
					//
					String searchOption1 = form.getSearchOption1();
					String searchOption2 = form.getSearchOption2();
					String searchInfo = form.getSearchInfo();
					String page = form.getPage();
					form.setSearchOption1(searchOption1);
					form.setSearchOption2(searchOption2);
					form.setSearchInfo(searchInfo);
					form.setPage(page);
					//
					
					System.out.println(searchOption1+searchOption2+searchInfo+page);
					
					TRK_ID=(String)session.get("id");
					UPD_ID= (String)session.get("id");
					COM_CONTENT = form.getCom_content();
					BBS_NUMBER = form.getBbs_number();
					
					Map<String, Object> map = new HashMap<String, Object>();
					
					map.put("COM_CONTENT", COM_CONTENT);
					map.put("BBS_NUMBER", BBS_NUMBER);
					map.put("TRK_ID", TRK_ID);
					
					sqlSession.insert("BbsInfo.setCommentWrite", map);
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


