package src.member.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import src.bean.UserTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.common.CodeSearch;
import src.common.StringUtility;
import src.member.actionForm.MemberUpdateForm;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;
/**
 * ユーザーの情報を修正するために使用するクラス。
 * @author KIM.SEONGHUI
 *
 */
public class MemberUpdateAccessBusiness implements BusinessInterface {
	
	private MemberUpdateForm form;
	private	SqlSession sqlSession = null;
	/**
	 * ユーザーが社員の情報を修正する時利用。
	 * @param　formData
	 * @return　error　updateする社員番号がない時。<br>
	 * 		　　　success　updateが成功する時。
	 * 
	 */

	@Override
	public String doBusiness(ActionForm formData) {
		int log_status;
	      try {
	    	  
	    	  	this.form = (MemberUpdateForm) formData;
				sqlSession = SqlMapClient.getSqlSession();		         
		        ActionContext con = ActionContext.getContext();
		        Map<String, Object> session = con.getSession();
		        String pw;
		        
		        List<UserTBLBean> list = sqlSession.selectList("Test.getUser",session.get("id"));
				if (list == null || list.size() == 0) {
					return RESULT_ERROR;
				} else {
					
					String dbPasswd = null;
					 pw = form.getUser_password();

					for (UserTBLBean testBean : list) {
					
						dbPasswd = testBean.getUSER_PASSWORD();
				
						if (StringUtility.checkEqual(dbPasswd,StringUtility.getSHA256(form.getUser_password()))) {
					
							if (session.get("id") == null) {
								session.put("id", testBean.getUSER_ID());
								con.setSession(session);
							}
					
								String pw1;
//								String namae;
								String ccfname;
								String cclname;
								String katafname;
								String katalname;
								String address;
								String tel;
								String department;
								String rank;
								String gender;
								String USER_BIRTHDAY;
								String USER_EMAIL;
								String Kaid;
								String bigo;
	
								form.setUid(list.get(0).getUSER_ID());
								
								pw1 = form.getUser_password1();
//								namae = form.getNamae().toString();
								ccfname=form.getCcfname().toString();
								cclname=form.getCclname().toString();
								katafname=form.getKatafname().toString();
								katalname=form.getKatalname().toString();
								address = form.getAddress();
								tel = form.getTel();
								department = form.getDepartment();
								rank = form.getRank();
								gender = form.getGender();
								USER_BIRTHDAY = form.getYear()+"-"+form.getMonth()+"-"+form.getDay();
					
								USER_EMAIL = form.getFemail()+"@"+form.getLemail();
								Kaid = form.getKaid();
								bigo = form.getBigo();
								pw =form.getUser_password();							
								
								
								
								Map<String, String> map = new HashMap<String, String>();
								if(pw1.toString()==null || pw1.equals("") || pw1.toString().length()==0){

									sqlSession.selectList("Test.getUser",session.get("id"));
									
									map.put("USER_ID",list.get(0).getUSER_ID());	
//									map.put("USER_NAME",namae);
									map.put("USER_CCFNAME",ccfname);
									map.put("USER_CCLNAME",cclname);
									map.put("USER_KATAFNAME",katafname);
									map.put("USER_KATALNAME",katalname);
									map.put("USER_ADDRESS", address);
									map.put("USER_PHONE",tel);
									map.put("USER_DEPARTMENT",department);
									map.put("USER_RANK",rank);
									map.put("USER_GENDER",gender);			
									map.put("USER_BIRTHDAY",USER_BIRTHDAY);
									map.put("USER_EMAIL",USER_EMAIL);
									map.put("USER_KAKAOTALK",Kaid);
									map.put("USER_INFO",bigo);
									form.setDepartmentList(CodeSearch.getCodeInfoList(CodeSearch.DIVISIOM_CODE));
									form.setRankList(CodeSearch.getCodeInfoList(CodeSearch.POSION_CODE));
									sqlSession.update("Test.updateMember_2", map);	
									sqlSession.commit();
									
									list = sqlSession.selectList("Test.getUser", session.get("id"));
									
									form.setUser_ccfname(list.get(0).getUSER_CCFNAME());
									form.setUser_cclname(list.get(0).getUSER_CCLNAME());
									form.setUser_rank(CodeSearch.getCodeInfo(
											CodeSearch.POSION_CODE, list.get(0).getUSER_RANK())
											.getSsk_nm());
									form.setUser_department(CodeSearch.getCodeInfo(
											CodeSearch.DIVISIOM_CODE,
											list.get(0).getUSER_DEPARTMENT()).getSsk_nm());
									
									String login_status = (String)session.get("status");
									 log_status=Integer.parseInt(login_status);
									 
									if(log_status==1){
										return RESULT_SUCCESS2;
									}else{
										return RESULT_SUCCESS;
									}									
								}else{

									sqlSession.selectList("Test.getUser",session.get("id"));								
									map.put("USER_ID",list.get(0).getUSER_ID());
									map.put("USER_PASSWORD1",StringUtility.getSHA256(form.getUser_password1()));
//									map.put("USER_NAME",namae);
									map.put("USER_CCFNAME",ccfname);
									map.put("USER_CCLNAME",cclname);
									map.put("USER_KATAFNAME",katafname);
									map.put("USER_KATALNAME",katalname);
									map.put("USER_ADDRESS", address);
									map.put("USER_PHONE",tel);
									map.put("USER_DEPARTMENT",department);
									map.put("USER_RANK",rank);
									map.put("USER_GENDER",gender);			
									map.put("USER_BIRTHDAY",USER_BIRTHDAY);
									map.put("USER_EMAIL",USER_EMAIL);
									map.put("USER_KAKAOTALK",Kaid);
									map.put("USER_INFO",bigo);
									form.setDepartmentList(CodeSearch.getCodeInfoList(CodeSearch.DIVISIOM_CODE));
									form.setRankList(CodeSearch.getCodeInfoList(CodeSearch.POSION_CODE));
									sqlSession.update("Test.updateMember_1", map);
									sqlSession.commit();
									
									
									form.setUser_ccfname(list.get(0).getUSER_CCFNAME());
									form.setUser_cclname(list.get(0).getUSER_CCLNAME());
									form.setUser_rank(CodeSearch.getCodeInfo(
											CodeSearch.POSION_CODE, list.get(0).getUSER_RANK())
											.getSsk_nm());
									form.setUser_department(CodeSearch.getCodeInfo(
											CodeSearch.DIVISIOM_CODE,
											list.get(0).getUSER_DEPARTMENT()).getSsk_nm());
									
									
									String login_status = (String)session.get("status");
									 log_status=Integer.parseInt(login_status);
									if(log_status==1){
										return RESULT_SUCCESS2;
									}else{
										return RESULT_SUCCESS;
									}										
								}	
							}
						}
					
							return RESULT_ERROR;
					}
			} catch (Exception e) {
				e.printStackTrace();
				return RESULT_ERROR;
			} finally {
				SqlMapClient.closeSession(sqlSession);
			
			}
		}
	}