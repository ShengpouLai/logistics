package com.lsp.logistics.dao.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.SubstationStoragePutInOrder;

public interface SubstationStoragePutInOrderDaoIfac extends BaseDao<SubstationStoragePutInOrder> {

	List<SubstationStoragePutInOrder> find(Integer id, String invoicingEndDate,
			String invoicingBeginDate);

}
