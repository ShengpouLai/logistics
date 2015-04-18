package com.lsp.logistics.web.action.storage.invoicing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lsp.logistics.entity.BuyGoodsOrder;
import com.lsp.logistics.entity.CentralStorageOutOfOrder;
import com.lsp.logistics.entity.CentralStoragePutInOrder;
import com.lsp.logistics.entity.CheckGoodsOrder;
import com.lsp.logistics.entity.DeliveryOrder;
import com.lsp.logistics.entity.GoodsTransferOrderEntity;
import com.lsp.logistics.entity.OrderDetailEntity;
import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.entity.SubstationStorageOutOfOrder;
import com.lsp.logistics.entity.SubstationStoragePutInOrder;
import com.lsp.logistics.entity.TaskOrderEntity;
import com.lsp.logistics.service.ifac.order.OrderDetailServiceIfac;
import com.lsp.logistics.service.ifac.storage.GoodsNumberServiceIfac;
import com.lsp.logistics.service.ifac.storage.StorageServiceIfac;
import com.lsp.logistics.service.ifac.storage.invoicing.CentralStorageOutOfOrderServiceIfac;
import com.lsp.logistics.service.ifac.storage.invoicing.CentralStoragePutInOrderServiceIfac;
import com.lsp.logistics.service.ifac.storage.invoicing.CheckGoodsOrderServiceIfac;
import com.lsp.logistics.service.ifac.storage.invoicing.DisreibutionOrderServiceIfac;
import com.lsp.logistics.service.ifac.storage.invoicing.SubstationStorageOutOfServiceIfac;
import com.lsp.logistics.service.ifac.storage.invoicing.SubstationStoragePutInOrderServiceIfac;
import com.lsp.logistics.service.ifac.substation.DeliveryOrderServiceIfac;
import com.lsp.logistics.service.ifac.substation.GoodsTransferOrderServiceIfac;
import com.lsp.logistics.service.ifac.substation.TaskOrderServiceIfac;
import com.lsp.logistics.service.ifac.supplier.BuyGoodsOrderServiceIfac;
import com.opensymphony.xwork2.ActionSupport;

public class StorageInvoicingManagerAction extends ActionSupport {
	
	private List<BuyGoodsOrder> buyGoodsOrderList;
	private String buyGoodsOrderId;
	private BuyGoodsOrder buyGoodsOrder;
	private CentralStoragePutInOrder centralStoragePutInOrder;
	private Map<String, Object> data;
	private Integer goodsId;
	private List<GoodsTransferOrderEntity> goodsTransferOrderList;
	private Integer goodsTransferOrderId;
	private List<CheckGoodsOrder> substationCheckGoodsOrderList;
	private Integer substationCheckGoodsOrderId;
	private List<OrderDetailEntity> orderDetailList;
	private Integer orderDetailId;
	private List<TaskOrderEntity> taskOrderList;
	private Integer taskOrderId;
	private TaskOrderEntity taskOrder;
	private DeliveryOrder deliveryOrder;
	private List<StorageEntity> storageList;
	private String invoicingType;
	private String storageId;
	private String invoicingBeginDate;
	private String invoicingEndDate;
	private List<CentralStoragePutInOrder> centralStoragePutInList;
	private List<CentralStorageOutOfOrder> centralStorageOutOfList;
	private List<SubstationStoragePutInOrder> substationStoragePutInList;
	private List<SubstationStorageOutOfOrder> substationStorageOutOfList;
	private Integer id;
	private CentralStorageOutOfOrder centralStorageOutOfOrder;

	public CentralStorageOutOfOrder getCentralStorageOutOfOrder() {
		return centralStorageOutOfOrder;
	}

	public void setCentralStorageOutOfOrder(
			CentralStorageOutOfOrder centralStorageOutOfOrder) {
		this.centralStorageOutOfOrder = centralStorageOutOfOrder;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CentralStoragePutInOrder> getCentralStoragePutInList() {
		return centralStoragePutInList;
	}

	public void setCentralStoragePutInList(
			List<CentralStoragePutInOrder> centralStoragePutInList) {
		this.centralStoragePutInList = centralStoragePutInList;
	}

	public List<CentralStorageOutOfOrder> getCentralStorageOutOfList() {
		return centralStorageOutOfList;
	}

	public void setCentralStorageOutOfList(
			List<CentralStorageOutOfOrder> centralStorageOutOfList) {
		this.centralStorageOutOfList = centralStorageOutOfList;
	}

	public List<SubstationStoragePutInOrder> getSubstationStoragePutInList() {
		return substationStoragePutInList;
	}

	public void setSubstationStoragePutInList(
			List<SubstationStoragePutInOrder> substationStoragePutInList) {
		this.substationStoragePutInList = substationStoragePutInList;
	}

	public List<SubstationStorageOutOfOrder> getSubstationStorageOutOfList() {
		return substationStorageOutOfList;
	}

	public void setSubstationStorageOutOfList(
			List<SubstationStorageOutOfOrder> substationStorageOutOfList) {
		this.substationStorageOutOfList = substationStorageOutOfList;
	}

	public String getInvoicingType() {
		return invoicingType;
	}

	public void setInvoicingType(String invoicingType) {
		this.invoicingType = invoicingType;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getInvoicingBeginDate() {
		return invoicingBeginDate;
	}

	public void setInvoicingBeginDate(String invoicingBeginDate) {
		this.invoicingBeginDate = invoicingBeginDate;
	}

	public String getInvoicingEndDate() {
		return invoicingEndDate;
	}

	public void setInvoicingEndDate(String invoicingEndDate) {
		this.invoicingEndDate = invoicingEndDate;
	}

	public List<StorageEntity> getStorageList() {
		return storageList;
	}

	public void setStorageList(List<StorageEntity> storageList) {
		this.storageList = storageList;
	}

	public DeliveryOrder getDeliveryOrder() {
		return deliveryOrder;
	}

	public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
		this.deliveryOrder = deliveryOrder;
	}

	public TaskOrderEntity getTaskOrder() {
		return taskOrder;
	}

	public void setTaskOrder(TaskOrderEntity taskOrder) {
		this.taskOrder = taskOrder;
	}

	public Integer getTaskOrderId() {
		return taskOrderId;
	}

	public void setTaskOrderId(Integer taskOrderId) {
		this.taskOrderId = taskOrderId;
	}

	public List<TaskOrderEntity> getTaskOrderList() {
		return taskOrderList;
	}

	public void setTaskOrderList(List<TaskOrderEntity> taskOrderList) {
		this.taskOrderList = taskOrderList;
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public List<OrderDetailEntity> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetailEntity> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public Integer getSubstationCheckGoodsOrderId() {
		return substationCheckGoodsOrderId;
	}

	public void setSubstationCheckGoodsOrderId(Integer substationCheckGoodsOrderId) {
		this.substationCheckGoodsOrderId = substationCheckGoodsOrderId;
	}

	public List<CheckGoodsOrder> getSubstationCheckGoodsOrderList() {
		return substationCheckGoodsOrderList;
	}

	public void setSubstationCheckGoodsOrderList(
			List<CheckGoodsOrder> substationCheckGoodsOrderList) {
		this.substationCheckGoodsOrderList = substationCheckGoodsOrderList;
	}

	public Integer getGoodsTransferOrderId() {
		return goodsTransferOrderId;
	}

	public void setGoodsTransferOrderId(Integer goodsTransferOrderId) {
		this.goodsTransferOrderId = goodsTransferOrderId;
	}

	public List<GoodsTransferOrderEntity> getGoodsTransferOrderList() {
		return goodsTransferOrderList;
	}

	public void setGoodsTransferOrderList(
			List<GoodsTransferOrderEntity> goodsTransferOrderList) {
		this.goodsTransferOrderList = goodsTransferOrderList;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public CentralStoragePutInOrder getCentralStoragePutInOrder() {
		return centralStoragePutInOrder;
	}

	public void setCentralStoragePutInOrder(
			CentralStoragePutInOrder centralStoragePutInOrder) {
		this.centralStoragePutInOrder = centralStoragePutInOrder;
	}

	public BuyGoodsOrder getBuyGoodsOrder() {
		return buyGoodsOrder;
	}

	public void setBuyGoodsOrder(BuyGoodsOrder buyGoodsOrder) {
		this.buyGoodsOrder = buyGoodsOrder;
	}

	public String getBuyGoodsOrderId() {
		return buyGoodsOrderId;
	}

	public void setBuyGoodsOrderId(String buyGoodsOrderId) {
		this.buyGoodsOrderId = buyGoodsOrderId;
	}

	public List<BuyGoodsOrder> getBuyGoodsOrderList() {
		return buyGoodsOrderList;
	}

	public void setBuyGoodsOrderList(List<BuyGoodsOrder> buyGoodsOrderList) {
		this.buyGoodsOrderList = buyGoodsOrderList;
	}

	private BuyGoodsOrderServiceIfac buyGoodsOrderService;
	private CentralStoragePutInOrderServiceIfac centralStoragePutInOrderService;
	private GoodsNumberServiceIfac goodsNumberService;
	private GoodsTransferOrderServiceIfac gtOrderService;
	private DisreibutionOrderServiceIfac disreibutionOrderService;
	private CheckGoodsOrderServiceIfac checkGoodsOrderService;
	private SubstationStoragePutInOrderServiceIfac substationStoragePutInOrderService;
	private TaskOrderServiceIfac taskOrderService;
	private DeliveryOrderServiceIfac deliceryOrderService;
	private SubstationStorageOutOfServiceIfac substationStorageOutOfService;
	private StorageServiceIfac storageService;
	private CentralStorageOutOfOrderServiceIfac centralStorageOutOfOrderService;
	private OrderDetailServiceIfac orderDetailService;

	public void setOrderDetailService(OrderDetailServiceIfac orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	public void setCentralStorageOutOfOrderService(
			CentralStorageOutOfOrderServiceIfac centralStorageOutOfOrderService) {
		this.centralStorageOutOfOrderService = centralStorageOutOfOrderService;
	}

	public void setStorageService(StorageServiceIfac storageService) {
		this.storageService = storageService;
	}

	public void setSubstationStorageOutOfService(
			SubstationStorageOutOfServiceIfac substationStorageOutOfService) {
		this.substationStorageOutOfService = substationStorageOutOfService;
	}

	public void setDeliceryOrderService(
			DeliveryOrderServiceIfac deliceryOrderService) {
		this.deliceryOrderService = deliceryOrderService;
	}

	public void setTaskOrderService(TaskOrderServiceIfac taskOrderService) {
		this.taskOrderService = taskOrderService;
	}

	public void setSubstationStoragePutInOrderService(
			SubstationStoragePutInOrderServiceIfac substationStoragePutInOrderService) {
		this.substationStoragePutInOrderService = substationStoragePutInOrderService;
	}

	public void setCheckGoodsOrderService(
			CheckGoodsOrderServiceIfac checkGoodsOrderService) {
		this.checkGoodsOrderService = checkGoodsOrderService;
	}

	public void setDisreibutionOrderService(
			DisreibutionOrderServiceIfac disreibutionOrderService) {
		this.disreibutionOrderService = disreibutionOrderService;
	}

	public void setGtOrderService(GoodsTransferOrderServiceIfac gtOrderService) {
		this.gtOrderService = gtOrderService;
	}

	public void setGoodsNumberService(GoodsNumberServiceIfac goodsNumberService) {
		this.goodsNumberService = goodsNumberService;
	}

	public void setCentralStoragePutInOrderService(
			CentralStoragePutInOrderServiceIfac centralStoragePutInOrderService) {
		this.centralStoragePutInOrderService = centralStoragePutInOrderService;
	}

	public void setBuyGoodsOrderService(
			BuyGoodsOrderServiceIfac buyGoodsOrderService) {
		this.buyGoodsOrderService = buyGoodsOrderService;
	}

	public String centralSBGList(){
		buyGoodsOrderList = this.buyGoodsOrderService.findNoPutIn();
		return "centralSBGList";
	}
	
	public String openCSPutIn(){
		buyGoodsOrder = this.buyGoodsOrderService.findById(buyGoodsOrder.getId());
		return "openCSPutIn";
	}
	
	public String centralStoragePutIn(){
		//修改购货单状态，表示已经入库
		this.buyGoodsOrderService.updateBuyGoodsOrderState(centralStoragePutInOrder.getBuyGoodsOrder().getId());

		//修改库存量，加上入库数量
		this.goodsNumberService.updateGoodsNumber(goodsId, centralStoragePutInOrder.getActualPutInNumber());

		//生成入库单
		data = new HashMap<String, Object>();
		if(this.centralStoragePutInOrderService.save(centralStoragePutInOrder)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "centralSBGList");
			data.put("rel", "");
			data.put("callbackType", "closeCurrent");
			data.put("forwardUrl", "");
		}
		else{
			data.put("statusCode", "300");
			data.put("message", "入库失败");
		}
		return "centralStoragePutIn";
	}
	
	public String transferOrderList(){
		try{
			goodsTransferOrderList = this.gtOrderService.findTransferOrderList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "transferOrderList";
	}
	
	public String transferGoods(){
		//生成分发单
		data = new HashMap<String, Object>();
		if(disreibutionOrderService.save(goodsTransferOrderId)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "transferOrderList");
			data.put("rel", "");
			data.put("callbackType", "forward");
			data.put("forwardUrl", "transferOrderList.action");
		}
		else{
			data.put("statusCode",300);
			data.put("message", "操作失败");
		}
		
		//生成出库单
		
		//更改商品调拨单状态，1--0
//		this.gtOrderService.upateState(goodsTransferOrderId);
		
		//更改订单状态
		
		return "transferGoods";
	}
	
	public String substationStoragePutInList(){
		substationCheckGoodsOrderList = this.checkGoodsOrderService.findNotPutIn();
		return "substationStoragePutInList";
	}
	
	public String substationStoragePutIn(){
		data = new HashMap<String, Object>();
		if(this.substationStoragePutInOrderService.save(substationCheckGoodsOrderId)){
			data.put("statusCode",200);
			data.put("message", "操作成功");
			data.put("navTabId", "substationStoragePutInList");
			data.put("rel", "");
			data.put("callbackType", "forward");
			data.put("forwardUrl", "substationStoragePutInList.action");
		}
		else{
			data.put("statusCode",300);
			data.put("message", "操作失败");
		}
		
		return "substationStoragePutIn";
	}
	
	public String substationStorageOutOfList(){
		taskOrderList = this.taskOrderService.findToOutOf();
		return "substationStorageOutOfList";
	}
	
	public String substationStorageOutOf(){
		data = new HashMap<String, Object>();
		try {
			if(this.substationStorageOutOfService.save(taskOrderId)){
				data.put("statusCode",200);
				data.put("message", "操作成功");
				data.put("navTabId", "substationStorageOutOfList");
				data.put("rel", "");
				data.put("callbackType", "forward");
				data.put("forwardUrl", "substationStorageOutOfList.action");
			}
			else{
				data.put("statusCode",300);
				data.put("message", "操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "substationStorageOutOf";
	}
	
	public String storageInvoicingList(){
		storageList = this.storageService.findAllStorage();
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("storageService", storageService);
		return "storageInvoicingList";
	}
	
	public String invoicing_find(){
		StorageEntity storage = this.storageService.findById(Integer.parseInt(storageId));
		//中心库房入库单
		if(invoicingType.equals("2") && storage.getStorageLevel().equals("1")) {
			centralStoragePutInList = this.centralStoragePutInOrderService.find(invoicingEndDate,invoicingBeginDate);
		}
		//中心库房出库单
		if((invoicingType.equals("1")) && storage.getStorageLevel().equals("1")) {
			centralStorageOutOfList = this.centralStorageOutOfOrderService.find(invoicingEndDate,invoicingBeginDate);
		}
		//分站库房入库单
		if(invoicingType.equals("2") && storage.getStorageLevel().equals("0")) {
			substationStoragePutInList = this.substationStoragePutInOrderService.find(storage.getId(), invoicingEndDate,invoicingBeginDate);
		}
		//分站库房出库单
		if(invoicingType.equals("1") && storage.getStorageLevel().equals("0")) {
			substationStorageOutOfList = this.substationStorageOutOfService.find(storage.getId(), invoicingEndDate,invoicingBeginDate);
		}
		return "invoicing_find";
	}
	
	public String centralStoragePutInDetail(){
		centralStoragePutInOrder = this.centralStoragePutInOrderService.findById(id);
		return "centralStoragePutInDetail";
	}
	
	public String centralStorageOutOfDetail(){
		centralStorageOutOfOrder = this.centralStorageOutOfOrderService.findById(id);
		orderDetailList = this.orderDetailService.findByOrder(centralStorageOutOfOrder.getGoodsTransferOrder().getT_order().getId());
		return "centralStorageOutOfDetail";
	}
	
}
