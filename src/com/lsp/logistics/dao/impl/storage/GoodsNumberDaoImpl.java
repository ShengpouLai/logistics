package com.lsp.logistics.dao.impl.storage;

import java.util.List;

import com.lsp.logistics.dao.ifac.storage.GoodsNumberDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.StorageEntity;

public class GoodsNumberDaoImpl extends BaseDaoImpl<GoodsNumberEntity> implements GoodsNumberDaoIfac {

	public GoodsNumberDaoImpl() {
		super(GoodsNumberEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<GoodsNumberEntity> lookGoodsNumber(Integer storage) {
		try{
			String hql = "from GoodsNumberEntity as gn where gn.storage.id = '" + storage + "'";
			return getHibernateTemplate().find(hql);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean saveGoodsNumber(GoodsEntity goods, StorageEntity storage) {
		GoodsNumberEntity g = new GoodsNumberEntity();
		g.setGoods(goods);
		g.setStorage(storage);
		g.setCanDistributeQuantity(0);
		g.setCannotDistributeQuantity(0);
		g.setReturnQuantity(0);
		g.setTotalQuantity(0);
		getHibernateTemplate().save(g);
		return true;
	}

	@Override
	public List<GoodsNumberEntity> findShortGoodsNumber(GoodsEntity goodsEntity) {
		String hql = "from GoodsNumberEntity as gn where gn.goods.id = '" + goodsEntity.getId() + "'";
		return getHibernateTemplate().find(hql);
	}

	@Override
	public boolean deleteGoodsNumber(Integer goodsId) {
		GoodsNumberEntity g = new GoodsNumberEntity();
		String hql = "from GoodsNumberEntity as gn where gn.goods.id = '" + goodsId +"'";
		g = (GoodsNumberEntity)getHibernateTemplate().find(hql).get(0);
		getHibernateTemplate().delete(g);
		return true;
	}

	@Override
	public boolean checkGoods(GoodsEntity goods, StorageEntity storage) {
		String hql = "from GoodsNumberEntity as g where g.goods.id = " + goods.getId() + " and g.storage.id = " + storage.getId() + "";
		if(getHibernateTemplate().find(hql).size() > 0){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public GoodsNumberEntity find(GoodsEntity goods, StorageEntity storage) {
		String hql = "from GoodsNumberEntity as g where g.goods.id = '" + goods.getId() + "' and g.storage.id = '" + storage.getId() + "'";
		return (GoodsNumberEntity) getHibernateTemplate().find(hql).get(0);
	}


}
