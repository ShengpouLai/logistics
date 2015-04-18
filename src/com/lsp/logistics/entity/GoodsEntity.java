package com.lsp.logistics.entity;

import java.util.Set;

/**
 * 商品实体
 * 
 * @author pou
 *
 */
public class GoodsEntity {
	
	private Integer id;
	
	/** 商品编号 */
	private String goodsId;
	
	/** 商品名称 */
	private String goodsName;
	
	/** 商品计量单位 */
	private String goodsUnit;
	
	/** 商品价格 */
	private Double goodsPrice;
	
	/** 商品折扣 */
	private Double goodsDiscount;
	
	/** 商品成本价 */
	private Double goodsCostPrice;
//	private String goodsNumber;
	
	/** 商品型号 */
	private String goodsModelId;
	
	/** 商品保修期（保质期） */
	private String goodsQGP;
	
	/** 商品可否换货 */
	private String goodsChange;
	
	/** 商品可否退货 */
	private String goodsConcel;
	
	/** 商品备注 */
	private String goodsRemark;
	
	/** 二级商品 */
	private SecondGoodsEntity secondGoods;
	
	/** 库房存储信息 */
	private Set<StorageReserveEntity> storageReserve;
	
	/** 供货商 */
	private SupplierEntity supplier;
	
	/** 库存量 */
	private GoodsNumberEntity goodsNumber;
	
	/** 
	 * 
	 * 货物状态 
	 * 
	 * 0表示已安排进货，1表示未安排进货
	 * */
	private String goodsState;
	public String getGoodsState() {
		return goodsState;
	}
	public void setGoodsState(String goodsState) {
		this.goodsState = goodsState;
	}
	public GoodsNumberEntity getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(GoodsNumberEntity goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public SupplierEntity getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}
	public Set<StorageReserveEntity> getStorageReserve() {
		return storageReserve;
	}
	public void setStorageReserve(Set<StorageReserveEntity> storageReserve) {
		this.storageReserve = storageReserve;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Double getGoodsDiscount() {
		return goodsDiscount;
	}
	public void setGoodsDiscount(Double goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}
	public Double getGoodsCostPrice() {
		return goodsCostPrice;
	}
	public void setGoodsCostPrice(Double goodsCostPrice) {
		this.goodsCostPrice = goodsCostPrice;
	}
	public String getGoodsModelId() {
		return goodsModelId;
	}
	public void setGoodsModelId(String goodsModelId) {
		this.goodsModelId = goodsModelId;
	}
	public String getGoodsQGP() {
		return goodsQGP;
	}
	public void setGoodsQGP(String goodsQGP) {
		this.goodsQGP = goodsQGP;
	}
	public String getGoodsChange() {
		return goodsChange;
	}
	public void setGoodsChange(String goodsChange) {
		this.goodsChange = goodsChange;
	}
	public String getGoodsConcel() {
		return goodsConcel;
	}
	public void setGoodsConcel(String goodsConcel) {
		this.goodsConcel = goodsConcel;
	}
	public String getGoodsRemark() {
		return goodsRemark;
	}
	public void setGoodsRemark(String goodsRemark) {
		this.goodsRemark = goodsRemark;
	}
	public SecondGoodsEntity getSecondGoods() {
		return secondGoods;
	}
	public void setSecondGoods(SecondGoodsEntity secondGoods) {
		this.secondGoods = secondGoods;
	}
	
}
