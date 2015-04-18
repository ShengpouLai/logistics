package com.lsp.logistics.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lsp.logistics.dao.ifac.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class<T> entityClass;

	/**
	 * @param entityClass
	 *            实体类的class
	 */
	public BaseDaoImpl(Class entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public boolean save(T entity) {
		try {
			getHibernateTemplate().save(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Integer id) {
		try {
			getHibernateTemplate().delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(T entity) {
		try {
			getHibernateTemplate().update(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public T findById(Integer id) {

		Object objEntity = getHibernateTemplate().get(entityClass, (Serializable) id);
		
		return (T) objEntity;
	}

	@Override
	public List<T> findAll() {
		String hql = "from " + entityClass.getName();
		List<T> list = getHibernateTemplate().find(hql);
		return list;
	}

}