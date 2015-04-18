package com.lsp.logistics.service.impl.substation;

import com.lsp.logistics.dao.ifac.substation.DeliveryOrderDaoIfac;
import com.lsp.logistics.entity.DeliveryOrder;
import com.lsp.logistics.service.ifac.substation.DeliveryOrderServiceIfac;

public class DeliveryOrderServiceImpl implements DeliveryOrderServiceIfac {
	
	private DeliveryOrderDaoIfac deliveryOrderDao;

	public void setDeliveryOrderDao(DeliveryOrderDaoIfac deliveryOrderDao) {
		this.deliveryOrderDao = deliveryOrderDao;
	}

	@Override
	public DeliveryOrder findByTaskOrderId(Integer id) {
		return this.deliveryOrderDao.findByTaskOrderId(id);
	}

}
