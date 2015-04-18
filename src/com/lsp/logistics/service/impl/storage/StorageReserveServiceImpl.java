package com.lsp.logistics.service.impl.storage;

import java.util.List;

import com.lsp.logistics.dao.ifac.storage.StorageReserveDaoIfac;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.StorageReserveEntity;
import com.lsp.logistics.service.ifac.storage.StorageReserveServiceIfac;

public class StorageReserveServiceImpl implements StorageReserveServiceIfac {
	
	private StorageReserveDaoIfac storageReserveDao;

	public void setStorageReserveDao(StorageReserveDaoIfac storageReserveDao) {
		this.storageReserveDao = storageReserveDao;
	}

	@Override
	public boolean saveStorageReserve(StorageReserveEntity storageReserve) {
		this.storageReserveDao.save(storageReserve);
		return true;
	}
	
	@Override
	public List<StorageReserveEntity> findStorageReserveByStorageId(Integer id) {
		return this.storageReserveDao.findStorageReserveByStorageId(id);
	}

	@Override
	public List<StorageReserveEntity> findShortageGoodsReserve(
			GoodsEntity goodsEntity) {
		return this.storageReserveDao.findShortageGoodsReserve(goodsEntity);
	}

}
