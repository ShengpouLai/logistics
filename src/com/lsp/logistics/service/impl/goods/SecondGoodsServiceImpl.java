package com.lsp.logistics.service.impl.goods;

import java.util.List;

import com.lsp.logistics.dao.ifac.goods.SecondGoodsDaoIfac;
import com.lsp.logistics.entity.FirstGoodsEntity;
import com.lsp.logistics.entity.SecondGoodsEntity;
import com.lsp.logistics.service.ifac.goods.SecondGoodsServiceIfac;

public class SecondGoodsServiceImpl implements SecondGoodsServiceIfac{
	private SecondGoodsDaoIfac secondGoodsDao;

	public void setSecondGoodsDao(SecondGoodsDaoIfac secondGoodsDao) {
		this.secondGoodsDao = secondGoodsDao;
	}

	@Override
	public List<SecondGoodsEntity> findAllSecondGoods() {
		return this.secondGoodsDao.findAll();
	}

	@Override
	public boolean saveSecondGoods(SecondGoodsEntity secondGoods) {
		this.secondGoodsDao.save(secondGoods);
		return true;
	}

	@Override
	public List<SecondGoodsEntity> findSercondByFirstGoodsId(Integer firstGoodsId) {
		return this.secondGoodsDao.findSercondByFirstGoodsId(firstGoodsId);
	}

	@Override
	public boolean deleteSecondGoods(Integer secondGoodsId) {
		this.secondGoodsDao.delete(secondGoodsId);
		return true;
	}

	@Override
	public SecondGoodsEntity findSecondGoodsById(Integer secondGoodsId) {
		return this.secondGoodsDao.findById(secondGoodsId);
	}

	@Override
	public boolean updateSecondGoods(SecondGoodsEntity secondGoods) {
		this.secondGoodsDao.update(secondGoods);
		return true;
	}

}
