package com.ruyicai.omp.service.support;

import org.springframework.beans.factory.annotation.Autowired;

import com.ruyicai.omp.dao.ibatis.base.BaseDAOIbatis;

/** 
 * @author hzf
 * <p>manager dao</p>
 * <p>support one or more dao access</p>
 */
public class ManagerSupport
{
	@Autowired
	protected BaseDAOIbatis dao;

	public BaseDAOIbatis getDao()
	{
		return dao;
	}

	public void setDao(BaseDAOIbatis dao)
	{
		this.dao = dao;
	}

}
