package com.lsp.logistics.dao.impl.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.storage.invoicing.CentralStorageOutOfOrderDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.CentralStorageOutOfOrder;

public class CentralStorageOutOfOrderDaoImpl extends
		BaseDaoImpl<CentralStorageOutOfOrder> implements
		CentralStorageOutOfOrderDaoIfac {

	public CentralStorageOutOfOrderDaoImpl() {
		super(CentralStorageOutOfOrder.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CentralStorageOutOfOrder> find(String invoicingEndDate,
			String invoicingBeginDate) {
		String hql = "from CentralStorageOutOfOrder as o where ";
		if(invoicingEndDate.length()>0 && invoicingBeginDate.length()>0){
			hql = hql + " o.centralStorageOutOfTime BETWEEN '" + invoicingBeginDate + "' and '" + invoicingEndDate + "' and ";
		}
		if(hql.lastIndexOf("and ")==hql.length() -4)
		      hql=hql.substring(0,hql.lastIndexOf("and ")) ;
		if(hql.lastIndexOf("where ")==hql.length() -6)
		      hql=hql.substring(0,hql.lastIndexOf("where ")) ;
		return getHibernateTemplate().find(hql);
	}

}
