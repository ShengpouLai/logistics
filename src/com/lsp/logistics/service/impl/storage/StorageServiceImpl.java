package com.lsp.logistics.service.impl.storage;

import java.util.List;

import com.lsp.logistics.dao.ifac.storage.StorageDaoIfac;
import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.entity.StorageReserveEntity;
import com.lsp.logistics.service.ifac.storage.StorageServiceIfac;

public class StorageServiceImpl implements StorageServiceIfac {

	private StorageDaoIfac storageDao;

	public void setStorageDao(StorageDaoIfac storageDao) {
		this.storageDao = storageDao;
	}

	@Override
	public List<StorageEntity> findAllStorage() {
		return this.storageDao.findAll();
	}

	/**
	 * 1、先判断是否想增加中心库房 2、如果是，查找数据库里是否存在中心库房
	 */
	@Override
	public boolean saveStorage(StorageEntity storage) {
		if (storage.getStorageLevel().equals("1")) {
			if (this.storageDao.selectCenterStorage()) {
				this.storageDao.save(storage);
				return true;
			} else {
				return false;
			}
		} else {
			this.storageDao.save(storage);
			return true;
		}

	}

	@Override
	public boolean deleteStorage(Integer id) {
		if (this.storageDao.delete(id)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public StorageEntity findById(Integer id) {
		return this.storageDao.findById(id);
	}

	@Override
	public boolean updateStorage(StorageEntity storage) {
		if(this.storageDao.update(storage)){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<StorageEntity> findStorage(String storageName) {
		return this.storageDao.findStorage(storageName);
	}

}
