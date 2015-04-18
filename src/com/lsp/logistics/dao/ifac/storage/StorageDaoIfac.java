package com.lsp.logistics.dao.ifac.storage;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.StorageEntity;

public interface StorageDaoIfac extends BaseDao<StorageEntity> {
	public boolean selectCenterStorage();

	public List<StorageEntity> findStorage(String storageName);

}
