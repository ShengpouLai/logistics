package com.lsp.logistics.entity;

/**
 * 库存量实体
 * 
 * @author pou
 *
 */
public class GoodsNumberEntity {
	
	private Integer id;
	
	/** 总库存量 */
	private Integer totalQuantity;
	
	/** 退回数量 */
	private Integer returnQuantity;
	
	/** 可分配量 */
	private Integer canDistributeQuantity;
	
	/** 已分配量 */
	private Integer cannotDistributeQuantity;
	
	/** 货物 */
	private GoodsEntity goods;
	
	/** 仓库 */
	private StorageEntity storage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Integer getReturnQuantity() {
		return returnQuantity;
	}
	public void setReturnQuantity(Integer returnQuantity) {
		this.returnQuantity = returnQuantity;
	}
	public Integer getCanDistributeQuantity() {
		return canDistributeQuantity;
	}
	public void setCanDistributeQuantity(Integer canDistributeQuantity) {
		this.canDistributeQuantity = canDistributeQuantity;
	}
	public Integer getCannotDistributeQuantity() {
		return cannotDistributeQuantity;
	}
	public void setCannotDistributeQuantity(Integer cannotDistributeQuantity) {
		this.cannotDistributeQuantity = cannotDistributeQuantity;
	}
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
	
}
