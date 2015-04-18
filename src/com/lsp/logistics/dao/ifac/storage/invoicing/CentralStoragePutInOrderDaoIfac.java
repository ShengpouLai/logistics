package com.lsp.logistics.dao.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.CentralStoragePutInOrder;

public interface CentralStoragePutInOrderDaoIfac extends BaseDao<CentralStoragePutInOrder> {

	List<CentralStoragePutInOrder> find(String invoicingEndDate,
			String invoicingBeginDate);

}
