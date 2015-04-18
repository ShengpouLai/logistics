package com.lsp.logistics.service.ifac.storage;

import java.util.List;

import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.entity.StorageReserveEntity;

public interface StorageServiceIfac {
	public List<StorageEntity> findAllStorage();
	public boolean saveStorage(StorageEntity storage);
//	public boolean saveStorageReserve(StorageReserveEntity storageReserve);
	public boolean deleteStorage(Integer id);
	public StorageEntity findById(Integer id);
	public boolean updateStorage(StorageEntity storage);
	public List<StorageEntity> findStorage(String storageName);

}
