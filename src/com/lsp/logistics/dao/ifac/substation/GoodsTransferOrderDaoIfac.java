package com.lsp.logistics.dao.ifac.substation;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.GoodsTransferOrderEntity;

public interface GoodsTransferOrderDaoIfac extends BaseDao<GoodsTransferOrderEntity> {
	
	public List<GoodsTransferOrderEntity> findTransferOrderList();

}
