package com.lsp.logistics.dao.impl.substation;

import com.lsp.logistics.dao.ifac.substation.ReceiptDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.ReceiptEntity;

public class ReceiptDaoImpl extends BaseDaoImpl<ReceiptEntity> implements ReceiptDaoIfac {

	public ReceiptDaoImpl() {
		super(ReceiptEntity.class);
		// TODO Auto-generated constructor stub
	}

}
