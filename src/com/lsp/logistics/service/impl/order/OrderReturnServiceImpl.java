package com.lsp.logistics.service.impl.order;

import java.util.List;

import com.lsp.logistics.dao.ifac.order.OrderDaoIfac;
import com.lsp.logistics.dao.ifac.order.OrderDetailDaoIfac;
import com.lsp.logistics.dao.ifac.order.OrderReturnDaoIfac;
import com.lsp.logistics.dao.ifac.storage.GoodsNumberDaoIfac;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.entity.OrderReturnEntity;
import com.lsp.logistics.service.ifac.order.OrderReturnServiceIfac;

public class OrderReturnServiceImpl implements OrderReturnServiceIfac {
	
	private OrderReturnDaoIfac orderReturnDao;
	
	private OrderDaoIfac orderDao;
	
	private OrderDetailDaoIfac orderDetailDao;
	
	private GoodsNumberDaoIfac goodsNumberDao;

	public void setOrderDetailDao(OrderDetailDaoIfac orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	public void setGoodsNumberDao(GoodsNumberDaoIfac goodsNumberDao) {
		this.goodsNumberDao = goodsNumberDao;
	}

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
			List<OrderDetailEntity> list = this.orderDetailDao.findByOrder(integer);
			for (int i = 0; i < list.size(); i++) {
				GoodsNumberEntity goodsNumber = (GoodsNumberEntity) this.goodsNumberDao.findShortGoodsNumber(list.get(i).getGoods()).get(0);
				goodsNumber.setCannotDistributeQuantity(goodsNumber.getCannotDistributeQuantity() - list.get(i).getGoodsNumber());
				goodsNumber.setCanDistributeQuantity(goodsNumber.getCanDistributeQuantity() + list.get(i).getGoodsNumber());
				goodsNumberDao.update(goodsNumber);
			}
			return this.orderReturnDao.save(orderReturn);
		}
		else{
			return false;
		}
	}

}
