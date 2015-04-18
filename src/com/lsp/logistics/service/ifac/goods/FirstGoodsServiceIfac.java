package com.lsp.logistics.service.ifac.goods;

import java.util.List;

import com.lsp.logistics.entity.CostomerEntity;
import com.lsp.logistics.entity.FirstGoodsEntity;

public interface FirstGoodsServiceIfac {
	
	public List<FirstGoodsEntity> findAllFirstGoods();
	public boolean saveFirstGoods(FirstGoodsEntity firstGoods);
	public boolean deleteFirstGoods(Integer firstGoodsId);
	public FirstGoodsEntity findFirstGoodsById(Integer firstGoodsId);
	public boolean updateFirstGoods(FirstGoodsEntity firstGoods);

}
