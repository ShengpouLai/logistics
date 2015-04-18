package com.lsp.logistics.entity;

import java.util.Date;

/**
 * 中心库房入库单实体
 * @author Administrator
 *
 */
public class CentralStoragePutInOrder {
	
	private Integer id;
	
	/** 应该入库数量 */
	private Integer shouldPutInNumber;
	
	/** 实际入库数量 */
	private Integer actualPutInNumber;
	
	/** 实际入库日期 */
	private Date actualPutInDate;
	
	/** 备注 */
	private String centralStoragePutInRemark;

	/** 购货单号 */
	private BuyGoodsOrder buyGoodsOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShouldPutInNumber() {
		return shouldPutInNumber;
	}

	public void setShouldPutInNumber(Integer shouldPutInNumber) {
		this.shouldPutInNumber = shouldPutInNumber;
	}

	public Integer getActualPutInNumber() {
		return actualPutInNumber;
	}

	public void setActualPutInNumber(Integer actualPutInNumber) {
		this.actualPutInNumber = actualPutInNumber;
	}

	public Date getActualPutInDate() {
		return actualPutInDate;
	}

	public void setActualPutInDate(Date actualPutInDate) {
		this.actualPutInDate = actualPutInDate;
	}

	public String getCentralStoragePutInRemark() {
		return centralStoragePutInRemark;
	}

	public void setCentralStoragePutInRemark(String centralStoragePutInRemark) {
		this.centralStoragePutInRemark = centralStoragePutInRemark;
	}

	public BuyGoodsOrder getBuyGoodsOrder() {
		return buyGoodsOrder;
	}

	public void setBuyGoodsOrder(BuyGoodsOrder buyGoodsOrder) {
		this.buyGoodsOrder = buyGoodsOrder;
	}

}
