package com.lsp.logistics.entity;

/**
 * 配送单
 * @author pou
 *
 */
public class DeliveryOrder {
	
	private Integer id;
	
	/** 配送任务单状态
	 *  未领货
	 *  已领货，配送中
	 *  配送完成
	 *  */
	private String deliveryOrderState;
	
	/** 任务单 */
	private TaskOrderEntity taskOrder;

	public String getDeliveryOrderState() {
		return deliveryOrderState;
	}

	public void setDeliveryOrderState(String deliveryOrderState) {
		this.deliveryOrderState = deliveryOrderState;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TaskOrderEntity getTaskOrder() {
		return taskOrder;
	}

	public void setTaskOrder(TaskOrderEntity taskOrder) {
		this.taskOrder = taskOrder;
	}
	

}
