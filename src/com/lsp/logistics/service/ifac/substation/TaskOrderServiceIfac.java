package com.lsp.logistics.service.ifac.substation;

import java.util.Date;
import java.util.List;

import com.lsp.logistics.entity.TaskOrderEntity;

public interface TaskOrderServiceIfac {
	
	/**
	 * 查询所有任务单
	 * @return list
	 */
	public List<TaskOrderEntity> findAllTaskOrder();
	
	/**
	 * 保存任务单
	 * @param storageId
	 * @param orderId
	 * @return true
	 */
	public boolean saveTaskOrder(Integer storageId, Integer orderId);

	/**
	 * 查询等待分配的任务单
	 * @return list
	 */
	public List<TaskOrderEntity> findToAllocation();

	/**
	 * 任务分配
	 * @param deliveryStaffId
	 * @return true
	 */
	public boolean taskAllocation(Integer deliveryStaffId);

	/**
	 * 通过Id查找任务单
	 * @param id
	 * @return TaskOrderEntity
	 */
	public TaskOrderEntity findById(Integer id);

	/**
	 * 
	 * @return
	 */
	public List<TaskOrderEntity> findToOutOf();

	/**
	 * 跳转回执录入页面
	 * @return list
	 */
	public List<TaskOrderEntity> findReceiptEnter();

	/**
	 * 条件查询任务单
	 * @param taskOrderId
	 * @param taskState
	 * @param substationId
	 * @param costomerName
	 * @param costomerPhone
	 * @param orderDeliverDate
	 * @return list
	 */
	public List<TaskOrderEntity> findTaskOrder(String taskOrderId,
			String taskState, String substationId, String costomerName,
			String costomerPhone, String orderDeliverDate);

	/**
	 * 通过分站名称查找任务单
	 * @param substationName
	 * @return list
	 */
	public List<TaskOrderEntity> findTask(String substationName);

	/**
	 * 回执录入时的条件查询任务单
	 * @param taskOrderId
	 * @param deliveryStaffName
	 * @return list
	 */
	public List<TaskOrderEntity> receipt_task_find(String taskOrderId,
			String deliveryStaffName);

}
