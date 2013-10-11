package com.ruyicai.omp.controller;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.ruyicai.omp.controller.base.BaseAction;
import com.ruyicai.omp.model.User;
import com.ruyicai.omp.service.SSJDemoService;

@ParentPackage(value = "showcase")
public class SSJDemo extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -665966043255846041L;
	
	private String respCode;
	
	private List<User> gridModel;
	
	@Autowired
	private SSJDemoService ssjDemoService;
	
	@Action(value = "/jsontable" , results = {
	    	@Result(name = "success", type = "json", params = {"excludeProperties", "respCode"})
	    })
	public String queryJSON(){
		gridModel = ssjDemoService.queryUserList();
		
		// Count Rows
		setRecords(10000);
		int to = (getRows() * getPage());
		if (to > getRecords()){
			to = getRecords();
		}
		// calculate the total pages for the query
		setTotal((int) Math.ceil((double) getRecords() / (double) getRows()));
		
		return "success";
	}

	
	public List<User> getGridModel() {
		System.out.println("print gridModel");
		return gridModel;
	}

//	public void setGridModel(List<User> gridModel) {
//		this.gridModel = gridModel;
//	}
	
	// if set excludeProperties that the getter will not execute when respose,
	// because the intercepter will filter it
	public String getRespCode() {
		System.out.println("print respCode");
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
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

}
