<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	<form id="pageForm" onsubmit="return navTabSearch(this);" action="taskOrder_find.action" method="post">
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					任务单号：<input type="text" name="taskId"  />
				</td>
				<!-- <td>
					任务类型：<select name="taskType" style="width: 15">
							 	<option value="">全部</option>
							 	<option value="0">新订</option>
							 	<option value="4">退订</option>
							 </select>
				</td> -->
				<td>
					任务状态：<select name="taskState">
								<option value="">请选择</option>
								<option value="配送完成。">配送完成</option>
								<option value="订单已调度，等待中心库房出库。">订单已调度，等待中心库房出库。</option>	
								<option value="订单已从中心库房出库，运输公司配送中。">订单已从中心库房出库，运输公司配送中。</option>
								<option value="订单已到达分站库房，等待分配。">订单已到达分站库房，等待分配。</option>
								<option value="订单已分配，等待配送员配送。">订单已分配，等待配送员配送。</option>
								<option value="配送员已领货，请耐心等待配送。">配送员已领货，请耐心等待配送。</option>
							 </select>
				</td>
				<td>
					执行任务分站：<select name="subId">
									<option value="">请选择</option>
									<c:forEach items="${substationList}" var="substation" varStatus="status">
										<option value="${substation.id}">${substation.substationName}</option>
									</c:forEach>
								 </select>
				</td>
			</tr>
			<tr>
				<td>
					客户姓名：<input type="text" name="costomerName"  />
				</td>
				<td>
					联系电话：<input type="text" name="costomerPhone"/>
				</td>
				
			
				<td>
				要求完成日期：<input type="text" name="orderDeliverDate" class="date" readonly="true"/>
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
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>任务单号</th>
				<th>任务状态</th>
				<th>要求完成日期</th>
				<th>执行任务分站</th>
				<th>客户姓名</th>
				<th>联系电话</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${taskOrderList}" var="taskOrder" varStatus="status">
				<tr>
					<td>${taskOrder.taskOrderId}</td>
					<td>${taskOrder.taskOrderState}</td>
					<td><fmt:formatDate value="${taskOrder.order.orderDeliverDate}" type="date"/></td>
					<td>${taskOrder.substation.substationName}</td>
					<td>${taskOrder.order.costomer.costomerName}</td>
					<td>${taskOrder.order.costomer.mobailPhone}</td>
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


