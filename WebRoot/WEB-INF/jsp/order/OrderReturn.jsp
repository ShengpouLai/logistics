<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="pageContent">
	<form method="post" action="order_return.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap">
			<dl>
				<dt>订单编号：</dt>
				<dd>
					<input name="orderReturn.order.orderId" value="${order.orderId}"
						readonly="readonly" type="text" size="30" />
				</dd>
			</dl>
			<dl>
				<dt>客户姓名：</dt>
				<dd>
					<input value="${order.costomer.costomerName}" readonly="readonly"
						type="text" size="30" />
				</dd>
			</dl>
			<dl>
				<dt>下单日期：</dt>
				<dd>
					<input value="${order.orderDate}" readonly="readonly" type="text"
						size="30" />
				</dd>
			</dl>
			<dl>
				<dt>退订原因：</dt>
				<dd>
					<input name="orderReturn.orderReturnReason" class="required"
						type="text" size="30" />
				</dd>
			</dl>
			<%
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");

				java.util.Date currentTime = new java.util.Date();//得到当前系统时间

				String str_date1 = formatter.format(currentTime); //将日期时间格局化
				String str_date2 = currentTime.toString(); //将Date型日期时间转换成字符串形式
			%>
			<input value="<%=str_date1%>" name="orderReturn.orderReturnDate" style="visibility: hidden;"/>
			<input value="${order.id}" name="orderReturn.order.id" style="visibility: hidden;"/>
		</div>
		<div class="panel collapse" defH="100">
			<h1>商品列表</h1>
			<div class="pageContent">
				<table class="table" width="100%">
					<thead>
						<tr>
							<td>商品名称</td>
							<td>商品数量</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderDetailList}" var="orderDetail"
							varStatus="status">
							<tr>
								<td>${orderDetail.goods.goodsName}</td>
								<td>${orderDetail.goodsNumber}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>