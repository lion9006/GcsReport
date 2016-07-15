package src.download.business;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import src.bean.FileListInfoTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.download.actionForm.DownloadListSearchForm;
import src.mybatis.SqlMapClient;

/**
 * 
 * @author KWON.JUYONG
 * 
 */
public class DownloadListSearchBusiness implements BusinessInterface {

	private DownloadListSearchForm form;
	private List<FileListInfoTBLBean> list = new ArrayList<FileListInfoTBLBean>();	// 検索したダウンロードリストのlimit
	private List<FileListInfoTBLBean> count = new ArrayList<FileListInfoTBLBean>();	// 検索したダウンロードリストのtotal

	SqlSession sqlSession = null;

	/**
	 * 検索したファイルリスト確認ビジネス<br>
	 * 検索したファイルリストを照会<br>
	 * 一致する場合、検索したダウンロード画面に遷移する。 <br>
	 * 失敗する場合、メイン画面に遷移する。 <br>
	 * 
	 * @param formData
	 * 
	 * 
	 * @return "success" 検索したファイルリストを持ってきた時 。
	 */

	public String doBusiness(ActionForm formData) {
		try {

			this.form = (DownloadListSearchForm) formData;

			sqlSession = SqlMapClient.getSqlSession();

			int pageNum = (Integer.parseInt(form.getPage()) - 1) * 20;
			String SearchInfo;
			SearchInfo = form.getSearchInfo();
			SearchInfo = URLDecoder.decode(SearchInfo, "UTF-8");

			Map<String, String> map = new HashMap<String, String>();
			map.put("keyword", SearchInfo);
			map.put("page", pageNum + "");

			list = sqlSession.selectList("Test.getSearchDownloadLimit", map);
			count = sqlSession.selectList("Test.getSearchDownload", map);

			int PageLen;
			if (count.size() % 20 == 0) {
				//検索したダウンロードリストのtotalを２０で割ると残りが０の場合
				PageLen = count.size() / 20;
			} else {
				//検索したダウンロードリストのtotalを２０で割ると残りが０ではない場合
				PageLen = (count.size() / 20) + 1;
			}
			if (list == null || list.size() == 0) {
				//検索したダウンロードのリストが0件の時
				form.getPagingSearchList().add(1);
				return RESULT_SUCCESS;
			} else {
				//検索したダウンロードのリストが1件以上の時
				
				//FILE_LIST_INDEX set
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setFILE_LIST_INDEX(
							((Integer.parseInt(form.getPage()) - 1) * 20) + i
									+ 1);
				}
				
				//PagingList set
				for (int i = 1; i <= PageLen; i++) {
					form.getPagingSearchList().add(i);
				}
				form.setList((ArrayList<FileListInfoTBLBean>) list);

				return RESULT_SUCCESS;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return RESULT_ERROR;
		} finally {
			SqlMapClient.closeSession(sqlSession);
		}
	}

}
