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
		<table class="searchContent">
			<tr>
				<td>
					任务单号：<input type="text" name="costomerName" size="30" />
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="substationStorageOutOf.action?taskOrderId={taskOrder_id}" target="ajaxTodo"><span>配送员领货出库</span></a></li>
			<li><a class="edit" href="openOrderDetail.action?substationCheckGoodsOrderId={substationCheckGoodsOrder_id}" target="dialog"><span>入库单修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="300">任务单号</th>
				<th width="250">配送员姓名</th>
				<th>核对详情</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${taskOrderList}" var="taskOrder" varStatus="status">
				<tr target="taskOrder_id" rel="${taskOrder.id}">
					<td>${taskOrder.taskOrderId}</td>
					<td>${taskOrder.deliveryStaff.deliveryStaffName}</td>
					<td><a href="findOrderDetailByOrder.action?id=${taskOrder.order.id}" target="dialog" width="800" height="370">核对详情</a></td>
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
