package com.lsp.logistics.web.action.substation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lsp.logistics.entity.DeliveryStaffEntity;
import com.lsp.logistics.entity.ReceiptEntity;
import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.entity.SubstationEntity;
import com.lsp.logistics.entity.TaskOrderEntity;
import com.lsp.logistics.service.ifac.storage.StorageServiceIfac;
import com.lsp.logistics.service.ifac.substation.DeliveryStaffServiceIfac;
import com.lsp.logistics.service.ifac.substation.ReceiptServiceIfac;
import com.lsp.logistics.service.ifac.substation.SubstationServiceIfac;
import com.lsp.logistics.service.ifac.substation.TaskOrderServiceIfac;
import com.opensymphony.xwork2.ActionSupport;

public class SubstationAction extends ActionSupport {
	
	private List<SubstationEntity> substationList;
	
	private List<StorageEntity> storageList;

	private Map<String, Object> data;
	
	private SubstationEntity sub;
	
	private List<TaskOrderEntity> taskOrderList;
	
	private List<DeliveryStaffEntity> deliveryStaffList;

	private Integer taskOrderId;
	
	private TaskOrderEntity taskOrder;
	
	private Integer deliveryStaffId;
	
	private ReceiptEntity receipt;
	
	private String taskId;
	
	private String taskState;
	
	private String costomerName;
	
	private String costomerPhone;
	
	private String subId;
	
	private String orderDeliverDate;

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskState() {
		return taskState;
	}

	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}

	public String getCostomerName() {
		return costomerName;
	}

	public void setCostomerName(String costomerName) {
		this.costomerName = costomerName;
	}

	public String getCostomerPhone() {
		return costomerPhone;
	}

	public void setCostomerPhone(String costomerPhone) {
		this.costomerPhone = costomerPhone;
	}

	public String getOrderDeliverDate() {
		return orderDeliverDate;
	}

	public void setOrderDeliverDate(String orderDeliverDate) {
		this.orderDeliverDate = orderDeliverDate;
	}

	public ReceiptEntity getReceipt() {
		return receipt;
	}

	public void setReceipt(ReceiptEntity receipt) {
		this.receipt = receipt;
	}

	public Integer getTaskOrderId() {
		return taskOrderId;
	}

	public void setTaskOrderId(Integer taskOrderId) {
		this.taskOrderId = taskOrderId;
	}

	public Integer getDeliveryStaffId() {
		return deliveryStaffId;
	}

	public void setDeliveryStaffId(Integer deliveryStaffId) {
		this.deliveryStaffId = deliveryStaffId;
	}
	
	public TaskOrderEntity getTaskOrder() {
		return taskOrder;
	}

	public void setTaskOrder(TaskOrderEntity taskOrder) {
		this.taskOrder = taskOrder;
	}

	public List<DeliveryStaffEntity> getDeliveryStaffList() {
		return deliveryStaffList;
	}

	public void setDeliveryStaffList(List<DeliveryStaffEntity> deliveryStaffList) {
		this.deliveryStaffList = deliveryStaffList;
	}

	public List<TaskOrderEntity> getTaskOrderList() {
		return taskOrderList;
	}

	public void setTaskOrderList(List<TaskOrderEntity> taskOrderList) {
		this.taskOrderList = taskOrderList;
	}

	public SubstationEntity getSub() {
		return sub;
	}

	public void setSub(SubstationEntity sub) {
		this.sub = sub;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public List<StorageEntity> getStorageList() {
		return storageList;
	}

	public void setStorageList(List<StorageEntity> storageList) {
		this.storageList = storageList;
	}

	public List<SubstationEntity> getSubstationList() {
		return substationList;
	}

	public void setSubstationList(List<SubstationEntity> substationList) {
		this.substationList = substationList;
	}

	private SubstationServiceIfac substationService;
	private StorageServiceIfac storageService;
	private TaskOrderServiceIfac taskOrderService;
	private DeliveryStaffServiceIfac deliveryStaffService;
	private ReceiptServiceIfac receiptService;
	
	public void setReceiptService(ReceiptServiceIfac receiptService) {
		this.receiptService = receiptService;
	}

	public void setDeliveryStaffService(
			DeliveryStaffServiceIfac deliveryStaffService) {
		this.deliveryStaffService = deliveryStaffService;
	}

	public void setTaskOrderService(TaskOrderServiceIfac taskOrderService) {
		this.taskOrderService = taskOrderService;
	}

	public void setStorageService(StorageServiceIfac storageService) {
		this.storageService = storageService;
	}

	public void setSubstationService(SubstationServiceIfac substationService) {
		this.substationService = substationService;
	}

	/*
	 * 查询所有分站
	 */
	public String findAllSubstation(){
		try{
			substationList = this.substationService.findAllSubstation();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "findAllSubstation";
	}
	
	/*
	 * 跳转新增分站页面
	 */
	public String openAddSubstationPage(){
		storageList = this.storageService.findAllStorage();
		return "openAddSubstationPage";
	}
	
	/*
	 * 新增分站
	 */
	public String addSubstation(){
		try{
			data = new HashMap<String, Object>();
			if(this.substationService.saveSubstation(sub)){
				data.put("statusCode",200);
				data.put("message", "操作成功");
				data.put("navTabId", "substationList");
				data.put("rel", "");
				data.put("callbackType", "closeCurrent");
				data.put("forwardUrl", "");
			}
			else{
				data.put("statusCode", "300");
				data.put("message", "添加失败!");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "addSubstation";
	}
	
	/*
	 * 删除分站
	 */
	public String deleteSubstation(){
		data = new HashMap<String, Object>();
		if(this.substationService.deleteSubstation(sub.getId())){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "substationList");
			data.put("rel", "");
			data.put("callbackType", "forward");
			data.put("forwardUrl", "substationList.action");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "删除失败!");
		}
		return "deleteSubstation";
	}
	
	/*
	 * 通过Id查询分站
	 */
	public String findSubstationById(){
		sub = this.substationService.findSubstationById(sub.getId());
		storageList = this.storageService.findAllStorage();
		return "findSubstationById";
	}
	
	/*
	 * 修改分站信息
	 */
	public String updateSubstation(){
		data = new HashMap<String, Object>();
		if(this.substationService.updateSubstation(sub)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "substationList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "更新失败");
		}
		return "updateSubstation";
	}
	
	/*
	 * 查询分站
	 */
	public String findSubstation(){
		substationList = this.substationService.findSubstation(sub.getSubstationName());
		if(substationList.size() != 0){
			return "findSubstation";
		}
		else{
			data = new HashMap<String, Object>();
			data.put("statusCode", "300");
			data.put("message", "请输入查询条件。");
			return "errorFind";
		}
	}
	
	/*
	 * 查询出等待分配的任务单
	 */
	public String taskAllocationList(){
		taskOrderList = this.taskOrderService.findToAllocation();
		return "taskAllocationList";
	}
	
	/*
	 * 跳转任务单分配页面
	 */
	public String openTaskAllocation(){
		TaskOrderEntity taskOrder1 = this.taskOrderService.findById(taskOrderId);
		deliveryStaffList = this.deliveryStaffService.findBySubstation(taskOrder1.getSubstation().getId());
		
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		session.setAttribute("taskOrderId", taskOrder1.getId());
		return "openTaskAllocation";
	}
	
	/*
	 * 任务分配时通过分站名称查询任务单
	 */
	public String task_find(){
		taskOrderList = this.taskOrderService.findTask(sub.getSubstationName());
		return "task_find";
	}
	
	/*
	 * 任务分配
	 */
	public String taskAllocation(){
		data = new HashMap<String, Object>();
		if(this.taskOrderService.taskAllocation(deliveryStaffId)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "taskAllocationList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "操作失败。");
		}
		return "taskAllocation";
	}
	
	/*
	 * 跳转回执录入列表
	 */
	public String receiptEnterList(){
		taskOrderList = this.taskOrderService.findReceiptEnter();
		return "receiptEnterList";
	}
	
	/*
	 * 跳转回执录入页面
	 */
	public String receiptEnter(){
		taskOrder = this.taskOrderService.findById(taskOrderId);
		return "receiptEnter";
	}
	
	/*
	 * 回执录入
	 */
	public String receipt_enter(){
		data = new HashMap<String, Object>();
		if(this.receiptService.saveReceipt(receipt, taskOrderId)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "receiptEnterList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "操作失败。");
		}
		return "receipt_enter";
	}
	
	/*
	 * 跳转任务单列表
	 */
	public String taskOrderList(){
		taskOrderList = this.taskOrderService.findAllTaskOrder();
		substationList = this.substationService.findAllSubstation();
		return "taskOrderList";
	}
	
	/*
	 * 条件查询任务单
	 */
	public String taskOrder_find(){
		taskOrderList = this.taskOrderService.findTaskOrder(taskId, taskState, subId, costomerName, costomerPhone, orderDeliverDate);
		return "taskOrder_find";
	}
	
	/*
	 * 回执录入时的条件查询任务单
	 */
	public String receipt_task_find(){
		taskOrderList = this.taskOrderService.receipt_task_find(taskOrder.getTaskOrderId(), taskOrder.getDeliveryStaff().getDeliveryStaffName());
		return "receipt_task_find";
	}
	
}
