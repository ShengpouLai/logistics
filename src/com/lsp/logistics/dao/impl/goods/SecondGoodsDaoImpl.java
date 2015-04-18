package com.lsp.logistics.dao.impl.goods;

import java.util.List;

import com.lsp.logistics.dao.ifac.goods.SecondGoodsDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.FirstGoodsEntity;
import com.lsp.logistics.entity.SecondGoodsEntity;

public class SecondGoodsDaoImpl extends BaseDaoImpl<SecondGoodsEntity> implements SecondGoodsDaoIfac {

	public SecondGoodsDaoImpl() {
		super(SecondGoodsEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SecondGoodsEntity> findSercondByFirstGoodsId(Integer firstGoodsId) {
		String hql = "from SecondGoodsEntity as s where firstGoods.id = " + firstGoodsId +"";
		return getHibernateTemplate().find(hql);
	}

}
