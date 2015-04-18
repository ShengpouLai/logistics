package com.lsp.logistics.entity;

/**
 * 订单详细实体
 * 
 * @author pou
 *
 */

public class OrderDetailEntity {
	
	private Integer id;
	
	/** 商品数量 */
	private Integer goodsNumber;
	
	/** 订单 */
	private OrderEntity order;
	
	/** 商品 */
	private GoodsEntity goods;
	
	public GoodsEntity getGoods() {
		return goods;
	}
	public void setGoods(GoodsEntity goods) {
		this.goods = goods;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}

}
