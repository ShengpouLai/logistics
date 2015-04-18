package com.lsp.logistics.service.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.entity.CentralStoragePutInOrder;

public interface CentralStoragePutInOrderServiceIfac {
	
	public boolean save(CentralStoragePutInOrder centralStoragePutInOrder);

	public List<CentralStoragePutInOrder> find(String invoicingEndDate,
			String invoicingBeginDate);

	public CentralStoragePutInOrder findById(Integer id);

}
