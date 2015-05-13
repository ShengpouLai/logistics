package com.lsp.logistics.service.ifac.substation;

import java.util.List;

import com.lsp.logistics.entity.ReceiptEntity;

public interface ReceiptServiceIfac {
	
	/**
	 * 回执录入
	 * @param receipt
	 * @param taskOrderId
	 * @return true
	 */
	public boolean saveReceipt(ReceiptEntity receipt, Integer taskOrderId);
	
	public List<ReceiptEntity> findAllReceipt();

}
