<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="pageContent">
	<form method="post" action="buyGoods" class="pageForm required-validate" 
		  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" >
			<dl>
				<dt>购货入库单单号：</dt>
				<dd>
				<input name="buyGoodsOrder.buyGoodsOrderId" type="text" size="30" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>供货商：</dt>
				<dd>
				<input value="${goods.supplier.supplierName}" name="supplier" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>商品名称：</dt>
				<dd>
				<input value="${goods.goodsName }" name="goodsName" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>计量单位：</dt>
				<dd>
				<input value="${goods.goodsUnit }" name="goodsUnit" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>商品型号：</dt>
				<dd>
				<input value="${goods.goodsModelId }" name="goodsModelId" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>进货量：</dt>
				<dd>
				<input value="${storageReserve.storageMaxReserves - goodsNumber.canDistributeQuantity}" name="buyGoodsOrder.buyGoodsNumber" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>日期：</dt>
				<dd>
				<input name="buyGoodsOrder.buyGoodsDate" class="required" type="text" size="30"/>
				</dd>
			</dl>
			<input name="buyGoodsOrder.buyGoodsOrderState" value="1" style="visibility: hidden;" />
			<input name="buyGoodsOrder.goods.id" value="${goods.id}" style="visibility: hidden;" />
			<input name="goodsId" value="${goods.id}" style="visibility: hidden;" />
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


