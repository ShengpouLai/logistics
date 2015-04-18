package com.lsp.logistics.service.ifac.substation;

import java.util.List;

import com.lsp.logistics.entity.ReceiptEntity;

public interface ReceiptServiceIfac {
	
	public boolean saveReceipt(ReceiptEntity receipt, Integer taskOrderId);
	
	public List<ReceiptEntity> findAllReceipt();

}
