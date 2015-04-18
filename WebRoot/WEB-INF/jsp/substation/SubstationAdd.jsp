<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="substation_add" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>分站名称：</dt>
				<dd>
				<input name="sub.substationName" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>分站电话：</dt>
				<dd>
				<input name="sub.substationPhone" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>分站地址：</dt>
				<dd>
				<input name="sub.substationAddress" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>分站库房：</dt>
				<dd>
				<s:select name="sub.storage.id" list="storageList" listValue="storageName" listKey="id"></s:select>
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