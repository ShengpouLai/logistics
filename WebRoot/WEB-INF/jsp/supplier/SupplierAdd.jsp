<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="supplier_add" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>供货商名称：</dt>
				<dd>
				<input name="supplier.supplierName" type="text" size="30" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>供货商地址：</dt>
				<dd>
				<input name="supplier.supplierAddress" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>供货商联系人：</dt>
				<dd>
				<input name="supplier.supplierContact" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>供货商联系电话：</dt>
				<dd>
				<input name="supplier.supplierPhone" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>开户行：</dt>
				<dd>
				<input name="supplier.supplierBank" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>银行账号：</dt>
				<dd>
				<input name="supplier.supplierBankAccount" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>传真：</dt>
				<dd>
				<input name="supplier.supplierFax" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>邮编：</dt>
				<dd>
				<input name="supplier.supplierPostcode" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>法人：</dt>
				<dd>
				<input name="supplier.supplierLegal" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>备注：</dt>
				<dd>
				<input name="supplier.supplierRemark" class="required" type="text" size="30"/>
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
