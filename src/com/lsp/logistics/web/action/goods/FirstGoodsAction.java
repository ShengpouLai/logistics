package com.lsp.logistics.web.action.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lsp.logistics.entity.FirstGoodsEntity;
import com.lsp.logistics.service.ifac.goods.FirstGoodsServiceIfac;
import com.opensymphony.xwork2.ActionSupport;

public class FirstGoodsAction extends ActionSupport {
	
	private FirstGoodsEntity firstGoods;
	private List<FirstGoodsEntity> firstGoodsList;
	private Map<String, Object> data;
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public List<FirstGoodsEntity> getFirstGoodsList() {
		return firstGoodsList;
	}

	public void setFirstGoodsList(List<FirstGoodsEntity> firstGoodsList) {
		this.firstGoodsList = firstGoodsList;
	}

	public FirstGoodsEntity getFirstGoods() {
		return firstGoods;
	}

	public void setFirstGoods(FirstGoodsEntity firstGoods) {
		this.firstGoods = firstGoods;
	}

	private FirstGoodsServiceIfac firstGoodsService;
	public void setFirstGoodsService(FirstGoodsServiceIfac firstGoodsService) {
		this.firstGoodsService = firstGoodsService;
	}
	
	public String findAllFirstGoods(){
		firstGoodsList = this.firstGoodsService.findAllFirstGoods();
		return "firstGoodsFindAll";
	}
	
	public String addFirstGoods(){
		data = new HashMap<String, Object>();
		if(this.firstGoodsService.saveFirstGoods(firstGoods)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "firstGoodsList");
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
	
	public String deleteFirstGoods(){
		data = new HashMap<String, Object>();
		if(this.firstGoodsService.deleteFirstGoods(firstGoods.getId())){
			data.put("statusCode",200);
			data.put("message", "删除成功");
			data.put("navTabId", "firstGoodsList");
			data.put("rel", "");
			data.put("callbackType", "forward");
			data.put("forwardUrl", "firstGoodsList.action");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "添加失败");
		}
		return "delete";
	}
	
	public String findFirstGoodsById(){
		firstGoods = this.firstGoodsService.findFirstGoodsById(firstGoods.getId());
		return "findById";
	}
	
	public String updateFirstGoods(){
		data = new HashMap<String, Object>();
		if(this.firstGoodsService.updateFirstGoods(firstGoods)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "firstGoodsList");
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
