package com.lsp.logistics.entity;

import java.util.Date;

/**
 * 分站库房出库单
 * @author pou
 *
 */
public class SubstationStorageOutOfOrder {
	
	private Integer id;
	
	/** 分站库房出库备注 */
	private String substationStorageOutOfOrderRemark;
	
	/** 分站库房出库日期 */
	private Date substationStorageOutOfOrderDate;
	
	/** 任务单 */
	private TaskOrderEntity taskOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubstationStorageOutOfOrderRemark() {
		return substationStorageOutOfOrderRemark;
	}

	public void setSubstationStorageOutOfOrderRemark(
			String substationStorageOutOfOrderRemark) {
		this.substationStorageOutOfOrderRemark = substationStorageOutOfOrderRemark;
	}

	public Date getSubstationStorageOutOfOrderDate() {
		return substationStorageOutOfOrderDate;
	}

	public void setSubstationStorageOutOfOrderDate(
			Date substationStorageOutOfOrderDate) {
		this.substationStorageOutOfOrderDate = substationStorageOutOfOrderDate;
	}

	public TaskOrderEntity getTaskOrder() {
		return taskOrder;
	}

	public void setTaskOrder(TaskOrderEntity taskOrder) {
		this.taskOrder = taskOrder;
	}

}
