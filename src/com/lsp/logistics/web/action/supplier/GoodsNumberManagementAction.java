package com.lsp.logistics.web.action.supplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lsp.logistics.entity.BuyGoodsOrder;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.StorageReserveEntity;
import com.lsp.logistics.service.ifac.goods.GoodsServiceIfac;
import com.lsp.logistics.service.ifac.storage.GoodsNumberServiceIfac;
import com.lsp.logistics.service.ifac.storage.StorageReserveServiceIfac;
import com.lsp.logistics.service.ifac.supplier.BuyGoodsOrderServiceIfac;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsNumberManagementAction extends ActionSupport{
	private List<GoodsEntity> goodsList;
	private List<StorageReserveEntity> storageReserveList;
	private List<GoodsNumberEntity> goodsNumberList;
	private GoodsEntity goods;
	private StorageReserveEntity storageReserve;
	private GoodsNumberEntity goodsNumber;
	private Map<String, Object> data;
	private BuyGoodsOrder buyGoodsOrder;
	private Integer goodsId;
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public BuyGoodsOrder getBuyGoodsOrder() {
		return buyGoodsOrder;
	}
	public void setBuyGoodsOrder(BuyGoodsOrder buyGoodsOrder) {
		this.buyGoodsOrder = buyGoodsOrder;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public StorageReserveEntity getStorageReserve() {
		return storageReserve;
	}
	public void setStorageReserve(StorageReserveEntity storageReserve) {
		this.storageReserve = storageReserve;
	}
	public GoodsNumberEntity getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(GoodsNumberEntity goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public GoodsEntity getGoods() {
		return goods;
	}
	public void setGoods(GoodsEntity goods) {
		this.goods = goods;
	}
	public List<GoodsNumberEntity> getGoodsNumberList() {
		return goodsNumberList;
	}
	public void setGoodsNumberList(List<GoodsNumberEntity> goodsNumberList) {
		this.goodsNumberList = goodsNumberList;
	}
	public List<StorageReserveEntity> getStorageReserveList() {
		return storageReserveList;
	}
	public void setStorageReserveList(List<StorageReserveEntity> storageReserveList) {
		this.storageReserveList = storageReserveList;
	}
	public List<GoodsEntity> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsEntity> goodsList) {
		this.goodsList = goodsList;
	}


	private GoodsServiceIfac goodsService;
	private StorageReserveServiceIfac storageReserveService;
	private GoodsNumberServiceIfac goodsNumberService;
	private BuyGoodsOrderServiceIfac buyGoodsOrderService;
	public void setBuyGoodsOrderService(
			BuyGoodsOrderServiceIfac buyGoodsOrderService) {
		this.buyGoodsOrderService = buyGoodsOrderService;
	}
	public void setGoodsNumberService(GoodsNumberServiceIfac goodsNumberService) {
		this.goodsNumberService = goodsNumberService;
	}
	public void setGoodsService(GoodsServiceIfac goodsService) {
		this.goodsService = goodsService;
	}
	public void setStorageReserveService(
			StorageReserveServiceIfac storageReserveService) {
		this.storageReserveService = storageReserveService;
	}

	/*
	 * 查出缺货商品列表
	 */
	public String buyGoodsList(){
		storageReserveList = new ArrayList<StorageReserveEntity>();
		goodsNumberList = new ArrayList<GoodsNumberEntity>();
		//查出缺货商品，首先用现有数量和预警值比较
		goodsList = this.goodsService.findShortageGoods();
		//查出缺货商品的库存量和库存储备
		for (int i = 0; i < goodsList.size(); i++) {
			storageReserveList.add(this.storageReserveService.findShortageGoodsReserve(goodsList.get(i)).get(0));
			goodsNumberList.add((GoodsNumberEntity)this.goodsNumberService.findShortGoodsNumber(goodsList.get(i)).get(0));
		}
		return "buyGoodsList";
	}
	
	/*
	 * 跳转购货页面
	 */
	public String openBuyGoodsPage(){
		goods = goodsService.findGoodsById(goods.getId());
		storageReserve = storageReserveService.findShortageGoodsReserve(goods).get(0);
		goodsNumber = goodsNumberService.findShortGoodsNumber(goods).get(0);
	
		return "openBuyGoodsPage";
	}
	
	/*
	 * 保存购货单
	 */
	public String buyGoods(){
		data = new HashMap<String, Object>();
		//保存购货入库单
		if(this.buyGoodsOrderService.saveBuyGoodsOrder(buyGoodsOrder)){
			this.goodsService.buyGoodsState(buyGoodsOrder.getGoods().getId());
//			this.goodsNumberService.updateGoodsNumber(buyGoodsOrder.getGoods().getId(), buyGoodsOrder.getBuyGoodsNumber());
			data.put("statusCode",200);
			data.put("message", "进货成功");
			data.put("navTabId", "buyGoodsList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "添加失败");
		}
		return "buyGoods";
	}

}
