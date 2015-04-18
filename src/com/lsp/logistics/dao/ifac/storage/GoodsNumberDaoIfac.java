package com.lsp.logistics.dao.ifac.storage;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.StorageEntity;

public interface GoodsNumberDaoIfac extends BaseDao<GoodsNumberEntity> {
	
	public List<GoodsNumberEntity> lookGoodsNumber(Integer storage);

	public boolean saveGoodsNumber(GoodsEntity goods, StorageEntity storage);

	public List<GoodsNumberEntity> findShortGoodsNumber(GoodsEntity goodsEntity);

	public boolean deleteGoodsNumber(Integer goodsId);

	public boolean checkGoods(GoodsEntity goods, StorageEntity storage);

	public GoodsNumberEntity find(GoodsEntity goods, StorageEntity storage);


}
