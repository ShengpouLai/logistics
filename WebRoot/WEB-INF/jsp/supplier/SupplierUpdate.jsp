<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="supplier_update" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>供货商名称：</dt>
				<dd>
				<input value="${supplier.supplierName }" name="supplier.supplierName" type="text" size="30" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>供货商地址：</dt>
				<dd>
				<input value="${supplier.supplierAddress }" name="supplier.supplierAddress" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>供货商联系人：</dt>
				<dd>
				<input value="${supplier.supplierContact }" name="supplier.supplierContact" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>供货商联系电话：</dt>
				<dd>
				<input value="${supplier.supplierPhone }" name="supplier.supplierPhone" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>开户行：</dt>
				<dd>
				<input value="${supplier.supplierBank }" name="supplier.supplierBank" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>银行账号：</dt>
				<dd>
				<input value="${supplier.supplierBankAccount }" name="supplier.supplierBankAccount" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>传真：</dt>
				<dd>
				<input value="${supplier.supplierFax }" name="supplier.supplierFax" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>邮编：</dt>
				<dd>
				<input value="${supplier.supplierPostcode }" name="supplier.supplierPostcode" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>法人：</dt>
				<dd>
				<input value="${supplier.supplierLegal }" name="supplier.supplierLegal" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>备注：</dt>
				<dd>
				<input value="${supplier.supplierRemark }" name="supplier.supplierRemark" type="text" size="30"/>
				</dd>
			</dl>
			<input name="supplier.id" value="${supplier.id }" style="visibility: hidden;" />
			
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

