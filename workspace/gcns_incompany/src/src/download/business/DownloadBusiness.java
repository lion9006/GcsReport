package src.download.business;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.StrutsStatics;

import src.bean.FileListInfoTBLBean;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.download.actionForm.DownloadForm;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;
/**
 * 
 * @author KWON.JUYONG
 * 
 */
@SuppressWarnings("serial")
public class DownloadBusiness extends HttpServlet implements BusinessInterface {

	private DownloadForm form;
	private List<FileListInfoTBLBean> list = new ArrayList<FileListInfoTBLBean>();
	
	private String fileName; 
	private String fileType; 
	
	SqlSession sqlSession = null;
	InputStream inputStream = null;
	ServletOutputStream out = null;
	
	/**
	 * ファイルダウンロードビジネス<br>
	 * ダウンロードファイルを照会<br>
	 * 一致する場合、ダウンロードします。 <br>
	 * 
	 * @param formData
	 * 
	 * 
	 * @return "success" ファイルをダウンロード <br>
	 *         。
	 * @throws IOException 
	 */

	public String doBusiness(ActionForm formData) throws IOException {
		try {

			this.form = (DownloadForm) formData;

			sqlSession = SqlMapClient.getSqlSession();

			int FILE_INDEX = form.getFILE_INDEX();	//ファイルのFILE_INDEX

			list = sqlSession.selectList("Test.getDownload", FILE_INDEX);

			if (list == null || list.size() == 0) {
				//ダウンロードするファイルがない場合
				return RESULT_ERROR;
			} else {
				//ダウンロードするファイルがある場合
				
				fileName = list.get(0).getFILE_NAME();			//ダウンロードするファイルのNAME
				fileType = list.get(0).getFILE_TYPE();			//ダウンロードするファイルのTYPE

				byte[] blob = list.get(0).getFILE_DATA();		//ダウンロードするファイルのDATA
				inputStream = new ByteArrayInputStream(blob);

				ActionContext ac = ActionContext.getContext();
				HttpServletResponse response = (HttpServletResponse) ac
						.get(StrutsStatics.HTTP_RESPONSE);

				response.setContentType("application/octet-stream");
				response.setHeader(
						"Content-Disposition",
						"attachment;filename="
								+ URLEncoder.encode(fileName + "." + fileType,
										"UTF-8"));
				response.setContentLength(blob.length); 
				out = response.getOutputStream();

				byte[] outputByte = new byte[4096];
				while (true) {
					int bytesRead = inputStream.read(outputByte);
					if (bytesRead < 0)
						break;
					out.write(outputByte, 0, bytesRead);
				}		
				
		
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return RESULT_ERROR;
		} finally {
			inputStream.close();
			out.flush();
			out.close();
			SqlMapClient.closeSession(sqlSession);
		}
	}

}
