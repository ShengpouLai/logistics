package com.lsp.logistics.service.ifac.supplier;

import java.util.List;

import com.lsp.logistics.entity.SupplierEntity;

public interface SupplierServiceIfac {
	public List<SupplierEntity> findAllSupplier();
	public boolean saveSupplier(SupplierEntity supplier);
	public boolean deleteSupplier(Integer id);
	public SupplierEntity findById(Integer id);
	public boolean updateSupplier(SupplierEntity supplier);
	public List<SupplierEntity> findSupplier(String supplierName);

}
