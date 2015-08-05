<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<form id="pageForm" onsubmit="return navTabSearch(this);" action="receipt_task_find.action" method="post">
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					任务单号：<input type="text" name="taskOrder.taskOrderId" size="30" />
				</td>
				<td>
					配送员姓名：<input type="text" name="taskOrder.deliveryStaff.deliveryStaffName" size="30"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="receiptEnter.action?taskOrderId={taskOrder_id}" target="dialog" width="614" height="323"><span>回执录入</span></a></li>
			<li><a class="delete" href="firstGoods_delete.action?firstGoods.id={firstGoods_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="firstGoods_findById.action?firstGoods.id={firstGoods_id}" target="dialog" width="614" height="220"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>任务单</th>
				<th>订单号</th>
				<th>配送员姓名</th>
				<th>要求完成日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${taskOrderList}" var="taskOrder" varStatus="status">
				<tr target="taskOrder_id" rel="${taskOrder.id}">
					<td>${taskOrder.taskOrderId}</td>
					<td>${taskOrder.order.orderId}</td>
					<td>${taskOrder.deliveryStaff.deliveryStaffName}</td>
					<td><fmt:formatDate value="${taskOrder.order.orderDeliverDate}" type="date"/></td>
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
