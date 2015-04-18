package com.lsp.logistics.service.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.entity.CentralStorageOutOfOrder;

public interface CentralStorageOutOfOrderServiceIfac {

	List<CentralStorageOutOfOrder> find(String invoicingEndDate,
			String invoicingBeginDate);

	CentralStorageOutOfOrder findById(Integer id);

}
