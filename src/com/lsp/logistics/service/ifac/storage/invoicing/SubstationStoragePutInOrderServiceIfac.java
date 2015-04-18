package com.lsp.logistics.service.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.entity.SubstationStoragePutInOrder;

public interface SubstationStoragePutInOrderServiceIfac {
	
	public boolean save(Integer integer);

	public List<SubstationStoragePutInOrder> find(Integer integer, String invoicingEndDate,
			String invoicingBeginDate);

}
