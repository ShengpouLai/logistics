package com.lsp.logistics.entity;

/**
 * 客户实体
 * 
 * @author pou
 *
 */
public class CostomerEntity {

	private Integer id;
	/** 客户姓名 */
	private String costomerName;
	
	/** 客户ID */
	private String costomerId;
	
	/** 客户公司 */
	private String company;
	
	/** 客户手机 */
	private String mobailPhone;
	
	/** 客户固定电话 */
	private String phone;
	
	/** 客户地址 */
	private String address;
	
	/** 客户邮编 */
	private String postcode;
	
	/** 客户邮箱 */
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCostomerName() {
		return costomerName;
	}

	public void setCostomerName(String costomerName) {
		this.costomerName = costomerName;
	}

	public String getCostomerId() {
		return costomerId;
	}

	public void setCostomerId(String costomerId) {
		this.costomerId = costomerId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMobailPhone() {
		return mobailPhone;
	}

	public void setMobailPhone(String mobailPhone) {
		this.mobailPhone = mobailPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
