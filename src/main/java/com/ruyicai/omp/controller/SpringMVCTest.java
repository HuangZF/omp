package com.ruyicai.omp.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.ruyicai.omp.controller.base.BaseAction;
import com.ruyicai.omp.model.User;
import com.ruyicai.omp.util.ResponseData;

@ParentPackage(value = "showcase")
public class SpringMVCTest extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -665966043255846041L;
	
	private String respCode = "0000";
	
	private List<User> gridModel;

	@Action(value = "/jsontable", results = {
	    	@Result(name = "success", type = "json", params ={"includeProperties","gridModel"})
	    })
	public String queryJSON(){
		ResponseData rd = new ResponseData();
		rd.setValue("test mvc");
		System.out.println("test mvc");
		
		gridModel = new ArrayList<User>();
		
		long start = System.currentTimeMillis();
		for(int i =0;i<100;i++)
		{
			User u = new User();
			u.setId(String.valueOf(i));
			u.setName("test" + String.valueOf(i));
			u.setCountry(String.valueOf(i));
			u.setCreditLimit(String.valueOf(i));
			u.setCity(String.valueOf(i));
			
			gridModel.add(u);
		}
		
		// Count Rows
		setRecords(10000);
		int to = (getRows() * getPage());
		if (to > getRecords()){
			to = getRecords();
		}
		// calculate the total pages for the query
		setTotal((int) Math.ceil((double) getRecords() / (double) getRows()));
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		return "success";
	}


	public List<User> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<User> gridModel) {
		this.gridModel = gridModel;
	}
	
	
	public String getRespCode() {
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
