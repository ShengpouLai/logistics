package com.lsp.logistics.service.ifac.storage.invoicing;

import java.util.List;

import com.lsp.logistics.entity.SubstationStoragePutInOrder;

public interface SubstationStoragePutInOrderServiceIfac {
	
	/**
	 * 分站库房接收入库
	 * @param integer substationCheckGoodsOrderId
	 * @return true
	 */
	public boolean save(Integer integer);

	public List<SubstationStoragePutInOrder> find(Integer integer, String invoicingEndDate,
			String invoicingBeginDate);

}
