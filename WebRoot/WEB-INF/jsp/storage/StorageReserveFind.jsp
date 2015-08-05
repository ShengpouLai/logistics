<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<div>
	<table class="table" width="100%" layoutH="48">
		<thead>
			<tr>
				<th width="100">库房名称</th>
				<th width="100">商品名称</th>
				<th width="100">预警值</th>
				<th width="100">最高值</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${storageReserveList}" var="storageReserve" varStatus="status">
				<tr target="firstGoods_id" rel="${storageReserve.id}">
					<td>${storageReserve.storage.storageName}</td>
					<td>${storageReserve.goods.goodsName}</td>
					<td>${storageReserve.storageWarningReserves}</td>
					<td>${storageReserve.storageMaxReserves}</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	</div>
</div>
