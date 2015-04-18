package com.lsp.logistics.service.ifac.order;

import java.util.List;

import com.lsp.logistics.entity.OrderDetailEntity;

public interface OrderDetailServiceIfac {
	
	public boolean saveOrderDetail(Integer goodsId);
	
	public List<OrderDetailEntity> findByOrder(Integer integer);

	public OrderDetailEntity findById(Integer id);
	
}
