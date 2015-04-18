package com.lsp.logistics.dao.ifac.order;

import java.util.Date;
import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.OrderEntity;

public interface OrderDaoIfac extends BaseDao<OrderEntity>{

	List<OrderEntity> findOrder(String orderId, String orderType,
			String orderState, String costomerName, String costomerMobailPhone,
			String orderBeginDate, String orderEndDate);

	List<OrderEntity> findNeedDispatchOrder();

}
