<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	<form id="pageForm" onsubmit="return navTabSearch(this);" action="substation_find.action" method="post">
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					分站名称：<input type="text" name="sub.substationName" size="30" />
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
			<li><a class="edit" href="openTaskAllocation.action?taskOrderId={taskOrder_id}" target="dialog" width="680" height="380"><span>任务分配</span></a></li>
		</ul>
	</div>
	<div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120">任务单号</th>
				<th>任务类型</th>
				<th>任务状态</th>
				<th>配送分站</th>
				<th>要求完成日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${taskOrderList}" var="taskOrder" varStatus="status">
				<tr target="taskOrder_id" rel="${taskOrder.id}">
					<td>${taskOrder.taskOrderId}</td>
					<td>${taskOrder.taskOrderType}</td>
					<td>${taskOrder.taskOrderState}</td>
					<td>${taskOrder.substation.substationName}</td>
					<td>${taskOrder.order.orderDeliverDate}</td>
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

