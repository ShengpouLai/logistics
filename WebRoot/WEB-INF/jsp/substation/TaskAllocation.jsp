<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="pageContent">
	<form method="post" action="taskAllocation.action" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<p>
				<label>配送员：</label>
				<s:select name="deliveryStaffId" list="deliveryStaffList" listValue="deliveryStaffName" listKey="id" cssStyle="width:100px"></s:select>
			</p>
			
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