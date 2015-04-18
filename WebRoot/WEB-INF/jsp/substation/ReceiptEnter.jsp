<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="receipt_enter.action" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>任务单号：</dt>
				<dd>
					<input value="${taskOrder.taskOrderId}" readonly="readonly" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>任务状态：</dt>
				<dd>
					<select name="receipt.taskState" style="width: 15em">
						<option value="完成">完成</option>
						<option value="失败">失败</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>客户满意度：</dt>
				<dd>
					<label><input type="radio" name="receipt.customerSatisfaction" value="非常好" />非常好</label>
					<label><input type="radio" name="receipt.customerSatisfaction" value="一般" />一般</label>
					<label><input type="radio" name="receipt.customerSatisfaction" value="差" />差</label>
				</dd>
			</dl>
			<dl>
				<dt>备注：</dt>
				<dd>
				<input name="receipt.receiptRemark" type="text" size="30"/>
				</dd>
			</dl>
			<input name="taskOrderId" value="${taskOrder.id}" style="visibility: hidden;">
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