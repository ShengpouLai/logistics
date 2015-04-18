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
	<form id="pageForm" onsubmit="return navTabSearch(this);" action="order_find.action" method="post">
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					订单号 &nbsp;&nbsp;&nbsp;：<input type="text" name="orderId"/>
				</td>
				<td>
					订单类型：<select name="orderType" style="width: 15">
							 	<option value="">全部</option>
							 	<option value="0">新订</option>
							 	<option value="1">异地收费</option>
							 	<option value="2">换货</option>
							 	<option value="3">退货</option>
							 	<option value="4">退订</option>
							 </select>
				</td>
				<td>
					订单状态：<select name="orderState">
								<option value="">请选择</option>
								<option value="配送完成。">配送完成。</option>
								<option value="订单已确认，等待调度。">订单已确认，等待调度。</option>	
								<option value="订单已调度，等待中心库房出库。">订单已调度，等待中心库房出库。</option>
								<option value="订单已从中心库房出库，运输公司配送中。">订单已从中心库房出库，运输公司配送中。</option>
							 </select>
				</td>
			</tr>
			<tr>
				<td>
					客户姓名：<input type="text" name="costomerName" size="15"/>
				</td>
				<td>
					联系电话：<input type="text" name="costomerMobailPhone"/>
				</td>
				
			
				<td>
				开始日期：<input type="text" name="orderBeginDate" class="date" readonly="true"/>
				</td>
				<td>
				结束日期：<input type="text" name="orderEndDate" class="date" readonly="true"/>
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
			<li><a class="add" href="orderAdd.action" target="navTab" width="800" height="370"><span>添加</span></a></li>
			<li><a class="delete" href="orderReturn.action?order.id={order_id}" target="dialog"><span>申请退订</span></a></li>
			<!-- <li><a class="delete" href="goodsReturn.action?order.id={order_id}" target="navTab" rel="returnGoods"><span>申请退货</span></a></li> -->
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<div rel="asdew" id="asdew">
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>订单号</th>
				<th>客户名</th>
				<th>联系电话</th>
				<th>下单日期</th>
				<th>订单状态</th>
				<th>货物详细</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${orderList}" var="order" varStatus="status">
				<tr target="order_id" rel="${order.id}">
					<td>${order.orderId}</td>
					<td>${order.costomer.costomerName}</td>
					<td>${order.costomer.mobailPhone}</td>
					<td><fmt:formatDate value="${order.orderDate}" type="date"/></td>
					<td>${order.orderState}</td>
					<td><a href="findOrderDetailByOrder.action?id=${order.id}" target="dialog" width="800" height="370">商品详细</a></td>
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


