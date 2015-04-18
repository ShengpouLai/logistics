package com.lsp.logistics.dao.impl.storage;

import java.util.ArrayList;
import java.util.List;

import com.lsp.logistics.dao.ifac.storage.StorageDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.StorageEntity;

public class StorageDaoImpl extends BaseDaoImpl<StorageEntity> implements StorageDaoIfac {

	public StorageDaoImpl() {
		super(StorageEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean selectCenterStorage() {
		String hql = "from StorageEntity as s where s.storageLevel = " + 1;
		if(getHibernateTemplate().find(hql).size() == 0){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public List<StorageEntity> findStorage(String storageName) {
		if(storageName.length() == 0){
			return new ArrayList<StorageEntity>();
		}
		else{
			String hql = "from StorageEntity as s where s.storageName = '" + storageName + "'";
			System.out.println(hql);
			return getHibernateTemplate().find(hql);
		}
	}

}
