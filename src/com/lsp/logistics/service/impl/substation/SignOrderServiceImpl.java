package com.lsp.logistics.service.impl.substation;

import com.lsp.logistics.dao.ifac.substation.SignOrderDaoIfac;
import com.lsp.logistics.service.ifac.substation.SignOrderServiceIfac;

public class SignOrderServiceImpl implements SignOrderServiceIfac {
	
	private SignOrderDaoIfac signOrderDao;

	public void setSignOrderDao(SignOrderDaoIfac signOrderDao) {
		this.signOrderDao = signOrderDao;
	}

}
