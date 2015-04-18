package com.lsp.logistics.service.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.entity.CheckGoodsOrder;
import com.lsp.logistics.entity.OrderDetailEntity;

public interface CheckGoodsOrderServiceIfac {

	public List<CheckGoodsOrder> findNotPutIn();

	public boolean updateOrderDetail(Integer substationCheckGoodsOrderId);

	public List<OrderDetailEntity> findOrderDetail(
			Integer substationCheckGoodsOrderId);

}
