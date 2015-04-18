package com.lsp.logistics.dao.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.CentralStorageOutOfOrder;

public interface CentralStorageOutOfOrderDaoIfac extends BaseDao<CentralStorageOutOfOrder> {

	List<CentralStorageOutOfOrder> find(String invoicingEndDate,
			String invoicingBeginDate);

}
