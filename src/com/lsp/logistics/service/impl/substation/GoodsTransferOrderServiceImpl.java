package com.lsp.logistics.service.impl.substation;

import java.util.List;

import com.lsp.logistics.dao.ifac.substation.GoodsTransferOrderDaoIfac;
import com.lsp.logistics.entity.GoodsTransferOrderEntity;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.service.ifac.substation.GoodsTransferOrderServiceIfac;

public class GoodsTransferOrderServiceImpl implements GoodsTransferOrderServiceIfac {
	
	private GoodsTransferOrderDaoIfac gtOrderDao;

	public void setGtOrderDao(GoodsTransferOrderDaoIfac gtOrderDao) {
		this.gtOrderDao = gtOrderDao;
	}

	@Override
	public boolean save(OrderEntity order) {
		return false;
	}

	@Override
	public List<GoodsTransferOrderEntity> findAll() {
		return this.gtOrderDao.findAll();
	}

	@Override
	public List<GoodsTransferOrderEntity> findTransferOrderList() {
		return this.gtOrderDao.findTransferOrderList();
	}

	@Override
	public boolean upateState(Integer goodsTransferOrderId) {
		GoodsTransferOrderEntity goodsTransferOrder = new GoodsTransferOrderEntity();
		goodsTransferOrder = this.gtOrderDao.findById(goodsTransferOrderId);
		goodsTransferOrder.setGoodsTransferType("0");
		this.gtOrderDao.update(goodsTransferOrder);
		return true;
	}

}
