package com.lsp.logistics.dao.ifac.goods;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.FirstGoodsEntity;
import com.lsp.logistics.entity.SecondGoodsEntity;

public interface SecondGoodsDaoIfac extends BaseDao<SecondGoodsEntity> {

	public List<SecondGoodsEntity> findSercondByFirstGoodsId(Integer firstGoodsId);
	

}
