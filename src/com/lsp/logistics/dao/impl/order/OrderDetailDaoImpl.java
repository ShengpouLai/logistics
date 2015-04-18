package com.lsp.logistics.dao.impl.order;

import java.util.List;

import com.lsp.logistics.dao.ifac.order.OrderDetailDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.entity.OrderEntity;

public class OrderDetailDaoImpl extends BaseDaoImpl<OrderDetailEntity> implements OrderDetailDaoIfac {

	public OrderDetailDaoImpl() {
		super(OrderDetailEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<OrderDetailEntity> findByOrder(Integer t_order) {
		String hql = "from OrderDetailEntity as o where o.order.id = '" + t_order + "'";
		return getHibernateTemplate().find(hql);
	}

}
