package com.lsp.logistics.service.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.entity.CheckGoodsOrder;
import com.lsp.logistics.entity.OrderDetailEntity;

public interface CheckGoodsOrderServiceIfac {

	/**
	 * 查询出等待接收入库的列表
	 * @return list
	 */
	public List<CheckGoodsOrder> findNotPutIn();

	/**
	 * 
	 * @param substationCheckGoodsOrderId
	 * @return
	 */
	public boolean updateOrderDetail(Integer substationCheckGoodsOrderId);

	/**
	 * 
	 * @param substationCheckGoodsOrderId
	 * @return
	 */
	public List<OrderDetailEntity> findOrderDetail(
			Integer substationCheckGoodsOrderId);

}
