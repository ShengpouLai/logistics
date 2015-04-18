package com.lsp.logistics.service.ifac.storage;

import java.util.List;

import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.StorageReserveEntity;

public interface StorageReserveServiceIfac {
	
	public boolean saveStorageReserve(StorageReserveEntity storageReserve);

	public List<StorageReserveEntity> findStorageReserveByStorageId(Integer id);

	public List<StorageReserveEntity> findShortageGoodsReserve(
			GoodsEntity goodsEntity);

}
