package com.lsp.logistics.service.ifac.order;

import java.util.Date;
import java.util.List;

import com.lsp.logistics.entity.OrderEntity;

public interface OrderServiceIfac {

	public boolean saveOrder(OrderEntity order);

	public List<OrderEntity> findAllOrder();

	public List<OrderEntity> findOrder(String orderId, String orderType,
			String orderState, String costomerName, String costomerMobailPhone,
			String orderBeginDate, String orderEndDate);

	public List<OrderEntity> findNeedDispatchOrder();

	public OrderEntity findById(Integer id);

	public boolean orderReturn(Integer id);

}
