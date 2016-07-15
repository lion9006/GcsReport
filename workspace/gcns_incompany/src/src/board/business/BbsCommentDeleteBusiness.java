package src.board.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import src.bean.CommentBean;
import src.board.actionForm.BbsCommentForm;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.mybatis.SqlMapClient;
/**
*  
 * コメント削除ビジネス
 * 
 * @author OH.YOUNGHWAN
 * 
 * @param COM_NUMBER 
 * @return SUCCESS 詳細画面に移動する
 * @return RESULT_ERROR エラー画面に移動する
 * 
 */
public class BbsCommentDeleteBusiness  implements BusinessInterface{
	private BbsCommentForm form;
	private List<CommentBean>commentlist= new ArrayList<CommentBean>();
	/**
	 * COM_NUMBERにようコメント削除。
	 * */

	public String doBusiness(ActionForm formData) {
		SqlSession sqlSession = null;
		try{
			this.form = (BbsCommentForm) formData;
			sqlSession = SqlMapClient.getSqlSession();
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
			int COM_NUMBER = form.getCom_number();
			int BBS_NUMBER=form.getBbs_number();
			
			 commentlist = sqlSession.selectList("BbsInfo.getCommentview",BBS_NUMBER);
			
				if(commentlist.size() == 0){
					return RESULT_ERROR;
				}else{
					sqlSession.insert("BbsInfo.setCommentDelete", COM_NUMBER);
					sqlSession.commit();
					System.out.println("END"+COM_NUMBER);
					return RESULT_SUCCESS;
				}
			
		}catch(Exception e){
			e.printStackTrace();
			return RESULT_ERROR;
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}
	}
}