package com.lsp.logistics.service.impl.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.order.OrderDetailDaoIfac;
import com.lsp.logistics.dao.ifac.storage.invoicing.CheckGoodsOrderDaoIfac;
import com.lsp.logistics.entity.CheckGoodsOrder;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.service.ifac.storage.invoicing.CheckGoodsOrderServiceIfac;

public class CheckGoodsOrderServiceImpl implements CheckGoodsOrderServiceIfac {
	
	private CheckGoodsOrderDaoIfac checkGoodsOrderDao;
	private OrderDetailDaoIfac orderDetailDao;

	public void setOrderDetailDao(OrderDetailDaoIfac orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	public void setCheckGoodsOrderDao(CheckGoodsOrderDaoIfac checkGoodsOrderDao) {
		this.checkGoodsOrderDao = checkGoodsOrderDao;
	}

	@Override
	public List<CheckGoodsOrder> findNotPutIn() {
		return this.checkGoodsOrderDao.findNotPutIn();
	}

	@Override
	public boolean updateOrderDetail(Integer substationCheckGoodsOrderId) {
		return false;
	}

	@Override
	public List<OrderDetailEntity> findOrderDetail(
			Integer substationCheckGoodsOrderId) {
		CheckGoodsOrder checkGoodsOrder = checkGoodsOrderDao.findById(substationCheckGoodsOrderId);
		
		return orderDetailDao.findByOrder(checkGoodsOrder.getGoodsTransferOrder().getT_order().getId());
	}

}
