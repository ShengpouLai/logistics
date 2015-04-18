package com.lsp.logistics.entity;

/**
 * 二级商品分类实体
 * 
 * @author pou
 *
 */
public class SecondGoodsEntity {
	private Integer id;
	
	/** 二级商品名称 */
	private String secondGoodsName;
	
	/** 二级商品备注 */
	private String secondGoodsInfo;
	
	/** 一级商品 */
	private FirstGoodsEntity firstGoods;
	
	public FirstGoodsEntity getFirstGoods() {
		return firstGoods;
	}
	public void setFirstGoods(FirstGoodsEntity firstGoods) {
		this.firstGoods = firstGoods;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSecondGoodsName() {
		return secondGoodsName;
	}
	public void setSecondGoodsName(String secondGoodsName) {
		this.secondGoodsName = secondGoodsName;
	}
	public String getSecondGoodsInfo() {
		return secondGoodsInfo;
	}
	public void setSecondGoodsInfo(String secondGoodsInfo) {
		this.secondGoodsInfo = secondGoodsInfo;
	}

}
