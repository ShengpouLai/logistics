package com.lsp.logistics.service.impl.storage.invoicing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lsp.logistics.dao.ifac.order.OrderDaoIfac;
import com.lsp.logistics.dao.ifac.order.OrderDetailDaoIfac;
import com.lsp.logistics.dao.ifac.storage.GoodsNumberDaoIfac;
import com.lsp.logistics.dao.ifac.storage.invoicing.CheckGoodsOrderDaoIfac;
import com.lsp.logistics.dao.ifac.storage.invoicing.SubstationStoragePutInOrderDaoIfac;
import com.lsp.logistics.dao.ifac.substation.TaskOrderDaoIfac;
import com.lsp.logistics.entity.CheckGoodsOrder;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.entity.SubstationStoragePutInOrder;
import com.lsp.logistics.entity.TaskOrderEntity;
import com.lsp.logistics.service.ifac.storage.invoicing.SubstationStoragePutInOrderServiceIfac;

public class SubstationStoragePutInOrderServiceImpl implements SubstationStoragePutInOrderServiceIfac{
	
	private SubstationStoragePutInOrderDaoIfac substationStoragePutInDao;
	private CheckGoodsOrderDaoIfac checkGoodsDao;
	private OrderDaoIfac orderDao;
	private OrderDetailDaoIfac orderDetatilDao;
	private GoodsNumberDaoIfac goodsNumberDao;
	private TaskOrderDaoIfac taskOrderDao;

	public void setTaskOrderDao(TaskOrderDaoIfac taskOrderDao) {
		this.taskOrderDao = taskOrderDao;
	}

	public void setGoodsNumberDao(GoodsNumberDaoIfac goodsNumberDao) {
		this.goodsNumberDao = goodsNumberDao;
	}

	public void setOrderDetatilDao(OrderDetailDaoIfac orderDetatilDao) {
		this.orderDetatilDao = orderDetatilDao;
	}

	public void setOrderDao(OrderDaoIfac orderDao) {
		this.orderDao = orderDao;
	}

	public void setCheckGoodsDao(CheckGoodsOrderDaoIfac checkGoodsDao) {
		this.checkGoodsDao = checkGoodsDao;
	}

	public void setSubstationStoragePutInDao(
			SubstationStoragePutInOrderDaoIfac substationStoragePutInDao) {
		this.substationStoragePutInDao = substationStoragePutInDao;
	}

	@Override
	public boolean save(Integer integer) {
		CheckGoodsOrder checkGoodsOrder = this.checkGoodsDao.findById(integer);
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("yyyyMMddhhmmss");
		List<OrderDetailEntity> orderDetailList = this.orderDetatilDao.findByOrder(checkGoodsOrder.getGoodsTransferOrder().getT_order().getId());
		StorageEntity storage = checkGoodsOrder.getGoodsTransferOrder().getSubstation().getStorage();
		
		//分站库房货物入库
		//判断分站库房里有没有货物
		//1、循环遍历出商品种数
		try{
			for (int i = 0; i < orderDetailList.size(); i++) {
				if(goodsNumberDao.checkGoods(orderDetailList.get(i).getGoods(), storage)){
					GoodsNumberEntity goodsNumber = this.goodsNumberDao.find(orderDetailList.get(i).getGoods(), storage);
					goodsNumber.setCanDistributeQuantity(goodsNumber.getCanDistributeQuantity() + orderDetailList.get(i).getGoodsNumber());
					goodsNumber.setTotalQuantity(goodsNumber.getTotalQuantity()+ orderDetailList.get(i).getGoodsNumber());
					goodsNumberDao.update(goodsNumber);
				}
				else{
					GoodsNumberEntity goodsNumber = new GoodsNumberEntity();
					goodsNumber.setStorage(storage);
					goodsNumber.setGoods(orderDetailList.get(i).getGoods());
					goodsNumber.setCanDistributeQuantity(orderDetailList.get(i).getGoodsNumber());
					goodsNumber.setReturnQuantity(0);
					goodsNumber.setCannotDistributeQuantity(0);
					goodsNumber.setTotalQuantity(orderDetailList.get(i).getGoodsNumber());
					goodsNumberDao.save(goodsNumber);
				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		//保存分站入库单
		SubstationStoragePutInOrder substationStoragePutInOrder = new SubstationStoragePutInOrder();
		substationStoragePutInOrder.setCheckGoodsOrder(checkGoodsOrder);
		String substationStoragePutInOrderId = format2.format(new Date());
		substationStoragePutInOrder.setSubstationStoragePutInOrderId(substationStoragePutInOrderId);
		Date substationStoragePutInOrderDate = new Date();
		try {
			substationStoragePutInOrderDate = format1.parse(format1.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		substationStoragePutInOrder.setSubstationStoragePutInDate(substationStoragePutInOrderDate);
		this.substationStoragePutInDao.save(substationStoragePutInOrder);
		
		
		//更改验货单状态
		checkGoodsOrder.setCheckGoodsState("0");
		this.checkGoodsDao.update(checkGoodsOrder);
		
		
		//更改订单状态
		OrderEntity order = substationStoragePutInOrder.getCheckGoodsOrder().getGoodsTransferOrder().getT_order();
		order.setOrderState("订单已到达分站库房，等待分配。");
		this.orderDao.update(order);
		
		//更改任务单状态
		TaskOrderEntity taskOrder = this.taskOrderDao.findByOrder(order.getId());
		taskOrder.setTaskOrderState("订单已到达分站库房，等待分配。");
		this.taskOrderDao.update(taskOrder);
		return true;
	}

	@Override
	public List<SubstationStoragePutInOrder> find(Integer id, String invoicingEndDate,
			String invoicingBeginDate) {
		return this.substationStoragePutInDao.find(id, invoicingEndDate,invoicingBeginDate);
	}

}
