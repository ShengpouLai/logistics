package com.lsp.logistics.web.action.supplier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lsp.logistics.entity.SupplierEntity;
import com.lsp.logistics.service.ifac.supplier.SupplierServiceIfac;
import com.opensymphony.xwork2.ActionSupport;

public class SupplierAction extends ActionSupport {
	private SupplierEntity supplier;
	private List<SupplierEntity> supplierList;
	private Map<String, Object> data;
	private String supplierName;
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public List<SupplierEntity> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<SupplierEntity> supplierList) {
		this.supplierList = supplierList;
	}

	public SupplierEntity getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}

	private SupplierServiceIfac supplierService;
	public void setSupplierService(SupplierServiceIfac supplierService) {
		this.supplierService = supplierService;
	}
	
	public String findAllSuplier(){
		supplierList = this.supplierService.findAllSupplier();
		return "findAll";
	}
	
	public String openAddPage(){
		return "openAddPage";
	}
	
	public String addSupplier(){
		data = new HashMap<String, Object>();
		if(this.supplierService.saveSupplier(supplier)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "supplierList");
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
	
	public String deleteSupplier(){
		data = new HashMap<String, Object>();
		if(this.supplierService.deleteSupplier(supplier.getId())){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "supplierList");
			data.put("rel", "");
			data.put("callbackType", "forward");
			data.put("forwardUrl", "supplierList.action");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "删除失败");
		}
		return "delete";
	}
	
	public String findSupplierById(){
		supplier = this.supplierService.findById(supplier.getId());
		return "findById";
	}
	
	public String updateSupplier(){
		data = new HashMap<String, Object>();
		if(this.supplierService.updateSupplier(supplier)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "supplierList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "删除失败");
		}
		return "update";
	}
	
	public String findSupplier(){
		supplierList = this.supplierService.findSupplier(supplierName);
		if(supplierList.size() > 0){
			return "findSupplier";
		}
		else{
			data = new HashMap<String, Object>();
			data.put("statusCode", "300");
			data.put("message", "请输入正确的查询条件");
			return "error";
		}
	}
	
	

}
