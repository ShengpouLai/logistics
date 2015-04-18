package com.lsp.logistics.dao.impl.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.storage.invoicing.CheckGoodsOrderDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.CheckGoodsOrder;

public class CheckGoodsOrderDaoImpl extends BaseDaoImpl<CheckGoodsOrder> implements CheckGoodsOrderDaoIfac {

	public CheckGoodsOrderDaoImpl() {
		super(CheckGoodsOrder.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CheckGoodsOrder> findNotPutIn() {
		String hql = "from CheckGoodsOrder as c where c.checkGoodsState = '1'";
		return getHibernateTemplate().find(hql);
	}

}
