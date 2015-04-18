package com.lsp.logistics.entity;

import java.util.Date;
/**
 * 分站验货单实体
 * @author pou
 *
 */

public class CheckGoodsOrder {
	
	private Integer id;
	
	/** 验货单号 */
	private String checkGoodsOrderId;
	
	/** 验货时间 */
	private Date checkGoodsOrderDate;
	
	/** 出库时间 */
	private Date putInTime;
	
	/** 商品调拨单 */
	private GoodsTransferOrderEntity goodsTransferOrder;
	
	/** 验货状态 
	 * 0表示分站已验货入库
	 * 1表示分站尚未验货入库
	 * */
	private String checkGoodsState;

	public Date getPutInTime() {
		return putInTime;
	}

	public void setPutInTime(Date putInTime) {
		this.putInTime = putInTime;
	}

	public String getCheckGoodsState() {
		return checkGoodsState;
	}

	public void setCheckGoodsState(String checkGoodsState) {
		this.checkGoodsState = checkGoodsState;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCheckGoodsOrderId() {
		return checkGoodsOrderId;
	}

	public void setCheckGoodsOrderId(String checkGoodsOrderId) {
		this.checkGoodsOrderId = checkGoodsOrderId;
	}

	public Date getCheckGoodsOrderDate() {
		return checkGoodsOrderDate;
	}

	public void setCheckGoodsOrderDate(Date checkGoodsOrderDate) {
		this.checkGoodsOrderDate = checkGoodsOrderDate;
	}

	public GoodsTransferOrderEntity getGoodsTransferOrder() {
		return goodsTransferOrder;
	}

	public void setGoodsTransferOrder(GoodsTransferOrderEntity goodsTransferOrder) {
		this.goodsTransferOrder = goodsTransferOrder;
	}

}
