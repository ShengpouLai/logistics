package com.lsp.logistics.dao.impl.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.storage.invoicing.SubstationStorageOutOfDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.SubstationStorageOutOfOrder;

public class SubstationStorageOutOfDaoImpl extends BaseDaoImpl<SubstationStorageOutOfOrder> implements SubstationStorageOutOfDaoIfac{

	public SubstationStorageOutOfDaoImpl() {
		super(SubstationStorageOutOfOrder.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SubstationStorageOutOfOrder> find(Integer id, String invoicingEndDate,
			String invoicingBeginDate) {
		String hql = "from SubstationStorageOutOfOrder as o where o.taskOrder.substation.storage.id = " + id + " and ";
		if(invoicingEndDate.length()>0 && invoicingBeginDate.length()>0){
			hql = hql + " o.substationStorageOutOfOrderDate BETWEEN '" + invoicingBeginDate + "' and '" + invoicingEndDate + "' and ";
		}
		if(hql.lastIndexOf("and ")==hql.length() -4)
		      hql=hql.substring(0,hql.lastIndexOf("and ")) ;
		if(hql.lastIndexOf("where ")==hql.length() -6)
		      hql=hql.substring(0,hql.lastIndexOf("where ")) ;
		return getHibernateTemplate().find(hql);
	}

}
