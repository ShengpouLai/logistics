<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="pageContent">
	<form method="post" action="secondGoods_add.action" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>一级商品名称：</dt>
				<dd>
				<s:select name="secondGoods.firstGoods.id" list="firstGoodsList" listValue="firstGoodsName" listKey="id"></s:select>
				</dd>
			</dl>
			<dl>
				<dt>二级商品名称：</dt>
				<dd>
				<input name="secondGoods.secondGoodsName" type="text" size="30" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>二级商品简介：</dt>
				<dd>
				<input name="secondGoods.secondGoodsInfo" class="required" type="text" size="30"/>
				</dd>
			</dl>
			
			
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