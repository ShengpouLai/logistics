<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="pageContent">
	<form method="post" action="deliveryStaff_update" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>配送员姓名：</dt>
				<dd>
					<input value="${deliveryStaff.deliveryStaffName}" name="deliveryStaff.deliveryStaffName" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>联系电话：</dt>
				<dd>
				<input value="${deliveryStaff.deliveryStaffPhone}" name="deliveryStaff.deliveryStaffPhone" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>所属分站：</dt>
				<dd>
				<s:select name="deliveryStaff.substation_t.id" list="substationList" listValue="substationName" listKey="id" value="deliveryStaff.substation_t.id"></s:select>
				</dd>
			</dl>
			<input value="${deliveryStaff.id}" name="deliveryStaff.id" style="visibility: hidden;">
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