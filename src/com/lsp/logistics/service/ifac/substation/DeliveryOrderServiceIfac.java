package com.lsp.logistics.service.ifac.substation;

import com.lsp.logistics.entity.DeliveryOrder;

public interface DeliveryOrderServiceIfac {
	
	public DeliveryOrder findByTaskOrderId(Integer id);

}
