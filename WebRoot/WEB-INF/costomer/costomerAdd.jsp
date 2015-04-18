<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="costomer_add" class="pageForm required-validate">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>身份证号：</label>
				<input name="costomer.costomerId" type="text" size="30"/>
			</p>
			<p>
				<label>客户名称：</label>
				<input name="costomer.costomerName" class="required" type="text" size="30" alt="请输入客户名称"/>
			</p>
			<p>
				<label>公司名称：</label>
				<input name="costomer.company" type="text" size="30"/>
			</p>
			<p>
				<label>手机：</label>
				<input name="costomer.mobailPhone" class="textInput">
			</p>
			<p>
				<label>固定电话：</label>
				<input name="costomer.phone" type="text" size="30"/>
			</p>
			<p>
				<label>地址：</label>
				<input type="text" name="costomer.address" class="textInput">
			</p>
			<p>
				<label>邮编：</label>
				<input name="costomer.postcode" type="text" size="30" alt="请输入数字"/>
			</p>
			<p>
				<label>电子邮件：</label>
				<input name="costomer.email" type="text" size="30" alt="请输入数字"/>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>