<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="pageContent sortDrag" selector="h1" layoutH="42">

	<div class="panel" defH="150">
		<h1>任务单商品信息</h1>
		<div>
			<table class="list" width="98%">
				<thead>
					<tr>
						<th>商品</th>
						<th>数量</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderDetailList}" var="orderDetail"
					varStatus="status">
					<tr target="orderDetail_id" rel="${orderDetail.id}">
						<td>${orderDetail.goods.goodsId}</td>
						<td>${orderDetail.goods.goodsName}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="panel" defH="150">
		<h1>配送单商品信息</h1>
		<div>
			<table class="list" width="98%">
				<thead>
					<tr>
						<th>商品</th>
						<th>数量</th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
		</div>
	</div>

</div>
