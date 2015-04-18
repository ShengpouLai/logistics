package com.lsp.logistics.service.impl.supplier;

import java.util.List;

import com.lsp.logistics.dao.ifac.supplier.SupplierDaoIfac;
import com.lsp.logistics.entity.SupplierEntity;
import com.lsp.logistics.service.ifac.supplier.SupplierServiceIfac;

public class SupplierServiceImpl implements SupplierServiceIfac {
	
	private SupplierDaoIfac supplierDao;

	public void setSupplierDao(SupplierDaoIfac supplierDao) {
		this.supplierDao = supplierDao;
	}

	@Override
	public boolean saveSupplier(SupplierEntity supplier) {
		if(supplierDao.save(supplier)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public List<SupplierEntity> findAllSupplier() {
		return supplierDao.findAll();
	}

	@Override
	public boolean deleteSupplier(Integer id) {
		if(supplierDao.delete(id)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public SupplierEntity findById(Integer id) {
		return this.supplierDao.findById(id);
	}

	@Override
	public boolean updateSupplier(SupplierEntity supplier) {
		if(this.supplierDao.update(supplier)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public List<SupplierEntity> findSupplier(String supplierName) {
		return this.supplierDao.findSupplier(supplierName);
	}

}
