package src.board.business;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import src.bean.BbsBean;
import src.bean.CodeTBLBean;
import src.board.actionForm.BbsListForm;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.common.CodeSearch;
import src.mybatis.SqlMapClient;
/**
 * 
 * @author MOON.BYEONGGEUN
 *
 */
public class BbsListBusiness implements BusinessInterface{

	private BbsListForm form;
	
	/**
	 * 掲示板リストビジネス<br>
	 * リストを照会<br>
	 * 
	 * @param formData
	 * 
	 * @return "success"
	 */
	public String doBusiness(ActionForm formData) {
		
		List<BbsBean> count = new ArrayList<BbsBean>();
		List<BbsBean> list = new ArrayList<BbsBean>();
		int pageNum;
		int page;
		int pageLen;
		int beforePage;
		int pageBlock;
		int nextPage;
		int startPage;
		int endPage;
		SqlSession sqlSession = null;
		String searchOption1;
		String searchOption2;
		String searchInfo;
		sqlSession = SqlMapClient.getSqlSession();
		
		try{
			this.form=(BbsListForm)formData;

			page=Integer.parseInt(form.getPage());
			pageNum=(Integer.parseInt(form.getPage())-1)*20;
			searchOption1 = form.getSearchOption1();
			searchOption2 = form.getSearchOption2();
			searchInfo = form.getSearchInfo();
			//code set
			form.setCodeList1((ArrayList<CodeTBLBean>)CodeSearch.getCodeInfoList(CodeSearch.CATEGORY_CODE));
			form.setCodeList2((ArrayList<CodeTBLBean>)CodeSearch.getCodeInfoList(CodeSearch.BBSSEARCH_CODE));
			if(searchInfo==null||searchInfo.equals("")){
				//リスト
				list = sqlSession.selectList("BbsInfo.getBbsListPage",pageNum);
				count= sqlSession.selectList("BbsInfo.getBbsListCount");
			}else{
				//検索する
				if(searchOption1.equals("1")&&searchOption2.equals("全体")){
					//all categorry all option
					Map<String, String> map = new HashMap<String, String>();
					map.put("value", searchInfo);
					map.put("page", pageNum + "");
					
					list = sqlSession.selectList("BbsInfo.getAllSearchList", map);
					count = sqlSession.selectList("BbsInfo.getAllSearchCount", map);
					
				}else if(searchOption1.equals("1")){
					//all category option
					Map<String, String> map = new HashMap<String, String>();
					map.put("option2", searchOption2);
					map.put("value", searchInfo);
					map.put("page", pageNum + "");

					list = sqlSession.selectList("BbsInfo.getAllCategorySearchList", map);
					count = sqlSession.selectList("BbsInfo.getAllCategorySearchCount", map);
				}else if(searchOption2.equals("全体")){
					//category all option
					Map<String, String> map = new HashMap<String, String>();
					map.put("option1", searchOption1);
					map.put("value", searchInfo);
					map.put("page", pageNum + "");

					list = sqlSession.selectList("BbsInfo.getAllOptionSearchList", map);
					count = sqlSession.selectList("BbsInfo.getAllOptionSearchCount", map);

				}else{
					//category option
					Map<String, String> map = new HashMap<String, String>();
					map.put("option1", searchOption1);
					map.put("option2", searchOption2);
					map.put("value", searchInfo);
					map.put("page", pageNum + "");

					list = sqlSession.selectList("BbsInfo.getDoubleOptionSearchList", map);
					count = sqlSession.selectList("BbsInfo.getDoubleOptionSearchCount", map);
					
				}
				
			}
			
			
			if(count.size()==0){
				//データがない時
				form.setSearchInfo(searchInfo);
				form.setSearchOption1(searchOption1);
				form.setSearchOption2(searchOption2);
				return RESULT_SUCCESS;
			}
			
			//ページングのカウント
			if(count.size()%20==0){
				pageLen=count.size()/20;
			}else{
				pageLen=(count.size()/20)+1;
			}
			
			pageBlock=10;
			startPage=((page-1)/pageBlock)*pageBlock+1;
			endPage = startPage + pageBlock - 1;
			
			beforePage=startPage-1;
			nextPage=startPage+pageBlock;
			
			
			
			if(endPage>pageLen){
				endPage=pageLen;
				nextPage=0;
			}
			//ページングのリスト
			for(int i=startPage;endPage>=i;i++){
				form.getPagingList().add(i);
			}
			
			//データをフォームで設定する
			
			form.setBeforePage(beforePage);
			form.setNextPage(nextPage);
			form.setList((ArrayList<BbsBean>) list);
			form.setSearchInfo(searchInfo);
			form.setSearchOption1(searchOption1);
			form.setSearchOption2(searchOption2);
			
			return RESULT_SUCCESS;
			
		}catch(Exception e){
			e.printStackTrace();
			return RESULT_ERROR;
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}

		
		
		
	}

	
}
