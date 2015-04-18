package com.lsp.logistics.dao.impl.goods;

import java.util.ArrayList;
import java.util.List;

import com.lsp.logistics.dao.ifac.goods.GoodsDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.GoodsEntity;

public class GoodsDaoImpl extends BaseDaoImpl<GoodsEntity> implements GoodsDaoIfac {

	public GoodsDaoImpl() {
		super(GoodsEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<GoodsEntity> findGoodsBySecondGoodsId(Integer secondGoodsId) {
		String hql = "from GoodsEntity as g where secondGoods.id = " + secondGoodsId;
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List<GoodsEntity> findGoods(String goodsId, String goodsName) {
		if(goodsId.length() == 0 && goodsName.length() == 0){
			return new ArrayList<GoodsEntity>();
		}
		else
		{
			String hql = "from GoodsEntity as g where ";
			if(goodsId.length()>0){
				hql = hql + "g.goodsId = '" + goodsId + "' and ";
			}
			if(goodsName.length()>0){
				hql = hql + "g.goodsName = '" + goodsName + "' and ";
			}
			if(hql.lastIndexOf("and ")==hql.length() -4)
			      hql=hql.substring(0,hql.lastIndexOf("and ")) ;
			System.out.println(hql);
			return getHibernateTemplate().find(hql);
		}
	}

	@Override
	public List<GoodsEntity> findShortageGoods() {
		String hql = "select gn.goods from GoodsNumberEntity as gn, StorageReserveEntity as sr where gn.goods = sr.goods and gn.canDistributeQuantity < sr.storageWarningReserves and sr.storage.storageLevel = '1' and gn.goods.goodsState = '1'";
		return getHibernateTemplate().find(hql);
	}

	@Override
	public boolean ifGoodsPutIn(Integer goodsId) {
		String hql = "from BuyGoodsOrder as bgo where bgo.buyGoodsOrderState = '1' and bgo.goods.id = '" + goodsId + "'";
		System.out.println(hql);
		if(getHibernateTemplate().find(hql).size() > 0){
			System.out.println("afr");
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public boolean buyGoodsState(String goodsState) {
		return false;
	}

}
