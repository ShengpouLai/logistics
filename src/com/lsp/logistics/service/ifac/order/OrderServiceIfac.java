package com.lsp.logistics.service.ifac.order;

import java.util.Date;
import java.util.List;

import com.lsp.logistics.entity.OrderEntity;

public interface OrderServiceIfac {

	/**
	 * 新订订单
	 * @param order
	 * @return true
	 */
	public boolean saveOrder(OrderEntity order);

	/**
	 * 查询所有订单
	 * @return orderList
	 */
	public List<OrderEntity> findAllOrder();

	/**
	 * 按条件查询订单
	 * @param orderId
	 * @param orderType
	 * @param orderState
	 * @param costomerName
	 * @param costomerMobailPhone
	 * @param orderBeginDate
	 * @param orderEndDate
	 * @return orderList
	 */
	public List<OrderEntity> findOrder(String orderId, String orderType,
			String orderState, String costomerName, String costomerMobailPhone,
			String orderBeginDate, String orderEndDate);

	/**
	 * 查询需要调度的订单
	 * @return orderList
	 */
	public List<OrderEntity> findNeedDispatchOrder();

	/**
	 * 通过Id查询订单
	 * @param id
	 * @return order
	 */
	public OrderEntity findById(Integer id);

	/**
	 * 订单退订
	 * @param id
	 * @return true
	 */
	public boolean orderReturn(Integer id);

}
