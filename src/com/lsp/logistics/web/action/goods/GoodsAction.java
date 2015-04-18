package com.lsp.logistics.web.action.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.lsp.logistics.entity.FirstGoodsEntity;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.SupplierEntity;
import com.lsp.logistics.service.ifac.goods.FirstGoodsServiceIfac;
import com.lsp.logistics.service.ifac.goods.GoodsServiceIfac;
import com.lsp.logistics.service.ifac.storage.GoodsNumberServiceIfac;
import com.lsp.logistics.service.ifac.supplier.SupplierServiceIfac;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport {
	private List<FirstGoodsEntity> firstGoodsList;
	private List<GoodsEntity> goodsList;
	private Map<String, Object> data;
	private GoodsEntity goods;
	private JSONArray jsonArray;
	private JSONArray jsonArray1;
	private Integer secondGoodsId;
	private String goodsId;
	private String goodsName;
	private List<SupplierEntity> supplierList;
	
	public List<SupplierEntity> getSupplierList() {
		return supplierList;
	}
	public void setSupplierList(List<SupplierEntity> supplierList) {
		this.supplierList = supplierList;
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
	public List<FirstGoodsEntity> getFirstGoodsList() {
		return firstGoodsList;
	}
	public void setFirstGoodsList(List<FirstGoodsEntity> firstGoodsList) {
		this.firstGoodsList = firstGoodsList;
	}
	public Integer getSecondGoodsId() {
		return secondGoodsId;
	}
	public void setSecondGoodsId(Integer secondGoodsId) {
		this.secondGoodsId = secondGoodsId;
	}
	public JSONArray getJsonArray() {
		return jsonArray;
	}
	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}
	public JSONArray getJsonArray1() {
		return jsonArray1;
	}
	public void setJsonArray1(JSONArray jsonArray1) {
		this.jsonArray1 = jsonArray1;
	}
	public GoodsEntity getGoods() {
		return goods;
	}
	public void setGoods(GoodsEntity goods) {
		this.goods = goods;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public List<GoodsEntity> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsEntity> goodsList) {
		this.goodsList = goodsList;
	}

	private GoodsServiceIfac goodsService;

	public void setGoodsService(GoodsServiceIfac goodsService) {
		this.goodsService = goodsService;
	}
	
	private FirstGoodsServiceIfac firstGoodsService;
	
	public void setFirstGoodsService(FirstGoodsServiceIfac firstGoodsService) {
		this.firstGoodsService = firstGoodsService;
	}
	private GoodsNumberServiceIfac goodsNumberService;
	public void setGoodsNumberService(GoodsNumberServiceIfac goodsNumberService) {
		this.goodsNumberService = goodsNumberService;
	}
	
	private SupplierServiceIfac supplierService;
	
	public void setSupplierService(SupplierServiceIfac supplierService) {
		this.supplierService = supplierService;
	}
	public String findAllGoods(){
		goodsList = this.goodsService.findAllGoods();
		return "findAllGoods";
	}
	
	public String addGoods(){
		data = new HashMap<String, Object>();
		if(this.goodsService.saveGoods(goods)){
//			this.goodsNumberService.saveGoodsNumber(goods, goods.getStorage());
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "goodsList");
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
	
	
	public String findGoodsBySecondGoodsId(){
		goodsList = this.goodsService.findGoodsBySecondGoodsId(secondGoodsId);
		jsonArray = new JSONArray();
		jsonArray1 = new JSONArray();
		
		for(int i = 0 ; i< goodsList.size();i++){
			String a = goodsList.get(i).getId()+"";
			jsonArray1.clear();
			jsonArray1.add(a);
			jsonArray1.add(goodsList.get(i).getGoodsName());
			jsonArray.add(jsonArray1);
	    } 
		
		return "findGoodsBySecondGoodsId";
	}
	
	public String deleteGoods(){
		data = new HashMap<String, Object>();
		try{
		if(this.goodsService.deleteGoods(goods.getId())){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "goodsList");
			data.put("rel", "");
			data.put("callbackType", "forward");
			data.put("forwardUrl", "goodsList.action");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "删除失败");
		}}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "delete";
	}
	
	public String findGoodsById(){
		firstGoodsList = this.firstGoodsService.findAllFirstGoods();
		goods = this.goodsService.findGoodsById(goods.getId());
		supplierList = this.supplierService.findAllSupplier();
		return "findGoodsById";
	}
	
	public String updateGoods(){
		data = new HashMap<String, Object>();
		if(goodsService.updateGoods(goods)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "goodsList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "添加失败");
		}
		return "update";
	}
	
	public String findGoods(){
		goodsList = this.goodsService.findGoods(goodsId, goodsName);
		if(goodsList.size() == 0){
			data = new HashMap<String, Object>();
			data.put("statusCode", "300");
			data.put("message", "请输入查询信息");
			return "errorFindGoods";
		}
		else{
			return "findGoods";
		}
	}
	

}
