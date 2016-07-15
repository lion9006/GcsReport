package src.board.business;

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

import src.bean.BbsBean;
import src.board.actionForm.BbsViewForm;
import src.common.ActionForm;
import src.common.BusinessInterface;
import src.mybatis.SqlMapClient;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings({ "serial" })
public class BbsDownloadBusiness extends HttpServlet implements BusinessInterface{
	
	
	private BbsViewForm form;
	private List<BbsBean> list = new ArrayList<BbsBean>();
	
	private String fileName; 
	
	
	SqlSession sqlSession = null;
	InputStream inputStream = null;
	ServletOutputStream out = null;

	public String doBusiness(ActionForm formData) throws IOException {
	try {

			this.form = (BbsViewForm) formData;

			sqlSession = SqlMapClient.getSqlSession();

				int BBS_NUMBER = form.getBbs_number();	//ファイルのFILE_INDEX

			list = sqlSession.selectList("BbsInfo.getDownload", BBS_NUMBER);

			if (list.get(0).getBBS_FNAME() == "none") {
				//ダウンロードするファイルがない場合
				return RESULT_ERROR;
			} else {
			}//ダウンロードするファイルがある場合
				
				fileName = list.get(0).getBBS_FNAME();			//ダウンロードするファイルのNAME
				byte[] blob = list.get(0).getBBS_FDATA();		//ダウンロードするファイルのDATA
				inputStream = new ByteArrayInputStream(blob);

				ActionContext ac = ActionContext.getContext();
				HttpServletResponse response = (HttpServletResponse) ac
						.get(StrutsStatics.HTTP_RESPONSE);

				response.setContentType("application/octet-stream");
				response.setHeader(
						"Content-Disposition",
						"attachment;filename="
								+ URLEncoder.encode(fileName ,
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

		 catch (Exception e) {
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

