package com.lsp.logistics.entity;

/**
 * 
 * 分站实体
 * @author pou
 *
 */

public class SubstationEntity {
	
	private Integer id;
	
	/** 分站名称 */
	private String substationName;
	
	/** 分站电话 */
	private String substationPhone;
	
	/** 分站地址 */
	private String substationAddress;
	
	/** 分站库房 */
	private StorageEntity storage;

	public StorageEntity getStorage() {
		return storage;
	}

	public void setStorage(StorageEntity storage) {
		this.storage = storage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubstationName() {
		return substationName;
	}

	public void setSubstationName(String substationName) {
		this.substationName = substationName;
	}

	public String getSubstationPhone() {
		return substationPhone;
	}

	public void setSubstationPhone(String substationPhone) {
		this.substationPhone = substationPhone;
	}

	public String getSubstationAddress() {
		return substationAddress;
	}

	public void setSubstationAddress(String substationAddress) {
		this.substationAddress = substationAddress;
	}

}
