package com.lsp.logistics.entity;

/**
 * 商品签收单
 * @author pou
 *
 */
public class SignOrder {
	
	private Integer id;
	
	/** 客户反馈 */
	private String signCostomerFeedback;
	
	/** 客户签名 */
	private String signCostomerAutograph;
	
	/** 任务单 */
	private TaskOrderEntity taskOrder;

	public TaskOrderEntity getTaskOrder() {
		return taskOrder;
	}

	public void setTaskOrder(TaskOrderEntity taskOrder) {
		this.taskOrder = taskOrder;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSignCostomerFeedback() {
		return signCostomerFeedback;
	}

	public void setSignCostomerFeedback(String signCostomerFeedback) {
		this.signCostomerFeedback = signCostomerFeedback;
	}

	public String getSignCostomerAutograph() {
		return signCostomerAutograph;
	}

	public void setSignCostomerAutograph(String signCostomerAutograph) {
		this.signCostomerAutograph = signCostomerAutograph;
	}

}
