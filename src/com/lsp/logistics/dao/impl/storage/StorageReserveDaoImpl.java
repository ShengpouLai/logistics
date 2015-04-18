package com.lsp.logistics.dao.impl.storage;

import java.util.List;

import com.lsp.logistics.dao.ifac.storage.StorageReserveDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.StorageReserveEntity;

public class StorageReserveDaoImpl extends BaseDaoImpl<StorageReserveEntity> implements StorageReserveDaoIfac {

	public StorageReserveDaoImpl() {
		super(StorageReserveEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<StorageReserveEntity> findStorageReserveByStorageId(Integer id) {
		String hql = "from StorageReserveEntity as sr where sr.storage.id = " + id;
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List<StorageReserveEntity> findShortageGoodsReserve(
			GoodsEntity goodsEntity) {
		String hql = "from StorageReserveEntity as sr where sr.storage.storageLevel = '1' and sr.goods.goodsName = '" + goodsEntity.getGoodsName() + "'";
		return getHibernateTemplate().find(hql);
	}

}
