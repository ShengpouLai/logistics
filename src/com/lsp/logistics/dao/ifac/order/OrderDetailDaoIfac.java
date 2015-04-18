package com.lsp.logistics.dao.ifac.order;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.entity.OrderEntity;

public interface OrderDetailDaoIfac extends BaseDao<OrderDetailEntity> {

	public List<OrderDetailEntity> findByOrder(Integer integer);

}
