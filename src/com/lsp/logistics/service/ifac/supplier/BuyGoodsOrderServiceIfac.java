package com.lsp.logistics.service.ifac.supplier;

import java.util.List;

import com.lsp.logistics.entity.BuyGoodsOrder;

public interface BuyGoodsOrderServiceIfac {
	
	/**
	 * 保存购货单
	 * @param buyGoodsOrder
	 * @return true
	 */
	public boolean saveBuyGoodsOrder(BuyGoodsOrder buyGoodsOrder);
	
	/**
	 * 查询所有购货单
	 * @return list
	 */
	public List<BuyGoodsOrder> findAll();
	
	/**
	 * 通过Id查询出购货单
	 * @param id
	 * @return BuyGoodsOrder
	 */
	public BuyGoodsOrder findById(Integer id);

	/**
	 * 查询出没有入库的购货单
	 * @return list
	 */
	public List<BuyGoodsOrder> findNoPutIn();

	/**
	 * 修改购货单状态
	 * @param id
	 * @return true
	 */
	public boolean updateBuyGoodsOrderState(Integer id);

}
