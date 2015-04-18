package com.lsp.logistics.dao.impl.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lsp.logistics.dao.ifac.order.OrderDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.OrderEntity;

public class OrderDaoImpl extends BaseDaoImpl<OrderEntity> implements OrderDaoIfac {

	public OrderDaoImpl() {
		super(OrderEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<OrderEntity> findOrder(String orderId, String orderType,
			String orderState, String costomerName, String costomerMobailPhone,
			String orderBeginDate, String orderEndDate) {
		if(orderId.length() == 0 && orderType.length() == 0 & orderState.length() == 0 && costomerName.length() == 0 && costomerMobailPhone.length() == 0 && orderBeginDate.length() == 0 && orderEndDate.length() == 0){
			return new ArrayList<OrderEntity>();
		} 
		else{
			String hql = "from OrderEntity as o where ";
			if(orderId.length() > 0){
				hql = hql + " o.orderId = '" + orderId + "' and ";
			}
			if(orderType.length() > 0){
				hql = hql + " o.orderType = '" + orderType + "' and ";
			}
			if(orderState.length() > 0){
				hql = hql + " o.orderState = '" + orderState + "' and ";
			}
			if(costomerName.length() > 0){
				hql = hql + " o.costomer.costomerName = '" + costomerName + "' and ";
			}
			if(costomerMobailPhone.length() > 0){
				hql = hql + " o.costomer.mobailPhone = '" + costomerMobailPhone + "' and ";
			}
			if(orderBeginDate.length()>0 && orderEndDate.length()>0){
				hql = hql + " o.orderDate BETWEEN '" + orderBeginDate + "' and '" + orderEndDate + "' and ";
			}
			if(hql.lastIndexOf("and ")==hql.length() -4)
			      hql=hql.substring(0,hql.lastIndexOf("and ")) ;
			if(hql.lastIndexOf("where ")==hql.length() -6)
			      hql=hql.substring(0,hql.lastIndexOf("where ")) ;
			return getHibernateTemplate().find(hql);
		}
	}

	@Override
	public List<OrderEntity> findNeedDispatchOrder() {
		String hql = "from OrderEntity as o where o.orderState = '订单已确认，等待调度。'";
		return getHibernateTemplate().find(hql);
	}

}
