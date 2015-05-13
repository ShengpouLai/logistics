package com.lsp.logistics.service.impl.substation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lsp.logistics.dao.ifac.order.OrderDaoIfac;
import com.lsp.logistics.dao.ifac.order.OrderDetailDaoIfac;
import com.lsp.logistics.dao.ifac.storage.GoodsNumberDaoIfac;
import com.lsp.logistics.dao.ifac.substation.DeliveryOrderDaoIfac;
import com.lsp.logistics.dao.ifac.substation.DeliveryStaffDaoIfac;
import com.lsp.logistics.dao.ifac.substation.GoodsTransferOrderDaoIfac;
import com.lsp.logistics.dao.ifac.substation.SignOrderDaoIfac;
import com.lsp.logistics.dao.ifac.substation.SubstationDaoIfac;
import com.lsp.logistics.dao.ifac.substation.TaskOrderDaoIfac;
import com.lsp.logistics.entity.DeliveryOrder;
import com.lsp.logistics.entity.DeliveryStaffEntity;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.GoodsTransferOrderEntity;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.entity.SignOrder;
import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.entity.TaskOrderEntity;
import com.lsp.logistics.service.ifac.substation.TaskOrderServiceIfac;

public class TaskOrderServiceImpl implements TaskOrderServiceIfac {
	private TaskOrderDaoIfac taskOrderDao;
	private OrderDaoIfac orderDao;
	private GoodsTransferOrderDaoIfac gtOrderDao;
	private SubstationDaoIfac substationDao;
	private DeliveryStaffDaoIfac deliveryStaffDao;
	private SignOrderDaoIfac signOrderDao;
	private DeliveryOrderDaoIfac deliveryOrderDao;
	private OrderDetailDaoIfac orderDetailDao;
	private GoodsNumberDaoIfac goodsNumberDao;

	public void setGoodsNumberDao(GoodsNumberDaoIfac goodsNumberDao) {
		this.goodsNumberDao = goodsNumberDao;
	}

	public void setOrderDetailDao(OrderDetailDaoIfac orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	public void setDeliveryOrderDao(DeliveryOrderDaoIfac deliveryOrderDao) {
		this.deliveryOrderDao = deliveryOrderDao;
	}

	public void setSignOrderDao(SignOrderDaoIfac signOrderDao) {
		this.signOrderDao = signOrderDao;
	}

	public void setDeliveryStaffDao(DeliveryStaffDaoIfac deliveryStaffDao) {
		this.deliveryStaffDao = deliveryStaffDao;
	}

	public void setSubstationDao(SubstationDaoIfac substationDao) {
		this.substationDao = substationDao;
	}

	public void setGtOrderDao(GoodsTransferOrderDaoIfac gtOrderDao) {
		this.gtOrderDao = gtOrderDao;
	}

	public void setOrderDao(OrderDaoIfac orderDao) {
		this.orderDao = orderDao;
	}

	public void setTaskOrderDao(TaskOrderDaoIfac taskOrderDao) {
		this.taskOrderDao = taskOrderDao;
	}

	@Override
	public List<TaskOrderEntity> findAllTaskOrder() {
		return this.taskOrderDao.findAll();
	}

	@Override
	public boolean saveTaskOrder(Integer storageId, Integer orderId) {
		/*
		 * 修改订单状态
		 * 1、获得订单
		 * 2、修改其状态
		 */
		OrderEntity order = new OrderEntity();
		
		try {
			order = this.orderDao.findById(orderId);
			order.setOrderState("订单已调度，等待中心库房出库。");
			this.orderDao.update(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//生成任务单号
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("yyyyMMddhhmmss");
		String taskOrderId = format2.format(new Date());
		String a = format1.format(new Date());
		
		/*
		 * 生成商品调拨单
		 */
		GoodsTransferOrderEntity gtOrder = new GoodsTransferOrderEntity();
		gtOrder.setT_order(order);
		gtOrder.setGoodsTransferOrderId(order.getId()+"");
		
		try {
			Date gtDate  = format1.parse(a);
			gtOrder.setGoodsTransferDate(gtDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		gtOrder.setGoodsTransferType("1");
		gtOrder.setSubstation(substationDao.findById(storageId));
		gtOrderDao.save(gtOrder);
		
		
		/*
		 * 新建任务单
		 */
		TaskOrderEntity taskOrder = new TaskOrderEntity();
		taskOrder.setOrder(order);
		taskOrder.setTaskOrderId(taskOrderId + order.getId());
		taskOrder.setTaskOrderState("订单已调度，等待中心库房出库。");
		taskOrder.setTaskOrderType("送货收款");
//		substationDao.findById(storageId);
		taskOrder.setSubstation(substationDao.findById(storageId));
		if(this.taskOrderDao.save(taskOrder)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public List<TaskOrderEntity> findToAllocation() {
		return this.taskOrderDao.findToAllocation();
	}

	@Override
	public boolean taskAllocation(Integer deliveryStaffId) {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		
		/*
		 * 更改任务单状态
		 */
		TaskOrderEntity taskOrder = this.taskOrderDao.findById((Integer)session.getAttribute("taskOrderId"));
		taskOrder.setTaskOrderState("订单已分配，等待配送员配送。");
		
		/*
		 * 给任务单分配配送员
		 */
		DeliveryStaffEntity deliveryStaff = this.deliveryStaffDao.findById(deliveryStaffId);
		taskOrder.setDeliveryStaff(deliveryStaff);
		
		taskOrderDao.update(taskOrder);
		
		/*
		 * 更改订单状态
		 */
		OrderEntity order = this.orderDao.findById(taskOrder.getOrder().getId());
		order.setOrderState("订单已分配，等待配送员配送。");
		orderDao.update(order);
		
		/*
		 * 补打商品签收单
		 */
		SignOrder signOrder = new SignOrder();
		signOrder.setTaskOrder(taskOrder);
		this.signOrderDao.save(signOrder);
		
		/*
		 * 生成配送单
		 */
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		deliveryOrder.setDeliveryOrderState("未领货");
		deliveryOrder.setTaskOrder(taskOrder);
		this.deliveryOrderDao.save(deliveryOrder);
		
		/*
		 * 更改库房货物数量
		 */
		List<OrderDetailEntity> orderDetailList = this.orderDetailDao.findByOrder(order.getId());
		StorageEntity storage = taskOrder.getSubstation().getStorage();
		try {
			for (int i = 0; i < orderDetailList.size(); i++) {
				GoodsNumberEntity goodsNumber = this.goodsNumberDao.find(orderDetailList.get(i).getGoods(), storage);
				/*
				 * 总量不变，变的是可分配量和已分配量
				 * 可分配量减去分配给配送员的数量
				 * 已分配量加上分配给配送员的数量
				 */
				goodsNumber.setCanDistributeQuantity(goodsNumber.getCanDistributeQuantity() - orderDetailList.get(i).getGoodsNumber());
				goodsNumber.setCannotDistributeQuantity(goodsNumber.getCannotDistributeQuantity() + orderDetailList.get(i).getGoodsNumber());
				goodsNumberDao.update(goodsNumber);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return true;
	}

	@Override
	public TaskOrderEntity findById(Integer id) {
		return this.taskOrderDao.findById(id);
	}

	@Override
	public List<TaskOrderEntity> findToOutOf() {
		return this.taskOrderDao.findToOutOf();
	}

	@Override
	public List<TaskOrderEntity> findReceiptEnter() {
		return this.taskOrderDao.findReceiptEnter();
	}

	@Override
	public List<TaskOrderEntity> findTaskOrder(String taskOrderId,
			String taskState, String substationId, String costomerName,
			String costomerPhone, String orderDeliverDate) {
		return this.taskOrderDao.findTaskOrder(taskOrderId, taskState, substationId, costomerName, costomerPhone, orderDeliverDate);
	}

	@Override
	public List<TaskOrderEntity> findTask(String substationName) {
		return this.taskOrderDao.findTask(substationName);
	}

	@Override
	public List<TaskOrderEntity> receipt_task_find(String taskOrderId,
			String deliveryStaffName) {
		return this.taskOrderDao.receipt_task_find(taskOrderId, deliveryStaffName);
	}

}
