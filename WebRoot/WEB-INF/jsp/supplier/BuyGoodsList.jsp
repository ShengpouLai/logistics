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
			<li><a class="add" href="openBuyGoodsPage.action?goods.id={goods_id}" target="dialog" width="720" height="400"><span>进货</span></a></li>
		</ul>
	</div>
	<div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100">商品一级分类</th>
				<th>商品二级分类</th>
				<th>商品代码</th>
				<th>商品名称</th>
				<th>现有库存量</th>
				<th>预警库存量</th>
				<th>缺货数量</th>
				<th>进货数量</th>
				<th>计量单位</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${goodsList}" var="goods" varStatus="st">
				<tr target="goods_id" rel="${goods.id}">
					<td>${goods.secondGoods.firstGoods.firstGoodsName}</td>
					<td>${goods.secondGoods.secondGoodsName}</td>
					<td>${goods.goodsId}</td>
					<td>${goods.goodsName}</td>
					<td>${goodsNumberList[st.count-1].canDistributeQuantity}</td>
					<td>${storageReserveList[st.count-1].storageWarningReserves}</td>
					<td>${storageReserveList[st.count-1].storageMaxReserves - goodsNumberList[st.count-1].canDistributeQuantity}</td>
					<td>${storageReserveList[st.count-1].storageMaxReserves - goodsNumberList[st.count-1].canDistributeQuantity}</td>
					<td>${goods.goodsUnit}</td>
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
