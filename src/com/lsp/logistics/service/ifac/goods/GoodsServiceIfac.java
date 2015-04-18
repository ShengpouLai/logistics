package com.lsp.logistics.service.ifac.goods;

import java.util.List;

import com.lsp.logistics.entity.GoodsEntity;

public interface GoodsServiceIfac {
	
	public List<GoodsEntity> findAllGoods();
	public boolean saveGoods(GoodsEntity goods);
	public List<GoodsEntity> findGoodsBySecondGoodsId(Integer secondGoodsId);
	public boolean deleteGoods(Integer goodsId);
	public GoodsEntity findGoodsById(Integer id);
	public boolean updateGoods(GoodsEntity goods);
	public List<GoodsEntity> findGoods(String goodsId, String goodsName);
	public List<GoodsEntity> findShortageGoods();
	public boolean ifGoodsPutIn(Integer goodsId);
	public boolean buyGoodsState(Integer goodsId);

}
