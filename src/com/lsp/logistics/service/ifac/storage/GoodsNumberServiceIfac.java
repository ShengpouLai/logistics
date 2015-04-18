package com.lsp.logistics.service.ifac.storage;

import java.util.List;

import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.StorageEntity;

public interface GoodsNumberServiceIfac {

	public List<GoodsNumberEntity> lookGoodsNumber(Integer integer);

	public boolean saveGoodsNumber(GoodsEntity goods, StorageEntity storage);

	public List<GoodsNumberEntity> findShortGoodsNumber(GoodsEntity goodsEntity);
	
	public boolean deleteGoodsNumber(Integer goodsId);

	public void updateGoodsNumber(Integer goodsId, Integer integer);
	
	public List<GoodsNumberEntity> findAll();
	
	public boolean updateInOrderDetail(Integer goodsId, Integer integer);


}
