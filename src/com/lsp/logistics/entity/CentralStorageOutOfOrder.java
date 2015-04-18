package com.lsp.logistics.entity;

import java.util.Date;

/**
 * 中心库房出库单实体
 * @author pou
 *
 */
public class CentralStorageOutOfOrder {
	
	private Integer id;
	
	/** 出库单号 */
	private String centralStorageOutOfOrderId;
	
	/** 出库时间 */
	private Date centralStorageOutOfTime;
	
	/** 备注 */
	private String centralStorageOutOfRemark;
	
	/** 商品调拨单 */
	private GoodsTransferOrderEntity goodsTransferOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCentralStorageOutOfOrderId() {
		return centralStorageOutOfOrderId;
	}

	public void setCentralStorageOutOfOrderId(String centralStorageOutOfOrderId) {
		this.centralStorageOutOfOrderId = centralStorageOutOfOrderId;
	}

	public Date getCentralStorageOutOfTime() {
		return centralStorageOutOfTime;
	}

	public void setCentralStorageOutOfTime(Date centralStorageOutOfTime) {
		this.centralStorageOutOfTime = centralStorageOutOfTime;
	}

	public String getCentralStorageOutOfRemark() {
		return centralStorageOutOfRemark;
	}

	public void setCentralStorageOutOfRemark(String centralStorageOutOfRemark) {
		this.centralStorageOutOfRemark = centralStorageOutOfRemark;
	}

	public GoodsTransferOrderEntity getGoodsTransferOrder() {
		return goodsTransferOrder;
	}

	public void setGoodsTransferOrder(GoodsTransferOrderEntity goodsTransferOrder) {
		this.goodsTransferOrder = goodsTransferOrder;
	}
}
