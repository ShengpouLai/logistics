<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="costomer_update.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>身份证号：</dt>
				<dd>
				<input value="${costomer.costomerId}" name="costomer.costomerId" type="text" size="30" class="required digits " minlength="18" maxlength="18" alt="请输入正确的身份证号码"/>
				</dd>
			</dl>
			<dl>
				<dt>客户名称：</dt>
				<dd>
				<input value="${costomer.costomerName}" name="costomer.costomerName" class="required" type="text" size="30" alt="请输入客户名称"/>
				</dd>
			</dl>
			<dl>
				<dt>公司名称：</dt>
				<dd>
				<input value="${costomer.company}" name="costomer.company" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>手机：</dt>
				<dd>
				<input value="${costomer.mobailPhone}" name="costomer.mobailPhone" class="required phone" size="30">
				</dd>
			</dl>
			<dl>
				<dt>固定电话：</dt>
				<dd>
				<input value="${costomer.phone}" name="costomer.phone" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>电子邮件：</dt>
				<dd>
				<input value="${costomer.email}" name="costomer.email" class="required email" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>地址：</dt>
				<dd>
				<input value="${costomer.address}" type="text" name="costomer.address" class="required" size="30">
				</dd>
			</dl>
			<dl>
				<dt>邮编：</dt>
				<dd>
				<input value="${costomer.postcode}" name="costomer.postcode" type="text" size="30"/>
				</dd>
			</dl>
			<input value="${costomer.id}" name="costomer.id" style="visibility:hidden"/>
			
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