package com.lsp.logistics.entity;

import java.util.Date;

/**
 * 分站库房入库单实体
 * @author pou
 *
 */

public class SubstationStoragePutInOrder {
	
	private Integer id;
	
	/** 入库单号 */
	private String substationStoragePutInOrderId;
	
	/** 实际入库日期 */
	private Date substationStoragePutInDate;
	
	/** 验货单 */
	private CheckGoodsOrder checkGoodsOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubstationStoragePutInOrderId() {
		return substationStoragePutInOrderId;
	}

	public void setSubstationStoragePutInOrderId(
			String substationStoragePutInOrderId) {
		this.substationStoragePutInOrderId = substationStoragePutInOrderId;
	}

	public Date getSubstationStoragePutInDate() {
		return substationStoragePutInDate;
	}

	public void setSubstationStoragePutInDate(Date substationStoragePutInDate) {
		this.substationStoragePutInDate = substationStoragePutInDate;
	}

	public CheckGoodsOrder getCheckGoodsOrder() {
		return checkGoodsOrder;
	}

	public void setCheckGoodsOrder(CheckGoodsOrder checkGoodsOrder) {
		this.checkGoodsOrder = checkGoodsOrder;
	}

}
