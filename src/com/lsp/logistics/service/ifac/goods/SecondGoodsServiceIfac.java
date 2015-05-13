package com.lsp.logistics.service.ifac.goods;

import java.util.List;

import com.lsp.logistics.entity.SecondGoodsEntity;

public interface SecondGoodsServiceIfac {
	
	/**
	 * 查询所有商品二级分类
	 * @return list
	 */
	public List<SecondGoodsEntity> findAllSecondGoods();
	
	/**
	 * 增加商品二级分类
	 * @param secondGoods
	 * @return true
	 */
	public boolean saveSecondGoods(SecondGoodsEntity secondGoods);
	
	/**
	 * 商品一级分类级联商品二级分类
	 * @param firstGoodsId
	 * @return
	 */
	public List<SecondGoodsEntity> findSercondByFirstGoodsId(Integer firstGoodsId);
	
	/**
	 * 删除商品二级分类
	 * @param secondGoodsId
	 * @return true
	 */
	public boolean deleteSecondGoods(Integer secondGoodsId);
	
	/**
	 * 通过Id查找商品二级分类
	 * @param secondGoodsId
	 * @return SecondGoodsEntity
	 */
	public SecondGoodsEntity findSecondGoodsById(Integer secondGoodsId);
	/**
	 * 修改商品二级分类信息
	 * @param secondGoods
	 * @return true
	 */
	public boolean updateSecondGoods(SecondGoodsEntity secondGoods);

}
