package com.ruyicai.omp.dao.ibatis.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class BaseDAOIbatis extends SqlMapClientDaoSupport {

	public List findObjectsByProperties(String sql) {
		return super.getSqlMapClientTemplate().queryForList(sql);
	}

	public List findObjectsByProperties(String sql, Object values) {
		return super.getSqlMapClientTemplate().queryForList(sql, values);
	}

	public Object findObjectByProperties(String sql) {
		return super.getSqlMapClientTemplate().queryForObject(sql);
	}

	public Object findObjectByProperties(String sql, Object values) {
		return super.getSqlMapClientTemplate().queryForObject(sql, values);
	}

	public List findObjectsByPage(String sql, int pageSize, int pageNum) {
		int startIndex = (pageNum - 1) * pageSize;
		return super.getSqlMapClientTemplate().queryForList(sql, null,
				startIndex, pageSize);
	}
	
	public List findObjectsByPage(String sql, Object args, int pageSize,
			int pageNum) {
		int startIndex = (pageNum - 1) * pageSize;
		return super.getSqlMapClientTemplate().queryForList(sql, args,
				startIndex, pageSize);
	}

	public Object getObject(String sql, Serializable id) {
		return super.getSqlMapClientTemplate().queryForObject(sql, id);
	}

	public long getObjectTotal(String sql) {
		return (Long) super.getSqlMapClientTemplate().queryForObject(sql);
	}

	public long getObjectTotal(String sql, Object args) {
		return (Long) super.getSqlMapClientTemplate().queryForObject(sql, args);
	}

	public void saveObject(String sql, Object args) {
		super.getSqlMapClientTemplate().insert(sql, args);
	}

	public int updateObject(String sql, Object args) {
		return super.getSqlMapClientTemplate().update(sql, args);
	}

	public int removeObject(String sql, Object args) {
		return super.getSqlMapClientTemplate().delete(sql, args);
	}
	
	public List findObjects(String sql, Object args) {
		return super.getSqlMapClientTemplate().queryForList(sql, args);
	}
	
}
