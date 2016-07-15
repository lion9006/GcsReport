package src.member.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import src.bean.CodeTBLBean;
import src.bean.UserTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.common.CodeSearch;
import src.member.actionForm.MemberListForm;
import src.mybatis.SqlMapClient;

public class MemberListBusiness implements BusinessInterface {

	private MemberListForm form;
	private List<UserTBLBean> list = new ArrayList<UserTBLBean>();		// 社員リストのlimit
	private List<UserTBLBean> count = new ArrayList<UserTBLBean>();		// 社員リストのtotal
	SqlSession sqlSession = null;

	/**
	 * 社員リスト確認ビジネス<br>
	 * 社員リストを照会<br>
	 * 一致する場合、社員リスト画面に遷移する。 <br>
	 * 失敗する場合、メイン画面に遷移する。 <br>
	 * 
	 * @param formData
	 * @return "success" 社員リスを持ってきた時 。
	 */

	public String doBusiness(ActionForm formData) {
		try {

			this.form = (MemberListForm) formData;

			sqlSession = SqlMapClient.getSqlSession();

			int pageNum = (Integer.parseInt(form.getPage()) - 1) * 20;

			list = sqlSession.selectList("Test.getAllUserLimit", pageNum);
			count = sqlSession.selectList("Test.getAllUser");
			form.setCodeList((ArrayList<CodeTBLBean>)CodeSearch.getCodeInfoList(CodeSearch.SEARCH_CODE));

			int PageLen;
			if (count.size() % 20 == 0) {
				// 社員リストのtotalを２０で割ると残りが０の場合
				PageLen = count.size() / 20;
			} else {
				// 社員リストのtotalを２０で割ると残りが０ではない場合
				PageLen = (count.size() / 20) + 1;
			}
			
			if (list == null || list.size() == 0) {
				//社員のリストが0件の時
				form.getPagingList().add(1);
				return RESULT_SUCCESS;
			} else {
				//社員のリストが1件以上の時
				
				//USER_LIST_INDEX set
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setUSER_LIST_INDEX(
							((Integer.parseInt(form.getPage()) - 1) * 20) + i
									+ 1);
				}
				
				//PagingList set
				for (int i = 1; i <= PageLen; i++) {
					form.getPagingList().add(i);
				}
				form.setList((ArrayList<UserTBLBean>) list);

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
