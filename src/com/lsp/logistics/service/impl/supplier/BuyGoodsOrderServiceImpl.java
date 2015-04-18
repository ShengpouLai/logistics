package com.lsp.logistics.service.impl.supplier;

import java.util.List;

import com.lsp.logistics.dao.ifac.supplier.BuyGoodsOrderDaoIfac;
import com.lsp.logistics.entity.BuyGoodsOrder;
import com.lsp.logistics.service.ifac.supplier.BuyGoodsOrderServiceIfac;

public class BuyGoodsOrderServiceImpl implements BuyGoodsOrderServiceIfac {
	
	private BuyGoodsOrderDaoIfac buyGoodsOrderDao;

	public void setBuyGoodsOrderDao(BuyGoodsOrderDaoIfac buyGoodsOrderDao) {
		this.buyGoodsOrderDao = buyGoodsOrderDao;
	}

	@Override
	public boolean saveBuyGoodsOrder(BuyGoodsOrder buyGoodsOrder) {
		if(buyGoodsOrderDao.save(buyGoodsOrder)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public List<BuyGoodsOrder> findAll() {
		return this.buyGoodsOrderDao.findAll();
	}

	@Override
	public BuyGoodsOrder findById(Integer id) {
		return this.buyGoodsOrderDao.findById(id);
	}

	@Override
	public List<BuyGoodsOrder> findNoPutIn() {
		return this.buyGoodsOrderDao.findNoPutIn();
	}

	@Override
	public boolean updateBuyGoodsOrderState(Integer id) {
		BuyGoodsOrder buyGoodsOrder = new BuyGoodsOrder();
		buyGoodsOrder = this.buyGoodsOrderDao.findById(id);
		buyGoodsOrder.setBuyGoodsOrderState("0");
		buyGoodsOrderDao.update(buyGoodsOrder);
		return true;
	}
	
}
