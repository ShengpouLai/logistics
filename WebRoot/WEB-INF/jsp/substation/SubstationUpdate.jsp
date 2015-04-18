<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="substation_update" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>库房名称：</dt>
				<dd>
				<input value="${sub.substationName}" name="sub.substationName" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>库房地址：</dt>
				<dd>
				<input value="${sub.substationAddress }" name="sub.substationAddress" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>库房电话：</dt>
				<dd>
				<input value="${sub.substationPhone}" name="sub.substationPhone" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>库房级别：</dt>
				<dd>
					<s:select name="sub.storage.id" list="storageList" listValue="storageName" listKey="id" value="sub.storage.id"></s:select>
				</dd>
			</dl>
			<input name="sub.id" value="${sub.id}" style="visibility: hidden;" />
			
			
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
