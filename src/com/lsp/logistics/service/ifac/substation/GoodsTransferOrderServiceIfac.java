package com.lsp.logistics.service.ifac.substation;

import java.util.List;

import com.lsp.logistics.entity.GoodsTransferOrderEntity;
import com.lsp.logistics.entity.OrderEntity;

public interface GoodsTransferOrderServiceIfac {
	
	public boolean save(OrderEntity order);
	
	public List<GoodsTransferOrderEntity> findAll();
	
	public List<GoodsTransferOrderEntity> findTransferOrderList();

	public boolean upateState(Integer goodsTransferOrderId);

}
