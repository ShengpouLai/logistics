package com.lsp.logistics.service.impl.order;

import com.lsp.logistics.dao.ifac.order.OrderDaoIfac;
import com.lsp.logistics.dao.ifac.order.OrderReturnDaoIfac;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.entity.OrderReturnEntity;
import com.lsp.logistics.service.ifac.order.OrderReturnServiceIfac;

public class OrderReturnServiceImpl implements OrderReturnServiceIfac {
	
	private OrderReturnDaoIfac orderReturnDao;
	
	private OrderDaoIfac orderDao;

	public void setOrderDao(OrderDaoIfac orderDao) {
		this.orderDao = orderDao;
	}

	public void setOrderReturnDao(OrderReturnDaoIfac orderReturnDao) {
		this.orderReturnDao = orderReturnDao;
	}

	@Override
	public boolean save(OrderReturnEntity orderReturn, Integer integer) {
		OrderEntity order = this.orderDao.findById(integer);
		if(order.getOrderState().equals("订单已确认，等待调度。")){
			return this.orderReturnDao.save(orderReturn);
		}
		else{
			return false;
		}
	}

}
