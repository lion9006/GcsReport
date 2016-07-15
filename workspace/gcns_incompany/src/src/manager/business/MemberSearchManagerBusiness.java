package src.manager.business;

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
import src.manager.actionForm.MemberSearchManagerForm;
import src.mybatis.SqlMapClient;
/**
 * 社員情報を検索するため利用するクラス。
 * @author ヤンチャンジン
 *
 */
public class MemberSearchManagerBusiness implements BusinessInterface {
	private MemberSearchManagerForm form;
	private List<UserTBLBean> userList = new ArrayList<UserTBLBean>();

	SqlSession sqlSession = null;
	/**
	 * 社員リストで自分が必要な情報について検索する。<br>
	 * @param　formData
	 * @return　success　探している検索語に合う情報がある時。
	 * 
	 */
	@Override
	public String doBusiness(ActionForm formData) {
		try {

			this.form = (MemberSearchManagerForm) formData;

			sqlSession = SqlMapClient.getSqlSession();

			String SearchOption;
			String SearchInfo;

			SearchOption = form.getSearchOption();
			SearchInfo = form.getSearchInfo();
			SearchInfo = URLDecoder.decode(SearchInfo, "UTF-8");

			Map<String, String> map = new HashMap<String, String>();
			map.put("column", SearchOption);
			map.put("keyword", SearchInfo);
			
//			if(SearchOption.equals("USER_NAME")){
//				userList = sqlSession.selectList("Manager.search_userid", map);
//				
//			}else if(SearchOption.equals("USER_DEPARTMENT")){
//				map.put("code", CodeSearch.DIVISIOM_CODE);
//				userList = sqlSession.selectList("Manager.searchoption", map);
//				
//			}else if(SearchOption.equals("USER_RANK")){
//				map.put("code", CodeSearch.POSION_CODE);
//				userList = sqlSession.selectList("Manager.searchoption", map);
//				
//			}	
			
			if(SearchOption.equals("USER_DEPARTMENT")){
				map.put("code", CodeSearch.DIVISIOM_CODE);
				userList = sqlSession.selectList("Manager.searchoption", map);
				
			}else if(SearchOption.equals("USER_RANK")){
				map.put("code", CodeSearch.POSION_CODE);
				userList = sqlSession.selectList("Manager.searchoption", map);
				
			}else{
				map.put("code", CodeSearch.DIVISIOM_CODE);
				userList = sqlSession.selectList("Manager.search_userid", map);
				
			}
			
			if (userList == null) {
				return RESULT_ERROR;
			} else {
				form.setCodeList((ArrayList<CodeTBLBean>)CodeSearch.getCodeInfoList(CodeSearch.SEARCH_CODE));
				form.setUserList((ArrayList<UserTBLBean>) userList);
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
