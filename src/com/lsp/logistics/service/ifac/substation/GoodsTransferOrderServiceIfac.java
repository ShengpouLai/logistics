package com.lsp.logistics.service.ifac.substation;

import java.util.List;

import com.lsp.logistics.entity.GoodsTransferOrderEntity;
import com.lsp.logistics.entity.OrderEntity;

public interface GoodsTransferOrderServiceIfac {
	
	/**
	 * 保存商品调拨单
	 * @param order
	 * @return true
	 */
	public boolean save(OrderEntity order);
	
	/**
	 * 查询所有商品调拨单
	 * @return list
	 */
	public List<GoodsTransferOrderEntity> findAll();
	
	/**
	 * 查找等待调拨的商品调拨单
	 * @return list
	 */
	public List<GoodsTransferOrderEntity> findTransferOrderList();

	/**
	 * 修改商品调拨单状态
	 * @param goodsTransferOrderId
	 * @return true
	 */
	public boolean upateState(Integer goodsTransferOrderId);

}
