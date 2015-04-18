<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="pageContent">
	<form method="post" action="centralStoragePutIn" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>购货单号：</dt>
				<dd>
				<input value="${buyGoodsOrder.buyGoodsOrderId}" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>商品名称：</dt>
				<dd>
				<input value="${buyGoodsOrder.goods.goodsName}" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>商品应入库数量：</dt>
				<dd>
				<input value="${buyGoodsOrder.buyGoodsNumber}" name="centralStoragePutInOrder.shouldPutInNumber" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>实际入库数量：</dt>
				<dd>
				<input value="${buyGoodsOrder.buyGoodsNumber}" name="centralStoragePutInOrder.actualPutInNumber" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>实际入库日期：</dt>
				<dd>
				<input type="text" name="centralStoragePutInOrder.actualPutInDate" class="date" readonly="true"/>
						<a class="inputDateButton" href="javascript:;">选择</a>
				</dd>
			</dl>
			<dl>
				<dt>备注：</dt>
				<dd>
				<input name="centralStoragePutInOrder.centralStoragePutInRemark" type="text" size="30"/>
				</dd>
			</dl>
			<input name="centralStoragePutInOrder.buyGoodsOrder.id" value="${buyGoodsOrder.id}" style="visibility: hidden;"/>
			<input name="goodsId" value="${buyGoodsOrder.goods.id}" style="visibility: hidden;" />

		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent">
				<button type="submit">保存</button>
				</div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>

