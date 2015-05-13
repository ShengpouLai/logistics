package com.lsp.logistics.service.ifac.storage;

import java.util.List;

import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.StorageEntity;

public interface GoodsNumberServiceIfac {

	/**
	 * 查看库存量
	 * @param integer
	 * @return true
	 */
	public List<GoodsNumberEntity> lookGoodsNumber(Integer integer);

	/**
	 * 设置库存量
	 * @param goods
	 * @param storage
	 * @return true
	 */
	public boolean saveGoodsNumber(GoodsEntity goods, StorageEntity storage);

	/**
	 * 查询出缺货商品库存量
	 * @param goodsEntity
	 * @return list
	 */
	public List<GoodsNumberEntity> findShortGoodsNumber(GoodsEntity goodsEntity);
	
	/**
	 * 删除库存量
	 * @param goodsId
	 * @return true
	 */
	public boolean deleteGoodsNumber(Integer goodsId);

	/**
	 * 修改中心库房货物数量
	 * @param goodsId
	 * @param integer
	 */
	public void updateGoodsNumber(Integer goodsId, Integer integer);
	
	public List<GoodsNumberEntity> findAll();
	
	public boolean updateInOrderDetail(Integer goodsId, Integer integer);


}
