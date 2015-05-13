package com.lsp.logistics.service.ifac.goods;

import java.util.List;

import com.lsp.logistics.entity.GoodsEntity;

public interface GoodsServiceIfac {
	
	/**
	 * 查询所有商品
	 * @return list
	 */
	public List<GoodsEntity> findAllGoods();
	
	/**
	 * 增加商品
	 * @param goods
	 * @return true
	 */
	public boolean saveGoods(GoodsEntity goods);
	
	/**
	 * 通过商品二级分类查询商品
	 * @param secondGoodsId
	 * @return list
	 */
	public List<GoodsEntity> findGoodsBySecondGoodsId(Integer secondGoodsId);
	
	/**
	 * 删除商品
	 * @param goodsId
	 * @return true
	 */
	public boolean deleteGoods(Integer goodsId);
	
	/**
	 * 通过Id查找商品
	 * @param id
	 * @return GoodsEntity
	 */
	public GoodsEntity findGoodsById(Integer id);
	
	/**
	 * 修改商品信息
	 * @param goods
	 * @return true
	 */
	public boolean updateGoods(GoodsEntity goods);
	
	/**
	 * 条件查询商品
	 * @param goodsId
	 * @param goodsName
	 * @return list
	 */
	public List<GoodsEntity> findGoods(String goodsId, String goodsName);
	
	/**
	 * 查询出缺货商品
	 * @return list
	 */
	public List<GoodsEntity> findShortageGoods();
	
	/**
	 * 判断商品是否已入库
	 * @param goodsId
	 * @return true
	 */
	public boolean ifGoodsPutIn(Integer goodsId);
	
	/**
	 * 修改商品状态，表示其已入库
	 * @param goodsId
	 * @return true
	 */
	public boolean buyGoodsState(Integer goodsId);

}
