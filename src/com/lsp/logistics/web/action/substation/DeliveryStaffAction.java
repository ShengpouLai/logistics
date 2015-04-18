package com.lsp.logistics.web.action.substation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lsp.logistics.entity.DeliveryStaffEntity;
import com.lsp.logistics.entity.SubstationEntity;
import com.lsp.logistics.service.ifac.substation.DeliveryStaffServiceIfac;
import com.lsp.logistics.service.ifac.substation.SubstationServiceIfac;
import com.opensymphony.xwork2.ActionSupport;

public class DeliveryStaffAction extends ActionSupport{
	
	private List<DeliveryStaffEntity> deliveryStaffList;
	private List<SubstationEntity> substationList;
	private Map<String, Object> data;
	private DeliveryStaffEntity deliveryStaff;
	
	public DeliveryStaffEntity getDeliveryStaff() {
		return deliveryStaff;
	}
	public void setDeliveryStaff(DeliveryStaffEntity deliveryStaff) {
		this.deliveryStaff = deliveryStaff;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public List<SubstationEntity> getSubstationList() {
		return substationList;
	}
	public void setSubstationList(List<SubstationEntity> substationList) {
		this.substationList = substationList;
	}
	public List<DeliveryStaffEntity> getDeliveryStaffList() {
		return deliveryStaffList;
	}
	public void setDeliveryStaffList(List<DeliveryStaffEntity> deliveryStaffList) {
		this.deliveryStaffList = deliveryStaffList;
	}
	
	private DeliveryStaffServiceIfac deliveryStaffService;
	private SubstationServiceIfac substationService;

	public void setSubstationService(SubstationServiceIfac substationService) {
		this.substationService = substationService;
	}
	public void setDeliveryStaffService(
			DeliveryStaffServiceIfac deliveryStaffService) {
		this.deliveryStaffService = deliveryStaffService;
	}
	
	public String deliveStaffList(){
		substationList = this.substationService.findAllSubstation();
		deliveryStaffList = this.deliveryStaffService.findAll();
		return "deliveStaffList";
	}
	
	public String deliveryStaffAdd(){
		substationList = this.substationService.findAllSubstation();
		return "deliveryStaffAdd";
	}
	
	public String delivery_add(){
		data = new HashMap<String, Object>();
		if(this.deliveryStaffService.saveDeliveryStaff(deliveryStaff)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "deliveryStaffList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "添加失败!");
		}
		
		return "delivery_add";
	}
	
	public String deliveryStaff_findById(){
		deliveryStaff = this.deliveryStaffService.findById(deliveryStaff.getId());
		substationList = this.substationService.findAllSubstation();
		return "deliveryStaff_findById";
	}
	
	public String deliveryStaff_update(){
		data = new HashMap<String, Object>();
		if(this.deliveryStaffService.update(deliveryStaff)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "deliveryStaffList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "更新失败");
		}
		return "deliveryStaff_update";
	}
	
	public String deliveryStaff_delete(){
		data = new HashMap<String, Object>();
		if(this.deliveryStaffService.delect(deliveryStaff.getId())){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "deliveryStaffList");
			data.put("rel", "");
			data.put("callbackType", "forward");
			data.put("forwardUrl", "deliveryStaffList.action");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "更新失败");
		}
		return "deliveryStaff_delete";
	}
	
	public String deliveryStaff_find(){
		deliveryStaffList = this.deliveryStaffService.findDeliveryStaff(deliveryStaff.getDeliveryStaffName(), deliveryStaff.getSubstation_t().getId());
		return "deliveryStaff_find";
	}

}
