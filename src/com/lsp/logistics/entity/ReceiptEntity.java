package com.lsp.logistics.entity;

/**
 * 回执实体
 * @author pou
 *
 */
public class ReceiptEntity {
	
	private Integer id;
	
	/** 任务状态 
	 *  完成
	 *  失败
	 * */
	private String taskState;
	
	/** 客户满意度 */
	private String customerSatisfaction;
	
	/** 回执备注 */
	private String receiptRemark;
	
	/** 任务单 */
	private TaskOrderEntity task_Order;

	public TaskOrderEntity getTask_Order() {
		return task_Order;
	}

	public void setTask_Order(TaskOrderEntity task_Order) {
		this.task_Order = task_Order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskState() {
		return taskState;
	}

	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}

	public String getCustomerSatisfaction() {
		return customerSatisfaction;
	}

	public void setCustomerSatisfaction(String customerSatisfaction) {
		this.customerSatisfaction = customerSatisfaction;
	}

	public String getReceiptRemark() {
		return receiptRemark;
	}

	public void setReceiptRemark(String receiptRemark) {
		this.receiptRemark = receiptRemark;
	}

}
