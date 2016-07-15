package src.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import src.bean.CodeTBLBean;
import src.mybatis.SqlMapClient;

public class CodeSearch {
	
	/**
	 * 分類コード：検索コード
	 */
	public static String SEARCH_CODE   = "001";
	
	/**
	 * 分類コード：部署コード
	 */
	public static String DIVISIOM_CODE = "002";
	
	/**
	 * 分類コード：職級コード
	 */
	public static String POSION_CODE   = "003";
	
	/**
	 * 分類コード：メールコード
	 */
	public static String MAIL_CODE     = "004";
	
	/**
	 * 分類コード：権限コード
	 */
	public static String STATUS_CODE   = "005";
	
	/**
	 * 分類コード：カテゴリーコード
	 */
	public static String CATEGORY_CODE = "006";
	
	/**
	 * 分類コード：掲示板検索コード
	 */
	public static String BBSSEARCH_CODE ="007"; 
	/**
	 * パラメータのコード分類番号に対するコード情報を<br>
	 * コードテーブルから取得し、返却する（複数件）<br>
	 * 
	 * @param code_bunrui_no
	 *            　コード分類番号
	 * @return　コードテーブル情報（複数件）　 
	 */
	public static List<CodeTBLBean> getCodeInfoList (String code_bunrui_no){
		
		List<CodeTBLBean> codeList = null;
		SqlSession sqlSession = null;
		
		try {
			codeList = new ArrayList<CodeTBLBean>();
			
			sqlSession = SqlMapClient.getSqlSession();
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("CODE_BUNRUI_NO", code_bunrui_no);
			
			codeList = sqlSession.selectList("CodeInfo.getAllCodeInfo", map);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			SqlMapClient.closeSession(sqlSession);
	
		}
		
		return codeList;
		
	}
	
	/**
	 * パラメータのコード分類番号とコード番号に対するコード情報を<br>
	 * コードテーブルから取得し、返却する（１件）<br>
	 * 
	 * @param code_bunrui_no
	 *            　コード分類番号
　　　　* @param code_no
	 *            　コード番号
	 * @return　コードテーブル情報（１件）　 
	 */
    public static CodeTBLBean getCodeInfo (String code_bunrui_no, String code_no){
		
		CodeTBLBean codeBean = null;
		SqlSession sqlSession = null;
		
		try {
						
			sqlSession = SqlMapClient.getSqlSession();
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("CODE_BUNRUI_NO", code_bunrui_no);
			map.put("CODE_NO", code_no);
			
			codeBean = (CodeTBLBean)sqlSession.selectOne("CodeInfo.getCodeInfo", map);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			SqlMapClient.closeSession(sqlSession);
			
		}
		
		return codeBean;
		
	}
	
}
