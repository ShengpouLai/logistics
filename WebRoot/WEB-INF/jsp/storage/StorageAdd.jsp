<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="storage_add.action" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>库房编号：</dt>
				<dd>
				<input name="storage.storageId" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>库房名称：</dt>
				<dd>
				<input name="storage.storageName" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>库房地址：</dt>
				<dd>
				<input name="storage.storageAddress" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>库管员：</dt>
				<dd>
				<input name="storage.storageManagement" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>库房级别：</dt>
				<dd>
					<select name="storage.storageLevel">
						<option value="0">分站库房</option>
						<option value="1">中心库房</option>
					</select>
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