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
	<form id="pageForm" onsubmit="return navTabSearch(this);" action="goods_find.action" method="post">
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					商品代码：<input type="text" name="goodsId" size="30" />
				</td>
				<td>
					商品名称：<input type="text" name="goodsName" class="digits" minlength="18" maxlength="18" />
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="goodsAdd.action" target="dialog" width="730" height="560"><span>添加</span></a></li>
			<li><a class="delete" href="goods_delete.action?goods.id={goods_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="goods_findById.action?goods.id={goods_id}" target="dialog" width="730" height="520"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>商品一级分类</th>
				<th>商品二级分类</th>
				<th>商品代码</th>
				<th>商品名称</th>
				<th>供货商</th>
				<th>计量单位</th>
				<th>商品价格</th>
				<th>商品折扣</th>
				<th>成本价</th>
				<th>商品型号</th>
				<th>保质期（保修期）</th>
				<th>可否退货</th>
				<th>可否换货</th>
				<th>商品备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${goodsList}" var="goods" varStatus="status">
				<tr target="goods_id" rel="${goods.id}">
					<td>${goods.secondGoods.firstGoods.firstGoodsName}</td>
					<td>${goods.secondGoods.secondGoodsName}</td>
					<td>${goods.goodsId}</td>
					<td>${goods.goodsName}</td>
					<td>${goods.supplier.supplierName}</td>
					<td>${goods.goodsUnit}</td>
					<td>${goods.goodsPrice}</td>
					<td>${goods.goodsDiscount}</td>
					<td>${goods.goodsCostPrice}</td>
					<td>${goods.goodsModelId}</td>
					<td>${goods.goodsQGP}</td>
					<td>
						<c:if test="${goods.goodsConcel  == 0}">可以退货</c:if>
						<c:if test="${goods.goodsConcel  == 1}">不可退货</c:if>
					</td>
					<td>
						<c:if test="${goods.goodsChange  == 0}">可以换货</c:if>
						<c:if test="${goods.goodsChange  == 1}">不可换货</c:if>
					</td>
					<td>${goods.goodsRemark}</td>
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
