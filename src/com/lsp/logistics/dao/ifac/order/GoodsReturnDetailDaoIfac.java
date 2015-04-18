package com.lsp.logistics.dao.ifac.order;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.GoodsReturnDetail;

public interface GoodsReturnDetailDaoIfac extends BaseDao<GoodsReturnDetail> {

	List<GoodsReturnDetail> findByOrderDetail(Integer id);

}
