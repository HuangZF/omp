package com.ruyicai.omp.controller.tcash;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.ruyicai.omp.constant.PubConst;
import com.ruyicai.omp.controller.base.BaseAction;
import com.ruyicai.omp.domain.tcash.TcashDetail;
import com.ruyicai.omp.service.tcash.TcashDetailService;
import com.ruyicai.omp.util.JqGridSearchTo;

/**
 * tcashdetail core controller
 * @author hzf
 *
 */
public class TcashDetailController extends BaseAction implements ModelDriven<TcashDetail>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(TcashDetailController.class);

	private List<TcashDetail> gridModel;

	@Autowired
	private TcashDetailService tcashDetailService;

	private TcashDetail tcashDetail = new TcashDetail();

	public String queryTcashDetail(){
		try
		{
			JqGridSearchTo jqGridSearchTo = getJqGridSearchTo();
			// Count Rows
			setRecords(tcashDetailService.countTcashDetail(jqGridSearchTo));
			
			int to = (getRows() * getPage());
			if (to > getRecords()){
				to = getRecords();
			}
			
			// search list
			setGridModel(tcashDetailService.queryTcashDetailList(jqGridSearchTo, getRows(), getPage(), sidx, sord));
			// calculate the total pages for the query
			setTotal((int) Math.ceil((double) getRecords() / (double) getRows()));
		}catch(Exception e)
		{
			logger.error("get tcahDetail error: ", e);
		}
		return "success";
	}

	// edit operation
	public String edit(){
		if (oper.equalsIgnoreCase("add")) {

		}else if(oper.equalsIgnoreCase("edit")){

		} else if (oper.equalsIgnoreCase("del")){

		}
		return PubConst.EDIT_SUCCESS;
	}

	public List<TcashDetail> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<TcashDetail> gridModel) {
		this.gridModel = gridModel;
	}

	/**
	 * @return total pages for the query
	 */
	//要提供给页面的属性必须把get方法写在子类而不能写在BaseAction中
	public Integer getTotal() {
		return total;
	}

	/**
	 * @return current page of the query
	 */
	//要提供给页面的属性必须把get方法写在子类而不能写在BaseAction中
	public Integer getPage() {
		return page;
	}

	/**
	 * @return total number of records for the query. e.g. select count(*) from
	 *         table
	 */
	//要提供给页面的属性必须把get方法写在子类而不能写在BaseAction中
	public Integer getRecords() {
		return records;
	}

	/**
	 * override the ModelDriven interface getModel() method
	 */
	public TcashDetail getModel() {
		return tcashDetail;
	}

}
