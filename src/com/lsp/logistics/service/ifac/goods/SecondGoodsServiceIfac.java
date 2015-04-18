package com.lsp.logistics.service.ifac.goods;

import java.util.List;

import com.lsp.logistics.entity.SecondGoodsEntity;

public interface SecondGoodsServiceIfac {
	public List<SecondGoodsEntity> findAllSecondGoods();
	public boolean saveSecondGoods(SecondGoodsEntity secondGoods);
	public List<SecondGoodsEntity> findSercondByFirstGoodsId(Integer firstGoodsId);
	public boolean deleteSecondGoods(Integer secondGoodsId);
	public SecondGoodsEntity findSecondGoodsById(Integer secondGoodsId);
	public boolean updateSecondGoods(SecondGoodsEntity secondGoods);

}
