package com.lsp.logistics.service.impl.order;

import com.lsp.logistics.dao.ifac.order.GoodsReturnEntityDaoIfac;
import com.lsp.logistics.service.ifac.order.GoodsReturnEntityServiceIfac;

public class GoodsReturnEntityServiceImpl implements GoodsReturnEntityServiceIfac {
	
	private GoodsReturnEntityDaoIfac goodsReturnDao;

	public void setGoodsReturnDao(GoodsReturnEntityDaoIfac goodsReturnDao) {
		this.goodsReturnDao = goodsReturnDao;
	}

}
