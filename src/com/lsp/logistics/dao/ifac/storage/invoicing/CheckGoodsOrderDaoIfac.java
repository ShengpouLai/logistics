package com.lsp.logistics.dao.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.CheckGoodsOrder;

public interface CheckGoodsOrderDaoIfac extends BaseDao<CheckGoodsOrder>{

	public List<CheckGoodsOrder> findNotPutIn();

}
