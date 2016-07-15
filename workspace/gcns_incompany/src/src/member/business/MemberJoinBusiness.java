package src.member.business;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import src.common.ActionForm;
import src.common.BusinessInterface;
import src.common.CodeSearch;
import src.common.StringUtility;
import src.member.actionForm.MemberJoinForm;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;
/**
 * 会員登録をするために使用するクラス。
 * @author KIM.SEONGHUI
 *
 */
public class MemberJoinBusiness implements BusinessInterface{

	private MemberJoinForm form;
	SqlSession sqlSession = null;
	/**
	 *　社員登録ビジネス
	 *　社員登録する時利用。
	 *　失敗する場合、alertウィンドウで表示した後、登録画面に遷移する。 <br>
	 *　@param　formData <br>
	 *　@return　error　既存のパスワード情報が間違っている場合。<br>
	 *　			 success　既存のパスワード情報が一致する場合。
	 * 
	 */
	@Override
	public String doBusiness(ActionForm formData) {
		// TODO Auto-generated method stub
		try {

			this.form = (MemberJoinForm) formData;

			ActionContext con = ActionContext.getContext();
			Map<String, Object> session = con.getSession();
			sqlSession = SqlMapClient.getSqlSession();

			String USER_ID;
			String USER_PASSWORD;
//			String USER_NAME;
			String USER_CCFNAME;
			String USER_CCLNAME;
			String USER_KATAFNAME;
			String USER_KATALNAME;
			String USER_ADDRESS;
			String USER_PHONE;
			String USER_DEPARTMENT;
			String USER_RANK;
			String USER_GENDER;
			String USER_BIRTHDAY;
			String USER_EMAIL;
			String USER_KAKAOTALK;
			String USER_INFO;
			String TRK_ID;
			String UPD_ID;
			String DEL_FLG;
			TRK_ID=(String)session.get("id");
			UPD_ID=(String)session.get("id");
			DEL_FLG="0";
			USER_ID = form.getUid();
			USER_PASSWORD = form.getPw1();
//			USER_NAME = form.getNamae();
			USER_CCFNAME=form.getCcfname();
			USER_CCLNAME=form.getCclname();
			USER_KATAFNAME=form.getKatafname();
			USER_KATALNAME=form.getKatalname();
			USER_ADDRESS = form.getAddress();
			USER_PHONE = form.getTel();
			USER_DEPARTMENT = form.getDepartment();
			USER_RANK = form.getRank();
			USER_GENDER = form.getGender();
			USER_BIRTHDAY = form.getYear()+"-"+form.getMonth()+"-"+form.getDay();
			USER_EMAIL = form.getFemail()+"@"+form.getLemail();
			USER_KAKAOTALK = form.getKaid();
			USER_INFO = form.getBigo();

			Map<String, String> map = new HashMap<String, String>();
			map.put("USER_ID",USER_ID);	
			System.out.println(USER_PASSWORD);
			String SHA256 = StringUtility.getSHA256(USER_PASSWORD);
			map.put("USER_PASSWORD",SHA256);
//			map.put("USER_NAME",USER_NAME);
			map.put("USER_CCFNAME",USER_CCFNAME);
			map.put("USER_CCLNAME",USER_CCLNAME);
			map.put("USER_KATAFNAME",USER_KATAFNAME);
			map.put("USER_KATALNAME",USER_KATALNAME);
			map.put("USER_ADDRESS", USER_ADDRESS);
			map.put("USER_PHONE",USER_PHONE);
			map.put("USER_DEPARTMENT",USER_DEPARTMENT);
			map.put("USER_RANK",USER_RANK);
			map.put("USER_GENDER",USER_GENDER);			
			map.put("USER_BIRTHDAY",USER_BIRTHDAY);
			map.put("USER_EMAIL",USER_EMAIL);
			map.put("USER_KAKAOTALK",USER_KAKAOTALK);
			map.put("USER_INFO",USER_INFO);
			map.put("USER_ID",USER_ID);
			map.put("TRK_ID",TRK_ID);
			map.put("UPD_ID", UPD_ID);
			map.put("DEL_FLG", DEL_FLG);
			form.setDepartmentList(CodeSearch.getCodeInfoList(CodeSearch.DIVISIOM_CODE));
			form.setRankList(CodeSearch.getCodeInfoList(CodeSearch.POSION_CODE));

			sqlSession.update("Test.setUserJoin", map);
			sqlSession.commit();	
			
			return RESULT_SUCCESS;	
			
		} catch (Exception e) {
			e.printStackTrace();					
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}
		return RESULT_ERROR;	
	}

}
