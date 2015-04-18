package com.lsp.logistics.service.impl.goods;

import java.util.List;

import com.lsp.logistics.dao.ifac.goods.GoodsDaoIfac;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.service.ifac.goods.GoodsServiceIfac;

public class GoodsServiceImpl implements GoodsServiceIfac {

	private GoodsDaoIfac goodsDao;

	public void setGoodsDao(GoodsDaoIfac goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public List<GoodsEntity> findAllGoods() {
		return this.goodsDao.findAll();
	}

	@Override
	public boolean saveGoods(GoodsEntity goods) {
		if (this.goodsDao.save(goods)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<GoodsEntity> findGoodsBySecondGoodsId(Integer secondGoodsId) {
		return this.goodsDao.findGoodsBySecondGoodsId(secondGoodsId);
	}

	@Override
	public boolean deleteGoods(Integer goodsId) {
		if (this.goodsDao.delete(goodsId)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public GoodsEntity findGoodsById(Integer id) {
		return this.goodsDao.findById(id);
	}

	@Override
	public boolean updateGoods(GoodsEntity goods) {
		if(this.goodsDao.update(goods)){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<GoodsEntity> findGoods(String goodsId, String goodsName) {
		return this.goodsDao.findGoods(goodsId, goodsName);
	}

	@Override
	public List<GoodsEntity> findShortageGoods() {
		return this.goodsDao.findShortageGoods();
	}

	@Override
	public boolean ifGoodsPutIn(Integer goodsId) {
		if(this.goodsDao.ifGoodsPutIn(goodsId)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean buyGoodsState(Integer goodsId) {
		GoodsEntity goods = this.goodsDao.findById(goodsId);
		goods.setGoodsState("0");
		this.goodsDao.update(goods);
		return true;
	}

}
