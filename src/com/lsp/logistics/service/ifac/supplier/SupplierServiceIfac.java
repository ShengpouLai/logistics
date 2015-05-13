package com.lsp.logistics.service.ifac.supplier;

import java.util.List;

import com.lsp.logistics.entity.SupplierEntity;

public interface SupplierServiceIfac {
	
	/**
	 * 查询所有供应商
	 * @return list
	 */
	public List<SupplierEntity> findAllSupplier();
	
	/**
	 * 保存供应商
	 * @param supplier
	 * @return true
	 */
	public boolean saveSupplier(SupplierEntity supplier);
	
	/**
	 * 删除供应商
	 * @param id
	 * @return true
	 */
	public boolean deleteSupplier(Integer id);
	
	/**
	 * 通过ID查询供应商
	 * @param id
	 * @return
	 */
	public SupplierEntity findById(Integer id);
	
	/**
	 * 修改供应商信息
	 * @param supplier
	 * @return
	 */
	public boolean updateSupplier(SupplierEntity supplier);
	
	/**
	 * 条件查询供应商
	 * @param supplierName
	 * @return
	 */
	public List<SupplierEntity> findSupplier(String supplierName);

}
