<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<div class="pageContent">
	<form method="post" action="storage_reserve_add" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>库房名称：</dt>
				<dd>
					<select class="combox" name="storageReserve.storage.id">
						<option value="">请选择</option>
						<s:iterator value="storageList" var="s">
							<option value="${s.id}">${s.storageName}</option>
						</s:iterator>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>一级商品分类：</dt>
				<dd>
				<select class="combox" name="firstGoodId" ref="secondGoodsCombox" refUrl="findSercondByFirstGoodsId.action?firstGoodsId={value}">
					<option value="">请选择</option>
					<s:iterator value="firstGoodsList" var="f">
						<option value="${f.id}">${f.firstGoodsName}</option>
					</s:iterator>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>二级商品分类：</dt>
				<dd>
				<select class="combox" name="secondGoodsId" ref="goodsCombox" refUrl="findGoodsBySecondGoodsId.action?secondGoodsId={value}" id="secondGoodsCombox">
					<option value="aaa">请选择</option>
					<s:iterator value="secondGoodsList" var="s">
						<option value="${s.id}">${s.secondGoodsName}</option>
					</s:iterator>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>商品名称：</dt>
				<dd>
				<select class="combox" name="storageReserve.goods.id" id="goodsCombox">
					<option value="">请选择</option>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>预警值：</dt>
				<dd>
				<input name="storageReserve.storageWarningReserves" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>最高值：</dt>
				<dd>
				<input name="storageReserve.storageMaxReserves" class="required" type="text" size="30"/>
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