package src.board.business;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import src.board.actionForm.BbsWriteForm;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;

/**
 * 掲示板に作成するアクション
 * 
 * @author Park.Jaedeok
 * 
 * @param BBS_CATEGORY カテゴリー
 * @param BBS_TITLE 題目
 * @param BBS_CONTENT 内容
 * @param BBS_FNAME ファイル名前
 * @param BBS_FDATA ファイルデータ
 * @param TRK_ID 登録者
 * @param UPD_ID 登録者
 * 
 * @return SUCCESS 詳細画面に移動する
 * @return RESULT_ERROR エラー画面に移動する
 * 
 */
public class BbsWriteBusiness implements BusinessInterface{
	
	private BbsWriteForm form;
	SqlSession sqlSession = null;
	
	@Override
	public String doBusiness(ActionForm formData) {
		try{
			this.form = (BbsWriteForm)formData;
			
			ActionContext con = ActionContext.getContext();
			Map<String, Object>session = con.getSession();
			sqlSession = SqlMapClient.getSqlSession();
						
			String TRK_ID=(String)session.get("id");
			String UPD_ID=(String)session.get("id");
						
			String BBS_CATEGORY = form.getBBS_CATEGORY();
			String BBS_TITLE = form.getBBS_TITLE();
			String BBS_CONTENT = form.getBBS_CONTENT();
			String BBS_FNAME = form.getBBS_FNAME();
			File BBS_FDATA1 = form.getBBS_FDATA();
			byte[] BBS_FDATA = null;
			
			//File to String Byte Code =>
			if(BBS_FDATA1 !=null){
				File file = BBS_FDATA1;
				
				FileInputStream fis = new FileInputStream(file);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
		        		        
				try{
					for(int readNum; (readNum = fis.read(buf)) != -1;){
						bos.write(buf, 0, readNum);
//						System.out.println("read " + readNum + "bytes , " + readNum/1024/1024 + "MB");
					}
				}catch(IOException ex){
					Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
				}
				BBS_FDATA = bos.toByteArray();
			}else{
				BBS_FNAME = "none";
			}
			// =>end
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("BBS_CATEGORY", BBS_CATEGORY);
			map.put("BBS_TITLE", BBS_TITLE);
			map.put("BBS_CONTENT", BBS_CONTENT);
			map.put("BBS_FNAME", BBS_FNAME);
			map.put("BBS_FDATA", BBS_FDATA);
			map.put("UPD_ID", UPD_ID);
			map.put("TRK_ID", TRK_ID);
			
			sqlSession.insert("BbsInfo.setBbsWrite", map);
			sqlSession.commit();
			
			return RESULT_SUCCESS;
			
		}catch(Exception e){
			e.printStackTrace();
			return RESULT_ERROR;
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}
	}	
}
