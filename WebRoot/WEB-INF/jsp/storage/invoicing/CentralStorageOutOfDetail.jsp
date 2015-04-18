<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="pageContent">
				<div class="panelBar">
					
				</div>
				<table class="table" width="100%">
					<thead>
						<tr>
							<th>商品代码</th>
							<th>商品名称</th>
							<th>单价</th>
							<th>出库数量</th>
							<th>金额</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderDetailList}" var="orderDetail" varStatus="status">
							<tr target="orderDetail_id" rel="${orderDetail.id}">
								<td>${orderDetail.goods.goodsId}</td>
								<td>${orderDetail.goods.goodsName}</td>
								<td>${orderDetail.goods.goodsPrice}</td>
								<td>${orderDetail.goodsNumber}</td>
								<td>${orderDetail.goods.goodsPrice * orderDetail.goodsNumber}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>