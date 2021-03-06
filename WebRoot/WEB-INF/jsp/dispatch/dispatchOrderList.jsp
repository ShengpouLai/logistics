<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script>
	function oqa(){
		$("#a1").attr("href", $("#a1").attr("href")+$("#select1").val());
	}
</script>

<form id="pagerForm" method="post" action="demo_page1.html">
	<input type="hidden" name="status" value="${param.status}"> <input
		type="hidden" name="keywords" value="${param.keywords}" /> <input
		type="hidden" name="pageNum" value="1" /> <input type="hidden"
		name="numPerPage" value="${model.numPerPage}" /> <input type="hidden"
		name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
	<form id="pageForm" onsubmit="return navTabSearch(this);" action="order_find_dispatchOrder.action" method="post">
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					订单号 &nbsp;&nbsp;&nbsp;：<input type="text" name="orderId"/>
				</td>
				<td>
					客户姓名：<input type="text" name="costomerName" size="15"/>
				</td>
				<td>
					联系电话：<input type="text" name="costomerMobailPhone"/>
				</td>
			</tr>
			<tr>
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
			<li><a id="a1" class="add" href="dispatch.action?order.id={order_id}&&storageId=" target="ajaxTodo"
				onclick="oqa()" width="800" height="370"><span>调度</span>
			</a>
			</li>
		</ul>
	</div>
	<div rel="asdew" id="asdew">
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="120">订单号</th>
					<th>客户名</th>
					<th>执行任务分站</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${orderList}" var="order" varStatus="status">
					<tr target="order_id" rel="${order.id}">
						<td>${order.orderId}</td>
						<td>${order.costomer.costomerName}</td>
						<td><select name="storageId" id="select1">
								<c:forEach items="${substationList}" var="sub">
									<option value="${sub.id}">${sub.substationName}</option>
								</c:forEach>
						</select></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span> <select class="combox" name="numPerPage"
				onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select> <span>条，共${totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="200"
			numPerPage="20" pageNumShown="10" currentPage="1"></div>

	</div>
</div>


