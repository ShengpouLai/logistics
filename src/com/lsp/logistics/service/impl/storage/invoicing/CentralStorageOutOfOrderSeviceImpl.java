package com.lsp.logistics.service.impl.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.storage.invoicing.CentralStorageOutOfOrderDaoIfac;
import com.lsp.logistics.entity.CentralStorageOutOfOrder;
import com.lsp.logistics.service.ifac.storage.invoicing.CentralStorageOutOfOrderServiceIfac;

public class CentralStorageOutOfOrderSeviceImpl implements
		CentralStorageOutOfOrderServiceIfac {
	
	private CentralStorageOutOfOrderDaoIfac centralStorageOutOfOrderDao;

	public void setCentralStorageOutOfOrderDao(
			CentralStorageOutOfOrderDaoIfac centralStorageOutOfOrderDao) {
		this.centralStorageOutOfOrderDao = centralStorageOutOfOrderDao;
	}

	@Override
	public List<CentralStorageOutOfOrder> find(String invoicingEndDate,
			String invoicingBeginDate) {
		return this.centralStorageOutOfOrderDao.find(invoicingEndDate,invoicingBeginDate);
	}

	@Override
	public CentralStorageOutOfOrder findById(Integer id) {
		return this.centralStorageOutOfOrderDao.findById(id);
	}

}
