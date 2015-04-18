package com.lsp.logistics.dao.ifac.goods;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.GoodsEntity;

public interface GoodsDaoIfac extends BaseDao<GoodsEntity> {
	
	public List<GoodsEntity> findGoodsBySecondGoodsId(Integer secondGoodsId);

	public List<GoodsEntity> findGoods(String goodsId, String goodsName);

	public List<GoodsEntity> findShortageGoods();

	public boolean ifGoodsPutIn(Integer goodsId);

	public boolean buyGoodsState(String goodsState);

}
