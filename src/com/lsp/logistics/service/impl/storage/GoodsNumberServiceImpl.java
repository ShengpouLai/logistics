package com.lsp.logistics.service.impl.storage;

import java.util.List;

import com.lsp.logistics.dao.ifac.goods.GoodsDaoIfac;
import com.lsp.logistics.dao.ifac.storage.GoodsNumberDaoIfac;
import com.lsp.logistics.entity.GoodsEntity;
import com.lsp.logistics.entity.GoodsNumberEntity;
import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.service.ifac.storage.GoodsNumberServiceIfac;

public class GoodsNumberServiceImpl implements GoodsNumberServiceIfac{
	
	private GoodsNumberDaoIfac goodsNumberDao;
	private GoodsDaoIfac goodsDao;

	public void setGoodsDao(GoodsDaoIfac goodsDao) {
		this.goodsDao = goodsDao;
	}

	public void setGoodsNumberDao(GoodsNumberDaoIfac goodsNumberDao) {
		this.goodsNumberDao = goodsNumberDao;
	}

	@Override
	public List<GoodsNumberEntity> lookGoodsNumber(Integer storage) {
		try{
			return goodsNumberDao.lookGoodsNumber(storage);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean saveGoodsNumber(GoodsEntity goods, StorageEntity storage) {
		return goodsNumberDao.saveGoodsNumber(goods, storage);
	}

	@Override
	public List<GoodsNumberEntity> findShortGoodsNumber(GoodsEntity goodsEntity) {
		return goodsNumberDao.findShortGoodsNumber(goodsEntity);
	}

	@Override
	public boolean deleteGoodsNumber(Integer goodsId) {
		return goodsNumberDao.deleteGoodsNumber(goodsId);
	}

	@Override
	public void updateGoodsNumber(Integer goodsId, Integer integer) {
		GoodsNumberEntity goodsNumber = new GoodsNumberEntity();
		goodsNumber = goodsNumberDao.findShortGoodsNumber(goodsDao.findById(goodsId)).get(0);
		goodsNumber.setTotalQuantity(goodsNumber.getTotalQuantity() + integer);
		goodsNumber.setCanDistributeQuantity(goodsNumber.getCanDistributeQuantity() + integer);
		goodsNumberDao.update(goodsNumber);
	}

	@Override
	public List<GoodsNumberEntity> findAll() {
		return this.goodsNumberDao.findAll();
	}

	@Override
	public boolean updateInOrderDetail(Integer goodsId, Integer integer) {
		GoodsNumberEntity goodsNumber = goodsNumberDao.findShortGoodsNumber(goodsDao.findById(goodsId)).get(0);
		goodsNumber.setCanDistributeQuantity(goodsNumber.getCanDistributeQuantity() - integer);
		goodsNumber.setCannotDistributeQuantity(goodsNumber.getCannotDistributeQuantity() + integer);
		return goodsNumberDao.update(goodsNumber);
	}


}
