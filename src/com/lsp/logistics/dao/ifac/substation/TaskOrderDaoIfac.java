package com.lsp.logistics.dao.ifac.substation;

import java.util.Date;
import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.TaskOrderEntity;

public interface TaskOrderDaoIfac extends BaseDao<TaskOrderEntity> {

	TaskOrderEntity findByOrder(Integer id);

	List<TaskOrderEntity> findToAllocation();

	List<TaskOrderEntity> findToOutOf();

	List<TaskOrderEntity> findReceiptEnter();

	List<TaskOrderEntity> findTaskOrder(String taskOrderId, String taskState,
			String substationId, String costomerName, String costomerPhone,
			String orderDeliverDate);

	List<TaskOrderEntity> findTask(String substationName);

	List<TaskOrderEntity> receipt_task_find(String taskOrderId,
			String deliveryStaffName);

}
