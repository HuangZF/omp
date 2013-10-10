/**
 * 
 */
package com.ruyicai.omp.controller.base;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionSupport;
import com.ruyicai.omp.util.JqGridSearchTo;


/**
 * @author hzf
 * 
 */
public class BaseAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 7819012021395364005L;
	protected final Log logger = LogFactory.getLog(getClass());
	protected String oper = "";
	protected Map<String, Object> session;
	// get how many rows we want to have into the grid - rowNum attribute in the
	// grid
	protected Integer rows = 0;
	// Get the requested page. By default grid sets this to 1.
	protected Integer page = 0;
	// Your Total Pages
	protected Integer total = 0;
	// All Records
	protected Integer records = 0;
	// sorting order - asc or desc
	protected String sord;
	// get index row - i.e. user click to sort.排序字段
	protected String sidx;

	// Search Field
	protected String searchField;
	// The Search String
	protected String searchString;
	// he Search Operation
	// ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	protected String searchOper;
	//一页显示全部数据，不分页
	protected boolean loadonce = false;
	private String	filters;

	public String getFilters() {
		return filters;
	}


	public void setFilters(String filters) {
		this.filters = filters;
	}

	/**
	 * @return how many rows we want to have into the grid
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            how many rows we want to have into the grid
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	/**
	 * @return current page of the query
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page
	 *            current page of the query
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return total pages for the query
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            total pages for the query
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return total number of records for the query. e.g. select count(*) from
	 *         table
	 */
	public Integer getRecords() {
		return records;
	}

	/**
	 * @param records
	 *            total number of records for the query. e.g. select count(*)
	 *            from table
	 */
	public void setRecords(Integer records) {

		this.records = records;

		if (this.records > 0 && this.rows > 0) {
			this.total = (int) Math.ceil((double) this.records
					/ (double) this.rows);
		} else {
			this.total = 0;
		}
	}



	/**
	 * @return sorting order
	 */
	public String getSord() {
		return sord;
	}

	/**
	 * @param sord
	 *            sorting order
	 */
	public void setSord(String sord) {
		this.sord = sord;
	}

	/**
	 * @return get index row - i.e. user click to sort.
	 */
	public String getSidx() {
		return sidx;
	}

	/**
	 * @param sidx
	 *            get index row - i.e. user click to sort.
	 */
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public void setLoadonce(boolean loadonce) {
		this.loadonce = loadonce;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
	
	protected JqGridSearchTo getJqGridSearchTo(){
		/*
		 *  filters =    
    		{	"groupOp":"AND",   
     			"rules":[   
       			{"field":"invdate","op":"ge","data":"2007-10-06"},   
       			{"field":"invdate","op":"le","data":"2007-10-20"},    
       			{"field":"name","op":"bw","data":"Client 3"}   
      			]   
    		} 
		 */
		JqGridSearchTo jqGridSearchTo = null;
		if(getFilters()!=null && !"".equals(getFilters())){
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				jqGridSearchTo = mapper.readValue(getFilters(), JqGridSearchTo.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jqGridSearchTo;
	}
	
}
