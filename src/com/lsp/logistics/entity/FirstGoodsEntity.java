package com.lsp.logistics.entity;

/**
 * 一级商品分类实体
 * 
 * @author pou
 *
 */
public class FirstGoodsEntity {
	private Integer id;
	
	/** 一级商品名称 */
	private String firstGoodsName;
	
	/** 一级商品简介 */
	private String firstGoodsInfo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstGoodsName() {
		return firstGoodsName;
	}
	public void setFirstGoodsName(String firstGoodsName) {
		this.firstGoodsName = firstGoodsName;
	}
	public String getFirstGoodsInfo() {
		return firstGoodsInfo;
	}
	public void setFirstGoodsInfo(String firstGoodsInfo) {
		this.firstGoodsInfo = firstGoodsInfo;
	}

}
