<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script>
	function orderD(s){
		$("#ord2"+s).attr("href",$("#ord2"+s).attr("href") + $("#qa"+s).val());
	}
	
	function sd(){
		navTab.closeCurrentTab();
		navTab.openTab(orderAdd);
	}
</script>


<div class="pageContent sortDrag" selector="h1" layoutH="42">

	<div class="panel collapse" defH="300">
		<h1>商品列表</h1>
		<div>
			<div class="pageHeader">
				<form id="pageForm" onsubmit="return navTabSearch(this);"
					action="order_detail_goods_find.action" method="post">

					<div class="searchBar">
						<table class="searchContent">
							<tr>
								<td>商品代码：<input type="text" name="goodsId" size="30" />
								</td>
								<td>商品名称：<input type="text" name="goodsName" class="digits"
									minlength="18" maxlength="18" />
								</td>
							</tr>
						</table>
						<div class="subBar">
							<ul>
								<li><div class="buttonActive">
										<div class="buttonContent">
											<button type="submit">检索</button>
										</div>
									</div></li>
							</ul>
						</div>
					</div>
				</form>
			</div>
			<div class="pageContent">
				<div class="panelBar">
					<ul class="toolBar">
						
					</ul>
				</div>
				<table class="table" width="100%">
					<thead>
						<tr>
							<th>商品一级分类</th>
							<th>商品二级分类</th>
							<th>商品代码</th>
							<th>商品名称</th>
							<th>计量单位</th>
							<th>商品价格</th>
							<th>商品折扣</th>
							<th>商品型号</th>
							<th width="100">保质期（保修期）</th>
							<th>可否退货</th>
							<th>可否换货</th>
							<th>商品库存</th>
							<th>购买数量</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${goodsList}" var="goods" varStatus="status">
							<tr target="goods_id" rel="${goods.id}">
								<td>${goods.secondGoods.firstGoods.firstGoodsName}</td>
								<td>${goods.secondGoods.secondGoodsName}</td>
								<td>${goods.goodsId}</td>
								<td>${goods.goodsName}</td>
								<td>${goods.goodsUnit}</td>
								<td>${goods.goodsPrice}</td>
								<td>${goods.goodsDiscount}</td>
								<td>${goods.goodsModelId}</td>
								<td>${goods.goodsQGP}</td>
								<td><c:if test="${goods.goodsConcel  == 0}">可以退货</c:if> <c:if
										test="${goods.goodsConcel  == 1}">不可退货</c:if>
								</td>
								<td><c:if test="${goods.goodsChange  == 0}">可以换货</c:if> <c:if
										test="${goods.goodsChange  == 1}">不可换货</c:if>
								</td>
								<td>${goodsNumberList[status.count-1].canDistributeQuantity}</td>
								<td><input name="qa" id="qa${status.index+1}" value="1"> </td>
								<td><a id="ord2${status.index+1}" href="orderDetailAdd.action?goods.id=${goods.id}&&goodsNumber=" target="ajaxTodo" onclick="orderD(${status.index+1})">购买</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="panel collapse" defH="150">
		<h1>购物车</h1>
		<table class="table" width="100%">
			<thead>
				<tr>
					<th>序号</th>
					<th>商品名称</th>
					<th>数量</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${buyGoodsNumberList}" var="buyGoodsNumberList" varStatus="status">
					<tr>
						<td>${status.index+1 }</td>
						<td>${goodsNameList[status.count-1].goodsName}</td>
						<td>${buyGoodsNumberList}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<a class="button"  href="orderAdd" title="订单结算页" rel="orderAdd" target="navTab" ><span>去结算</span></a>