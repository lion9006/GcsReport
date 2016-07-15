package src.member.business;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import src.bean.UserTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.common.CodeSearch;
import src.member.actionForm.MemberUpdateForm;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;

/**
 * ユーザーの情報を持って来るクラス。
 * @author KIM.SEONGHUI
 *
 */
public class MemberUpdateBusiness implements BusinessInterface {
	
	private MemberUpdateForm form;
	SqlSession sqlSession = null;	

	/**
	 *　社員情報の修正ビジネス
	 *　社員情報を修正する時利用。
	 *　一致する場合、ログイン画面に遷移する。 <br>
	 *　失敗する場合、社員情報修正画面に遷移する。 <br>
	 * 
	 *　@param　formData <br>
	 *　@return　error　既存のパスワード情報が間違っている場合。<br>
	 *　 		 success　既存のパスワード情報が一致する場合。
	 * 
	 */
	
	@Override
	   public String doBusiness(ActionForm formData) {

	      try {
	         this.form = (MemberUpdateForm) formData;
	         
			 sqlSession = SqlMapClient.getSqlSession();
	         
	         ActionContext con = ActionContext.getContext();
	         Map<String, Object> session = con.getSession();
	         List<UserTBLBean> list = sqlSession.selectList("Test.getUser",session.get("id"));

	         if (list == null || list.size() == 0) {

	            return RESULT_SUCCESS2;
	         } else {
	        	form.setUid(list.get(0).getUSER_ID());
	        	form.setGender(list.get(0).getUSER_GENDER());	           
	        	Date birthDay = list.get(0).getUSER_BIRTHDAY();
	        	String BirthDay = birthDay.toString();
	        	String Birthday[] = BirthDay.split("-");
	        	form.setYear(Birthday[0]);
	        	form.setMonth(Birthday[1]);
	        	form.setDay(Birthday[2]);            
	        	form.setAddress(list.get(0).getUSER_ADDRESS());
	        	form.setTel(list.get(0).getUSER_PHONE());
	        	form.setKaid(list.get(0).getUSER_KAKAOTALK());
	        	form.setUser_password(list.get(0).getUSER_PASSWORD());
	        	form.setBigo(list.get(0).getUSER_INFO()); 
	            form.setKaid(list.get(0).getUSER_KAKAOTALK());
	            String mail_name[] = list.get(0).getUSER_EMAIL().split("@");
//	            form.setNamae(list.get(0).getUSER_NAME());
	            form.setCcfname(list.get(0).getUSER_CCFNAME());
	            form.setCclname(list.get(0).getUSER_CCLNAME());
	            form.setKatafname(list.get(0).getUSER_KATAFNAME());
	            form.setKatalname(list.get(0).getUSER_KATALNAME());
	            form.setFemail(mail_name[0]);
	            form.setLemail(mail_name[1]);
	            form.setDepartment(list.get(0).getUSER_DEPARTMENT());
	            form.setRank(list.get(0).getUSER_RANK());
				form.setDepartmentList(CodeSearch.getCodeInfoList(CodeSearch.DIVISIOM_CODE));
				form.setRankList(CodeSearch.getCodeInfoList(CodeSearch.POSION_CODE));

	            return RESULT_SUCCESS;
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
			} finally {
				SqlMapClient.closeSession(sqlSession);
			}
	        return RESULT_ERROR;
	   }
	   
	}