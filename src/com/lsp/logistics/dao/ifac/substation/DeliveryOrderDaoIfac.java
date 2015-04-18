package com.lsp.logistics.dao.ifac.substation;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.DeliveryOrder;

public interface DeliveryOrderDaoIfac extends BaseDao<DeliveryOrder> {

	DeliveryOrder findByTaskOrderId(Integer id);

}
