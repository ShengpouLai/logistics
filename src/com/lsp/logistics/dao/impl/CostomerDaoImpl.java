package com.lsp.logistics.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.lsp.logistics.dao.ifac.CostomerDaoIfac;
import com.lsp.logistics.entity.CostomerEntity;

public class CostomerDaoImpl extends BaseDaoImpl<CostomerEntity> implements CostomerDaoIfac {

	public CostomerDaoImpl() {
		super(CostomerEntity.class);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 通过条件查找用户
	 * 
	 * @param costomerId 用户身份证号
	 * @param costomerName 用户姓名
	 * @param costomerMobailPhone 用户手机号
	 */
	@Override
	public List<CostomerEntity> findCostomer(String costomerId,
			String costomerName, String costomerMobailPhone) {
		String hql = "from CostomerEntity as c where ";
		if(costomerId.length() > 0){
			hql = hql + " c.costomerId = '" + costomerId + "' and ";
		}
		if(costomerName.length() > 0){
			hql = hql + " c.costomerName = '" + costomerName + "' and ";
		}
		if(costomerMobailPhone.length() > 0){
			hql = hql + " c.costomerMobailPhone = '" + costomerMobailPhone + "' and ";
		}
		if(hql.lastIndexOf("and ")==hql.length() -4)
		      hql=hql.substring(0,hql.lastIndexOf("and ")) ;
		if(hql.lastIndexOf("where ")==hql.length() -6)
		      hql=hql.substring(0,hql.lastIndexOf("where ")) ;
		return getHibernateTemplate().find(hql);
	}
	
}
