package com.lsp.logistics.web.action.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lsp.logistics.entity.FirstGoodsEntity;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.entity.StorageReserveEntity;
import com.lsp.logistics.service.ifac.goods.FirstGoodsServiceIfac;
import com.lsp.logistics.service.ifac.storage.GoodsNumberServiceIfac;
import com.lsp.logistics.service.ifac.storage.StorageReserveServiceIfac;
import com.lsp.logistics.service.ifac.storage.StorageServiceIfac;
import com.opensymphony.xwork2.ActionSupport;

public class StorageAction extends ActionSupport {
	
	private List<StorageEntity> storageList;
	private StorageEntity storage;
	private Map<String, Object> data;
	private List<FirstGoodsEntity> firstGoodsList;
	private StorageReserveEntity storageReserve;
	private List<StorageReserveEntity> storageReserveList;
	private Integer storageId;
	private String storageName;
	private List<GoodsNumberEntity> goodsNumberList;

	public List<GoodsNumberEntity> getGoodsNumberList() {
		return goodsNumberList;
	}

	public void setGoodsNumberList(List<GoodsNumberEntity> goodsNumberList) {
		this.goodsNumberList = goodsNumberList;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public Integer getStorageId() {
		return storageId;
	}

	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}

	public List<StorageReserveEntity> getStorageReserveList() {
		return storageReserveList;
	}

	public void setStorageReserveList(List<StorageReserveEntity> storageReserveList) {
		this.storageReserveList = storageReserveList;
	}

	public StorageReserveEntity getStorageReserve() {
		return storageReserve;
	}

	public void setStorageReserve(StorageReserveEntity storageReserve) {
		this.storageReserve = storageReserve;
	}

	public List<FirstGoodsEntity> getFirstGoodsList() {
		return firstGoodsList;
	}

	public void setFirstGoodsList(List<FirstGoodsEntity> firstGoodsList) {
		this.firstGoodsList = firstGoodsList;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public StorageEntity getStorage() {
		return storage;
	}

	public void setStorage(StorageEntity storage) {
		this.storage = storage;
	}

	public List<StorageEntity> getStorageList() {
		return storageList;
	}

	public void setStorageList(List<StorageEntity> storageList) {
		this.storageList = storageList;
	}
	
	private StorageServiceIfac storageService;
	private FirstGoodsServiceIfac firstGoodsService;
	private StorageReserveServiceIfac storageReserveService;
	private GoodsNumberServiceIfac goodsNumberService;
	
	public void setGoodsNumberService(GoodsNumberServiceIfac goodsNumberService) {
		this.goodsNumberService = goodsNumberService;
	}

	public void setStorageReserveService(
			StorageReserveServiceIfac storageReserveService) {
		this.storageReserveService = storageReserveService;
	}

	public void setFirstGoodsService(FirstGoodsServiceIfac firstGoodsService) {
		this.firstGoodsService = firstGoodsService;
	}

	public void setStorageService(StorageServiceIfac storageService) {
		this.storageService = storageService;
	}

	/*
	 * 查询出所有库房
	 */
	public String findAllStorage(){
		storageList = this.storageService.findAllStorage();
		return "findAllStorage";
	}
	
	/*
	 * 跳转新增库房页面
	 */
	public String openAddStoragePage(){
		return "openAddStoragePage";
	}
	
	/*
	 * 新增库房
	 */
	public String addStorage(){
		data = new HashMap<String, Object>();
		if(this.storageService.saveStorage(storage)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "storageList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "添加失败，只能存在一个中心库房！");
		}
		return "add";
	}
	
	/*
	 * 跳转设置库房存储量页面
	 */
	public String openAddStorageReservePage(){
		storageList = this.storageService.findAllStorage();
		firstGoodsList = this.firstGoodsService.findAllFirstGoods();
		return "openAddStorageReservePage";
	}
	
	/*
	 * 设置库房存储量
	 */
	public String addStorageReserve(){
		data = new HashMap<String, Object>();
		if(this.storageReserveService.saveStorageReserve(storageReserve)){
			this.goodsNumberService.saveGoodsNumber(storageReserve.getGoods(), storageReserve.getStorage());
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "storageList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "添加失败");
		}
		return "addStorageReserve";
	}
	
	/*
	 * 查看库房存储量
	 */
	public String findStorageReserver(){
		storageReserveList = this.storageReserveService.findStorageReserveByStorageId(storageId);
		return "findStorageReserver";
	}
	
	/*
	 * 删除库房
	 */
	public String deleteStorage(){
		data = new HashMap<String, Object>();
		if(this.storageService.deleteStorage(storage.getId())){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "storageList");
			data.put("rel", "");
			data.put("callbackType", "forward");
			data.put("forwardUrl", "storageList.action");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "删除失败，请确认库房里没有存在商品。");
		}
		return "delete";
	}
	
	/*
	 * 通过Id查询库房
	 */
	public String findById(){
		storage = this.storageService.findById(storage.getId());
		return "findById";
	}
	
	/*
	 * 修改库房信息
	 */
	public String updateStorage(){
		data = new HashMap<String, Object>();
		if(this.storageService.updateStorage(storage)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "storageList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "更新失败");
		}
		return "update";
	}
	
	/*
	 * 条件查询库房
	 */
	public String findStorage(){
		storageList = this.storageService.findStorage(storageName);
		if(storageList.size() != 0){
			return "findStorage";
		}
		else{
			data = new HashMap<String, Object>();
			data.put("statusCode", "300");
			data.put("message", "请输入查询条件。");
			return "errorFind";
		}
	}
	
	/*
	 * 查看库存量
	 */
	public String lookGoodsNumber(){
			goodsNumberList = goodsNumberService.lookGoodsNumber(storage.getId());
		return "lookGoodsNumber";
	}
	
}
