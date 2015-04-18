package com.lsp.logistics.dao.impl.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.storage.invoicing.CentralStoragePutInOrderDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.CentralStoragePutInOrder;

public class CentralStoragePutInOrderDaoImpl extends BaseDaoImpl<CentralStoragePutInOrder> implements CentralStoragePutInOrderDaoIfac {

	public CentralStoragePutInOrderDaoImpl() {
		super(CentralStoragePutInOrder.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CentralStoragePutInOrder> find(String invoicingEndDate,
			String invoicingBeginDate) {
		String hql = "from CentralStoragePutInOrder as o where ";
		if(invoicingEndDate.length()>0 && invoicingBeginDate.length()>0){
			hql = hql + " o.actualPutInDate BETWEEN '" + invoicingBeginDate + "' and '" + invoicingEndDate + "' and ";
		}
		if(hql.lastIndexOf("and ")==hql.length() -4)
		      hql=hql.substring(0,hql.lastIndexOf("and ")) ;
		if(hql.lastIndexOf("where ")==hql.length() -6)
		      hql=hql.substring(0,hql.lastIndexOf("where ")) ;
		return getHibernateTemplate().find(hql);
	}

}
