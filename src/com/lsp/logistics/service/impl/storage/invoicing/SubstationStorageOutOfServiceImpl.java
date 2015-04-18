package com.lsp.logistics.service.impl.storage.invoicing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lsp.logistics.dao.ifac.order.OrderDaoIfac;
import com.lsp.logistics.dao.ifac.order.OrderDetailDaoIfac;
import com.lsp.logistics.dao.ifac.storage.GoodsNumberDaoIfac;
import com.lsp.logistics.dao.ifac.storage.invoicing.SubstationStorageOutOfDaoIfac;
import com.lsp.logistics.dao.ifac.substation.DeliveryOrderDaoIfac;
import com.lsp.logistics.dao.ifac.substation.TaskOrderDaoIfac;
import com.lsp.logistics.entity.DeliveryOrder;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.entity.SubstationStorageOutOfOrder;
import com.lsp.logistics.entity.TaskOrderEntity;
import com.lsp.logistics.service.ifac.storage.invoicing.SubstationStorageOutOfServiceIfac;

public class SubstationStorageOutOfServiceImpl implements SubstationStorageOutOfServiceIfac {
	
	private SubstationStorageOutOfDaoIfac substationStorageOutOfDao;
	private TaskOrderDaoIfac taskOrderDao;
	private OrderDaoIfac orderDao;
	private DeliveryOrderDaoIfac deliveryOrderDao;
	private OrderDetailDaoIfac orderDetailDao;
	private GoodsNumberDaoIfac goodsNumberDao;

	public void setOrderDetailDao(OrderDetailDaoIfac orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	public void setGoodsNumberDao(GoodsNumberDaoIfac goodsNumberDao) {
		this.goodsNumberDao = goodsNumberDao;
	}

	public void setDeliveryOrderDao(DeliveryOrderDaoIfac deliveryOrderDao) {
		this.deliveryOrderDao = deliveryOrderDao;
	}

	public void setOrderDao(OrderDaoIfac orderDao) {
		this.orderDao = orderDao;
	}

	public void setTaskOrderDao(TaskOrderDaoIfac taskOrderDao) {
		this.taskOrderDao = taskOrderDao;
	}

	public void setSubstationStorageOutOfDao(
			SubstationStorageOutOfDaoIfac substationStorageOutOfDao) {
		this.substationStorageOutOfDao = substationStorageOutOfDao;
	}

	@Override
	public boolean save(Integer id) {
		try {
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			/*
			 * 生成分站出库单
			 */
			TaskOrderEntity taskOrder = this.taskOrderDao.findById(id);
			SubstationStorageOutOfOrder substationStorageOutOfOrder = new SubstationStorageOutOfOrder();
			substationStorageOutOfOrder.setTaskOrder(taskOrder);
			try {
				substationStorageOutOfOrder.setSubstationStorageOutOfOrderDate(format1.parse(format1.format(new Date())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			this.substationStorageOutOfDao.save(substationStorageOutOfOrder);

			/*
			 * 更改订单状态
			 */
			OrderEntity order = taskOrder.getOrder();
			order.setOrderState("配送员已领货，请耐心等待配送。");
			this.orderDao.update(order);

			/*
			 * 更改任务单状态
			 */
			taskOrder.setTaskOrderState("配送员已领货，请耐心等待配送。");
			this.taskOrderDao.update(taskOrder);
			
			/*
			 * 更改配送单状态
			 */
			DeliveryOrder deliveryOrder = this.deliveryOrderDao.findByTaskOrderId(id);
			deliveryOrder.setDeliveryOrderState("已领货，配送中");
			this.deliveryOrderDao.update(deliveryOrder);

			/*
			 * 更改库房货物数量
			 */
			List<OrderDetailEntity> orderDetailList = this.orderDetailDao.findByOrder(order.getId());
			StorageEntity storage = taskOrder.getSubstation().getStorage();
			
			try {
				for (int i = 0; i < orderDetailList.size(); i++) {
					GoodsNumberEntity goodsNumber = this.goodsNumberDao.find(orderDetailList.get(i).getGoods(), storage);
					/*
					 * 总量减去分配给配送员的数量
					 * 可分配量不变
					 * 已分配量减去分配给配送员的数量
					 */
					goodsNumber.setCannotDistributeQuantity(goodsNumber.getCannotDistributeQuantity() - orderDetailList.get(i).getGoodsNumber());
					goodsNumber.setTotalQuantity(goodsNumber.getTotalQuantity() - orderDetailList.get(i).getGoodsNumber());
					goodsNumberDao.update(goodsNumber);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return true;
	}

	@Override
	public List<SubstationStorageOutOfOrder> find(Integer id, String invoicingEndDate,
			String invoicingBeginDate) {
		return this.substationStorageOutOfDao.find(id, invoicingEndDate,invoicingBeginDate);
	}

}
