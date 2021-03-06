<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<form id="pagerForm" method="post" action="demo_page1.html">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
	<form id="pageForm" onsubmit="return navTabSearch(this);" action="costomer_findCostomer.action" method="post">
	
	<div class="searchBar">
		
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="transferGoods.action?goodsTransferOrderId={goodsTransferOrder_id}" target="ajaxTodo" width="800" height="370"><span>中心库房出库</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="88">
		<thead>
			<tr>
				<th width="120">商品调拨单号</th>
				<th>订单号</th>
				<th width="80">日期</th>
				<th>商品详细</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${goodsTransferOrderList}" var="goodsTransferOrder" varStatus="status">
				<tr target="goodsTransferOrder_id" rel="${goodsTransferOrder.id}">
					<td>${goodsTransferOrder.goodsTransferOrderId}</td>
					<td>${goodsTransferOrder.t_order.orderId}</td>
					<td>${goodsTransferOrder.goodsTransferDate}</td>
					<td><a href="findOrderDetailByOrder.action?id=${goodsTransferOrder.t_order.id}" target="dialog" width="800" height="370">商品详细</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>

	</div>
</div>
