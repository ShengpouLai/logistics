package com.lsp.logistics.entity;

import java.util.Date;

/**
 * 商品调拨单实体
 * @author pou
 *
 */

public class GoodsTransferOrderEntity {
	
	private Integer id;
	
	/** 商品调拨单号 */
	private String goodsTransferOrderId;
	
	/** 商品调拨日期 */
	private Date goodsTransferDate;
	
	/** 订单 */
	private OrderEntity t_order;
	
	/** 商品调拨状态 
	 * 
	 * 0表示商品已经调拨出库
	 * 1表示商品尚未调拨出库
	 * 
	 * */
	private String goodsTransferType;
	
	/** 分站 */
	private SubstationEntity substation;
	
	public SubstationEntity getSubstation() {
		return substation;
	}
	public void setSubstation(SubstationEntity substation) {
		this.substation = substation;
	}
	public String getGoodsTransferType() {
		return goodsTransferType;
	}
	public void setGoodsTransferType(String goodsTransferType) {
		this.goodsTransferType = goodsTransferType;
	}
	public Date getGoodsTransferDate() {
		return goodsTransferDate;
	}
	public void setGoodsTransferDate(Date goodsTransferDate) {
		this.goodsTransferDate = goodsTransferDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsTransferOrderId() {
		return goodsTransferOrderId;
	}
	public void setGoodsTransferOrderId(String goodsTransferOrderId) {
		this.goodsTransferOrderId = goodsTransferOrderId;
	}
	public OrderEntity getT_order() {
		return t_order;
	}
	public void setT_order(OrderEntity t_order) {
		this.t_order = t_order;
	}

}
