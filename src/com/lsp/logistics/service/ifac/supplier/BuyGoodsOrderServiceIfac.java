package com.lsp.logistics.service.ifac.supplier;

import java.util.List;

import com.lsp.logistics.entity.BuyGoodsOrder;

public interface BuyGoodsOrderServiceIfac {
	
	public boolean saveBuyGoodsOrder(BuyGoodsOrder buyGoodsOrder);
	
	public List<BuyGoodsOrder> findAll();
	
	public BuyGoodsOrder findById(Integer id);

	public List<BuyGoodsOrder> findNoPutIn();

	public boolean updateBuyGoodsOrderState(Integer id);

}
