package com.lsp.logistics.service.impl.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.storage.invoicing.CentralStoragePutInOrderDaoIfac;
import com.lsp.logistics.entity.CentralStoragePutInOrder;
import com.lsp.logistics.service.ifac.storage.invoicing.CentralStoragePutInOrderServiceIfac;

public class CentralStoragePutInOrderServiceImpl implements CentralStoragePutInOrderServiceIfac {
	
	private CentralStoragePutInOrderDaoIfac centralStoragePutInOrderDao;

	public void setCentralStoragePutInOrderDao(
			CentralStoragePutInOrderDaoIfac centralStoragePutInOrderDao) {
		this.centralStoragePutInOrderDao = centralStoragePutInOrderDao;
	}

	@Override
	public boolean save(CentralStoragePutInOrder centralStoragePutInOrder) {
		this.centralStoragePutInOrderDao.save(centralStoragePutInOrder);
		return true;
	}

	@Override
	public List<CentralStoragePutInOrder> find(String invoicingEndDate,
			String invoicingBeginDate) {
		return this.centralStoragePutInOrderDao.find(invoicingEndDate, invoicingBeginDate);
	}

	@Override
	public CentralStoragePutInOrder findById(Integer id) {
		return this.centralStoragePutInOrderDao.findById(id);
	}

}
