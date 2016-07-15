package src.download.actionForm;

import java.util.ArrayList;

import src.bean.FileListInfoTBLBean;
import src.common.ActionForm;

/**
 * 
 * @author KWON.JUYONG
 * 
 */
public class DownloadListForm extends ActionForm {

	private String page = "1";
	private ArrayList<FileListInfoTBLBean> list = new ArrayList<FileListInfoTBLBean>();
	private ArrayList<Integer> pagingList = new ArrayList<Integer>();

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
	public ArrayList<Integer> getPagingList() {
		return pagingList;
	}// End of getPagingList

	/**
	 * @param pagingList
	 *            the pagingList to set
	 */
	public void setPagingList(ArrayList<Integer> pagingList) {
		this.pagingList = pagingList;
	}// End of setPagingList

}
