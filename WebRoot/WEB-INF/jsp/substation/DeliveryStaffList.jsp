<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<form id="pagerForm" method="post" action="demo_page1.html">
	<input type="hidden" name="status" value="${param.status}"> <input
		type="hidden" name="keywords" value="${param.keywords}" /> <input
		type="hidden" name="pageNum" value="1" /> <input type="hidden"
		name="numPerPage" value="${model.numPerPage}" /> <input type="hidden"
		name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
	<form id="pageForm" onsubmit="return navTabSearch(this);"
		action="deliveryStaff_find.action" method="post">

		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>配送员姓名：<input type="text"
						name="deliveryStaff.deliveryStaffName" size="30" /></td>
					<td>所属分站：<select name="deliveryStaff.substation_t.id">
							<option value="">请选择</option>
							<c:forEach items="${substationList}" var="sub">
								<option value="${sub.id}">${sub.substationName}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="deliveryStaffAdd.action"
				target="dialog" width="680" height="350"><span>添加</span>
			</a>
			</li>
			<li><a class="delete"
				href="deliveryStaff_delete.action?deliveryStaff.id={deliveryStaff_id}"
				target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
			</a>
			</li>
			<li><a class="edit"
				href="deliveryStaff_findById.action?deliveryStaff.id={deliveryStaff_id}"
				target="dialog" width="680" height="380"><span>修改</span>
			</a>
			</li>
		</ul>
	</div>
	<div>
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="100">配送员姓名</th>
					<th>配送员电话</th>
					<th>所属分站</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${deliveryStaffList}" var="deliveryStaff"
					varStatus="status">
					<tr target="deliveryStaff_id" rel="${deliveryStaff.id}">
						<td>${deliveryStaff.deliveryStaffName}</td>
						<td>${deliveryStaff.deliveryStaffPhone}</td>
						<td>${deliveryStaff.substation_t.substationName}</td>
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
