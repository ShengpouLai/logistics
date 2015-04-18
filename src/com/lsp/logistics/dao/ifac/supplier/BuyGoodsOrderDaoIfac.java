package com.lsp.logistics.dao.ifac.supplier;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.BuyGoodsOrder;

public interface BuyGoodsOrderDaoIfac extends BaseDao<BuyGoodsOrder> {

	public List<BuyGoodsOrder> findNoPutIn();

}
