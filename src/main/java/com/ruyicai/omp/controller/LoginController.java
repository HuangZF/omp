package com.ruyicai.omp.controller;

import com.ruyicai.omp.controller.base.BaseAction;

public class LoginController extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String doLogin()
	{
		return "success";
	}
	
	public String topMenu()
	{
		return "top_menu";
	}
	
	public String leftMenu()
	{
		return "left_menu";
	}
	
	public String rigth()
	{
		return "right";
	}
}
