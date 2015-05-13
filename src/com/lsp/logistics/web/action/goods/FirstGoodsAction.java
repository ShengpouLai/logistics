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
	
	/*
	 * 跳转商品一级分类列表
	 */
	public String findAllFirstGoods(){
		firstGoodsList = this.firstGoodsService.findAllFirstGoods();
		return "firstGoodsFindAll";
	}
	
	/*
	 * 保存商品一级分类
	 */
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
	
	/*
	 * 删除商品一级分类
	 */
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
	
	/*
	 * 跳转修改商品一级分类页面
	 */
	public String findFirstGoodsById(){
		firstGoods = this.firstGoodsService.findFirstGoodsById(firstGoods.getId());
		return "findById";
	}
	
	/*
	 * 修改商品一级分类
	 */
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
