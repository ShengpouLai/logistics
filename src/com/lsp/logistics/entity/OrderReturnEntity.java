package com.lsp.logistics.entity;

import java.util.Date;

public class OrderReturnEntity {
private Integer id;
/** 退订原因 */
private String orderReturnReason;

/** 退订日期 */
private Date orderReturnDate;

/** 退订订单 */
private OrderEntity order;
public String getOrderReturnReason() {
	return orderReturnReason;
}

public void setOrderReturnReason(String orderReturnReason) {
	this.orderReturnReason = orderReturnReason;
}

public Date getOrderReturnDate() {
	return orderReturnDate;
}

public void setOrderReturnDate(Date orderReturnDate) {
	this.orderReturnDate = orderReturnDate;
}

public OrderEntity getOrder() {
	return order;
}

public void setOrder(OrderEntity order) {
	this.order = order;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
}
