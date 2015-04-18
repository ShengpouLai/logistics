package com.lsp.logistics.web.action.dispatch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.entity.SubstationEntity;
import com.lsp.logistics.service.ifac.order.OrderServiceIfac;
import com.lsp.logistics.service.ifac.substation.SubstationServiceIfac;
import com.lsp.logistics.service.ifac.substation.TaskOrderServiceIfac;
import com.opensymphony.xwork2.ActionSupport;

public class DispatchAction extends ActionSupport{
	
	private List<OrderEntity> orderList;
	private List<SubstationEntity> substationList;
	private OrderEntity order;
	private Integer storageId;
	private Map<String, Object> data;

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public Integer getStorageId() {
		return storageId;
	}

	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}

	public List<SubstationEntity> getSubstationList() {
		return substationList;
	}

	public void setSubstationList(List<SubstationEntity> substationList) {
		this.substationList = substationList;
	}

	public List<OrderEntity> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderEntity> orderList) {
		this.orderList = orderList;
	}

	private OrderServiceIfac orderService;
	private SubstationServiceIfac substationService;
	private TaskOrderServiceIfac taskOrderService;

	public void setTaskOrderService(TaskOrderServiceIfac taskOrderService) {
		this.taskOrderService = taskOrderService;
	}

	public void setSubstationService(SubstationServiceIfac substationService) {
		this.substationService = substationService;
	}

	public void setOrderService(OrderServiceIfac orderService) {
		this.orderService = orderService;
	}
	
	public String dispatchOrderList(){
		orderList = this.orderService.findNeedDispatchOrder();
		substationList = this.substationService.findAllSubstation();
		return "dispatchOrderList";
	}
	
	public String dispatch(){
		data = new HashMap<String, Object>();
		this.taskOrderService.saveTaskOrder(storageId, order.getId());
		data.put("statusCode",200);
		data.put("message", "调度成功");
		data.put("navTabId", "dispatchOrder");
		data.put("rel", "");
		data.put("callbackType", "forward");
		data.put("forwardUrl", "dispatchOrder.action");
		
		
		return "dispatch";
	}

}
