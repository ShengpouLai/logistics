package com.lsp.logistics.service.impl.order;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lsp.logistics.dao.ifac.CostomerDaoIfac;
import com.lsp.logistics.dao.ifac.goods.GoodsDaoIfac;
import com.lsp.logistics.dao.ifac.order.OrderDaoIfac;
import com.lsp.logistics.dao.ifac.order.OrderDetailDaoIfac;
import com.lsp.logistics.entity.CostomerEntity;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.service.ifac.order.OrderServiceIfac;

public class OrderServiceImpl implements OrderServiceIfac {
	
	private OrderDaoIfac orderDao;
	private CostomerDaoIfac costomerDao;
	private GoodsDaoIfac goodsDao;
	private OrderDetailDaoIfac orderDetailDao;

	public void setOrderDetailDao(OrderDetailDaoIfac orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	public void setGoodsDao(GoodsDaoIfac goodsDao) {
		this.goodsDao = goodsDao;
	}

	public void setCostomerDao(CostomerDaoIfac costomerDao) {
		this.costomerDao = costomerDao;
	}

	public void setOrderDao(OrderDaoIfac orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public boolean saveOrder(OrderEntity order) {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		
		//订单Id和订单生产日期
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("yyyyMMddhhmmss");
		String a = format1.format(new Date());
		String orderId = format2.format(new Date());
		try {
			Date orderDate  = format1.parse(a);
			order.setOrderDate(orderDate);
			order.setOrderId(orderId);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//订单状态
		order.setOrderState("订单已确认，等待调度。");
		
		//下单客户
		order.setCostomer(costomerDao.findById((Integer)session.getAttribute("costomerId")));
		
		//订单总金额
		order.setOrderMoney((Double)session.getAttribute("goodsAllMoney"));
		
		//保存订单
		this.orderDao.save(order);
		
		/* 保存订单详细，首先得通过session找到货物Id，货物数量，货物，然后通过for循环保存订单详细 */
		List<Integer> buyGoodsList = new ArrayList<Integer>();
		List<Integer> buyGoodsNumberList = new ArrayList<Integer>();
		List<GoodsEntity> goodsNameList = new ArrayList<GoodsEntity>();
		
		if ((ArrayList<Integer>) session.getAttribute("buyGoodsList") != null) {
			buyGoodsList.addAll((ArrayList<Integer>) session
					.getAttribute("buyGoodsList"));
		}
		
		buyGoodsNumberList = new ArrayList<Integer>();
		if ((ArrayList<Integer>) session.getAttribute("buyGoodsNumberList") != null) {
			buyGoodsNumberList.addAll((ArrayList<Integer>) session
					.getAttribute("buyGoodsNumberList"));
		}
		
		for (int i = 0; i < buyGoodsList.size(); i++) {
			goodsNameList.add(goodsDao.findById(buyGoodsList.get(i)));
		}
		
		for (int i = 0; i < buyGoodsList.size(); i++) {
			OrderDetailEntity orderDetail = new OrderDetailEntity();
			
			//商品数量
			orderDetail.setGoodsNumber(buyGoodsNumberList.get(i));
			
			//商品
			orderDetail.setGoods(goodsNameList.get(i));
			
			//订单
			orderDetail.setOrder(order);
			
			//保存订单详细
			this.orderDetailDao.save(orderDetail);
		}
		
		//订单详细保存以后，得把session里面的内容清空，也就是清空购物车
		session.removeAttribute("buyGoodsNumberList");
		session.removeAttribute("buyGoodsList");
		session.removeAttribute("goodsNameList");
		
		return true;
	}

	@Override
	public List<OrderEntity> findAllOrder() {
		return this.orderDao.findAll();
	}

	@Override
	public List<OrderEntity> findOrder(String orderId, String orderType,
			String orderState, String costomerName, String costomerMobailPhone,
			String orderBeginDate, String orderEndDate) {
		return this.orderDao.findOrder(orderId, orderType, orderState, costomerName, costomerMobailPhone, orderBeginDate, orderEndDate);
	}

	/*
	 * 找出需要调度的订单
	 */
	@Override
	public List<OrderEntity> findNeedDispatchOrder() {
		return this.orderDao.findNeedDispatchOrder();
	}

	@Override
	public OrderEntity findById(Integer id) {
		return this.orderDao.findById(id);
	}

	@Override
	public boolean orderReturn(Integer id) {
		OrderEntity order = this.orderDao.findById(id);
		order.setOrderState("已退订");
		order.setOrderType("1");
		orderDao.update(order);
		return true;
	}

}
