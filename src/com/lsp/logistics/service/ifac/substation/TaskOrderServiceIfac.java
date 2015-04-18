package com.lsp.logistics.service.ifac.substation;

import java.util.Date;
import java.util.List;

import com.lsp.logistics.entity.TaskOrderEntity;

public interface TaskOrderServiceIfac {
	
	public List<TaskOrderEntity> findAllTaskOrder();
	
	public boolean saveTaskOrder(Integer storageId, Integer orderId);

	public List<TaskOrderEntity> findToAllocation();

	public boolean taskAllocation(Integer deliveryStaffId);

	public TaskOrderEntity findById(Integer id);

	public List<TaskOrderEntity> findToOutOf();

	public List<TaskOrderEntity> findReceiptEnter();

	public List<TaskOrderEntity> findTaskOrder(String taskOrderId,
			String taskState, String substationId, String costomerName,
			String costomerPhone, String orderDeliverDate);

}
