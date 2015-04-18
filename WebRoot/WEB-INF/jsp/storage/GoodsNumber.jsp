<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100">库房名称</th>
				<th>商品名称</th>
				<th>总库存量</th>
				<th>退回数量</th>
				<th>已分配量</th>
				<th>可分配量</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${goodsNumberList}" var="goodsNumber" varStatus="status">
				<tr target="goodNum_id" rel="${goodsNumber.id}">
					<td>${goodsNumber.storage.storageName }</td>
					<td>${goodsNumber.goods.goodsName }</td>
					<td>${goodsNumber.totalQuantity }</td>
					<td>${goodsNumber.returnQuantity }</td>
					<td>${goodsNumber.cannotDistributeQuantity }</td>
					<td>${goodsNumber.canDistributeQuantity }</td>
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
