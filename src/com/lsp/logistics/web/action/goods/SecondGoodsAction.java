package com.lsp.logistics.web.action.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.lsp.logistics.entity.FirstGoodsEntity;
import com.lsp.logistics.entity.SecondGoodsEntity;
import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.entity.SupplierEntity;
import com.lsp.logistics.service.ifac.goods.FirstGoodsServiceIfac;
import com.lsp.logistics.service.ifac.goods.SecondGoodsServiceIfac;
import com.lsp.logistics.service.ifac.storage.StorageServiceIfac;
import com.lsp.logistics.service.ifac.supplier.SupplierServiceIfac;
import com.opensymphony.xwork2.ActionSupport;

public class SecondGoodsAction extends ActionSupport {
	
	private List<FirstGoodsEntity> firstGoodsList;
	private List<SecondGoodsEntity> secondGoodsList;
	private SecondGoodsEntity secondGoods;
	private Map<String, Object> data;
	private Integer firstGoodsId;
	private FirstGoodsEntity firstGoods;
	private JSONArray jsonArray;
	private JSONArray jsonArray1;
	private List<SupplierEntity> supplierList;
	private List<StorageEntity> storageList;

	public List<StorageEntity> getStorageList() {
		return storageList;
	}

	public void setStorageList(List<StorageEntity> storageList) {
		this.storageList = storageList;
	}

	public List<SupplierEntity> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<SupplierEntity> supplierList) {
		this.supplierList = supplierList;
	}

	public JSONArray getJsonArray1() {
		return jsonArray1;
	}

	public void setJsonArray1(JSONArray jsonArray1) {
		this.jsonArray1 = jsonArray1;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public FirstGoodsEntity getFirstGoods() {
		return firstGoods;
	}

	public void setFirstGoods(FirstGoodsEntity firstGoods) {
		this.firstGoods = firstGoods;
	}

	public Integer getFirstGoodsId() {
		return firstGoodsId;
	}

	public void setFirstGoodsId(Integer firstGoodsId) {
		this.firstGoodsId = firstGoodsId;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public SecondGoodsEntity getSecondGoods() {
		return secondGoods;
	}

	public void setSecondGoods(SecondGoodsEntity secondGoods) {
		this.secondGoods = secondGoods;
	}

	public List<SecondGoodsEntity> getSecondGoodsList() {
		return secondGoodsList;
	}

	public void setSecondGoodsList(List<SecondGoodsEntity> secondGoodsList) {
		this.secondGoodsList = secondGoodsList;
	}
	
	public List<FirstGoodsEntity> getFirstGoodsList() {
		return firstGoodsList;
	}

	public void setFirstGoodsList(List<FirstGoodsEntity> firstGoodsList) {
		this.firstGoodsList = firstGoodsList;
	}
	
	private FirstGoodsServiceIfac firstGoodsService;
	private SecondGoodsServiceIfac secondGoodsService;
	private SupplierServiceIfac supplierService;
	private StorageServiceIfac storageService;

	public void setStorageService(StorageServiceIfac storageService) {
		this.storageService = storageService;
	}

	public void setSupplierService(SupplierServiceIfac supplierService) {
		this.supplierService = supplierService;
	}

	public void setSecondGoodsService(SecondGoodsServiceIfac secondGoodsService) {
		this.secondGoodsService = secondGoodsService;
	}

	public void setFirstGoodsService(FirstGoodsServiceIfac firstGoodsService) {
		this.firstGoodsService = firstGoodsService;
	}
	
	public String findAllSecondGoods(){
		secondGoodsList = this.secondGoodsService.findAllSecondGoods();
		return "secondGoodsFindAll";
	}
	
	public String findFirstGoods(){
		firstGoodsList = this.firstGoodsService.findAllFirstGoods();
		supplierList = this.supplierService.findAllSupplier();
		storageList = this.storageService.findAllStorage();
		return "firstGoods";
	}
	
	public String addSecondGoods(){
		data = new HashMap<String, Object>();
		if(this.secondGoodsService.saveSecondGoods(secondGoods)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "secondGoodsList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "添加失败");
		}
		return "add";
	}
	
	public String findSercondByFirstGoodsId(){
		secondGoodsList = this.secondGoodsService.findSercondByFirstGoodsId(firstGoodsId);
		data = new HashMap<String, Object>();
		jsonArray = new JSONArray();
		jsonArray1 = new JSONArray();
		if(secondGoodsList.size()==0){
			System.out.println("cccc");
		}
		for(int i = 0 ; i< secondGoodsList.size();i++){
			String a = secondGoodsList.get(i).getId()+"";
			jsonArray1.clear();
			jsonArray1.add(a);
			jsonArray1.add(secondGoodsList.get(i).getSecondGoodsName());
			jsonArray.add(jsonArray1);
	    } 
		return "findSercondByFirstGoodsId";
	}
	
	public String deleteSecondGoods(){
		data = new HashMap<String, Object>();
		if(this.secondGoodsService.deleteSecondGoods(secondGoods.getId())){
			data.put("statusCode",200);
			data.put("message", "删除成功");
			data.put("navTabId", "secondGoodsList");
			data.put("rel", "");
			data.put("callbackType", "forward");
			data.put("forwardUrl", "secondGoodsList.action");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "删除失败");
		}
		return "delete";
	}
	
	public String findSecondGoodsById(){
		firstGoodsList = this.firstGoodsService.findAllFirstGoods();
		secondGoods = this.secondGoodsService.findSecondGoodsById(secondGoods.getId());
		return "findById";
	}
	
	public String updateSecondGoods(){
		data = new HashMap<String, Object>();
		if(this.secondGoodsService.updateSecondGoods(secondGoods)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "secondGoodsList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "修改失败");
		}
		return "update";
	}

}
