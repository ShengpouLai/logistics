package com.lsp.logistics.entity;

/**
 * 配送员实体
 * @author pou
 *
 */

public class DeliveryStaffEntity {
	
	private Integer id;
	
	/** 配送员姓名 */
	private String deliveryStaffName;
	
	/** 配送员电话 */
	private String deliveryStaffPhone;
	
	/** 分站 */
	private SubstationEntity substation_t;

	public SubstationEntity getSubstation_t() {
		return substation_t;
	}

	public void setSubstation_t(SubstationEntity substation_t) {
		this.substation_t = substation_t;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeliveryStaffName() {
		return deliveryStaffName;
	}

	public void setDeliveryStaffName(String deliveryStaffName) {
		this.deliveryStaffName = deliveryStaffName;
	}

	public String getDeliveryStaffPhone() {
		return deliveryStaffPhone;
	}

	public void setDeliveryStaffPhone(String deliveryStaffPhone) {
		this.deliveryStaffPhone = deliveryStaffPhone;
	}

}
