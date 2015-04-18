package com.lsp.logistics.service.impl.storage.invoicing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lsp.logistics.dao.ifac.order.OrderDaoIfac;
import com.lsp.logistics.dao.ifac.order.OrderDetailDaoIfac;
import com.lsp.logistics.dao.ifac.storage.GoodsNumberDaoIfac;
import com.lsp.logistics.dao.ifac.storage.invoicing.CentralStorageOutOfOrderDaoIfac;
import com.lsp.logistics.dao.ifac.storage.invoicing.CheckGoodsOrderDaoIfac;
import com.lsp.logistics.dao.ifac.storage.invoicing.DisreibutionOrderDaoIfac;
import com.lsp.logistics.dao.ifac.substation.GoodsTransferOrderDaoIfac;
import com.lsp.logistics.dao.ifac.substation.TaskOrderDaoIfac;
import com.lsp.logistics.entity.CentralStorageOutOfOrder;
import com.lsp.logistics.entity.CheckGoodsOrder;
import com.lsp.logistics.entity.DisreibutionOrderEntity;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.GoodsTransferOrderEntity;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.entity.TaskOrderEntity;
import com.lsp.logistics.service.ifac.storage.invoicing.DisreibutionOrderServiceIfac;

public class DisreibutionOrderServiceImpl implements DisreibutionOrderServiceIfac {
	
	private DisreibutionOrderDaoIfac disreibutionOrderDao;
	private GoodsTransferOrderDaoIfac gtOrderDao;
	private OrderDaoIfac orderDao;
	private CentralStorageOutOfOrderDaoIfac centralStorageOutOfOrderDao;
	private OrderDetailDaoIfac orderDetailDao;
	private GoodsNumberDaoIfac goodsNumberDao;
	private CheckGoodsOrderDaoIfac checkGoodsOrderDao;
	private TaskOrderDaoIfac taskOrderDao;

	public void setTaskOrderDao(TaskOrderDaoIfac taskOrderDao) {
		this.taskOrderDao = taskOrderDao;
	}

	public void setCheckGoodsOrderDao(CheckGoodsOrderDaoIfac checkGoodsOrderDao) {
		this.checkGoodsOrderDao = checkGoodsOrderDao;
	}

	public void setGoodsNumberDao(GoodsNumberDaoIfac goodsNumberDao) {
		this.goodsNumberDao = goodsNumberDao;
	}

	public void setOrderDetailDao(OrderDetailDaoIfac orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	public void setCentralStorageOutOfOrderDao(
			CentralStorageOutOfOrderDaoIfac centralStorageOutOfOrderDao) {
		this.centralStorageOutOfOrderDao = centralStorageOutOfOrderDao;
	}

	public void setOrderDao(OrderDaoIfac orderDao) {
		this.orderDao = orderDao;
	}

	public void setGtOrderDao(GoodsTransferOrderDaoIfac gtOrderDao) {
		this.gtOrderDao = gtOrderDao;
	}

	public void setDisreibutionOrderDao(
			DisreibutionOrderDaoIfac disreibutionOrderDao) {
		this.disreibutionOrderDao = disreibutionOrderDao;
	}

	@Override
	public boolean save(Integer transferOrderId) {
		/*
		 * 保存分发单
		 */
		DisreibutionOrderEntity disreibutionOrder = new DisreibutionOrderEntity();
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("yyyyMMddhhmmss");
		String disreibutionOrderId = format2.format(new Date());
		Date distributionOrderDate = new Date();
		try {
			distributionOrderDate = format1.parse(format1.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		GoodsTransferOrderEntity goodsTransferOrder = new GoodsTransferOrderEntity();
		goodsTransferOrder = gtOrderDao.findById(transferOrderId);
		
		disreibutionOrder.setGoodsTransferOrder(goodsTransferOrder);
		disreibutionOrder.setDisreibutionOrderId(disreibutionOrderId);
		disreibutionOrder.setDistributionOrderDate(distributionOrderDate);
		this.disreibutionOrderDao.save(disreibutionOrder);
		
		/*
		 * 保存验货单
		 */
		Date putInTime = new Date();
		try {
			putInTime = format2.parse(format2.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		CheckGoodsOrder checkGoodsOrder = new CheckGoodsOrder();
		checkGoodsOrder.setCheckGoodsOrderId(disreibutionOrderId);
		checkGoodsOrder.setPutInTime(putInTime);
		checkGoodsOrder.setGoodsTransferOrder(goodsTransferOrder);
		checkGoodsOrder.setCheckGoodsState("1");
		this.checkGoodsOrderDao.save(checkGoodsOrder);
		
		/*
		 * 更改商品调拨单状态
		 */
		goodsTransferOrder.setGoodsTransferType("0");
		this.gtOrderDao.update(goodsTransferOrder);
		
		/*
		 * 保存中心库房出库单
		 */
		CentralStorageOutOfOrder centralStorageOutOfOrder = new CentralStorageOutOfOrder();
		centralStorageOutOfOrder.setCentralStorageOutOfOrderId(disreibutionOrderId);
		Date centralStorageOutOfTime = new Date();
		try {
			centralStorageOutOfTime = format2.parse(format2.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		centralStorageOutOfOrder.setCentralStorageOutOfTime(centralStorageOutOfTime);
		centralStorageOutOfOrder.setGoodsTransferOrder(goodsTransferOrder);
		this.centralStorageOutOfOrderDao.save(centralStorageOutOfOrder);
		
		/*
		 * 更改订单状态
		 */
		OrderEntity order = new OrderEntity();
		order = this.orderDao.findById(goodsTransferOrder.getT_order().getId());
		order.setOrderState("订单已从中心库房出库，运输公司配送中。");
		this.orderDao.update(order);
		
		/*
		 * 更改任务单状态
		 */
		TaskOrderEntity taskOrder = this.taskOrderDao.findByOrder(goodsTransferOrder.getT_order().getId());
		taskOrder.setTaskOrderState("订单已从中心库房出库，运输公司配送中。");
		this.taskOrderDao.update(taskOrder);
		
		/*
		 * 更改商品库存量
		 */
		GoodsNumberEntity goodsNumber = new GoodsNumberEntity();
		OrderDetailEntity orderDetail = new OrderDetailEntity();
		List<OrderDetailEntity> orderDetailList = new ArrayList<OrderDetailEntity>();
		orderDetailList = this.orderDetailDao.findByOrder(goodsTransferOrder.getT_order().getId());
		System.out.println(orderDetailList.size());
		for (int i = 0; i < orderDetailList.size(); i++) {
			orderDetail = orderDetailList.get(i);
			Integer a = orderDetail.getGoodsNumber();//获得商品数量
			goodsNumber = this.goodsNumberDao.findShortGoodsNumber(orderDetail.getGoods()).get(0);
			goodsNumber.setCannotDistributeQuantity(goodsNumber.getCannotDistributeQuantity() - a);
			goodsNumberDao.update(goodsNumber);
		}
		
		return true;
	}

}
