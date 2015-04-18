package com.lsp.logistics.service.impl.order;

import java.util.List;

import com.lsp.logistics.dao.ifac.goods.GoodsDaoIfac;
import com.lsp.logistics.dao.ifac.order.OrderDetailDaoIfac;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.service.ifac.order.OrderDetailServiceIfac;

public class OrderDetailServiceImpl implements OrderDetailServiceIfac {

	private OrderDetailDaoIfac orderDetailDao;
	private GoodsDaoIfac goodsDao;

	public void setGoodsDao(GoodsDaoIfac goodsDao) {
		this.goodsDao = goodsDao;
	}

	public void setOrderDetailDao(OrderDetailDaoIfac orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	@Override
	public boolean saveOrderDetail(Integer goodsId) {
		OrderDetailEntity orderDetail = new OrderDetailEntity();
		OrderEntity order = new OrderEntity();
		GoodsEntity goods = goodsDao.findById(goodsId);
		orderDetail.setGoods(goods);
		orderDetail.setGoodsNumber(1);
		orderDetail.setOrder(order);
		orderDetailDao.save(orderDetail);
		return true;
	}

	@Override
	public List<OrderDetailEntity> findByOrder(Integer integer) {
		return this.orderDetailDao.findByOrder(integer);
	}

	@Override
	public OrderDetailEntity findById(Integer id) {
		return this.orderDetailDao.findById(id);
	}

}
