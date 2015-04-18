package com.lsp.logistics.dao.impl.supplier;

import java.util.List;

import com.lsp.logistics.dao.ifac.supplier.BuyGoodsOrderDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.BuyGoodsOrder;

public class BuyGoodsOrderDaoImpl extends BaseDaoImpl<BuyGoodsOrder> implements BuyGoodsOrderDaoIfac{

	public BuyGoodsOrderDaoImpl() {
		super(BuyGoodsOrder.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BuyGoodsOrder> findNoPutIn() {
		String hql = "from BuyGoodsOrder as b where b.buyGoodsOrderState = '1'";
		return getHibernateTemplate().find(hql);
	}

}
