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
	<form id="pageForm" onsubmit="return navTabSearch(this);" action="costomer_findCostomer.action" method="post">
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					客户姓名：<input type="text" name="costomerName" size="30" />
				</td>
				<td>
					身份证号：<input type="text" name="costomerId" class="digits" minlength="18" maxlength="18" />
				</td>
				<td>
					手机号：<input type="text" name="costomerMobailPhone" class="phone"/>
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
			<li><a class="add" href="costomerAdd.action" target="dialog" width="800" height="370"><span>添加</span></a></li>
			<li><a class="delete" href="costomer_delete.action?costomer.id={costomer_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="costomer_findById.action?costomer.id={costomer_id}" target="dialog" width="800" height="370"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="add" href="openOrderDetail.action?costomerId={costomer_id}" target="navTab" ref="orderDetailList"><span>新建订单</span></a></li>
		</ul>
	</div>
	<div rel="asdew" id="asdew">
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120">客户姓名</th>
				<th width="250">身份证号码</th>
				<th width="150">工作单位</th>
				<th width="150">座机</th>
				<th width="150">移动电话</th>
				<th>联系地址</th>
				<th width="80">邮编</th>
				<th width="80">email</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${costomerList}" var="costomer" varStatus="status">
				<tr target="costomer_id" rel="${costomer.id}">
					<td>${costomer.costomerName}</td>
					<td>${costomer.costomerId}</td>
					<td>${costomer.company}</td>
					<td>${costomer.phone}</td>
					<td>${costomer.mobailPhone}</td>
					<td>${costomer.address}</td>
					<td>${costomer.postcode}</td>
					<td>${costomer.email}</td>
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
