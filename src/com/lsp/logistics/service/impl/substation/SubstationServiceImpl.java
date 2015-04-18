package com.lsp.logistics.service.impl.substation;

import java.util.List;

import com.lsp.logistics.dao.ifac.substation.SubstationDaoIfac;
import com.lsp.logistics.entity.SubstationEntity;
import com.lsp.logistics.service.ifac.substation.SubstationServiceIfac;

public class SubstationServiceImpl implements SubstationServiceIfac {
	
	private SubstationDaoIfac substationDao;

	public void setSubstationDao(SubstationDaoIfac substationDao) {
		this.substationDao = substationDao;
	}

	@Override
	public List<SubstationEntity> findSubstation(String substationName) {
		return this.substationDao.findSubstation(substationName);
	}

	@Override
	public List<SubstationEntity> findAllSubstation() {
		return this.substationDao.findAll();
	}

	@Override
	public boolean saveSubstation(SubstationEntity substation) {
		if(this.substationDao.save(substation)){
			return true;
		} else{
			return false;
		}
	}

	@Override
	public boolean deleteSubstation(Integer id) {
		if(this.substationDao.delete(id)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public SubstationEntity findSubstationById(Integer id) {
		return this.substationDao.findById(id);
	}

	@Override
	public boolean updateSubstation(SubstationEntity sub) {
		if(this.substationDao.update(sub)){
			return true;
		}
		else{
			return false;
		}
	}

}
