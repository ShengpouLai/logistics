package com.lsp.logistics.dao.impl.substation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lsp.logistics.dao.ifac.substation.TaskOrderDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.OrderEntity;
import com.lsp.logistics.entity.TaskOrderEntity;

public class TaskOrderDaoImpl extends BaseDaoImpl<TaskOrderEntity> implements TaskOrderDaoIfac {

	public TaskOrderDaoImpl() {
		super(TaskOrderEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TaskOrderEntity findByOrder(Integer id) {
		String hql = "from TaskOrderEntity as t where t.order.id = " + id;
		return (TaskOrderEntity) getHibernateTemplate().find(hql).get(0);
	}

	@Override
	public List<TaskOrderEntity> findToAllocation() {
		String hql = "from TaskOrderEntity as t where t.taskOrderState = '订单已到达分站库房，等待分配。'";
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List<TaskOrderEntity> findToOutOf() {
		String hql = "from TaskOrderEntity as t where t.taskOrderState = '订单已分配，等待配送员配送。'";
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List<TaskOrderEntity> findReceiptEnter() {
		String hql = "from TaskOrderEntity as t where t.taskOrderState = '配送员已领货，请耐心等待配送。'";
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List<TaskOrderEntity> findTaskOrder(String taskOrderId,
			String taskState, String substationId, String costomerName,
			String costomerPhone, String orderDeliverDate) {
		if(taskOrderId.length() == 0 && taskState.length() == 0 & substationId.length() == 0 && costomerName.length() == 0 && costomerPhone.length() == 0 &&   orderDeliverDate.length() == 0){
			return new ArrayList<TaskOrderEntity>();
		} 
		else{
			String hql = "from TaskOrderEntity as o where ";
			if(taskOrderId.length() > 0){
				hql = hql + " o.taskOrderId = '" + taskOrderId + "' and ";
			}
			if(taskState.length() > 0){
				hql = hql + " o.taskOrderState = '" + taskState + "' and ";
			}
			if(substationId.length() > 0){
				hql = hql + " o.substation.id = '" + substationId + "' and ";
			}
			if(costomerName.length() > 0){
				hql = hql + " o.order.costomer.costomerName = '" + costomerName + "' and ";
			}
			if(costomerPhone.length() > 0){
				hql = hql + " o.order.costomer.mobailPhone = '" + costomerPhone + "' and ";
			}
			if(orderDeliverDate.length() > 0){
				hql = hql + " o.order.orderDeliverDate = '" + orderDeliverDate + "' and ";
			}
			if(hql.lastIndexOf("and ")==hql.length() -4)
			      hql=hql.substring(0,hql.lastIndexOf("and ")) ;
			if(hql.lastIndexOf("where ")==hql.length() -6)
			      hql=hql.substring(0,hql.lastIndexOf("where ")) ;
			return getHibernateTemplate().find(hql);
		}
	}

	@Override
	public List<TaskOrderEntity> findTask(String substationName) {
		String hql = "from TaskOrderEntity as t where ";
		if(substationName.length() > 0){
			hql = hql + "t.substation.substationName = '" + substationName + "'";
			return getHibernateTemplate().find(hql);
		}
		else{
			return new ArrayList<TaskOrderEntity>();
		}
	}

	@Override
	public List<TaskOrderEntity> receipt_task_find(String taskOrderId,
			String deliveryStaffName) {
		if(taskOrderId.length() == 0 && deliveryStaffName.length() == 0){
			return new ArrayList<TaskOrderEntity>();
		} 
		else{
			String hql = "from TaskOrderEntity as t where ";
			if(taskOrderId.length() > 0){
				hql = hql + " t.taskOrderId = '" + taskOrderId + "' and ";
			}
			if(deliveryStaffName.length() > 0){
				hql = hql + " t.deliveryStaff.deliveryStaffName = '" + deliveryStaffName + "' and ";
			}
			return getHibernateTemplate().find(hql);
		}
	}

}
