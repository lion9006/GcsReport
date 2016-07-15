package src.download.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import src.bean.FileListInfoTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.download.actionForm.DownloadListForm;
import src.mybatis.SqlMapClient;


/**
 * 
 * @author KWON.JUYONG
 * 
 */
public class DownloadListBusiness implements BusinessInterface {

	private DownloadListForm form;
	private List<FileListInfoTBLBean> list = new ArrayList<FileListInfoTBLBean>();	//ダウンロードリストのlimit
	private List<FileListInfoTBLBean> count = new ArrayList<FileListInfoTBLBean>();	//ダウンロードリストのtotal
	
	SqlSession sqlSession = null;
	
	/**
	 * ファイルリスト確認ビジネス<br>
	 * ファイルリストを照会<br>
	 * 一致する場合、ダウンロード画面に遷移する。 <br>
	 * 失敗する場合、メイン画面に遷移する。 <br>
	 * 
	 * @param formData
	 * 
	 * 
	 * @return "success" ファイルリストを持ってきた時 。
	 */

	public String doBusiness(ActionForm formData) {
		try {
			
			this.form = (DownloadListForm)formData;
			
			sqlSession = SqlMapClient.getSqlSession();
			
			int pageNum = (Integer.parseInt(form.getPage())-1) * 20;
					
			list = sqlSession.selectList("Test.getAllDownloadLimit",pageNum );
			count = sqlSession.selectList("Test.getAllDownload");
			
			int PageLen;
			if(count.size()%20==0){
				//ダウンロードリストのtotalを２０で割ると残りが０の場合
				PageLen = count.size()/20;
			}else{
				//ダウンロードリストのtotalを２０で割ると残りが０ではない場合
				PageLen = (count.size()/20)+1;
			}
			
			if (list == null || list.size() == 0) {
				//ダウンロードのリストが0件の時
				form.getPagingList().add(1);
				return RESULT_SUCCESS;
			} else {
				//ダウンロードのリストが1件以上の時
				
				//FILE_LIST_INDEX set
				for(int i=0; i<list.size(); i++){
					list.get(i).setFILE_LIST_INDEX(((Integer.parseInt(form.getPage())-1) * 20)+i+1);
				}
				
				//PagingList set
				for(int i=1; i<=PageLen; i++){
					form.getPagingList().add(i);
				}
				form.setList((ArrayList<FileListInfoTBLBean>) list);
				
				return RESULT_SUCCESS;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			return RESULT_ERROR;
		}finally{
			SqlMapClient.closeSession(sqlSession);
		}
	}

}
