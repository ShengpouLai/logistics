package com.lsp.logistics.service.impl.order;

import java.util.List;

import com.lsp.logistics.dao.ifac.order.GoodsReturnDetailDaoIfac;
import com.lsp.logistics.entity.GoodsReturnDetail;
import com.lsp.logistics.service.ifac.order.GoodsReturnDetailServiceIfac;

public class GoodsReturnDetailServiceImpl implements GoodsReturnDetailServiceIfac {
	
	private GoodsReturnDetailDaoIfac goodsReturnDetailDao;

	public void setGoodsReturnDetailDao(
			GoodsReturnDetailDaoIfac goodsReturnDetailDao) {
		this.goodsReturnDetailDao = goodsReturnDetailDao;
	}

	@Override
	public List<GoodsReturnDetail> findByOrderDetail(Integer id) {
		return this.goodsReturnDetailDao.findByOrderDetail(id);
	}

}
