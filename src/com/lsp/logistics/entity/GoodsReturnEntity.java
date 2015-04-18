package com.lsp.logistics.entity;

import java.util.Date;

/**
 * 退货订单实体
 * @author pou
 *
 */
public class GoodsReturnEntity {
	
	private Integer id;
	
	/** 退货日期 */
	private Date goodsReturnDate;
	
	/** 退货原因 */
	private String goodsReturnReason;
	
	/** 退货订单 */
	private OrderEntity order;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getGoodsReturnDate() {
		return goodsReturnDate;
	}

	public void setGoodsReturnDate(Date goodsReturnDate) {
		this.goodsReturnDate = goodsReturnDate;
	}

	public String getGoodsReturnReason() {
		return goodsReturnReason;
	}

	public void setGoodsReturnReason(String goodsReturnReason) {
		this.goodsReturnReason = goodsReturnReason;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

}
