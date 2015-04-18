<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="storage_update" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>库房编号：</dt>
				<dd>
				<input value="${storage.storageId}" name="storage.storageId" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>库房名称：</dt>
				<dd>
				<input value="${storage.storageName}" name="storage.storageName" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>库房地址：</dt>
				<dd>
				<input value="${storage.storageAddress }" name="storage.storageAddress" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>库管员：</dt>
				<dd>
				<input value="${ storage.storageManagement}" name="storage.storageManagement" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>库房级别：</dt>
				<dd>
					<select name="storage.storageLevel">
						<c:if test="${storage.storageLevel == 0}">
							<option value="0" selected="selected">分站库房</option>
							<option value="1">中心库房</option>
						</c:if>
						<c:if test="${storage.storageLevel == 1}">
							<option value="0">分站库房</option>
							<option value="1" selected="selected">中心库房</option>
						</c:if>
					</select>
				</dd>
			</dl>
			<input name="storage.id" value="${storage.id}" style="visibility: hidden;" />
			
			
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