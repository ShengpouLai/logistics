package com.lsp.logistics.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 库房实体
 * 
 * @author pou
 *
 */

public class StorageEntity {
	
	private Integer id;
	
	/** 仓库编号 */
	private String storageId;
	
	/** 仓库名 */
	private String storageName;
	
	/** 仓库地址*/
	private String storageAddress;
	
	/** 仓库管理员*/
	private String storageManagement;
	
	/** 仓库等级 */
	private String storageLevel;
	
	/** 商品 */
	private Set<GoodsEntity> goods = new HashSet<GoodsEntity>();
	
	public Set<GoodsEntity> getGoods() {
		return goods;
	}
	public void setGoods(Set<GoodsEntity> goods) {
		this.goods = goods;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStorageId() {
		return storageId;
	}
	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	public String getStorageName() {
		return storageName;
	}
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
	public String getStorageAddress() {
		return storageAddress;
	}
	public void setStorageAddress(String storageAddress) {
		this.storageAddress = storageAddress;
	}
	public String getStorageManagement() {
		return storageManagement;
	}
	public void setStorageManagement(String storageManagement) {
		this.storageManagement = storageManagement;
	}
	public String getStorageLevel() {
		return storageLevel;
	}
	public void setStorageLevel(String storageLevel) {
		this.storageLevel = storageLevel;
	}

}
