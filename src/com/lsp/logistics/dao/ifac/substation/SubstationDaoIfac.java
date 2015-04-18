package com.lsp.logistics.dao.ifac.substation;

import java.util.List;

import com.lsp.logistics.dao.ifac.BaseDao;
import com.lsp.logistics.entity.SubstationEntity;

public interface SubstationDaoIfac extends BaseDao<SubstationEntity> {
	
	public List<SubstationEntity> findSubstation(String substationName);

}
