package com.lsp.logistics.dao.impl.supplier;

import java.util.ArrayList;
import java.util.List;

import com.lsp.logistics.dao.ifac.supplier.SupplierDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.SupplierEntity;

public class SupplierDaoImpl extends BaseDaoImpl<SupplierEntity> implements
		SupplierDaoIfac {

	public SupplierDaoImpl() {
		super(SupplierEntity.class);
	}

	@Override
	public List<SupplierEntity> findSupplier(String supplierName) {
		if (supplierName.length() > 0) {
			String hql = "from SupplierEntity as s where s.supplierName = '"
					+ supplierName + "'";
			return getHibernateTemplate().find(hql);
		} else {
			return new ArrayList<SupplierEntity>();
		}
	}

}
