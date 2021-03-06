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
			<li><a class="add" href="openCSPutIn.action?buyGoodsOrder.id={buyGoodsOrder_id}" target="dialog" width="800" height="370"><span>中心库房入库</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="88">
		<thead>
			<tr>
				<th width="120">购货入库单号</th>
				<th width="250">供应商</th>
				<th width="150">商品名称</th>
				<th width="150">型号</th>
				<th width="150">计量单位</th>
				<th width="80">进货量</th>
				<th width="80">日期</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${buyGoodsOrderList}" var="buyGoodsOrder" varStatus="status">
				<tr target="buyGoodsOrder_id" rel="${buyGoodsOrder.id}">
					<td>${buyGoodsOrder.buyGoodsOrderId}</td>
					<td>${buyGoodsOrder.goods.supplier.supplierName}</td>
					<td>${buyGoodsOrder.goods.goodsName}</td>
					<td>${buyGoodsOrder.goods.goodsModelId}</td>
					<td>${buyGoodsOrder.goods.goodsUnit}</td>
					<td>${buyGoodsOrder.buyGoodsNumber}</td>
					<td>${buyGoodsOrder.buyGoodsDate}</td>
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
