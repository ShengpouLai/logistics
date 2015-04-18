package com.lsp.logistics.dao.impl.substation;

import com.lsp.logistics.dao.ifac.substation.DeliveryOrderDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.DeliveryOrder;

public class DeliveryOrderDaoImpl extends BaseDaoImpl<DeliveryOrder> implements DeliveryOrderDaoIfac {

	public DeliveryOrderDaoImpl() {
		super(DeliveryOrder.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DeliveryOrder findByTaskOrderId(Integer id) {
		String hql = "from DeliveryOrder as d where d.taskOrder.id = " + id;
		return (DeliveryOrder) getHibernateTemplate().find(hql).get(0);
	}

}
