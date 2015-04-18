package com.lsp.logistics.entity;

import java.util.Date;

/**
 * 购货入库单实体
 * @author Administrator
 *
 */
public class BuyGoodsOrder {
	
	private Integer id;
	
	/** 购货入库单号 */
	private String buyGoodsOrderId;
	
	/** 购货入库日期 */
	private Date buyGoodsDate;
	
	/** 购货数量 */
	private Integer buyGoodsNumber;
	
	/** 购货入库单状态
	 *  
	 *  0表示该购货单的商品已入库
	 *  1表示该购货单的商品未入库
	 *  
	 *  */
	private String buyGoodsOrderState;
	
	public String getBuyGoodsOrderState() {
		return buyGoodsOrderState;
	}
	public void setBuyGoodsOrderState(String buyGoodsOrderState) {
		this.buyGoodsOrderState = buyGoodsOrderState;
	}
	/** 商品 */
	private GoodsEntity goods;
	
	public GoodsEntity getGoods() {
		return goods;
	}
	public void setGoods(GoodsEntity goods) {
		this.goods = goods;
	}
	public Integer getBuyGoodsNumber() {
		return buyGoodsNumber;
	}
	public void setBuyGoodsNumber(Integer buyGoodsNumber) {
		this.buyGoodsNumber = buyGoodsNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBuyGoodsOrderId() {
		return buyGoodsOrderId;
	}
	public void setBuyGoodsOrderId(String buyGoodsOrderId) {
		this.buyGoodsOrderId = buyGoodsOrderId;
	}
	public Date getBuyGoodsDate() {
		return buyGoodsDate;
	}
	public void setBuyGoodsDate(Date buyGoodsDate) {
		this.buyGoodsDate = buyGoodsDate;
	}

}
