package com.lsp.logistics.dao.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.SubstationStorageOutOfOrder;

public interface SubstationStorageOutOfDaoIfac extends BaseDao<SubstationStorageOutOfOrder> {

	List<SubstationStorageOutOfOrder> find(Integer id, String invoicingEndDate,
			String invoicingBeginDate);

}
