<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="firstGoods_update.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>一级商品名称：</dt>
				<dd>
				<input value="${firstGoods.firstGoodsName}" name="firstGoods.firstGoodsName" type="text" size="30" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>一级商品简介：</dt>
				<dd>
				<input value="${firstGoods.firstGoodsInfo}" name="firstGoods.firstGoodsInfo" class="required" type="text" size="30"/>
				</dd>
			</dl>
			
			<input value="${firstGoods.id}" name="firstGoods.id" style="visibility:hidden"/>
			
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