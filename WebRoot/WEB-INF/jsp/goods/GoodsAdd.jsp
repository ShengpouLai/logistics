<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="pageContent">
	<form method="post" action="goods_add" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>商品一级分类：</dt>
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
				<dt>商品二级分类：</dt>
				<dd>
				<select class="combox" name="goods.secondGoods.id" id="secondGoodsCombox">
					<option value="aaa">请选择</option>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>商品代码：</dt>
				<dd>
				<input name="goods.goodsId" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>商品名称：</dt>
				<dd>
				<input name="goods.goodsName" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>供货商：</dt>
				<dd>
				<s:select list="supplierList" name="goods.supplier.id" listValue="supplierName" listKey="id"></s:select>
				</dd>
			</dl>
			<dl>
				<dt>计量单位：</dt>
				<dd>
				<input name="goods.goodsUnit" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>商品价格：</dt>
				<dd>
				<input name="goods.goodsPrice" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>商品折扣：</dt>
				<dd>
				<input name="goods.goodsDiscount" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>成本价：</dt>
				<dd>
				<input name="goods.goodsCostPrice" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>商品型号：</dt>
				<dd>
				<input name="goods.goodsModelId" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>保质期（保修期）：</dt>
				<dd>
				<input name="goods.goodsQGP" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>可否退货：</dt>
				<dd>
				<select class="combox" name="goods.goodsConcel">
					<option value="0">可以退货</option>
					<option value="1">不可退货</option>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>可否换货：</dt>
				<dd>
				<select class="combox" name="goods.goodsChange">
					<option value="0">可以换货</option>
					<option value="1">不可换货</option>
				</select>
				</dd>
			</dl>
			<dl>
				<dt>商品备注：</dt>
				<dd>
				<input name="goods.goodsRemark" class="required" type="text" size="30"/>
				</dd>
			</dl>
			
			<input type="text" value="1" name="goods.storage.id" style="visibility: hidden;">
			<input name="goods.goodsState" value="1" style="visibility: hidden;" />
			
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