package com.lsp.logistics.dao.impl.substation;

import java.util.ArrayList;
import java.util.List;

import com.lsp.logistics.dao.ifac.substation.SubstationDaoIfac;
import com.lsp.logistics.dao.impl.BaseDaoImpl;
import com.lsp.logistics.entity.StorageEntity;
import com.lsp.logistics.entity.SubstationEntity;

public class SubstationDaoImpl extends BaseDaoImpl<SubstationEntity> implements SubstationDaoIfac {

	public SubstationDaoImpl() {
		super(SubstationEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SubstationEntity> findSubstation(String substationName) {
		if(substationName.length() == 0){
			return new ArrayList<SubstationEntity>();
		}
		else{
			String hql = "from SubstationEntity as s where s.substationName = '" + substationName + "'";
			return getHibernateTemplate().find(hql);
		}
	}
}
