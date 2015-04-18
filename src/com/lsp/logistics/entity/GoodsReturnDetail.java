package com.lsp.logistics.entity;

/**
 * 退货订单详细
 * @author pou
 *
 */
public class GoodsReturnDetail {
	
	private Integer id;
	
	/** 订单 */
	private OrderEntity order;
	
	/** 退货数量 */
	private Integer goodsReturnNum;
	
	/** 退货商品 */
	private GoodsEntity goods;
	
	/** 退货单 */
	private GoodsReturnEntity goodsReturn;
	
	/** 订单详细 */
	private OrderDetailEntity orderDetail;

	public OrderDetailEntity getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetailEntity orderDetail) {
		this.orderDetail = orderDetail;
	}

	public GoodsReturnEntity getGoodsReturn() {
		return goodsReturn;
	}

	public void setGoodsReturn(GoodsReturnEntity goodsReturn) {
		this.goodsReturn = goodsReturn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public Integer getGoodsReturnNum() {
		return goodsReturnNum;
	}

	public void setGoodsReturnNum(Integer goodsReturnNum) {
		this.goodsReturnNum = goodsReturnNum;
	}

	public GoodsEntity getGoods() {
		return goods;
	}

	public void setGoods(GoodsEntity goods) {
		this.goods = goods;
	}

}
