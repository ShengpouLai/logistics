package com.lsp.logistics.entity;

/**
 * 库房存储信息实体
 * 
 * @author pou
 *
 */
public class StorageReserveEntity {
	
	private Integer id;
	
	/** 预警值 */
	private Integer storageWarningReserves;
	
	/** 最大值 */
	private Integer storageMaxReserves;
	
	/** 仓库 */
	private StorageEntity storage;
	
	/** 货物 */
	private GoodsEntity goods;
	public GoodsEntity getGoods() {
		return goods;
	}
	public void setGoods(GoodsEntity goods) {
		this.goods = goods;
	}
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
	public Integer getStorageWarningReserves() {
		return storageWarningReserves;
	}
	public void setStorageWarningReserves(Integer storageWarningReserves) {
		this.storageWarningReserves = storageWarningReserves;
	}
	public Integer getStorageMaxReserves() {
		return storageMaxReserves;
	}
	public void setStorageMaxReserves(Integer storageMaxReserves) {
		this.storageMaxReserves = storageMaxReserves;
	}

}
