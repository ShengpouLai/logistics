package com.lsp.logistics.dao.impl.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.storage.invoicing.SubstationStoragePutInOrderDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.SubstationStoragePutInOrder;

public class SubstationStoragePutInOrderDaoImpl extends BaseDaoImpl<SubstationStoragePutInOrder> implements SubstationStoragePutInOrderDaoIfac{

	public SubstationStoragePutInOrderDaoImpl() {
		super(SubstationStoragePutInOrder.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SubstationStoragePutInOrder> find(Integer id, String invoicingEndDate,
			String invoicingBeginDate) {
		String hql = "from SubstationStoragePutInOrder as o where o.checkGoodsOrder.goodsTransferOrder.substation.storage.id = " + id + " and ";
		if(invoicingEndDate.length()>0 && invoicingBeginDate.length()>0){
			hql = hql + " o.substationStoragePutInDate BETWEEN '" + invoicingBeginDate + "' and '" + invoicingEndDate + "' and ";
		}
		if(hql.lastIndexOf("and ")==hql.length() -4)
		      hql=hql.substring(0,hql.lastIndexOf("and ")) ;
		if(hql.lastIndexOf("where ")==hql.length() -6)
		      hql=hql.substring(0,hql.lastIndexOf("where ")) ;
		return getHibernateTemplate().find(hql);
	}

}
