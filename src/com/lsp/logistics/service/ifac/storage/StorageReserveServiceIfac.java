package com.lsp.logistics.service.ifac.storage;

import java.util.List;

import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.StorageReserveEntity;

public interface StorageReserveServiceIfac {
	
	/**
	 * 设置库房存储量
	 * @param storageReserve
	 * @return true
	 */
	public boolean saveStorageReserve(StorageReserveEntity storageReserve);

	/**
	 * 查看库房存储量
	 * @param id
	 * @return list
	 */
	public List<StorageReserveEntity> findStorageReserveByStorageId(Integer id);

	public List<StorageReserveEntity> findShortageGoodsReserve(
			GoodsEntity goodsEntity);

}
