package src.member.business;

/**
 * 
 * @author KWON.JUYONG
 *
 */
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import src.bean.CodeTBLBean;
import src.bean.UserTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.common.CodeSearch;
import src.member.actionForm.MemberListSearchForm;
import src.mybatis.SqlMapClient;

public class MemberListSearchBusiness implements BusinessInterface {

	private MemberListSearchForm form;
	private List<UserTBLBean> list = new ArrayList<UserTBLBean>();	// 検索した社員リストのlimit
	private List<UserTBLBean> count = new ArrayList<UserTBLBean>();	// 検索した社員リストのtotal

	SqlSession sqlSession = null;

	/**
	 * 検索した社員リスト確認ビジネス<br>
	 * 検索した社員リストを照会<br>
	 * 一致する場合、検索した社員リスト画面に遷移する。 <br>
	 * 失敗する場合、メイン画面に遷移する。 <br>
	 * 
	 * @param formData
	 * 
	 * 
	 * @return "success" 検索した社員リスを持ってきた時 。
	 */

	public String doBusiness(ActionForm formData) {
		try {

			this.form = (MemberListSearchForm) formData;

			sqlSession = SqlMapClient.getSqlSession();

			String SearchOption;
			String SearchInfo;
			
			SearchOption = form.getSearchOption();
			SearchInfo = form.getSearchInfo();
			SearchInfo = URLDecoder.decode(SearchInfo, "UTF-8");
			System.out.println(SearchOption);
			System.out.println(SearchInfo);
			
			int pageNum = (Integer.parseInt(form.getPage()) - 1) * 20;
			Map<String, String> map = new HashMap<String, String>();
			map.put("column", SearchOption);
			map.put("keyword", SearchInfo);
			map.put("page", pageNum + "");
//			if(SearchOption.equals("USER_NAME")){
//				list = sqlSession.selectList("Test.getSearchUserLimit", map);
//				count = sqlSession.selectList("Test.getSearchUser", map);
//			}else if(SearchOption.equals("USER_DEPARTMENT")){
//				map.put("code", CodeSearch.DIVISIOM_CODE);
//				list = sqlSession.selectList("Test.getSearchUserLimit2", map);
//				count = sqlSession.selectList("Test.getSearchUser2", map);
//			}else if(SearchOption.equals("USER_RANK")){
//				map.put("code", CodeSearch.POSION_CODE);
//				list = sqlSession.selectList("Test.getSearchUserLimit2", map);
//				count = sqlSession.selectList("Test.getSearchUser2", map);
//			}	
			
			if(SearchOption.equals("USER_DEPARTMENT")){
				map.put("code", CodeSearch.DIVISIOM_CODE);
				list = sqlSession.selectList("Test.getSearchUserLimit2", map);
				count = sqlSession.selectList("Test.getSearchUser2", map);
			}else if(SearchOption.equals("USER_RANK")){
				map.put("code", CodeSearch.POSION_CODE);
				list = sqlSession.selectList("Test.getSearchUserLimit2", map);
				count = sqlSession.selectList("Test.getSearchUser2", map);
			}else{
				map.put("code", CodeSearch.DIVISIOM_CODE);
				System.out.println(CodeSearch.DIVISIOM_CODE);
				list = sqlSession.selectList("Test.getSearchUserLimit", map);
				count = sqlSession.selectList("Test.getSearchUser", map);
			}
				
		
			int PageLen;
			if (count.size() % 20 == 0) {
				//検索した社員リストのtotalを２０で割ると残りが０の場合
				PageLen = count.size() / 20;
			} else {
				//検索した社員リストのtotalを２０で割ると残りが０ではない場合
				PageLen = (count.size() / 20) + 1;
			}

			if (list == null || list.size() == 0) {
				//検索した社員のリストが0件の時
				form.getPagingSearchList().add(1);
				form.setCodeList((ArrayList<CodeTBLBean>)CodeSearch.getCodeInfoList(CodeSearch.SEARCH_CODE));
				form.setSearchOption(SearchOption);
				return RESULT_SUCCESS;
			} else {
				//検索した社員のリストが1件以上の時
				
				//USER_LIST_INDEX set
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setUSER_LIST_INDEX(
							((Integer.parseInt(form.getPage()) - 1) * 20) + i
									+ 1);
				}
				
				//PagingSearchList set
				for (int i = 1; i <= PageLen; i++) {
					form.getPagingSearchList().add(i);
				}
				
				form.setList((ArrayList<UserTBLBean>) list);
				form.setCodeList((ArrayList<CodeTBLBean>)CodeSearch.getCodeInfoList(CodeSearch.SEARCH_CODE));
				form.setSearchOption(SearchOption);
				form.setSearchInfo(SearchInfo);
				
				return RESULT_SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RESULT_ERROR;
		} finally {
			SqlMapClient.closeSession(sqlSession);
		}
	}

}
