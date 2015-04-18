package com.lsp.logistics.dao.ifac;

import java.util.List;

/**
 * @author lsp
 */
public interface BaseDao<T> {
	public boolean save(T entity);

	public boolean delete(Integer id);

	public boolean update(T entity);

	public T findById(Integer id);
	
	public List<T> findAll();
}

