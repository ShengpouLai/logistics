package com.lsp.logistics.service.ifac.substation;

import java.util.List;

import com.lsp.logistics.entity.SubstationEntity;

public interface SubstationServiceIfac {
	
	/**
	 * 通过分站名称查询分站
	 * @param substationName
	 * @return list
	 */
	public List<SubstationEntity> findSubstation(String substationName);
	
	/**
	 * 查询所有分站
	 * @return list
	 */
	public List<SubstationEntity> findAllSubstation();
	
	/**
	 * 添加分站
	 * @param substation
	 * @return true
	 */
	public boolean saveSubstation(SubstationEntity substation);
	
	/**
	 * 删除分站
	 * @param id
	 * @return true
	 */
	public boolean deleteSubstation(Integer id);

	/**
	 * 通过Id查询分站
	 * @param id
	 * @return SubstationEntity
	 */
	public SubstationEntity findSubstationById(Integer id);

	/**
	 * 修改分站信息
	 * @param sub
	 * @return true
	 */
	public boolean updateSubstation(SubstationEntity sub);

}
