package src.main.business;

import java.util.Map;

import src.common.ActionForm;
import src.common.BusinessInterface;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author キムウンジ
 */

public class LogoutActionBusiness implements BusinessInterface {

	/**
	 * ログアウトセッション削除ビジネス<br>
	 * ログアウトをする時、セッションを消してログインページに移動する。<br>
	 * 
	 * @return "success" セッションを消してログインページに移動する。
	 */

	@Override
	public String doBusiness(ActionForm formData) {
		ActionContext con = ActionContext.getContext();
		Map<String, Object>  session = (Map<String, Object>)con.getSession();

		//セッションが保存されている時、セッションにあるIdを消してログアウトする。
		if (session.get("id") != null) {
			session.remove("id");
			
			//ログイン画面に遷移
			return RESULT_SUCCESS;
			
		}
		return RESULT_ERROR;
	}
}
