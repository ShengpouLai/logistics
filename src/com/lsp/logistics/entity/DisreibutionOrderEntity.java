package com.lsp.logistics.entity;

import java.util.Date;

/**
 * 
 * 分发单实体
 * @author pou
 *
 */

public class DisreibutionOrderEntity {
	
	private Integer id;
	
	/** 分发单编号 */
	private String disreibutionOrderId;
	
	/** 签收人 */
	private String distributionOrderSigner;
	
	/** 分发日期 */
	private Date distributionOrderDate;
	
	/** 商品调拨单 */
	private GoodsTransferOrderEntity goodsTransferOrder;
	
	/**  */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisreibutionOrderId() {
		return disreibutionOrderId;
	}

	public void setDisreibutionOrderId(String disreibutionOrderId) {
		this.disreibutionOrderId = disreibutionOrderId;
	}

	public String getDistributionOrderSigner() {
		return distributionOrderSigner;
	}

	public void setDistributionOrderSigner(String distributionOrderSigner) {
		this.distributionOrderSigner = distributionOrderSigner;
	}

	public Date getDistributionOrderDate() {
		return distributionOrderDate;
	}

	public void setDistributionOrderDate(Date distributionOrderDate) {
		this.distributionOrderDate = distributionOrderDate;
	}

	public GoodsTransferOrderEntity getGoodsTransferOrder() {
		return goodsTransferOrder;
	}

	public void setGoodsTransferOrder(GoodsTransferOrderEntity goodsTransferOrder) {
		this.goodsTransferOrder = goodsTransferOrder;
	}
	

}
