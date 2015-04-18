package com.lsp.logistics.service.ifac.order;

import java.util.List;

import com.lsp.logistics.entity.GoodsReturnDetail;

public interface GoodsReturnDetailServiceIfac {

	public List<GoodsReturnDetail> findByOrderDetail(Integer id);

}
