package src.board.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import src.bean.BbsBean;
import src.bean.CommentBean;
import src.board.actionForm.BbsViewForm;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @author OH.YOUNGHWAN
 * 
 * 
 */
public class BbsViewBusiness implements BusinessInterface {
	private BbsViewForm form;
	private List<BbsBean> bbslist = new ArrayList<BbsBean>();
	private List<CommentBean> commentlist = new ArrayList<CommentBean>();

	String UPD_ID;
	String login_COM_ID;
	String login_TRK_ID;
	String login_status;
	int log_status;
	/**
	 * 掲示板詳細ビジネス<br>
	 * 
	 * 
	 * @param formData
	 * 
	 * @return "success"
	 */

	SqlSession sqlSession = null;

	@Override
	public String doBusiness(ActionForm formData) throws IOException {
try{
			
			this.form=(BbsViewForm)formData;
			 ActionContext con = ActionContext.getContext();
			 Map<String, Object> session = con.getSession();			
			 sqlSession = SqlMapClient.getSqlSession();
		 	 String login_TRK_ID = (String)session.get("id");
		 	 String login_status = (String)session.get("status");
			 UPD_ID= (String)session.get("id");
			 log_status=Integer.parseInt(login_status);
			 int value=form.getBbs_number();
			 String searchOption1 = form.getSearchOption1();
			 String searchOption2 = form.getSearchOption2();
			 String searchInfo = form.getSearchInfo();
			 String page = form.getPage();
		
			 	 
			 
			 bbslist = sqlSession.selectList("BbsInfo.getBbsview",value);
			 commentlist = sqlSession.selectList("BbsInfo.getCommentview",value);
			 form.setBbslist((ArrayList<BbsBean>)bbslist);
			 form.setCommentlist((ArrayList<CommentBean>)commentlist);
			 form.setSearchOption1(searchOption1);
			 form.setSearchOption2(searchOption2);
			 form.setSearchInfo(searchInfo);
			 form.setPage(page);
			 form.setUPD_ID(UPD_ID);
						 
			 if(login_TRK_ID.equals(bbslist.get(0).getUPD_ID().toString()))			
				 form.setLogin_TRK_ID(1);						
		
			 else if(log_status ==1)
				 form.setLogin_TRK_ID(2);
			 
			 else if((log_status !=1))
				 form.setLogin_TRK_ID(3);

			
			if(bbslist.size() == 0){
				return RESULT_ERROR;
			}else{
				return RESULT_SUCCESS;
			}

		}catch(Exception e){
			e.printStackTrace();
			return RESULT_ERROR;
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}

	}

}
