package com.lsp.logistics.service.ifac.storage.invoicing;

public interface DisreibutionOrderServiceIfac {
	
	/**
	 * 中心库房调拨出库
	 * @param transferOrderId
	 * @return
	 */
	public boolean save(Integer transferOrderId);

}
