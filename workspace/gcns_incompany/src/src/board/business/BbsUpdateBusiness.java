package src.board.business;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import src.bean.BbsBean;
import src.board.actionForm.BbsUpdateForm;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;
/**
 * 掲示板に修正するアクション<br>
 * @author Yun.jaewon
 */
public class BbsUpdateBusiness implements BusinessInterface {
	private BbsUpdateForm form;
	
	/**
	 * @param formData
	 * @throws Exception
	 * @return RESULT_SUCCESS : アップデートしたbbsviewページを出力。
	 * @return RESULT_ERROR : errorページを出力。
	 */
	@Override
	public String doBusiness(ActionForm formData){
		// TODO Auto-generated method stub
		List<BbsBean> bbslist = new ArrayList<BbsBean>();
		SqlSession sqlSession = null;
		try{
			this.form = (BbsUpdateForm)formData;
			
			ActionContext con = ActionContext.getContext();
			Map<String, Object>session = con.getSession();
			sqlSession = SqlMapClient.getSqlSession();
			Map<String, Object> map = new HashMap<String, Object>();
			
			int BBS_NUMBER = form.getBBS_NUMBER();
			String BBS_CATEGORY = form.getBBS_CATEGORY();
			String BBS_TITLE = form.getBBS_TITLE();
			String BBS_CONTENT = form.getBBS_CONTENT();
			String BBS_FNAME = form.getBBS_FNAME();
			byte[] BBS_FDATA = null;
			File BBS_FDATA1 = form.getBBS_FDATA();
			int FileCode = 0;
			String searchOption1 = form.getSearchOption1();
			String searchOption2 = form.getSearchOption2();
			String searchInfo = form.getSearchInfo();
			String page = form.getPage();
			String UPD_ID = (String)session.get("id");
			Timestamp TRK_DT = form.getTRK_DT();
			

			/**
			 * ファイルをbyteに返還、ファイルがなかったらBBS_FNAMにnoneを貯蔵。<br>
			 * */
			if(BBS_FNAME != null && BBS_FDATA1 == null){
				FileCode = 1;		
			}else{	
				if(BBS_FDATA1 !=null && BBS_FNAME != null){ 
					File file = BBS_FDATA1;
				
					FileInputStream fis = new FileInputStream(file);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
		        		        
					try{
						for(int readNum; (readNum = fis.read(buf)) != -1;){
							bos.write(buf, 0, readNum);
//							System.out.println("read " + readNum + "bytes , " + readNum/1024/1024 + "MB");
						}
					}catch(IOException ex){
						Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
					}
					BBS_FDATA = bos.toByteArray();
					FileCode = 2;
				}else{
					BBS_FNAME = "none";
					FileCode = 3;
				}
			}
			/**
			 * BBS_FNAMEにnoneがあったらファイルアップデートがないのでsetBbsUpdateNoFileを実行。 <br>
			 * ファイルがあったらsetBbsUpdateNewFileを実行。
			 * */
			if(FileCode == 3){
				BBS_FDATA = null;
				
				map.put("BBS_CATEGORY", BBS_CATEGORY);
				map.put("BBS_NUMBER", BBS_NUMBER);
				map.put("BBS_TITLE", BBS_TITLE);
				map.put("BBS_CONTENT", BBS_CONTENT);
				map.put("BBS_FNAME", BBS_FNAME);
				map.put("BBS_FDATA", BBS_FDATA);
				map.put("TRK_DT", TRK_DT);
				
				sqlSession.insert("BbsInfo.setBbsUpdateNoFile", map);
			}else if(FileCode == 2){
				map.put("BBS_CATEGORY", BBS_CATEGORY);
				map.put("BBS_NUMBER", BBS_NUMBER);
				map.put("BBS_TITLE", BBS_TITLE);
				map.put("BBS_CONTENT", BBS_CONTENT);
				map.put("BBS_FNAME", BBS_FNAME);
				map.put("BBS_FDATA", BBS_FDATA);
				map.put("TRK_DT", TRK_DT);
				sqlSession.insert("BbsInfo.setBbsUpdateNewFile", map);
			}else if(FileCode == 1){
				map.put("BBS_CATEGORY", BBS_CATEGORY);
				map.put("BBS_NUMBER", BBS_NUMBER);
				map.put("BBS_TITLE", BBS_TITLE);
				map.put("BBS_CONTENT", BBS_CONTENT);
				map.put("TRK_DT", TRK_DT);
				sqlSession.insert("BbsInfo.setBbsUpdate", map);
			}
			form.setSearchOption1(searchOption1);
			form.setSearchOption2(searchOption2);
			form.setSearchInfo(searchInfo);
			form.setPage(page);
			sqlSession.commit();
			System.out.println(form.getSearchOption2() + " : serachOption2");
			return RESULT_SUCCESS;
			
		}catch(Exception e){
			e.printStackTrace();
			return RESULT_ERROR;
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}
	}	
}
