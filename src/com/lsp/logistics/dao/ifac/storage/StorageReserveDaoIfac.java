package com.lsp.logistics.dao.ifac.storage;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.StorageReserveEntity;

public interface StorageReserveDaoIfac extends BaseDao<StorageReserveEntity> {
	
	public List<StorageReserveEntity> findStorageReserveByStorageId(Integer id);

	public List<StorageReserveEntity> findShortageGoodsReserve(
			GoodsEntity goodsEntity);

}
