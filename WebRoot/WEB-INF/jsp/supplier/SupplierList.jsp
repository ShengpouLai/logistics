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
	<form id="pageForm" onsubmit="return navTabSearch(this);" action="supplier_find.action" method="post">
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					供应商名称：<input type="text" name="supplierName" size="30" />
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
			<li><a class="add" href="supplierAdd.action" target="dialog" width="720" height="400"><span>添加</span></a></li>
			<li><a class="delete" href="supplier_delete.action?supplier.id={supplier_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="supplier_findById.action?supplier.id={supplier_id}" target="dialog" width="680" height="380"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100">供应商名称</th>
				<th>供应商地址</th>
				<th>供应商联系人</th>
				<th>供应商联系电话</th>
				<th>开户行</th>
				<th>银行账号</th>
				<th>传真</th>
				<th>邮编</th>
				<th>法人</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${supplierList}" var="supplier" varStatus="status">
				<tr target="supplier_id" rel="${supplier.id}">
					<td>${supplier.supplierName}</td>
					<td>${supplier.supplierAddress}</td>
					<td>${supplier.supplierContact}</td>
					<td>${supplier.supplierPhone}</td>
					<td>${supplier.supplierBank}</td>
					<td>${supplier.supplierBankAccount}</td>
					<td>${supplier.supplierFax}</td>
					<td>${supplier.supplierPostcode}</td>
					<td>${supplier.supplierLegal}</td>
					<td>${supplier.supplierRemark}</td>
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
