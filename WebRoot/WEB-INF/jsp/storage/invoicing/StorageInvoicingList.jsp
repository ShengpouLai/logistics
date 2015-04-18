<%@page import="com.lsp.logistics.service.ifac.storage.StorageServiceIfac"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
$(document).ready(function(){
		var list1;
		list1 = '${centralStorageOutOfList}';
		var list2;
		list2 = '${centralStoragePutInList}';
		var list3;
		list3 = '${substationStorageOutOfList}';
		var list4;
		list4 = '${substationStoragePutInList}';
		//中心库房出库 table2
		if(list1 != ""){
			$("#table1").hide();
			$("#table3").hide();
			$("#table4").hide();
			$("#table2").show();
		}
		//中心库房入库 table1
		if(list2 != ""){
			$("#table2").hide();
			$("#table3").hide();
			$("#table4").hide();
			$("#table1").show();
			
		}
		//分站库房出库 table3
		if(list3 != ""){
			$("#table2").hide();
			$("#table1").hide();
			$("#table4").hide();
			$("#table3").show();
		}
		
		//分站库房入库 table4
		if(list4 != ""){
			$("#table2").hide();
			$("#table3").hide();
			$("#table1").hide();
			$("#table4").show();
		}
	
});
</script>

<form id="pagerForm" method="post" action="demo_page1.html">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
	<form id="pageForm" onsubmit="return navTabSearch(this);" action="invoicing_find.action" method="post">
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型：<select id="invoicingType" name="invoicingType" style="width: 153px">
							 	<option value="1">出库单</option>
							 	<option value="2">入库单</option>
						 </select>
				</td>
				<td>
					库房名称：<select id="storageId" name="storageId" style="width: 153px">
								<c:forEach items="${storageList}" var="storage" varStatus="status">
										<option value="${storage.id}">${storage.storageName}</option>
								</c:forEach>
							 </select>
				</td>
			</tr>
			<tr>
				<td>
					开始日期：<input type="text" name="invoicingBeginDate" class="date" readonly="true"/>
				</td>
				<td>
					结束日期：<input type="text" name="invoicingEndDate" class="date" readonly="true"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="doSeach()">检索</button></div></div></li>
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
	<!-- 中心库房入库表格 -->
	<div id="table1" style="display: none;">
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>类型</th>
				<th>单号</th>
				<th>仓库名</th>
				<th>日期</th>
				<th>详细</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${centralStoragePutInList}" var="centralStoragePutIn" varStatus="status">
				<tr>
					<td>入库单</td>
					<td>${centralStoragePutIn.id}</td>
					<td>中心库房</td>
					<td><fmt:formatDate value="${centralStoragePutIn.actualPutInDate}" type="date"/></td>
					<td><a href="centralStoragePutInDetail.action?id=${centralStoragePutIn.id}" target="dialog" width="800" height="370">商品详细</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<!-- 中心库房出库表格 -->
	<div id="table2" style="display: none;">
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>类型</th>
				<th>单号</th>
				<th>仓库名</th>
				<th>日期</th>
				<th>详细</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${centralStorageOutOfList}" var="centralStorageOutOf" varStatus="status">
				<tr>
					<td>出库单</td>
					<td>${centralStorageOutOf.id}</td>
					<td>中心库房</td>
					<td><fmt:formatDate value="${centralStorageOutOf.centralStorageOutOfTime}" type="date"/></td>
					<td><a href="findOrderDetailByOrder.action?id=${centralStorageOutOf.goodsTransferOrder.t_order.id}" target="dialog" width="800" height="370">商品详细</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<!-- 分站库房出库 -->
	<div id="table3" style="display: none;">
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>类型</th>
				<th>单号</th>
				<th>仓库名</th>
				<th>日期</th>
				<th>详细</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${substationStorageOutOfList}" var="substationStorageOutOf" varStatus="status">
				<tr>
					<td>出库单</td>
					<td>${substationStorageOutOf.id}</td>
					<td>${substationStorageOutOf.taskOrder.substation.storage.storageName}</td>
					<td><fmt:formatDate value="${substationStorageOutOf.substationStorageOutOfOrderDate}" type="date"/></td>
					<td><a href="findOrderDetailByOrder.action?id=${substationStorageOutOf.taskOrder.order.id}" target="dialog" width="800" height="370">商品详细</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<!-- 分站库房入库 -->
	<div id="table4" style="display: none;">
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>类型</th>
				<th>单号</th>
				<th>仓库名</th>
				<th>日期</th>
				<th>详细</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${substationStoragePutInList}" var="substationStoragePutIn" varStatus="status">
				<tr>
					<td>入库单</td>
					<td>${substationStoragePutIn.id}</td>
					<td>${substationStoragePutIn.checkGoodsOrder.goodsTransferOrder.substation.storage.storageName}</td>
					<td><fmt:formatDate value="${substationStoragePutIn.substationStoragePutInDate}" type="date"/></td>
					<td><a href="findOrderDetailByOrder.action?id=${substationStoragePutIn.checkGoodsOrder.goodsTransferOrder.t_order.id}" target="dialog" width="800" height="370">商品详细</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
</div>