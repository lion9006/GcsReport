package src.board.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import src.bean.BbsBean;
import src.board.actionForm.BbsUpdateForm;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.mybatis.SqlMapClient;
/**
 * 掲示板を修正するための掲示板内容をロードするアクション<br>
 * @author Yun.jaewon
 */
public class BbsUpdateViewBusiness implements BusinessInterface {
	private BbsUpdateForm form;

	/**
	 * @param formData
	 * @throws Exception
	 * @return RESULT_SUCCESS : bbs_updateページを出力
	 * @return RESULT_ERROR : errorページを出力
	 */
	public String doBusiness(ActionForm formData) {

		List<BbsBean> bbslist = new ArrayList<BbsBean>();
		SqlSession sqlSession = null;
		
		try{
			
			this.form=(BbsUpdateForm)formData;
			int value=form.getBBS_NUMBER();
			String searchOption1 = form.getSearchOption1();
			String searchOption2 = form.getSearchOption2();
			String searchInfo = form.getSearchInfo();
			String page = form.getPage();
			sqlSession = SqlMapClient.getSqlSession();
			
			/**
			 * value値による掲示板の内容の検索。
			 * */
			bbslist = sqlSession.selectList("BbsInfo.getBbsview",value); 
			form.setBbslist((ArrayList<BbsBean>)bbslist);
			form.setSearchOption1(searchOption1);
			form.setSearchOption2(searchOption2);
			form.setSearchInfo(searchInfo);
			form.setPage(page);
			
			System.out.println(searchOption1 + ": searchOption1");
			System.out.println(searchOption2 + ": searchOption2");
			System.out.println(searchInfo + ": searchInfo");
			System.out.println(page + " : page");
			
			if(bbslist.size() == 0){
				return RESULT_ERROR;
			}else{
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
	

