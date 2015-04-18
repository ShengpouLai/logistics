package com.lsp.logistics.dao.impl.order;

import java.util.List;

import com.lsp.logistics.dao.ifac.order.GoodsReturnDetailDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.GoodsReturnDetail;

public class GoodsReturnDetailDaoImpl extends BaseDaoImpl<GoodsReturnDetail> implements GoodsReturnDetailDaoIfac {

	public GoodsReturnDetailDaoImpl() {
		super(GoodsReturnDetail.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<GoodsReturnDetail> findByOrderDetail(Integer id) {
		String hql = "from GoodsReturnDetail as g where g.orderDetail.id = " + id;
		return getHibernateTemplate().find(hql);
	}

}
