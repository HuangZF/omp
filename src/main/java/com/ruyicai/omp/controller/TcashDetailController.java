package com.ruyicai.omp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.ruyicai.omp.constant.PubConst;
import com.ruyicai.omp.controller.base.BaseAction;
import com.ruyicai.omp.domain.TcashDetail;
import com.ruyicai.omp.service.TcashDetailService;

public class TcashDetailController extends BaseAction implements ModelDriven<TcashDetail>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<TcashDetail> gridModel;

	@Autowired
	private TcashDetailService tcashDetailService;

	private TcashDetail tcashDetail = new TcashDetail();

	public String showPage()
	{
		return "tcashdetail_page";
	}

	public String queryTcashDetail(){
		// Count Rows
		setRecords(tcashDetailService.countTcashDetail());
		// search list
		setGridModel(tcashDetailService.queryTcashDetailList1());
		int to = (getRows() * getPage());
		if (to > getRecords()){
			to = getRecords();
		}
		// calculate the total pages for the query
		setTotal((int) Math.ceil((double) getRecords() / (double) getRows()));

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

//	/**
//	 * @return total number of records for the query. e.g. select count(*) from
//	 *         table
//	 */
//	//要提供给页面的属性必须把get方法写在子类而不能写在BaseAction中
//	public Integer getRecords() {
//		return records;
//	}

	/**
	 * override  the ModelDriven interface method
	 */
	public TcashDetail getModel() {
		return tcashDetail;
	}

}
