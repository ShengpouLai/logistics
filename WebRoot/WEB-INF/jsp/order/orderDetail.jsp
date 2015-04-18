<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="pageContent">
				<div class="panelBar">
					<ul class="toolBar">
						
					</ul>
				</div>
				<table class="table" width="100%">
					<thead>
						<tr>
							<th>商品代码</th>
							<th>商品名称</th>
							<th>计量单位</th>
							<th>商品价格</th>
							<th>商品数量</th>
							<th>总计</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderDetailList}" var="orderDetail" varStatus="status">
							<tr target="orderDetail_id" rel="${orderDetail.id}">
								<td>${orderDetail.goods.goodsId}</td>
								<td>${orderDetail.goods.goodsName}</td>
								<td>${orderDetail.goods.goodsUnit}</td>
								<td>${orderDetail.goods.goodsPrice}</td>
								<td>${orderDetail.goodsNumber}</td>
								<td>${orderDetail.goods.goodsPrice * orderDetail.goodsNumber}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>