<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<div class="pageContent">
	<form method="post" action="goods_update"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap">
			<dl>
				<dt>商品一级分类：</dt>
				<dd>
					<select class="combox" name="firstGoodId" ref="secondGoodsCombox"
						refUrl="findSercondByFirstGoodsId.action?firstGoodsId={value}">
						 <s:iterator value="firstGoodsList" var="f">
							<option value="${f.id}">${f.firstGoodsName}</option>
						</s:iterator>
					</select> 
				</dd>
			</dl>
			<dl>
				<dt>商品二级分类：</dt>
				<dd>
					<select class="combox" name="goods.secondGoods.id"
						id="secondGoodsCombox">
						<option value="${goods.secondGoods.id }">${goods.secondGoods.secondGoodsName}</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>商品代码：</dt>
				<dd>
					<input value="${goods.goodsId}" name="goods.goodsId"
						class="required" type="text" size="30" />
				</dd>
			</dl>
			<dl>
				<dt>商品名称：</dt>
				<dd>
					<input value="${goods.goodsName}" name="goods.goodsName"
						class="required" type="text" size="30" />
				</dd>
			</dl>
			<dl>
				<dt>供货商：</dt>
				<dd>
				<s:select list="supplierList" name="goods.supplier.id" listValue="supplierName" listKey="id"></s:select>
			</dl>
			<dl>
				<dt>计量单位：</dt>
				<dd>
					<input value="${goods.goodsUnit}" name="goods.goodsUnit"
						class="required" type="text" size="30" />
				</dd>
			</dl>
			<dl>
				<dt>商品价格：</dt>
				<dd>
					<input value="${goods.goodsPrice }" name="goods.goodsPrice"
						class="required" type="text" size="30" />
				</dd>
			</dl>
			<dl>
				<dt>商品折扣：</dt>
				<dd>
					<input value="${goods.goodsDiscount }" name="goods.goodsDiscount"
						class="required" type="text" size="30" />
				</dd>
			</dl>
			<dl>
				<dt>成本价：</dt>
				<dd>
					<input value="${goods.goodsCostPrice}" name="goods.goodsCostPrice"
						class="required" type="text" size="30" />
				</dd>
			</dl>
			<dl>
				<dt>商品型号：</dt>
				<dd>
					<input value="${goods.goodsModelId }" name="goods.goodsModelId"
						class="required" type="text" size="30" />
				</dd>
			</dl>
			<dl>
				<dt>保质期（保修期）：</dt>
				<dd>
					<input value="${goods.goodsQGP }" name="goods.goodsQGP"
						class="required" type="text" size="30" />
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
					<input value="${goods.goodsRemark }" name="goods.goodsRemark"
						 type="text" size="30" />
				</dd>
			</dl>
			<input value="${goods.id }" name="goods.id" style="visibility:hidden">

		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>