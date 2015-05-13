package com.lsp.logistics.service.ifac.goods;

import java.util.List;

import com.lsp.logistics.entity.CostomerEntity;
import com.lsp.logistics.entity.FirstGoodsEntity;

public interface FirstGoodsServiceIfac {
	
	/**
	 * 商品一级分类列表
	 * @return list
	 */
	public List<FirstGoodsEntity> findAllFirstGoods();
	
	/**
	 * 保存商品一级分类
	 * @param firstGoods
	 * @return true
	 */
	public boolean saveFirstGoods(FirstGoodsEntity firstGoods);
	
	/**
	 * 删除商品一级分类
	 * @param firstGoodsId
	 * @return true
	 */
	public boolean deleteFirstGoods(Integer firstGoodsId);
	
	/**
	 * 通过Id查找
	 * @param firstGoodsId
	 * @return FirstGoodsEntity
	 */
	public FirstGoodsEntity findFirstGoodsById(Integer firstGoodsId);
	
	/**
	 * 修改商品一级分类
	 * @param firstGoods
	 * @return true
	 */
	public boolean updateFirstGoods(FirstGoodsEntity firstGoods);

}
