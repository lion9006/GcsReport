package src.download.actionForm;

import java.util.ArrayList;

import src.bean.FileListInfoTBLBean;
import src.common.ActionForm;

/**
 * 
 * @author KWON.JUYONG
 * 
 */
public class DownloadListSearchForm extends ActionForm {

	private String SearchInfo;
	private String page = "1";
	private ArrayList<FileListInfoTBLBean> list = new ArrayList<FileListInfoTBLBean>();
	private ArrayList<Integer> pagingSearchList = new ArrayList<Integer>();

	/**
	 * @return the SearchInfo
	 */
	public String getSearchInfo() {
		return SearchInfo;
	}// End of getSearchInfo

	/**
	 * @param SearchInfo
	 *            the setSearchInfo to set
	 */
	public void setSearchInfo(String SearchInfo) {
		this.SearchInfo = SearchInfo;
	}// End of setSearchInfo

	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}// End of getPage

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}// End of setPage

	/**
	 * @return the list
	 */
	public ArrayList<FileListInfoTBLBean> getList() {
		return list;
	}// End of getList

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(ArrayList<FileListInfoTBLBean> list) {
		this.list = list;
	}// End of setList

	/**
	 * @return the pagingList
	 */
	public ArrayList<Integer> getPagingSearchList() {
		return pagingSearchList;
	}// End of getPagingList

	/**
	 * @param pagingList
	 *            the pagingList to set
	 */
	public void setPagingSearchList(ArrayList<Integer> pagingList) {
		this.pagingSearchList = pagingSearchList;
	}// End of setPagingList

}
