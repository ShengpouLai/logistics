package com.lsp.logistics.entity;

import java.util.Date;

/**
 * 订单实体
 * @author pou
 *
 */
public class OrderEntity {
	
	/** 下单客户 */
	private CostomerEntity costomer;
	private Integer id;
	
	/** 订单号 */
	private String orderId;
	
	/** 订单总金额 */
	private Double orderMoney;
	
	/** 订单备注 */
	private String orderRemark;
	
	/** 下单日期 */
	private Date orderDate;
	
	/** 要求送达日期 */
	private Date orderDeliverDate;
	
	/** 订单类型 
	 *  0，表示新建订单
	 *  1，表示退订订单
	 *  2，表示换货订单
	 * */
	private String orderType;
	
	/** 收货人姓名 */
	private String orderConsigneeName;
	
	/** 收货人地址 */
	private String orderConsigneeAddress;
	
	/** 收货人手机 */
	private String orderConsigneePhone;
	
	/** 收货人邮编 */
	private String orderConsigneePostcode;
	
	/** 是否需要发票 */
	private String orderNeedInvoce;
	
	/** 付款人姓名 */
	private String orderPayerName;
	
	/** 付款人地址 */
	private String orderPayerAddress;
	
	/** 付款人手机 */
	private String orderPayerPhone;
	
	/** 付款人邮编 */
	private String orderPayerPostcode;
	
	/** 订单状态 
	 * 
	 * 已完成
	 * 订单已确认，等待调度。
	 * 订单已调度，等待中心库房出库。
	 * 订单已从中心库房出库，运输公司配送中。
	 * 订单已到达分站库房，等待分配。
	 * 订单已分配，等待配送员配送。
	 * 配送员已领货，请耐心等待配送。
	 * 配送完成。
	 * 
	 * */
	private String orderState;
	public Double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderDeliverDate() {
		return orderDeliverDate;
	}
	public void setOrderDeliverDate(Date orderDeliverDate) {
		this.orderDeliverDate = orderDeliverDate;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderConsigneeName() {
		return orderConsigneeName;
	}
	public void setOrderConsigneeName(String orderConsigneeName) {
		this.orderConsigneeName = orderConsigneeName;
	}
	public String getOrderConsigneeAddress() {
		return orderConsigneeAddress;
	}
	public void setOrderConsigneeAddress(String orderConsigneeAddress) {
		this.orderConsigneeAddress = orderConsigneeAddress;
	}
	public String getOrderConsigneePhone() {
		return orderConsigneePhone;
	}
	public void setOrderConsigneePhone(String orderConsigneePhone) {
		this.orderConsigneePhone = orderConsigneePhone;
	}
	public String getOrderConsigneePostcode() {
		return orderConsigneePostcode;
	}
	public void setOrderConsigneePostcode(String orderConsigneePostcode) {
		this.orderConsigneePostcode = orderConsigneePostcode;
	}
	public String getOrderNeedInvoce() {
		return orderNeedInvoce;
	}
	public void setOrderNeedInvoce(String orderNeedInvoce) {
		this.orderNeedInvoce = orderNeedInvoce;
	}
	public String getOrderPayerName() {
		return orderPayerName;
	}
	public void setOrderPayerName(String orderPayerName) {
		this.orderPayerName = orderPayerName;
	}
	public String getOrderPayerAddress() {
		return orderPayerAddress;
	}
	public void setOrderPayerAddress(String orderPayerAddress) {
		this.orderPayerAddress = orderPayerAddress;
	}
	public String getOrderPayerPhone() {
		return orderPayerPhone;
	}
	public void setOrderPayerPhone(String orderPayerPhone) {
		this.orderPayerPhone = orderPayerPhone;
	}
	public String getOrderPayerPostcode() {
		return orderPayerPostcode;
	}
	public void setOrderPayerPostcode(String orderPayerPostcode) {
		this.orderPayerPostcode = orderPayerPostcode;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public CostomerEntity getCostomer() {
		return costomer;
	}
	public void setCostomer(CostomerEntity costomer) {
		this.costomer = costomer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
