package com.lsp.logistics.service.impl.goods;

import java.util.List;

import com.lsp.logistics.dao.ifac.goods.FirstGoodsDaoIfac;
import com.lsp.logistics.entity.FirstGoodsEntity;
import com.lsp.logistics.service.ifac.goods.FirstGoodsServiceIfac;

public class FirstGoodsServiceImpl implements FirstGoodsServiceIfac {
	
	private FirstGoodsDaoIfac firstGoodsDao;

	public void setFirstGoodsDao(FirstGoodsDaoIfac firstGoodsDao) {
		this.firstGoodsDao = firstGoodsDao;
	}

	@Override
	public List<FirstGoodsEntity> findAllFirstGoods() {
		return this.firstGoodsDao.findAll();
	}

	@Override
	public boolean saveFirstGoods(FirstGoodsEntity firstGoods) {
		this.firstGoodsDao.save(firstGoods);
		return true;
	}

	@Override
	public boolean deleteFirstGoods(Integer firstGoodsId) {
		this.firstGoodsDao.delete(firstGoodsId);
		return true;
	}

	@Override
	public FirstGoodsEntity findFirstGoodsById(Integer firstGoodsId) {
		
		return this.firstGoodsDao.findById(firstGoodsId);
	}

	@Override
	public boolean updateFirstGoods(FirstGoodsEntity firstGoods) {
		this.firstGoodsDao.update(firstGoods);
		return true;
	}

}
