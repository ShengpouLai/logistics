package com.lsp.logistics.dao.ifac.supplier;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.SupplierEntity;

public interface SupplierDaoIfac extends BaseDao<SupplierEntity>{
	public List<SupplierEntity> findSupplier(String supplierName);

}
