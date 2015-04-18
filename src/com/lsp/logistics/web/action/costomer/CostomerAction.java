package com.lsp.logistics.web.action.costomer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lsp.logistics.entity.CostomerEntity;
import com.lsp.logistics.service.ifac.CostomerService;
import com.opensymphony.xwork2.ActionSupport;

public class CostomerAction extends ActionSupport {
	
	private Map<String, Object> data;
	private List<CostomerEntity> costomerList;
	private String costomerId;
	private String costomerName;
	private String costomerMobailPhone;
	
	public String getCostomerId() {
		return costomerId;
	}

	public void setCostomerId(String costomerId) {
		this.costomerId = costomerId;
	}

	public String getCostomerName() {
		return costomerName;
	}

	public void setCostomerName(String costomerName) {
		this.costomerName = costomerName;
	}

	public String getCostomerMobailPhone() {
		return costomerMobailPhone;
	}

	public void setCostomerMobailPhone(String costomerMobailPhone) {
		this.costomerMobailPhone = costomerMobailPhone;
	}

	public List<CostomerEntity> getCostomerList() {
		return costomerList;
	}

	public void setCostomerList(List<CostomerEntity> costomerList) {
		this.costomerList = costomerList;
	}
	
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	private CostomerEntity costomer;

	public CostomerEntity getCostomer() {
		return costomer;
	}

	public void setCostomer(CostomerEntity costomer) {
		this.costomer = costomer;
	}

	private CostomerService costomerService;

	public void setCostomerService(CostomerService costomerService) {
		this.costomerService = costomerService;
	}
	
	public String costomer(){
		return "costomer";
	}
	
	public String addCostomer() throws Exception {
		data = new HashMap<String, Object>();
		if(this.costomerService.saveCostomer(costomer)){
			data.put("statusCode",200);
			data.put("message", "添加成功");
			data.put("navTabId", "costomerList");
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
	
	public String findAllCostomer() throws Exception{
		costomerList = this.costomerService.findAllCostomer();
		return "costomerFindAll";
	}
	
	public String deleteCostomer() throws Exception{
		data = new HashMap<String, Object>();
		if(this.costomerService.deleteCostomer(costomer.getId())){
			data.put("statusCode",200);
			data.put("message", "删除成功");
			data.put("navTabId", "costomerList");
			data.put("rel", "");
			data.put("callbackType", "forward");
			data.put("forwardUrl", "costomerList.action");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "删除失败");
		}
		return "costomerDelete";
	}
	
	public String findCostomerById(){
		costomer = this.costomerService.findCostomerById(costomer.getId());
		return "costomerFindById";
	}
	
	public String updateCostomer(){
		data = new HashMap<String, Object>();
		if(this.costomerService.updateCostomer(costomer)){
			data.put("statusCode",200);
			data.put("message", "修改成功");
			data.put("navTabId", "costomerList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "修改失败");
		}
		return "costomerUpdate";
	}
	
	public String  findCostomer(){
		data = new HashMap<String, Object>();
		try{
			costomerList = this.costomerService.findCostomer(costomerId, costomerName, costomerMobailPhone);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
//		data.put("statusCode",200);
//		data.put("message", "chengg");
//		data.put("navTabId", "costomerFind");
//		data.put("rel", "");
//		data.put("callbackType", "forward");
//		data.put("forwardUrl", "costomer_findAll.action");
		return "costomersFind";
	}

}
