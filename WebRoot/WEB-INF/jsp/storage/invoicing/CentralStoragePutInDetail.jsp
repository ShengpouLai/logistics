<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">

		</ul>
	</div>
	<div class="pageFormContent nowrap">
		<dl>
			<dt>商品代码：</dt>
			<dd>
				<input
					value="${centralStoragePutInOrder.buyGoodsOrder.goods.goodsId}"
					type="text" size="30" />
			</dd>
		</dl>
		<dl>
			<dt>商品名称：</dt>
			<dd>
				<input
					value="${centralStoragePutInOrder.buyGoodsOrder.goods.goodsName}"
					type="text" size="30" />
			</dd>
		</dl>
		<dl>
			<dt>单价：</dt>
			<dd>
				<input
					value="${centralStoragePutInOrder.buyGoodsOrder.goods.goodsPrice}"
					type="text" size="30" />
			</dd>
		</dl>
		<dl>
			<dt>入库数量：</dt>
			<dd>
				<input value="${centralStoragePutInOrder.actualPutInNumber}"
					type="text" size="30">
			</dd>
		</dl>
		<dl>
			<dt>金额：</dt>
			<dd>
				<input
					value="${centralStoragePutInOrder.buyGoodsOrder.goods.goodsPrice * centralStoragePutInOrder.actualPutInNumber}"
					type="text" size="30" />
			</dd>
		</dl>
		<dl>
			<dt>入库日期：</dt>
			<dd>
				<input value="<fmt:formatDate value="${centralStoragePutInOrder.actualPutInDate}" type="date"/>" type="text" size="30" ></input>
			</dd>
		</dl>
	</div>
</div>