package src.member.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import src.bean.CodeTBLBean;
import src.common.CodeSearch;
import src.member.actionForm.MemberUpdateForm;
import src.member.business.MemberUpdateAccessBusiness;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/**
 *情報修正機能画面アクション
 * @author KIM.SEONGHUI
 *
 */

	public class MemberUpdateAccessAction implements Action, Preparable,ModelDriven<MemberUpdateForm> {
	
		/**
		 * 社員情報を持って来て修正する。
		 * 
		 * @return SUCCESS 情報修正画面に遷移
		 */
		static Logger logger = Logger.getLogger(MemberUpdateAccessAction.class);
		
		private MemberUpdateForm formData;
		private String returnCode;
		
		   List<CodeTBLBean> emailList;	
		   private List<String> email = new ArrayList<String>();	
		   
		   List<CodeTBLBean> rankList;
		   private List<String> rank = new ArrayList<String>();
		   
		   List<CodeTBLBean> departmentList;
		   private List<String> department = new ArrayList<String>();
		
		@Override
		public String execute() throws Exception {
			BasicConfigurator.configure();
			logger.info("MemberUpdateAccessAction[START]" + this.getClass().getName());
			
			MemberUpdateAccessBusiness memberUpdateaccessBusiness = new MemberUpdateAccessBusiness();
			returnCode = memberUpdateaccessBusiness.doBusiness(formData);
			emailList = CodeSearch.getCodeInfoList(CodeSearch.MAIL_CODE);
			rankList = CodeSearch.getCodeInfoList(CodeSearch.POSION_CODE);
			departmentList = CodeSearch.getCodeInfoList(CodeSearch.DIVISIOM_CODE);
			logger.info("MemberUpdateAccessAction[END]" + this.getClass().getName());

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
		return formData;
		}
		
		@Override
		public void prepare() throws Exception {
		this.formData = new MemberUpdateForm();
		}
		
	}