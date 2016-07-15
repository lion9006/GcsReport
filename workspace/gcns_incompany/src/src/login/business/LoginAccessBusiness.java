package src.login.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import src.login.actionForm.LoginAccessForm;
import src.bean.UserTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.common.CodeSearch;
import src.common.StringUtility;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;

public class LoginAccessBusiness implements BusinessInterface {

	private LoginAccessForm form;
	private SqlSession sqlSession = null;
	private List<UserTBLBean> list = new ArrayList<UserTBLBean>();

	/**
	 * ログインユーザ確認ビジネス<br>
	 * ログイン社員IDでパスワードを検索して入力パスワードと比較する。(暗号化後に比較)<br>
	 * 一致する場合、セッションに社員IDを保存してメイン画面に遷移する。 <br>
	 * 失敗する場合、ログイン画面に遷移する。 <br>
	 * 
	 * @param formData
	 * @return "error" ①DB上に該当社員IDがない場合。<br>
	 *         ②比較結果パスワードが一致しない場合。
	 * @return "success" パスワードが一致する場合。
	 */

	public String doBusiness(ActionForm formData) {

		try {
			this.form = (LoginAccessForm) formData;
			sqlSession = SqlMapClient.getSqlSession();
			list = sqlSession.selectList("Test.getUser", form.getUser_id());
			if (list == null || list.size() == 0) {
				// 場合1 : DB上に該当社員IDがない場合（ログイン失敗）
				form.setLoginMessage("1");
				return RESULT_ERROR;
			} else {
				String dbPasswd = null;
				dbPasswd = list.get(0).getUSER_PASSWORD();
				// （ログイン成功）
				if (StringUtility.checkEqual(dbPasswd,
						StringUtility.getSHA256(form.getUser_password()))) {
					ActionContext con = ActionContext.getContext();
					Map<String, Object> session = con.getSession();
					session.remove("id");
					// セッションにIdを保存する。
					if (session.get("id") == null) {
						session.put("id", list.get(0).getUSER_ID());
						session.put("status", list.get(0).getUSER_STATUS());
						con.setSession(session);
					}// End of if

//					form.setUser_name(list.get(0).getUSER_NAME());
					form.setUser_ccfname(list.get(0).getUSER_CCFNAME());
					form.setUser_cclname(list.get(0).getUSER_CCLNAME());
					form.setUser_rank(CodeSearch.getCodeInfo(
							CodeSearch.POSION_CODE, list.get(0).getUSER_RANK())
							.getSsk_nm());
					form.setUser_department(CodeSearch.getCodeInfo(
							CodeSearch.DIVISIOM_CODE,
							list.get(0).getUSER_DEPARTMENT()).getSsk_nm());
					// 管理者メイン画面に遷移
					if (list.get(0).getUSER_STATUS().equals("1")) {
						return RESULT_SUCCESS2;
					} else if (list.get(0).getUSER_STATUS().equals("2")) {
						// ユーザーメイン画面に遷移
						return RESULT_SUCCESS;
					}
				} else {
					// 場合2 : 比較結果パスワードが一致しない場合（ログイン失敗）
					form.setLoginMessage("2");
					return RESULT_ERROR;
				}
				return RESULT_ERROR2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RESULT_ERROR2;
		} finally {
			SqlMapClient.closeSession(sqlSession);

		}

	}
}