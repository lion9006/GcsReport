package src.main.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import src.bean.UserTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.common.CodeSearch;
import src.login.actionForm.LoginAccessForm;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;
/**
 * @author キムソンヒ
 */
public class MainBusiness implements BusinessInterface {
   private SqlSession sqlSession = null;
   private LoginAccessForm form;
   /**
    * 修正する画面でcancelボタン押す時、ビジネス<br>
    * cancelボタン押す時、メイン画面に移動する。<br>
    * 
    * @return "success" メイン画面にに移動する。
    */   
   

   @Override
   public String doBusiness(ActionForm formData) {

      try {
         this.form = (LoginAccessForm) formData;
         sqlSession = SqlMapClient.getSqlSession();
	     ActionContext con = ActionContext.getContext();
	     Map<String, Object> session = con.getSession();
         List<UserTBLBean> list = sqlSession.selectList("Test.getUser",session.get("id"));
         for (UserTBLBean testBean : list) {             
//            form.setUser_name(testBean.getUSER_NAME());
        	form.setUser_ccfname(list.get(0).getUSER_CCFNAME());
        	form.setUser_cclname(list.get(0).getUSER_CCLNAME());
            form.setUser_rank(CodeSearch.getCodeInfo(CodeSearch.POSION_CODE,testBean.getUSER_RANK()).getSsk_nm());
            form.setUser_department(CodeSearch.getCodeInfo(CodeSearch.DIVISIOM_CODE, testBean.getUSER_DEPARTMENT()).getSsk_nm());

            if (testBean.getUSER_STATUS().equals("1")) {
               return RESULT_SUCCESS2;
            }else{
               return RESULT_SUCCESS;
            }
         }   
         
      } catch (Exception e) {
         e.printStackTrace();
         return RESULT_ERROR;
      } finally {
         SqlMapClient.closeSession(sqlSession);
      }
      return RESULT_ERROR;
   
   }
}