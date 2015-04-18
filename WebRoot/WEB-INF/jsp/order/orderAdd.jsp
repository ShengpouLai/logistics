<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script type="text/javascript">
	$(function() {
		$("#r1").change(function() {
			$("#r2Div").hide();
		});
		$("#r2").change(function() {
			$("#r2Div").show();
		});
	});
</script>

<div class="pageContent">
	<form method="post" action="order_add"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent nowrap">

			<div class="panel">
				<h1>收货人信息</h1>
				<div>
					<p>
						<label>收货人：</label> <input value="${costomer.costomerName }"
							name="order.orderConsigneeName" type="text" size="30"
							class="required" />

					</p>
					<p>
						<label>收货人地址：</label> <input name="order.orderConsigneeAddress"
							type="text" size="30" class="required" />

					</p>
					<p>
						<label>收货人手机：</label> <input name="order.orderConsigneePhone"
							type="text" size="30" class="required" />

					</p>
					<p>
						<label>收货人邮编：</label> <input name="order.orderConsigneePostcode"
							type="text" size="30" class="required" />

					</p>
				</div>
			</div>

			<div class="panel">
				<h1>支付方式及配送要求</h1>
				<div>
					<label><input type="radio" name="order.orderType" id="r1" checked="checked" value="0"/>货到付款</label> 
					<label><input type="radio" name="order.orderType" id="r2" value="1"/>找人代付</label>
					<label>要求送达日期：</label>
						<input type="text" name="order.orderDeliverDate" class="date" readonly="true"/>
						<a class="inputDateButton" href="javascript:;">选择</a>
					<div id="r2Div" style="display: none;">
						<dl>
							<dt>付款人：</dt>
							<dd><input name="order.orderPayerName"
								type="text" size="30"/>
								</dd>
						</dl>
						<dl>
							<dt>付款人手机：</dt> 
							<dd><input name="order.orderPayerAddress"
								type="text" size="30"/>
								</dd>
						</dl>
						<dl>
							<dt>付款人地址：</dt>
							<dd><input name="order.orderPayerPhone"
								type="text" size="30"/>
								</dd>
						</dl>
						<dl>
							<dt>付款人邮编：</dt> 
							<dd><input name="order.orderPayerPostcode"
								type="text" size="30"/>
								</dd>
						</dl>
					</div>
				</div>
			</div>

			<div class="panel">
				<h1>发票信息</h1>
				<div>
					<label>是否需要发票：</label>
					<label><input type="radio" name="order.orderNeedInvoce" checked="checked"/ value="0">是</label> 
					<label><input type="radio" name="order.orderNeedInvoce" value="1" />否</label>
				</div>
			</div>
			
			<div class="panel">
				<h1>送货清单</h1>
				<table class="table" width="100%">
					<thead>
						<tr>
							<th></th>
							<th>商品名称</th>
							<th>单价</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${buyGoodsNumberList}" var="buyGoodsNumberList" varStatus="status">
							<tr>
								<td>${status.index+1 }</td>
								<td>${goodsNameList[status.count-1].goodsName}</td>
								<td>${goodsNameList[status.count-1].goodsPrice}</td>
								<td>${buyGoodsNumberList}</td>
								<td>${goodsNameList[status.count-1].goodsPrice * buyGoodsNumberList}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<label>订单备注：</label><input type="text" name="order.orderRemark" />
				</div>
				<div>
				<div style="float: right;color: red;">
					<label>订单总金额：${goodsAllMoney} </label>
				</div></div>
			</div>
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">提交订单</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>


