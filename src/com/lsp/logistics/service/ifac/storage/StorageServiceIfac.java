package com.lsp.logistics.service.ifac.storage;

import java.util.List;

import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.entity.StorageReserveEntity;

public interface StorageServiceIfac {
	
	/**
	 * 查询所有库房
	 * @return list
	 */
	public List<StorageEntity> findAllStorage();
	
	/**
	 * 增加库房
	 * @param storage
	 * @return true
	 */
	public boolean saveStorage(StorageEntity storage);
	
	/**
	 * 删除库房
	 * @param id
	 * @return true
	 */
	public boolean deleteStorage(Integer id);
	
	/**
	 * 通过Id查找库房
	 * @param id
	 * @return storageEntity
	 */
	public StorageEntity findById(Integer id);
	
	/**
	 * 修改库房基本信息
	 * @param storage
	 * @return true
	 */
	public boolean updateStorage(StorageEntity storage);
	
	/**
	 * 条件查询库房
	 * @param storageName
	 * @return list
	 */
	public List<StorageEntity> findStorage(String storageName);

}
