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
	<form id="pageForm" onsubmit="return navTabSearch(this);" action="storage_find.action" method="post">
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					库房名称：<input type="text" name="storageName" size="30" />
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
			<li><a class="add" href="storageAdd.action" target="dialog" width="680" height="350"><span>添加</span></a></li>
			<li><a class="delete" href="storage_delete.action?storage.id={storage_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="storage_findById.action?storage.id={storage_id}" target="dialog" width="680" height="380"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="storageReserveAdd.action" target="dialog" width="730" height="290"><span>库房储备设置</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="lookGoodsNumber.action?storage.id={storage_id}" target="dialog" width="730" height="290"><span>库存量查询</span></a></li>
		</ul>
	</div>
	<div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100">库房名称</th>
				<th>库房地址</th>
				<th>库房管理员</th>
				<th>库房级别</th>
				<th>库房储备信息</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${storageList}" var="storage" varStatus="status">
				<tr target="storage_id" rel="${storage.id}">
					<td>${storage.storageName}</td>
					<td>${storage.storageAddress}</td>
					<td>${storage.storageManagement}</td>
					<td>
					<c:if test="${storage.storageLevel == 1}">中心库房</c:if>
					<c:if test="${storage.storageLevel == 0}">分站库房</c:if>
					</td>
					<td><a target="dialog" href="findStorageReserver.action?storageId=${storage.id}">库房储备信息</a></td>
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
