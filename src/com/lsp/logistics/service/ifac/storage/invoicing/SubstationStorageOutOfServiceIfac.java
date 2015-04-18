package com.lsp.logistics.service.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.entity.SubstationStorageOutOfOrder;

public interface SubstationStorageOutOfServiceIfac {
	
	public boolean save(Integer id);

	public List<SubstationStorageOutOfOrder> find(Integer integer, String invoicingEndDate,
			String invoicingBeginDate);

}
