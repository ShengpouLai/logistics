package com.lsp.logistics.service.impl.substation;

import java.util.List;

import com.lsp.logistics.dao.ifac.order.OrderDaoIfac;
import com.lsp.logistics.dao.ifac.substation.DeliveryOrderDaoIfac;
import com.lsp.logistics.dao.ifac.substation.ReceiptDaoIfac;
import com.lsp.logistics.dao.ifac.substation.TaskOrderDaoIfac;
import com.lsp.logistics.entity.DeliveryOrder;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.entity.ReceiptEntity;
import com.lsp.logistics.entity.TaskOrderEntity;
import com.lsp.logistics.service.ifac.substation.ReceiptServiceIfac;

public class ReceiptServiceImpl implements ReceiptServiceIfac {
	
	private ReceiptDaoIfac receiptDao;
	private TaskOrderDaoIfac taskOrder;
	private OrderDaoIfac orderDao;
	private DeliveryOrderDaoIfac deliveryOrderDao;

	public void setOrderDao(OrderDaoIfac orderDao) {
		this.orderDao = orderDao;
	}

	public void setDeliveryOrderDao(DeliveryOrderDaoIfac deliveryOrderDao) {
		this.deliveryOrderDao = deliveryOrderDao;
	}

	public void setTaskOrder(TaskOrderDaoIfac taskOrder) {
		this.taskOrder = taskOrder;
	}

	public void setReceiptDao(ReceiptDaoIfac receiptDao) {
		this.receiptDao = receiptDao;
	}

	@Override
	public boolean saveReceipt(ReceiptEntity receipt,Integer id) {
		
		/*
		 * 更改任务单状态
		 */
		TaskOrderEntity taskOrder = this.taskOrder.findById(id);
		taskOrder.setTaskOrderState("配送完成。");
		this.taskOrder.update(taskOrder);
		
		/*
		 * 更改订单状态
		 */
		OrderEntity order = taskOrder.getOrder();
		order.setOrderState("配送完成。");
		this.orderDao.update(order);
		
		/*
		 * 更改配送单状态
		 */
		DeliveryOrder deliveryOrder = this.deliveryOrderDao.findByTaskOrderId(id);
		deliveryOrder.setDeliveryOrderState("已完成");
		
		/*
		 * 回执录入
		 */
		receipt.setTask_Order(taskOrder);
		this.receiptDao.save(receipt);
		return true;
	}

	@Override
	public List<ReceiptEntity> findAllReceipt() {
		return this.receiptDao.findAll();
	}

}
