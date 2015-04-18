package com.lsp.logistics.entity;

/**
 * 任务单实体
 * @author pou
 *
 */
public class TaskOrderEntity {
	private Integer id;
	
	/** 任务单号 */
	private String taskOrderId;
	
	/** 任务类型 */
	private String taskOrderType;
	
	/** 任务状态
	 * 
	 *  未调度
	 *  已调度
	 *  可分配
	 *  已分配
	 *  已领货
	 *  配送收款
	 *  已完成
	 *  
	 *  */
	private String taskOrderState;
	
	/** 订单 */
	private OrderEntity order;
	
	/** 分站 */
	private SubstationEntity substation;
	
	/** 配送员 */
	private DeliveryStaffEntity deliveryStaff;

	public DeliveryStaffEntity getDeliveryStaff() {
		return deliveryStaff;
	}

	public void setDeliveryStaff(DeliveryStaffEntity deliveryStaff) {
		this.deliveryStaff = deliveryStaff;
	}

	public SubstationEntity getSubstation() {
		return substation;
	}

	public void setSubstation(SubstationEntity substation) {
		this.substation = substation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskOrderId() {
		return taskOrderId;
	}

	public void setTaskOrderId(String taskOrderId) {
		this.taskOrderId = taskOrderId;
	}

	public String getTaskOrderType() {
		return taskOrderType;
	}

	public void setTaskOrderType(String taskOrderType) {
		this.taskOrderType = taskOrderType;
	}

	public String getTaskOrderState() {
		return taskOrderState;
	}

	public void setTaskOrderState(String taskOrderState) {
		this.taskOrderState = taskOrderState;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

}
