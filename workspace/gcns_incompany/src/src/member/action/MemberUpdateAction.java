package src.member.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.bean.CodeTBLBean;
import src.common.CodeSearch;
import src.member.actionForm.MemberUpdateForm;
import src.member.business.MemberUpdateBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 社員情報の修正アクション
 * 
 * @author KIM.SEONGHUI
 * 
 */ 
public class MemberUpdateAction implements Action, Preparable, ModelDriven<MemberUpdateForm>{
   
   static Logger logger = Logger.getLogger(MemberUpdateAction.class); 
   
   private MemberUpdateForm form;
   private String returnCode;  
   List<CodeTBLBean> emailList;	
   private List<String> email = new ArrayList<String>();	
   
   List<CodeTBLBean> rankList;
   private List<String> rank = new ArrayList<String>();
   
   List<CodeTBLBean> departmentList;
   private List<String> department = new ArrayList<String>();
   /**
    * アクション開始ログ出力<br>
    * アクション終了ログ出力<br>
    *     
    * @return SUCCESS 修正画面に遷移
    */   
   @Override
   public String execute() throws Exception {
      // TODO Auto-generated method stub
      BasicConfigurator.configure();
      logger.info("[INFO]  [START]" + this.getClass().getName());
      
		emailList = CodeSearch.getCodeInfoList(CodeSearch.MAIL_CODE);
		rankList = CodeSearch.getCodeInfoList(CodeSearch.POSION_CODE);
		departmentList = CodeSearch.getCodeInfoList(CodeSearch.DIVISIOM_CODE);
      
      MemberUpdateBusiness memberupdatebusiness = new MemberUpdateBusiness();
      returnCode = memberupdatebusiness.doBusiness(form);
      
      logger.info("[INFO]  [END]" + this.getClass().getName());
		return returnCode;
   }
	public List<CodeTBLBean> getEmailList() {
		return emailList;
	}
	public void setEmailList(List<CodeTBLBean> emailList) {
		this.emailList = emailList;
	}
	
	public List<CodeTBLBean> getRankList() {
		return rankList;
	}
	public void setRankList(List<CodeTBLBean> rankList) {
		this.rankList = rankList;
	}
	
	public List<CodeTBLBean> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<CodeTBLBean> departmentList) {
		this.departmentList = departmentList;
	}
	
	@Override
	public MemberUpdateForm getModel() {
	
		// TODO Auto-generated method stub
		return form;
	}
	
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		this.form = new MemberUpdateForm();
	}
}