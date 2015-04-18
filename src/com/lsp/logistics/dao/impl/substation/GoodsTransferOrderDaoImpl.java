package com.lsp.logistics.dao.impl.substation;

import java.util.List;

import com.lsp.logistics.dao.ifac.substation.GoodsTransferOrderDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.GoodsTransferOrderEntity;

public class GoodsTransferOrderDaoImpl extends BaseDaoImpl<GoodsTransferOrderEntity> implements GoodsTransferOrderDaoIfac {

	public GoodsTransferOrderDaoImpl() {
		super(GoodsTransferOrderEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<GoodsTransferOrderEntity> findTransferOrderList() {
		String hql = "from GoodsTransferOrderEntity as g where g.goodsTransferType = '1'";
		return getHibernateTemplate().find(hql);
	}

}
