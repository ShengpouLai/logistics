package com.lsp.logistics.service.ifac.substation;

import java.util.List;

import com.lsp.logistics.entity.SubstationEntity;

public interface SubstationServiceIfac {
	
	public List<SubstationEntity> findSubstation(String substationName);
	
	public List<SubstationEntity> findAllSubstation();
	
	public boolean saveSubstation(SubstationEntity substation);
	
	public boolean deleteSubstation(Integer id);

	public SubstationEntity findSubstationById(Integer id);

	public boolean updateSubstation(SubstationEntity sub);

}
