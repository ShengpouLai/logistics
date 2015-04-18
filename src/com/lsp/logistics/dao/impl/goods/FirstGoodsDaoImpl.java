package com.lsp.logistics.dao.impl.goods;

import com.lsp.logistics.dao.ifac.goods.FirstGoodsDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.FirstGoodsEntity;

public class FirstGoodsDaoImpl extends BaseDaoImpl<FirstGoodsEntity> implements FirstGoodsDaoIfac {

	public FirstGoodsDaoImpl() {
		super(FirstGoodsEntity.class);
		// TODO Auto-generated constructor stub
	}

}
